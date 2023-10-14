/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.rastvor;

import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.NameFieldExcelStyle;
import chemicalanalysisfx.java.model.User;
import chemicalanalysisfx.java.model.rastvor.Rastvor;
import chemicalanalysisfx.java.viewmodel.rastvor.RastvorViewModel;
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
public class RastvorController extends BaseController{
    @FXML
    private TableView<RastvorViewModel> rastvor;
    @FXML
    private TableColumn<RastvorViewModel, String> point_ot;
    @FXML
    private TableColumn<RastvorViewModel, String> dat_sel;
    @FXML
    private TableColumn<RastvorViewModel, String> dat_an;
    @FXML
    private TableColumn<RastvorViewModel, String> avto_N;
    @FXML
    private TableColumn<RastvorViewModel, String> ustan;
    @FXML
    private TableColumn<RastvorViewModel, String> plot;
    @FXML
    private TableColumn<RastvorViewModel, String> kon_fak;
    @FXML
    private TableColumn<RastvorViewModel, String> kon_zad;
    @FXML
    private TableColumn<RastvorViewModel, String> rast;
    @FXML
    private TableColumn<RastvorViewModel, String> h2o;
    @FXML
    private TableColumn<RastvorViewModel, String> note;
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
    private ComboBox<String> comboBoxUstan;
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
    
    public RastvorController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<RastvorViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("Точка отбора",                 0, 1, 0, 0));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата",                         0, 0, 1, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("отбора",                       1, 1, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("анализа",                      1, 1, 2, 2));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Автоцистерна",                 0, 1, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("ЦСЖ/\nУППГ",                   0, 1, 4, 4));
        nameFieldsExcel.add(new NameFieldExcelStyle("Плотность\nd ₄¹⁵",              0, 1, 5, 5));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Концентрация\n  инг-ра (%Д)",  0, 0, 6, 7));
        nameFieldsExcel.add(new NameFieldExcelStyle("фактич.",                      1, 1, 6, 6));
        nameFieldsExcel.add(new NameFieldExcelStyle("задан.",                       1, 1, 7, 7));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Растворитель",                 0, 1, 8, 8));
        nameFieldsExcel.add(new NameFieldExcelStyle("Содержание H₂O,\n  % масс.",    0, 1, 9, 9));
        nameFieldsExcel.add(new NameFieldExcelStyle("Примечание",                   0, 1, 10, 10));
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
        ustan.setCellValueFactory(cellData -> cellData.getValue().ustan);
        plot.setCellValueFactory(cellData -> cellData.getValue().plot);
        kon_fak.setCellValueFactory(cellData -> cellData.getValue().kon_fak);
        kon_zad.setCellValueFactory(cellData -> cellData.getValue().kon_zad);
        rast.setCellValueFactory(cellData -> cellData.getValue().rast);
        h2o.setCellValueFactory(cellData -> cellData.getValue().h2o);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        
        // задаем списки для combobox
        comboBoxUstan.setItems(FXCollections.observableArrayList("Все", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9", "ЦСЖ", "УСХР"));
        comboBoxUstan.setValue("Все");
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
            RastvorViewModel.new_id = -1;
            rastvor.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/rastvor/rastvor_new.fxml"));
            loader.setController(new RastvorNewController(newStage, "add", tablename, new Rastvor()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (RastvorViewModel.new_id != -1){
                var item = new Rastvor(DatabaseDriver.getRowFromDb(tablename, RastvorViewModel.new_id));
                rastvor.getItems().add(makeViewModel(item));
                labelCount.setText("1");
                System.out.println("rastvor_new stage closed!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonChangeValueAction(){ // событие изменение данных, открываем новое окно
        String err = "id";
        try{
            var item = rastvor.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/rastvor/rastvor_new.fxml"));
            loader.setController(new RastvorNewController(newStage, "change", tablename, new Rastvor(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new Rastvor(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = rastvor.getItems().indexOf(item);
            rastvor.getItems().set(index, makeViewModel(new_item));
            System.out.println("rastvor_new stage closed!");
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
            var item = rastvor.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            rastvor.getItems().remove(item); // обновляем визуализацию
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
        String ustan = comboBoxUstan.getValue().toString(); 
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
        var data = DatabaseDriver.getDataFromRastDizt(tablename, dateOne, dateB, dateE, listPointOt, skv_n, NN_emk, NN_cis, ustan, avtoN, sortCrit);
        ArrayList<Rastvor> rastvorData = new ArrayList<Rastvor>();
        for (int i = 0; i < data.size(); i++) 
            rastvorData.add(new Rastvor(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<RastvorViewModel>();
        for (int i=0; i< rastvorData.size(); i++)
            dataVm.add(makeViewModel(rastvorData.get(i)));
        
        // добавляем данные на форму
        rastvor.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public RastvorViewModel makeViewModel(Rastvor rastvorData){
        String point_ot_full = rastvorData.point_ot.equals("Скважина") ? rastvorData.point_ot + " " + rastvorData.skv_n :
                rastvorData.point_ot + " " + rastvorData.NN;
        return new RastvorViewModel(rastvorData.id, point_ot_full, rastvorData.avto_N, 
                    rastvorData.ustan, rastvorData.dat_sel, rastvorData.dat_an, 
                    rastvorData.plot, rastvorData.kon_fak, rastvorData.kon_zad, 
                    rastvorData.rast, rastvorData.h2o, rastvorData.note);
    }
}
