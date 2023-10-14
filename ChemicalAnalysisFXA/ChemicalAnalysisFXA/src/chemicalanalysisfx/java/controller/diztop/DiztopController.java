/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.diztop;

import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.NameFieldExcelStyle;
import chemicalanalysisfx.java.model.User;
import chemicalanalysisfx.java.model.diztop.Diztop;
import chemicalanalysisfx.java.viewmodel.diztop.DiztopViewModel;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
public class DiztopController extends BaseController{
    @FXML
    private TableView<DiztopViewModel> diztop;
    @FXML
    private TableColumn<DiztopViewModel, String> point_ot;
    @FXML
    private TableColumn<DiztopViewModel, String> dat_sel;
    @FXML
    private TableColumn<DiztopViewModel, String> dat_an;
    @FXML
    private TableColumn<DiztopViewModel, String> avto_N;
    @FXML
    private TableColumn<DiztopViewModel, String> uppg;
    @FXML
    private TableColumn<DiztopViewModel, String> plot;
    @FXML
    private TableColumn<DiztopViewModel, String> temp;
    @FXML
    private TableColumn<DiztopViewModel, String> frak1;
    @FXML
    private TableColumn<DiztopViewModel, String> frak2;
    @FXML
    private TableColumn<DiztopViewModel, String> temp2;
    @FXML
    private TableColumn<DiztopViewModel, String> h2o;
    @FXML
    private TableColumn<DiztopViewModel, String> note;
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
    private ComboBox<String> comboBoxUppg;
    @FXML
    private ComboBox<String> comboBoxAvto_N;
    @FXML
    private TextField textFieldAvto_Name;
    @FXML
    private TextField textFieldAvto_N;
    @FXML
    private CheckBox checkBoxSkv;
    @FXML
    private TextField textFieldSkv;
    @FXML
    private CheckBox checkBoxCist;
    @FXML
    private TextField textFieldCist;
    @FXML
    private CheckBox checkBoxEmk;
    @FXML
    private TextField textFieldEmk;
    @FXML
    private MenuButton buttonEdit;
    
