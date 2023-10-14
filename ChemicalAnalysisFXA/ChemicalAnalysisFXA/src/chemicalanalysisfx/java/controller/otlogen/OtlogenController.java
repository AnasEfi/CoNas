/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.otlogen;

import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.NameFieldExcelStyle;
import chemicalanalysisfx.java.model.User;
import chemicalanalysisfx.java.model.otlogen.Otlogen;
import chemicalanalysisfx.java.viewmodel.otlogen.OtlogenViewModel;
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
public class OtlogenController extends BaseController{
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private TableView<OtlogenViewModel> otlogen;
    @FXML
    private TableColumn<OtlogenViewModel, String> n_skv;
    @FXML
    private TableColumn<OtlogenViewModel, String> dat_sel;
    @FXML
    private TableColumn<OtlogenViewModel, String> dat_an;
    @FXML
    private TableColumn<OtlogenViewModel, String> point_ot;
    @FXML
    private TableColumn<OtlogenViewModel, String> vid;
    @FXML
    private TableColumn<OtlogenViewModel, String> FE3_FE2;
    @FXML
    private TableColumn<OtlogenViewModel, String> FE_FEzol;
    @FXML
    private TableColumn<OtlogenViewModel, String> S_total;
    @FXML
    private TableColumn<OtlogenViewModel, String> S_elem;
    @FXML
    private TableColumn<OtlogenViewModel, String> Cl;
    @FXML
    private TableColumn<OtlogenViewModel, String> CO3;
    @FXML
    private TableColumn<OtlogenViewModel, String> SiO2;
    @FXML
    private TableColumn<OtlogenViewModel, String> C_grafit;
    @FXML
    private TableColumn<OtlogenViewModel, String> uglevod;
    @FXML
    private TableColumn<OtlogenViewModel, String> water;
    @FXML
    private TableColumn<OtlogenViewModel, String> p_100;
    @FXML
    private TableColumn<OtlogenViewModel, String> p_300;
    @FXML
    private TableColumn<OtlogenViewModel, String> p_500;
    @FXML
    private TableColumn<OtlogenViewModel, String> p_800;
    @FXML
    private TableColumn<OtlogenViewModel, String> H2S_CO2;
    @FXML
    private TableColumn<OtlogenViewModel, String> note;
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
    private MenuButton buttonEdit;
    
