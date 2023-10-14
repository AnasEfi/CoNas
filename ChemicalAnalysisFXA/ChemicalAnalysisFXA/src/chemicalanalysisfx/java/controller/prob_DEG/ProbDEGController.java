/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.prob_DEG;

import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.NameFieldExcelStyle;
import chemicalanalysisfx.java.model.User;
import chemicalanalysisfx.java.model.prob_DEG.ProbDEG;
import chemicalanalysisfx.java.viewmodel.prob_DEG.ProbDEGViewModel;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author annab
 */
public class ProbDEGController extends BaseController{
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private TableView<ProbDEGViewModel> probDEG;
    @FXML
    private TableColumn<ProbDEGViewModel, String> n_skv;
    @FXML
    private TableColumn<ProbDEGViewModel, String> uppg;
    @FXML
    private TableColumn<ProbDEGViewModel, String> dat_sel;
    @FXML
    private TableColumn<ProbDEGViewModel, String> dat_an;
    @FXML
    private TableColumn<ProbDEGViewModel, String> plot;
    @FXML
    private TableColumn<ProbDEGViewModel, String> pH;
    @FXML
    private TableColumn<ProbDEGViewModel, String> deg;
    @FXML
    private TableColumn<ProbDEGViewModel, String> h2o;
    @FXML
    private TableColumn<ProbDEGViewModel, String> met;
    @FXML
    private TableColumn<ProbDEGViewModel, String> prim;
    @FXML
    private TableColumn<ProbDEGViewModel, String> teg;
    @FXML
    private TableColumn<ProbDEGViewModel, String> note;
    
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
    private TextField textFieldSkv;
    @FXML
    private TextField textFieldProch;
    @FXML
    private ComboBox<String> comboBoxUppg;
    @FXML
    private MenuButton buttonEdit;
    
    public ProbDEGController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<ProbDEGViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("№, скв",                   0, 1, 0, 0));
        nameFieldsExcel.add(new NameFieldExcelStyle("УППГ",                     0, 1, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата отбора",              0, 1, 2, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата анализа",             0, 1, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("Плотность\nd ₄²⁰",         0, 1, 4, 4));
        nameFieldsExcel.add(new NameFieldExcelStyle("pH",                       0, 1, 5, 5));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Компонентный состав, % масс.", 0, 0, 6, 10));
        nameFieldsExcel.add(new NameFieldExcelStyle("ДЭГ",                      1, 1, 6, 6));
        nameFieldsExcel.add(new NameFieldExcelStyle("Вода",                     1, 1, 7, 7));
        nameFieldsExcel.add(new NameFieldExcelStyle("Метанол",                  1, 1, 8, 8));
        nameFieldsExcel.add(new NameFieldExcelStyle("Примеси",                  1, 1, 9, 9));
        nameFieldsExcel.add(new NameFieldExcelStyle("ТЭГ",                      1, 1, 10, 10));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Визуальная характеристика",0, 1, 11, 11));
    }
    
    @FXML
    private void initialize(){      
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        // инициализируем колонки таблицы данными 
        n_skv.setCellValueFactory(cellData -> cellData.getValue().n_skv);
        uppg.setCellValueFactory(cellData -> cellData.getValue().uppg);
        dat_sel.setCellValueFactory(cellData -> cellData.getValue().dat_sel);
        dat_an.setCellValueFactory(cellData -> cellData.getValue().dat_an);
        plot.setCellValueFactory(cellData -> cellData.getValue().plot);
        pH.setCellValueFactory(cellData -> cellData.getValue().pH);
        deg.setCellValueFactory(cellData -> cellData.getValue().deg);
        h2o.setCellValueFactory(cellData -> cellData.getValue().h2o);
        met.setCellValueFactory(cellData -> cellData.getValue().met);
        prim.setCellValueFactory(cellData -> cellData.getValue().prim);
        teg.setCellValueFactory(cellData -> cellData.getValue().teg);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        
        // задаем списки для combobox
        comboBoxUppg.setItems(FXCollections.observableArrayList("Все", "-", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9"));
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
            ProbDEGViewModel.new_id = -1;
            probDEG.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/prob_DEG/deg_new.fxml"));
            loader.setController(new ProbDEGNewController(newStage, "add", tablename, new ProbDEG()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (ProbDEGViewModel.new_id != -1){
                var item = new ProbDEG(DatabaseDriver.getRowFromDb(tablename, ProbDEGViewModel.new_id));
                probDEG.getItems().add(makeViewModel(item));
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
            var item = probDEG.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/prob_DEG/deg_new.fxml"));
            loader.setController(new ProbDEGNewController(newStage, "change", tablename, new ProbDEG(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new ProbDEG(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = probDEG.getItems().indexOf(item);
            probDEG.getItems().set(index, makeViewModel(new_item));
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
            var item = probDEG.getSelectionModel().getSelectedItem();//.id.get();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            probDEG.getItems().remove(item); // обновляем визуализацию
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
        String uppg = comboBoxUppg.getValue(); 
        String skv = textFieldSkv.getText().strip();
        String skv_pr = textFieldProch.getText().strip();
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
        var data = DatabaseDriver.getDataFromDb(tablename, dateOne, dateB, dateE, uppg, skv, skv_pr, listPointOt, sortCrit);
        ArrayList<ProbDEG> degData = new ArrayList<ProbDEG>();
        for (int i = 0; i < data.size(); i++) 
            degData.add(new ProbDEG(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<ProbDEGViewModel>();
        for (int i=0; i < degData.size(); i++)
            dataVm.add(makeViewModel(degData.get(i)));
        
        // добавляем данные на форму
        probDEG.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public ProbDEGViewModel makeViewModel(ProbDEG degData){
        return new ProbDEGViewModel(degData.id, degData.n_skv, degData.uppg, degData.dat_sel, degData.dat_an, degData.plot,
        degData.pH, degData.deg, degData.h2o, degData.met, degData.prim, degData.teg, degData.note);
    }
}
