/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.ingibitor;

import chemicalanalysisfx.java.ChemicalAnalysisFX;
import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.model.*;
import chemicalanalysisfx.java.model.ingibitor.Ingibitor;
import chemicalanalysisfx.java.model.podzem.*;
import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import chemicalanalysisfx.java.viewmodel.ingibitor.IngibitorViewModel;
import chemicalanalysisfx.java.viewmodel.podzem.PodzemViewModel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author ebondarenko
 */

public class IngibitorController extends BaseController{    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private TableView<IngibitorViewModel> ingibitor;
    @FXML
    private TableColumn<IngibitorViewModel, String> n_skv;
    @FXML
    private TableColumn<IngibitorViewModel, String> dat_sel;
    @FXML
    private TableColumn<IngibitorViewModel, String> dat_an;
    @FXML
    private TableColumn<IngibitorViewModel, String> conc;
    @FXML
    private TableColumn<IngibitorViewModel, String> plot;
    @FXML
    private TableColumn<IngibitorViewModel, String> note;
   
    @FXML
    private ToggleGroup toggleGroupDate;
    @FXML
    private DatePicker datePickerOneDate;
    @FXML
    private DatePicker datePickerRangeDateB;
    @FXML
    private DatePicker datePickerRangeDateE;
    @FXML
    private Label labelDateB;
    @FXML
    private Label labelDateE;
    @FXML
    private Label labelCount;
    @FXML
    private ComboBox<String> comboBoxSkv;
    @FXML
    private ComboBox<String> comboBoxUppg;
    @FXML
    private MenuButton buttonEdit;
    
