/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.podzem;

import chemicalanalysisfx.java.ChemicalAnalysisFX;
import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.model.*;
import chemicalanalysisfx.java.model.podzem.*;
import chemicalanalysisfx.java.viewmodel.BaseViewModel;
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

public class PodzemController extends BaseController{   
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private TableView<PodzemViewModel> podzem;
    @FXML
    private TableColumn<PodzemViewModel, String> n_skv;
    @FXML
    private TableColumn<PodzemViewModel, String> point_ot;
    @FXML
    private TableColumn<PodzemViewModel, String> dat_sel_an;
    @FXML
    private TableColumn<PodzemViewModel, String> pres_be;
    @FXML
    private TableColumn<PodzemViewModel, String> plot;
    @FXML
    private TableColumn<PodzemViewModel, String> fe;
    @FXML
    private TableColumn<PodzemViewModel, String> ph;
    @FXML
    private TableColumn<PodzemViewModel, String> shel12;
    @FXML
    private TableColumn<PodzemViewModel, String> cl12;
    @FXML
    private TableColumn<PodzemViewModel, String> s12;
    @FXML
    private TableColumn<PodzemViewModel, String> sulf12;
    @FXML
    private TableColumn<PodzemViewModel, String> ca12;
    @FXML
    private TableColumn<PodzemViewModel, String> mg12;
    @FXML
    private TableColumn<PodzemViewModel, String> na12;
    @FXML
    private TableColumn<PodzemViewModel, String> k12;
    @FXML
    private TableColumn<PodzemViewModel, String> kat_an;
    @FXML
    private TableColumn<PodzemViewModel, String> raz_ion12;
    @FXML
    private TableColumn<PodzemViewModel, String> min_ves_ras;
    @FXML
    private TableColumn<PodzemViewModel, String> note;
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
    private ToggleGroup toggleGroupPointOt;
    @FXML
    private CheckBox checkBoxKS;
    @FXML
    private CheckBox checkBoxZatr;
    @FXML
    private CheckBox checkBoxUst;
    @FXML
    private CheckBox checkBoxProch;
    @FXML
    private CheckBox checkBoxGlub;
    @FXML
    private CheckBox checkBox79;
    @FXML
    private CheckBox checkBox912;
    @FXML
    private CheckBox checkBox1216;
    @FXML
    private MenuButton buttonEdit;
    
