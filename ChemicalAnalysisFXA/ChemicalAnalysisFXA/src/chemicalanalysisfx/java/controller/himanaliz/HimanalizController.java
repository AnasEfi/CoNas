/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.himanaliz;

import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.controller.podzem.PodzemNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.NameFieldExcelStyle;
import chemicalanalysisfx.java.model.User;
import chemicalanalysisfx.java.model.himanaliz.Himanaliz;
import chemicalanalysisfx.java.model.podzem.Podzem;
import chemicalanalysisfx.java.viewmodel.himanaliz.HimanalizViewModel;
import chemicalanalysisfx.java.viewmodel.podzem.PodzemViewModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ebondarenko
 */
public class HimanalizController extends BaseController{
    @FXML
    private TableView<HimanalizViewModel> himanaliz;
    @FXML
    private TableColumn<HimanalizViewModel, String> n_skv;
    @FXML
    private TableColumn<HimanalizViewModel, String> uppg;
    @FXML
    private TableColumn<HimanalizViewModel, String> point_ot;
    @FXML
    private TableColumn<HimanalizViewModel, String> dat_sel;
    @FXML
    private TableColumn<HimanalizViewModel, String> dat_an;
    @FXML
    private TableColumn<HimanalizViewModel, String> pres_b;
    @FXML
    private TableColumn<HimanalizViewModel, String> pres_e;
    @FXML
    private TableColumn<HimanalizViewModel, String> he;
    @FXML
    private TableColumn<HimanalizViewModel, String> h2;
    @FXML
    private TableColumn<HimanalizViewModel, String> n2;
    @FXML
    private TableColumn<HimanalizViewModel, String> o2;
    @FXML
    private TableColumn<HimanalizViewModel, String> c1;
    @FXML
    private TableColumn<HimanalizViewModel, String> co2;
    @FXML
    private TableColumn<HimanalizViewModel, String> c2;
    @FXML
    private TableColumn<HimanalizViewModel, String> h2s;
    @FXML
    private TableColumn<HimanalizViewModel, String> c3;
    @FXML
    private TableColumn<HimanalizViewModel, String> ic4;
    @FXML
    private TableColumn<HimanalizViewModel, String> c4;
    @FXML
    private TableColumn<HimanalizViewModel, String> ic5;
    @FXML
    private TableColumn<HimanalizViewModel, String> c5;
    @FXML
    private TableColumn<HimanalizViewModel, String> c6;
    @FXML
    private TableColumn<HimanalizViewModel, String> c7;
    @FXML
    private TableColumn<HimanalizViewModel, String> rsh;
    @FXML
    private TableColumn<HimanalizViewModel, String> sum_comp;
    @FXML
    private TableColumn<HimanalizViewModel, String> molec_mass;
    @FXML
    private TableColumn<HimanalizViewModel, String> abs_density;
    @FXML
    private TableColumn<HimanalizViewModel, String> otn_density;
    @FXML
    private TableColumn<HimanalizViewModel, String> note;
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
    private CheckBox checkBoxGazDebut;
    @FXML
    private CheckBox checkBoxGazDegaz;
    @FXML
    private CheckBox checkBoxGazOch;
    @FXML
    private CheckBox checkBox79;
    @FXML
    private CheckBox checkBox912;
    @FXML
    private CheckBox checkBox1216;
    @FXML
    private MenuButton buttonEdit;
    
    public HimanalizController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<HimanalizViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        nameFieldsExcel.add(new NameFieldExcelStyle("№, скв",          0, 1, 0, 0));
        nameFieldsExcel.add(new NameFieldExcelStyle("УППГ",             0, 1, 1, 1));
        nameFieldsExcel.add(new NameFieldExcelStyle("Точка\nотбора",    0, 1, 2, 2));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата\nотбора",     0, 1, 3, 3));
        nameFieldsExcel.add(new NameFieldExcelStyle("Дата анализа",     0, 1, 4, 4));
        nameFieldsExcel.add(new NameFieldExcelStyle("Pтр\nPнач",        0, 1, 5, 5));
        nameFieldsExcel.add(new NameFieldExcelStyle("Pкс\nPкон",        0, 1, 6, 6));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Содержание компонентов газа, % моль",  0, 0, 7, 22));
        nameFieldsExcel.add(new NameFieldExcelStyle("He",               1, 1, 7, 7));
        nameFieldsExcel.add(new NameFieldExcelStyle("H₂",               1, 1, 8, 8));
        nameFieldsExcel.add(new NameFieldExcelStyle("N₂",               1, 1, 9, 9));
        nameFieldsExcel.add(new NameFieldExcelStyle("O₂",               1, 1, 10, 10));
        nameFieldsExcel.add(new NameFieldExcelStyle("C₁",               1, 1, 11, 11));
        nameFieldsExcel.add(new NameFieldExcelStyle("CO₂",              1, 1, 12, 12));
        nameFieldsExcel.add(new NameFieldExcelStyle("C₂",               1, 1, 13, 13));
        nameFieldsExcel.add(new NameFieldExcelStyle("H₂S",              1, 1, 14, 14));
        nameFieldsExcel.add(new NameFieldExcelStyle("C₃",               1, 1, 15, 15));
        nameFieldsExcel.add(new NameFieldExcelStyle("iC₄",              1, 1, 16, 16));
        nameFieldsExcel.add(new NameFieldExcelStyle("C₄",               1, 1, 17, 17));
        nameFieldsExcel.add(new NameFieldExcelStyle("iC₅",              1, 1, 18, 18));
        nameFieldsExcel.add(new NameFieldExcelStyle("C₅",               1, 1, 19, 19));
        nameFieldsExcel.add(new NameFieldExcelStyle("∑C₆",              1, 1, 20, 20));
        nameFieldsExcel.add(new NameFieldExcelStyle("∑C₇",              1, 1, 21, 21));
        nameFieldsExcel.add(new NameFieldExcelStyle("∑RSH",             1, 1, 22, 22));
        