    public OtlogenController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<OtlogenViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("№, скв",                  0, 1, 0, 0));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата отбора",              0, 1, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата анализа",             0, 1, 2, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("Точка отбора",             0, 1, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("Внешний вид",              0, 1, 4, 4));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Химический состав, %",     0, 0, 5, 12));
        nameFieldsExcel.add(new NameFieldExcelStyle("Fe³⁺\nFe²⁻",               1, 1, 5, 5));
        nameFieldsExcel.add(new NameFieldExcelStyle("Fe общ\n(в золе)",         1, 1, 6, 6));
        nameFieldsExcel.add(new NameFieldExcelStyle("S общ",                    1, 1, 7, 7));
        nameFieldsExcel.add(new NameFieldExcelStyle("S элем",                   1, 1, 8, 8));
        nameFieldsExcel.add(new NameFieldExcelStyle("Cl⁻",                      1, 1, 9, 9));
        nameFieldsExcel.add(new NameFieldExcelStyle("CaCO₃",                    1, 1, 10, 10));
        nameFieldsExcel.add(new NameFieldExcelStyle("SiO₂",                     1, 1, 11, 11));
        nameFieldsExcel.add(new NameFieldExcelStyle("C",                        1, 1, 12, 12));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("УВ",                       0, 1, 13, 13));
        nameFieldsExcel.add(new NameFieldExcelStyle("Вода",                     0, 1, 14, 14));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Потери при прокаливании",  0, 0, 15, 18));
        nameFieldsExcel.add(new NameFieldExcelStyle("100°С",                    1, 1, 15, 15));
        nameFieldsExcel.add(new NameFieldExcelStyle("300°С",                    1, 1, 16, 16));
        nameFieldsExcel.add(new NameFieldExcelStyle("500°С",                    1, 1, 17, 17));
        nameFieldsExcel.add(new NameFieldExcelStyle("800°С",                    1, 1, 18, 18));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("H₂S/\nCO₂",                0, 1, 19, 19));
        nameFieldsExcel.add(new NameFieldExcelStyle("Выводы",                   0, 1, 20, 20));
    }
    
    @FXML
    private void initialize(){      
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        // инициализируем колонки таблицы данными 
        n_skv.setCellValueFactory(cellData -> cellData.getValue().n_skv);
        dat_sel.setCellValueFactory(cellData -> cellData.getValue().dat_sel);
        dat_an.setCellValueFactory(cellData -> cellData.getValue().dat_an);
        point_ot.setCellValueFactory(cellData -> cellData.getValue().point_ot);
        vid.setCellValueFactory(cellData -> cellData.getValue().vid);
        FE3_FE2.setCellValueFactory(cellData -> cellData.getValue().FE3_FE2);
        FE_FEzol.setCellValueFactory(cellData -> cellData.getValue().FE_FEzol);
        S_total.setCellValueFactory(cellData -> cellData.getValue().S_total);
        S_elem.setCellValueFactory(cellData -> cellData.getValue().S_elem);
        Cl.setCellValueFactory(cellData -> cellData.getValue().Cl);
        CO3.setCellValueFactory(cellData -> cellData.getValue().CO3);
        SiO2.setCellValueFactory(cellData -> cellData.getValue().SiO2);
        C_grafit.setCellValueFactory(cellData -> cellData.getValue().C_grafit);
        uglevod.setCellValueFactory(cellData -> cellData.getValue().uglevod);
        water.setCellValueFactory(cellData -> cellData.getValue().water);
        p_100.setCellValueFactory(cellData -> cellData.getValue().p_100);
        p_300.setCellValueFactory(cellData -> cellData.getValue().p_300);
        p_500.setCellValueFactory(cellData -> cellData.getValue().p_500);
        p_800.setCellValueFactory(cellData -> cellData.getValue().p_800);
        H2S_CO2.setCellValueFactory(cellData -> cellData.getValue().H2S_CO2);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        
        // задаем списки для combobox
        comboBoxSkv.setItems(FXCollections.observableArrayList(DatabaseDriver.getListSkv(tablename)));
        comboBoxSkv.setValue("");
        
        // создаем событие для переключателя даты
        toggleGroupDate.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed (ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                changedToggleGroupDate(newValue);
            }
        });
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

    @FXML
    public void buttonViewAction(){ // событие просмотр данных
        viewTable("num_skv, n_skv, date_sel");
    }
    
    @FXML
    public void buttonNewValueAction(){ // событие - ввод новых данных, открываем новое окно
        try{
            OtlogenViewModel.new_id = -1;
            otlogen.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/otlogen/otlogen_new.fxml"));
            loader.setController(new OtlogenNewController(newStage, "add", tablename, new Otlogen()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (OtlogenViewModel.new_id != -1){
                var item = new Otlogen(DatabaseDriver.getRowFromDb(tablename, OtlogenViewModel.new_id));
                otlogen.getItems().add(makeViewModel(item));
                labelCount.setText("1");
                System.out.println("otlogen_new stage closed!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonChangeValueAction(){ // событие изменение данных, открываем новое окно
        String err = "id";
        try{
            var item = otlogen.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/otlogen/otlogen_new.fxml"));
            loader.setController(new OtlogenNewController(newStage, "change", tablename, new Otlogen(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new Otlogen(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = otlogen.getItems().indexOf(item);
            otlogen.getItems().set(index, makeViewModel(new_item));
            System.out.println("otlogen_new stage closed!");
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
            var item = otlogen.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            otlogen.getItems().remove(item); // обновляем визуализацию
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Не выбрана точка отбора!", "Ошибка удаления", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @FXML
    public void buttonSortSkvDateSelAction(){   // отсортировать данные по скважине и дате отбора
        viewTable("num_skv, n_skv, date_sel");
    }
    
    @FXML
    public void buttonSortDateSelAction(){       // отсортировать данные по дате отбора
        viewTable("date_sel");
    }
    
    public void viewTable(String sortCrit){ // отображение данных
        String dateOne = "", dateB = "", dateE = "";
        String skv = comboBoxSkv.getValue().toString();
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
        var data = DatabaseDriver.getDataFromDb(tablename, dateOne, dateB, dateE, "Все", skv, "", listPointOt, sortCrit);
        ArrayList<Otlogen> otlogenData = new ArrayList<Otlogen>();
        for (int i = 0; i < data.size(); i++) 
            otlogenData.add(new Otlogen(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<OtlogenViewModel>();
        for (int i=0; i< otlogenData.size(); i++)
            dataVm.add(makeViewModel(otlogenData.get(i)));
        
        // добавляем данные на форму
        otlogen.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public OtlogenViewModel makeViewModel(Otlogen otlogenData){
        return new OtlogenViewModel(otlogenData.id,otlogenData.n_skv,otlogenData.dat_sel,  
                otlogenData.dat_an,otlogenData.point_ot, otlogenData.FE3_FE2,  
                otlogenData.FE_FEzol,otlogenData.S_total, otlogenData.S_elem,  
                otlogenData.Cl, otlogenData.CO3, otlogenData.SiO2,  otlogenData.C_grafit,  
                otlogenData.uglevod,otlogenData.water,otlogenData.p_100, otlogenData.p_300,  
                otlogenData.p_500,otlogenData.p_800,  
                otlogenData.H2S_CO2,otlogenData.note,otlogenData.vid);
    }
}