    public DiztopController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<DiztopViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("Точка отбора",                         0, 1, 0, 0));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата",                                 0, 0, 1, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("отбора",                               1, 1, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("анализа",                              1, 1, 2, 2));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Автоцистерна",                         0, 1, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("ЦСЖ/\nУППГ",                           0, 1, 4, 4));
        nameFieldsExcel.add(new NameFieldExcelStyle("Плотность\nd ₄¹⁵",                     0, 1, 5, 5));
        nameFieldsExcel.add(new NameFieldExcelStyle("Температура вспышки \nв закрытом тигле, °С",   0, 1, 6, 6));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Фракционный состав",                   0, 0, 7, 8));
        nameFieldsExcel.add(new NameFieldExcelStyle("50%,\nне выше 280 °С",                 1, 1, 7, 7));
        nameFieldsExcel.add(new NameFieldExcelStyle("96%,\nне выше 360 °С",                 1, 1, 8, 8));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Температура\nзастывания °С, не выше",  0, 1, 9, 9));
        nameFieldsExcel.add(new NameFieldExcelStyle("Содержание\nводы, (%)",                0, 1, 10, 10));
        nameFieldsExcel.add(new NameFieldExcelStyle("Примечание",                           0, 1, 11, 11));
    }
    
    @FXML
    private void initialize(){
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        // инициализируем колонки таблицы данными 
        point_ot.setCellValueFactory(cellData -> cellData.getValue().point_ot_full);
        dat_sel.setCellValueFactory(cellData -> cellData.getValue().dat_sel);
        dat_an.setCellValueFactory(cellData -> cellData.getValue().dat_an);
        avto_N.setCellValueFactory(cellData -> cellData.getValue().avto_N);
        uppg.setCellValueFactory(cellData -> cellData.getValue().uppg);
        plot.setCellValueFactory(cellData -> cellData.getValue().plot);
        temp.setCellValueFactory(cellData -> cellData.getValue().temp);
        frak1.setCellValueFactory(cellData -> cellData.getValue().frak1);
        frak2.setCellValueFactory(cellData -> cellData.getValue().frak2);
        temp2.setCellValueFactory(cellData -> cellData.getValue().temp2);
        h2o.setCellValueFactory(cellData -> cellData.getValue().h2o);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        
        // задаем списки для combobox
        comboBoxUppg.setItems(FXCollections.observableArrayList("Все", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9", "ЦСЖ", "УСХР"));
        comboBoxUppg.setValue("Все");
        comboBoxAvto_N.setItems(FXCollections.observableArrayList("", "МАЗ", "КАМАЗ", "Татра", "КРАЗ"));
        comboBoxAvto_N.setValue("");
        
        // создаем событие для переключателя даты
        toggleGroupDate.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed (ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                changedToggleGroupDate(newValue);
            }
        });
    }
    
    @FXML
    public void buttonViewAction(){ // событие просмотр данных
        viewTable("dat_sel");
    }
    
    @FXML
    public void buttonNewValueAction(){ // событие - ввод новых данных, открываем новое окно
        try{
            DiztopViewModel.new_id = -1;
            diztop.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/diztop/diztop_new.fxml"));
            loader.setController(new DiztopNewController(newStage, "add", tablename, new Diztop()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (DiztopViewModel.new_id != -1){
                var item = new Diztop(DatabaseDriver.getRowFromDb(tablename, DiztopViewModel.new_id));
                diztop.getItems().add(makeViewModel(item));
                labelCount.setText("1");
                System.out.println("diztop_new stage closed!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonChangeValueAction(){ // событие изменение данных, открываем новое окно
        String err = "id";
        try{
            var item = diztop.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/diztop/diztop_new.fxml"));
            loader.setController(new DiztopNewController(newStage, "change", tablename, new Diztop(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new Diztop(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = diztop.getItems().indexOf(item);
            diztop.getItems().set(index, makeViewModel(new_item));
            System.out.println("diztop_new stage closed!");
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
            var item = diztop.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            diztop.getItems().remove(item); // обновляем визуализацию
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
    public void buttonSortDateSelAction(){   // отсортировать данные по дате отбора
        viewTable("dat_sel");
    }
    
    @FXML
    public void comboBoxAvto_NAction(){   // событие выбора а/ц из списка
        textFieldAvto_Name.setText(comboBoxAvto_N.getValue());
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
        String avtoN = textFieldAvto_Name.getText().strip().equals("") ? "" : 
                textFieldAvto_Name.getText().strip() + " №" + (textFieldAvto_N.getText().strip().equals("") ? "%"
                : textFieldAvto_N.getText().strip());
        String skv_n = textFieldSkv.getText().strip(), 
               NN_cis = textFieldCist.getText().strip(), 
               NN_emk = textFieldEmk.getText().strip();
        ArrayList<String> listPointOt = new ArrayList<String>();
        RadioButton selectedBtn = (RadioButton)toggleGroupDate.getSelectedToggle();
        if (selectedBtn.getText().equals("только за")) {
            dateOne=datePickerOneDate.getValue() == null ? "" : datePickerOneDate.getValue().toString().replace('-', '.');
        }
        else if (selectedBtn.getText().equals("диапазон")){
            dateB=datePickerRangeDateB.getValue() == null ? "" : datePickerRangeDateB.getValue().toString().replace('-', '.');
            dateE=datePickerRangeDateE.getValue() == null ? "" : datePickerRangeDateE.getValue().toString().replace('-', '.');
        }
        System.out.println(dateOne + " " + dateB + " " + dateE);
        
        if(checkBoxSkv.isSelected()) listPointOt.add("Скважина");
        if(checkBoxEmk.isSelected()) listPointOt.add("Емкость");
        if(checkBoxCist.isSelected()) listPointOt.add("Цистерна");
        if (listPointOt.isEmpty()) listPointOt.add("");
        
        // получаем данные из БД отсортированные
        var data = DatabaseDriver.getDataFromRastDizt(tablename, dateOne, dateB, dateE, listPointOt, skv_n, NN_emk, NN_cis, uppg, avtoN, sortCrit);
        ArrayList<Diztop> rastvorData = new ArrayList<Diztop>();
        for (int i = 0; i < data.size(); i++) 
            rastvorData.add(new Diztop(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<DiztopViewModel>();
        for (int i=0; i< rastvorData.size(); i++)
            dataVm.add(makeViewModel(rastvorData.get(i)));
        
        // добавляем данные на форму
        diztop.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public DiztopViewModel makeViewModel(Diztop diztopData){
        String point_ot_full = diztopData.point_ot.equals("Скважина") ? diztopData.point_ot + " " + diztopData.skv_n :
                diztopData.point_ot + " " + diztopData.NN;
        return new DiztopViewModel(diztopData.id, point_ot_full, diztopData.avto_N, 
                    diztopData.uppg, diztopData.dat_sel, diztopData.dat_an, 
                    diztopData.plot, diztopData.frak1, diztopData.frak2, 
                    diztopData.temp, diztopData.temp2, diztopData.h2o, diztopData.note);
    }
}