        nameFieldsExcel.add(new NameFieldExcelStyle("Суммарное\nсодержание\nкомпонентов\n%",    0, 1, 23, 23));
        nameFieldsExcel.add(new NameFieldExcelStyle("Молеку-\nлярная\nмасса\nгаза",             0, 1, 24, 24));
        nameFieldsExcel.add(new NameFieldExcelStyle("Абсо-\nлютная\nплотность\nкг/m³",          0, 1, 25, 25));
        nameFieldsExcel.add(new NameFieldExcelStyle("Относи-\nтельная\nплот-\nность",           0, 1, 26, 26));
        nameFieldsExcel.add(new NameFieldExcelStyle("Примечание",                               0, 1, 27, 27));
    }
    
    @FXML
    private void initialize(){
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        n_skv.setCellValueFactory(cellData -> cellData.getValue().n_skv);
        uppg.setCellValueFactory(cellData -> cellData.getValue().uppg);
        point_ot.setCellValueFactory(cellData -> cellData.getValue().point_ot);
        dat_sel.setCellValueFactory(cellData -> cellData.getValue().dat_sel);
        dat_an.setCellValueFactory(cellData -> cellData.getValue().dat_an);
        pres_b.setCellValueFactory(cellData -> cellData.getValue().pres_b);
        pres_e.setCellValueFactory(cellData -> cellData.getValue().pres_e);
        he.setCellValueFactory(cellData -> cellData.getValue().he);
        h2.setCellValueFactory(cellData -> cellData.getValue().h2);
        n2.setCellValueFactory(cellData -> cellData.getValue().n2);
        o2.setCellValueFactory(cellData -> cellData.getValue().o2);
        c1.setCellValueFactory(cellData -> cellData.getValue().c1);
        co2.setCellValueFactory(cellData -> cellData.getValue().co2);
        c2.setCellValueFactory(cellData -> cellData.getValue().c2);
        h2s.setCellValueFactory(cellData -> cellData.getValue().h2s);
        c3.setCellValueFactory(cellData -> cellData.getValue().c3);
        ic4.setCellValueFactory(cellData -> cellData.getValue().ic4);
        c4.setCellValueFactory(cellData -> cellData.getValue().c4);
        ic5.setCellValueFactory(cellData -> cellData.getValue().ic5);
        c5.setCellValueFactory(cellData -> cellData.getValue().c5);
        c6.setCellValueFactory(cellData -> cellData.getValue().c6);
        c7.setCellValueFactory(cellData -> cellData.getValue().c7);
        rsh.setCellValueFactory(cellData -> cellData.getValue().rsh);
        sum_comp.setCellValueFactory(cellData -> cellData.getValue().sum_comp);
        molec_mass.setCellValueFactory(cellData -> cellData.getValue().molec_mass);
        abs_density.setCellValueFactory(cellData -> cellData.getValue().abs_density);
        otn_density.setCellValueFactory(cellData -> cellData.getValue().otn_density);
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
            HimanalizViewModel.new_id = -1;
            himanaliz.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/himanaliz/himanaliz_new.fxml"));
            loader.setController(new HimanalizNewController(newStage, "add", tablename, 1, new Himanaliz()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (HimanalizViewModel.new_id != -1){
                var item = new Himanaliz(DatabaseDriver.getRowFromDb(tablename, HimanalizViewModel.new_id));
                himanaliz.getItems().add(makeViewModel(item));
                labelCount.setText("1");
                System.out.println("podzem_new stage closed!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonNewValueAction2(){ // событие - ввод новых данных, открываем новое окно
        try{
            HimanalizViewModel.new_id = -1;
            himanaliz.getItems().clear();
            labelCount.setText("0");
            
            Stage newStage = new Stage();
            newStage.setTitle("Ввод новых значений");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/himanaliz/himanaliz_new.fxml"));
            loader.setController(new HimanalizNewController(newStage, "add", tablename, 2, new Himanaliz()));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            if (HimanalizViewModel.new_id != -1){
                var item = new Himanaliz(DatabaseDriver.getRowFromDb(tablename, HimanalizViewModel.new_id));
                himanaliz.getItems().add(makeViewModel(item));
                labelCount.setText("1");
                System.out.println("podzem_new stage closed!");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void buttonChangeValueAction(){
        String err = "id";
        try{
            var item = himanaliz.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            
            err="stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/himanaliz/himanaliz_new.fxml"));
            loader.setController(new HimanalizNewController(newStage, "change", tablename, 1, new Himanaliz(DatabaseDriver.getRowFromDb(tablename, item.id.get()))));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            newStage.setScene(scene);
            newStage.showAndWait();
            
            // обновляем визуализацию
            var new_item = new Himanaliz(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = himanaliz.getItems().indexOf(item);
            himanaliz.getItems().set(index, makeViewModel(new_item));
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
            var item = himanaliz.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            himanaliz.getItems().remove(item); // обновляем визуализацию
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Не выбрана точка отбора!", "Ошибка удаления", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @FXML
    public void buttonSortPointOtAction(){ // отсортировать данные по точке отбора
        viewTable("point_ot");
    }
    @FXML
    public void buttonSortSkvDateSelAction(){ // отсортировать данные по скважине и дате отбора
        viewTable("num_skv, n_skv, dat_sel");
    }
    @FXML
    public void buttonSortDateAnAction(){  // отсортировать данные по дате анализа
        viewTable("dat_an");
    }
    @FXML
    public void buttonSortUppgAction(){ // отсортировать данные по УППГ
        viewTable("uppg, num_skv, n_skv, dat_sel");
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
    
    public void changedToggleGroupPointOt(Toggle newValue){
        RadioButton selectedBtn = (RadioButton)newValue;
        if (selectedBtn.getText().equals("все")){
            checkBoxKS.setVisible(false);
            checkBoxZatr.setVisible(false);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGazDebut.setVisible(false);
            checkBoxGazDegaz.setVisible(false);
            checkBoxGazOch.setVisible(false);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
        }
        else if (selectedBtn.getText().equals("МКП")){
            checkBoxKS.setVisible(false);
            checkBoxZatr.setVisible(false);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGazDebut.setVisible(false);
            checkBoxGazDegaz.setVisible(false);
            checkBoxGazOch.setVisible(false);
            checkBox79.setVisible(true);
            checkBox912.setVisible(true);
            checkBox1216.setVisible(true);
        }
        else{
            checkBoxKS.setVisible(true);
            checkBoxZatr.setVisible(true);
            checkBoxUst.setVisible(true);
            checkBoxProch.setVisible(true);
            checkBoxGazDebut.setVisible(true);
            checkBoxGazDegaz.setVisible(true);
            checkBoxGazOch.setVisible(true);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
        }
    }
    
    public void viewTable(String sortCrit){
        String dateOne = "", dateB="", dateE="";
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
            if(checkBoxGazDebut.isSelected()) listPointOt.add(checkBoxGazDebut.getText());
            if(checkBoxGazDegaz.isSelected()) listPointOt.add(checkBoxGazDegaz.getText());
            if(checkBoxGazOch.isSelected()) listPointOt.add(checkBoxGazOch.getText());
        }
        
        // получаем данные из БД отсортированные
        var data = DatabaseDriver.getDataFromDb(tablename, dateOne, dateB, dateE, "Все", skv, "", listPointOt, sortCrit);
        ArrayList<Himanaliz> himanalizData = new ArrayList<Himanaliz>();
        for (int i = 0; i < data.size(); i++) 
            himanalizData.add(new Himanaliz(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<HimanalizViewModel>();
        for (int i=0; i< himanalizData.size(); i++)
            dataVm.add(makeViewModel(himanalizData.get(i)));
        
        himanaliz.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public HimanalizViewModel makeViewModel(Himanaliz himanalizData){
        return new HimanalizViewModel(himanalizData.id, himanalizData.n_skv, himanalizData.uppg, 
                    himanalizData.point_ot, himanalizData.dat_sel, himanalizData.dat_an, himanalizData.pres_b,
                    himanalizData.pres_e, himanalizData.he, himanalizData.h2, himanalizData.n2, himanalizData.o2,
                    himanalizData.c1, himanalizData.co2, himanalizData.c2, himanalizData.h2s, himanalizData.c3,
                    himanalizData.ic4, himanalizData.c4, himanalizData.ic5, himanalizData.c5, himanalizData.c6,
                    himanalizData.c7, himanalizData.rsh, himanalizData.sum_comp, himanalizData.molec_mass,
                    himanalizData.abs_density, himanalizData.otn_density, himanalizData.note);
    }
}