    public PodzemController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<PodzemViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("№, скв",                          0, 1, 0, 0));
        nameFieldsExcel.add(new NameFieldExcelStyle("Точка\nотбора",                    0, 1, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата\nотбор/\nанализ",             0, 1, 2, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("Давление\nнач./кон. (бар)",        0, 1, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("Плотность",                        0, 1, 4, 4));
        nameFieldsExcel.add(new NameFieldExcelStyle("Fe(общ)\nмг/дм³",                  0, 1, 5, 5));
        nameFieldsExcel.add(new NameFieldExcelStyle("PH",                               0, 1, 6, 6));
        nameFieldsExcel.add(new NameFieldExcelStyle("Щелоч-ть\nIст./IIст.\nмг-экв/дм³", 0, 1, 7, 7));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("мг-экв./дм³\nмг/дм³",              0, 0, 8, 14));
        nameFieldsExcel.add(new NameFieldExcelStyle("Clˉ",                              1, 1, 8, 8));
        nameFieldsExcel.add(new NameFieldExcelStyle("S²ˉ",                              1, 1, 9, 9));
        nameFieldsExcel.add(new NameFieldExcelStyle("SO₄²ˉ",                            1, 1, 10, 10));
        nameFieldsExcel.add(new NameFieldExcelStyle("Cа²⁺",                             1, 1, 11, 11));
        nameFieldsExcel.add(new NameFieldExcelStyle("Mg²⁺",                             1, 1, 12, 12));
        nameFieldsExcel.add(new NameFieldExcelStyle("Na⁺",                              1, 1, 13, 13));
        nameFieldsExcel.add(new NameFieldExcelStyle("K⁺",                               1, 1, 14, 14));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Катионы\nАнионы\nмг-экв/дм³",      0, 1, 15, 15));
        nameFieldsExcel.add(new NameFieldExcelStyle("Разн.\nионов\nмг-экв/дм³\n%",      0, 1, 16, 16));
        nameFieldsExcel.add(new NameFieldExcelStyle("Минер-я\nвес./\nрас.\nмг/дм³",     0, 1, 17, 17));
        nameFieldsExcel.add(new NameFieldExcelStyle("Примечание",                       0, 1, 18, 18));
    }
    
    @FXML
    private void initialize(){      
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        // инициализируем колонки таблицы данными 
        n_skv.setCellValueFactory(cellData -> cellData.getValue().n_skv);
        point_ot.setCellValueFactory(cellData -> cellData.getValue().point_ot);
        dat_sel_an.setCellValueFactory(cellData -> cellData.getValue().dat_sel_an);
        pres_be.setCellValueFactory(cellData -> cellData.getValue().pres_be);
        plot.setCellValueFactory(cellData -> cellData.getValue().plot);
        fe.setCellValueFactory(cellData -> cellData.getValue().fe);
        ph.setCellValueFactory(cellData -> cellData.getValue().ph);
        shel12.setCellValueFactory(cellData -> cellData.getValue().shel12);
        cl12.setCellValueFactory(cellData -> cellData.getValue().cl12);
        s12.setCellValueFactory(cellData -> cellData.getValue().s12);
        sulf12.setCellValueFactory(cellData -> cellData.getValue().sulf12);
        ca12.setCellValueFactory(cellData -> cellData.getValue().ca12);
        mg12.setCellValueFactory(cellData -> cellData.getValue().mg12);
        na12.setCellValueFactory(cellData -> cellData.getValue().na12);
        k12.setCellValueFactory(cellData -> cellData.getValue().k12);
        kat_an.setCellValueFactory(cellData -> cellData.getValue().kat_an);
        raz_ion12.setCellValueFactory(cellData -> cellData.getValue().raz_ion12);
        min_ves_ras.setCellValueFactory(cellData -> cellData.getValue().min_ves_ras);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        
        // задаем списки для combobox
        comboBoxSkv.setItems(FXCollections.observableArrayList(DatabaseDriver.getListSkv(tablename)));
        comboBoxSkv.setValue("");
        comboBoxUppg.setItems(FXCollections.observableArrayList("Все", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9", "ЛЭС"));
        comboBoxUppg.setValue("Все");
        
        // создаем событие для переключателя даты
        toggleGroupDate.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed (ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                changedToggleGroupDate(newValue);
            }
        });
        
        // создаем событие для переключателя точки отбора
        toggleGroupPointOt.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                changedToggleGroupPointOt(newValue);
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
            PodzemViewModel.new_id = -1;
            podzem.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/podzem/podzem_new.fxml"));
            loader.setController(new PodzemNewController(newStage, "add", tablename, new Podzem()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (PodzemViewModel.new_id != -1){
                var item = new Podzem(DatabaseDriver.getRowFromDb(tablename, PodzemViewModel.new_id));
                podzem.getItems().add(makeViewModel(item));
                labelCount.setText("1");
                System.out.println("podzem_new stage closed!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonChangeValueAction(){ // событие изменение данных, открываем новое окно
        String err = "id";
        try{
            var item = podzem.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/podzem/podzem_new.fxml"));
            loader.setController(new PodzemNewController(newStage, "change", tablename, new Podzem(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new Podzem(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = podzem.getItems().indexOf(item);
            podzem.getItems().set(index, makeViewModel(new_item));
            System.out.println("podzem_new stage closed!");
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
            var item = podzem.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            podzem.getItems().remove(item); // обновляем визуализацию
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Не выбрана точка отбора!", "Ошибка удаления", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @FXML
    public void buttonSortPointOtAction(){      // отсортировать данные по точке отбора
        viewTable("point_ot");
    }
    
    @FXML
    public void buttonSortSkvDateSelAction(){   // отсортировать данные по скважине и дате отбора
        viewTable("num_skv, n_skv, dat_sel");
    }
    
    @FXML
    public void buttonSortDateAnAction(){       // отсортировать данные по дате анализа
        viewTable("dat_an");
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
    
    public void changedToggleGroupPointOt(Toggle newValue){ // обработка события переключателя точки отбора
        RadioButton selectedBtn = (RadioButton)newValue;
        if (selectedBtn.getText().equals("все")){
            checkBoxKS.setVisible(false);
            checkBoxZatr.setVisible(false);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
        }
        else if (selectedBtn.getText().equals("МКП")){
            checkBoxKS.setVisible(false);
            checkBoxZatr.setVisible(false);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(true);
            checkBox912.setVisible(true);
            checkBox1216.setVisible(true);
        }
        else{
            checkBoxKS.setVisible(true);
            checkBoxZatr.setVisible(true);
            checkBoxUst.setVisible(true);
            checkBoxProch.setVisible(true);
            checkBoxGlub.setVisible(true);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
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
        
        RadioButton selectedBtnPoint = (RadioButton)toggleGroupPointOt.getSelectedToggle();
        if (selectedBtnPoint.getText().equals("МКП")){
            if(checkBox79.isSelected()) listPointOt.add(checkBox79.getText());
            if(checkBox912.isSelected()) listPointOt.add(checkBox912.getText());
            if(checkBox1216.isSelected()) listPointOt.add(checkBox1216.getText());
        }
        else if(selectedBtnPoint.getText().equals("другие")){
            if(checkBoxKS.isSelected()) listPointOt.add(checkBoxKS.getText());
            if(checkBoxZatr.isSelected()) listPointOt.add(checkBoxZatr.getText());
            if(checkBoxUst.isSelected()) listPointOt.add(checkBoxUst.getText());
            if(checkBoxProch.isSelected()) listPointOt.add(checkBoxProch.getText());
            if(checkBoxGlub.isSelected()) listPointOt.add(checkBoxGlub.getText());
        }
        
        // получаем данные из БД отсортированные
        var data = DatabaseDriver.getDataFromDb(tablename, dateOne, dateB, dateE, uppg, skv, "", listPointOt, sortCrit);
        ArrayList<Podzem> podzemData = new ArrayList<Podzem>();
        for (int i = 0; i < data.size(); i++) 
            podzemData.add(new Podzem(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<PodzemViewModel>();
        for (int i=0; i< podzemData.size(); i++)
            dataVm.add(makeViewModel(podzemData.get(i)));
        
        // добавляем данные на форму
        podzem.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public PodzemViewModel makeViewModel(Podzem podzemData){
        return new PodzemViewModel(podzemData.id, podzemData.point_ot, podzemData.n_skv, 
                    podzemData.dat_sel  + "\n-----------\n" + podzemData.dat_an, 
                    podzemData.pres_b   + "\n-----------\n" + podzemData.pres_e, 
                    podzemData.plot, podzemData.fe, podzemData.ph, 
                    podzemData.shel1    + "\n-----------\n" + podzemData.shel2, 
                    podzemData.cl1      + "\n-----------\n" + podzemData.cl2, 
                    podzemData.s1       + "\n-----------\n" + podzemData.s2, 
                    podzemData.sulf1    + "\n-----------\n" + podzemData.sulf2, 
                    podzemData.ca1      + "\n-----------\n" + podzemData.ca2, 
                    podzemData.mg1      + "\n-----------\n" + podzemData.mg2, 
                    podzemData.na1      + "\n-----------\n" + podzemData.na2, 
                    podzemData.k1       + "\n-----------\n" + podzemData.k2, 
                    podzemData.kation   + "\n-----------\n" + podzemData.anion,
                    podzemData.raz_ion1 + "\n-----------\n" + podzemData.raz_ion2, 
                    podzemData.min_ves  + "\n-----------\n" + podzemData.min_ras,
                    podzemData.note);
    }
}