    public IngibitorController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<IngibitorViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("№, скв",         0, 0, 0, 0));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата отбора",     0, 0, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата анализа",    0, 0, 2, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("Концентрация\nингибитора\nДодиген, мг/дм³(ppm)",        0, 0, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("Плотность",       0, 0, 4, 4));
        nameFieldsExcel.add(new NameFieldExcelStyle("Примечание",      0, 0, 5, 5));
    }
    
    @FXML
    private void initialize(){      
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        // инициализируем колонки таблицы данными 
        n_skv.setCellValueFactory(cellData -> cellData.getValue().n_skv);
        dat_sel.setCellValueFactory(cellData -> cellData.getValue().dat_sel);
        dat_an.setCellValueFactory(cellData -> cellData.getValue().dat_an);
        conc.setCellValueFactory(cellData -> cellData.getValue().conc);
        plot.setCellValueFactory(cellData -> cellData.getValue().plot);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        
        // задаем списки для combobox
        comboBoxSkv.setItems(FXCollections.observableArrayList(DatabaseDriver.getListSkv(tablename)));
        comboBoxSkv.setValue("");
        comboBoxUppg.setItems(FXCollections.observableArrayList("Все", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9"));
        comboBoxUppg.setValue("Все");
        
        // создаем событие для переключателя даты
        toggleGroupDate.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed (ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                changedToggleGroupDate(newValue);
            }
        });
    }
    
    @FXML
    public void buttonViewAction(){ // событие просмотр данных
        viewTable("num_skv, n_skv, dat_sel");
    }
    
    @FXML
    public void buttonNewValueAction(){ // событие - ввод новых данных, открываем новое окно
        try{
            IngibitorViewModel.new_id = -1;
            ingibitor.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/ingibitor/ingibitor_new.fxml"));
            loader.setController(new IngibitorNewController(newStage, "add", tablename, new Ingibitor()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (IngibitorViewModel.new_id != -1){
                var item = new Ingibitor(DatabaseDriver.getRowFromDb(tablename, IngibitorViewModel.new_id));
                ingibitor.getItems().add(makeViewModel(item));
                labelCount.setText("1");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonChangeValueAction(){ // событие изменение данных, открываем новое окно
        String err = "id";
        try{
            var item = ingibitor.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/ingibitor/ingibitor_new.fxml"));
            loader.setController(new IngibitorNewController(newStage, "change", tablename, new Ingibitor(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new Ingibitor(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = ingibitor.getItems().indexOf(item);
            ingibitor.getItems().set(index, makeViewModel(new_item));
        }
        catch (Exception e){
            if (err.equals("id"))
                JOptionPane.showMessageDialog(null, "Не выбрана точка отбора!", "Ошибка изменения", JOptionPane.WARNING_MESSAGE);
            else 
                e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonDeleteValueAction(){ // событие удаление строки
        try{
            var item = ingibitor.getSelectionModel().getSelectedItem();//.id.get();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            ingibitor.getItems().remove(item); // обновляем визуализацию
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Не выбрана точка отбора!", "Ошибка удаления", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @FXML
    public void buttonSortSkvDateSelAction(){   // отсортировать данные по скважине и дате отбора
        viewTable("num_skv, n_skv, dat_sel");
    }
    
    @FXML
    public void buttonSortDateSelAction(){       // отсортировать данные по дате анализа
        viewTable("dat_sel");
    }
    
    public void changedToggleGroupDate(Toggle newValue) // обработка события переключателя даты
    {
        RadioButton selectedBtn = (RadioButton)newValue;
        if (selectedBtn.getText().equals("все даты")){
            datePickerOneDate.setVisible(false);
            datePickerRangeDateB.setVisible(false);
            datePickerRangeDateE.setVisible(false);
            labelDateB.setVisible(false);
            labelDateE.setVisible(false);
        }
        else if (selectedBtn.getText().equals("только за")){
            datePickerOneDate.setVisible(true);
            datePickerRangeDateB.setVisible(false);
            datePickerRangeDateE.setVisible(false);
            labelDateB.setVisible(false);
            labelDateE.setVisible(false);
        }
        else{
            datePickerOneDate.setVisible(false);
            datePickerRangeDateB.setVisible(true);
            datePickerRangeDateE.setVisible(true);
            labelDateB.setVisible(true);
            labelDateE.setVisible(true);
        }
    }
    
    public void viewTable(String sortCrit){ // отображение данных
        String dateOne = "", dateB="", dateE="";
        String uppg=comboBoxUppg.getValue().toString(); 
        String skv=comboBoxSkv.getValue().toString();
        ArrayList<String> listPointOt=new ArrayList<String>();
        RadioButton selectedBtn = (RadioButton)toggleGroupDate.getSelectedToggle();
        if (selectedBtn.getText().equals("только за")) {
            dateOne=datePickerOneDate.getValue() == null ? "" : datePickerOneDate.getValue().toString().replace('-', '.');
        }
        else if (selectedBtn.getText().equals("диапазон")){
            dateB=datePickerRangeDateB.getValue() == null ? "" : datePickerRangeDateB.getValue().toString().replace('-', '.');
            dateE=datePickerRangeDateE.getValue() == null ? "" : datePickerRangeDateE.getValue().toString().replace('-', '.');
        }
        System.out.println(dateOne + " " + dateB + " " + dateE);
        
        // получаем данные из БД отсортированные
        var data = DatabaseDriver.getDataFromDb(tablename, dateOne, dateB, dateE, uppg, skv, "", listPointOt, sortCrit);
        ArrayList<Ingibitor> ingibitorData = new ArrayList<Ingibitor>();
        for (int i = 0; i < data.size(); i++) 
            ingibitorData.add(new Ingibitor(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<IngibitorViewModel>();
        for (int i=0; i< ingibitorData.size(); i++)
            dataVm.add(makeViewModel(ingibitorData.get(i)));
        
        // добавляем данные на форму
        ingibitor.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public IngibitorViewModel makeViewModel(Ingibitor ingibitorData){
        return new IngibitorViewModel(ingibitorData.id, ingibitorData.n_skv, ingibitorData.dat_sel, ingibitorData.dat_an, ingibitorData.conc, ingibitorData.plot, ingibitorData.note);
    }
}
