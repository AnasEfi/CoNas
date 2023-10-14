/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.proby;

import chemicalanalysisfx.java.controller.BaseController;
import chemicalanalysisfx.java.controller.podzem.PodzemNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.NameFieldExcelStyle;
import chemicalanalysisfx.java.model.RowData;
import chemicalanalysisfx.java.model.User;
import chemicalanalysisfx.java.model.podzem.Podzem;
import chemicalanalysisfx.java.model.proby.Proby;
import chemicalanalysisfx.java.viewmodel.podzem.PodzemViewModel;
import chemicalanalysisfx.java.viewmodel.proby.ProbyViewModel;
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
public class ProbyController extends BaseController {    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private TableView<ProbyViewModel> proby;
    @FXML
    private TableColumn<ProbyViewModel, String> n_skv;
    @FXML
    private TableColumn<ProbyViewModel, String> point_ot;
    @FXML
    private TableColumn<ProbyViewModel, String> note;
    @FXML
    private TableColumn<ProbyViewModel, String> dat_sel;
    @FXML
    private TableColumn<ProbyViewModel, String> dat_an;
    @FXML
    private TableColumn<ProbyViewModel, String> pres_n;
    @FXML
    private TableColumn<ProbyViewModel, String> pres_k;
    @FXML
    private TableColumn<ProbyViewModel, String> plot;
    @FXML
    private TableColumn<ProbyViewModel, String> v20;
    @FXML
    private TableColumn<ProbyViewModel, String> v50;
    @FXML
    private TableColumn<ProbyViewModel, String> prel;
    @FXML
    private TableColumn<ProbyViewModel, String> mol_mass;
    @FXML
    private TableColumn<ProbyViewModel, String> voda;
    @FXML
    private TableColumn<ProbyViewModel, String> asfal;
    @FXML
    private TableColumn<ProbyViewModel, String> smol;
    @FXML
    private TableColumn<ProbyViewModel, String> paraf;
    @FXML
    private TableColumn<ProbyViewModel, String> masla;
    @FXML
    private TableColumn<ProbyViewModel, String> ser_o;
    @FXML
    private TableColumn<ProbyViewModel, String> ser_m;
    @FXML
    private TableColumn<ProbyViewModel, String> ser_s;
    @FXML
    private TableColumn<ProbyViewModel, String> hlor_s;
    @FXML
    private TableColumn<ProbyViewModel, String> m_prim;
    @FXML
    private TableColumn<ProbyViewModel, String> kisl;
    @FXML
    private TableColumn<ProbyViewModel, String> t_nk;
    
    @FXML
    private TableColumn<ProbyViewModel, String> volume;
    @FXML
    private TableColumn<ProbyViewModel, String> v_100;
    @FXML
    private TableColumn<ProbyViewModel, String> v_120;
    @FXML
    private TableColumn<ProbyViewModel, String> v_140;
    @FXML
    private TableColumn<ProbyViewModel, String> v_150;
    @FXML
    private TableColumn<ProbyViewModel, String> v_160;
    @FXML
    private TableColumn<ProbyViewModel, String> v_180;
    @FXML
    private TableColumn<ProbyViewModel, String> v_200;
    @FXML
    private TableColumn<ProbyViewModel, String> v_220;
    @FXML
    private TableColumn<ProbyViewModel, String> v_240;
    @FXML
    private TableColumn<ProbyViewModel, String> v_250;
    @FXML
    private TableColumn<ProbyViewModel, String> v_260;
    @FXML
    private TableColumn<ProbyViewModel, String> v_280;
    @FXML
    private TableColumn<ProbyViewModel, String> v_300;
    @FXML
    private TableColumn<ProbyViewModel, String> v_350;
    
    @FXML
    private TableColumn<ProbyViewModel, String> temp;
    @FXML
    private TableColumn<ProbyViewModel, String> t_10;
    @FXML
    private TableColumn<ProbyViewModel, String> t_20;
    @FXML
    private TableColumn<ProbyViewModel, String> t_30;
    @FXML
    private TableColumn<ProbyViewModel, String> t_40;
    @FXML
    private TableColumn<ProbyViewModel, String> t_50;
    @FXML
    private TableColumn<ProbyViewModel, String> t_60;
    @FXML
    private TableColumn<ProbyViewModel, String> t_70;
    @FXML
    private TableColumn<ProbyViewModel, String> t_80;
    @FXML
    private TableColumn<ProbyViewModel, String> t_90;
    @FXML
    private TableColumn<ProbyViewModel, String> t_96;
    
    @FXML
    private TableColumn<ProbyViewModel, String> t_kk;
    @FXML
    private TableColumn<ProbyViewModel, String> vyh_300;
    @FXML
    private TableColumn<ProbyViewModel, String> vyh;
    @FXML
    private TableColumn<ProbyViewModel, String> ostat;
    @FXML
    private TableColumn<ProbyViewModel, String> poter;
    @FXML
    private TableColumn<ProbyViewModel, String> conc;
    
    @FXML
    private Label labelTitle;
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
    private ToggleGroup toggleGroupFS;
    @FXML
    private ToggleGroup toggleGroupPointOt;
    
    @FXML
    private CheckBox checkBox79;
    @FXML
    private CheckBox checkBox912;
    @FXML
    private CheckBox checkBox1216;
    @FXML
    private CheckBox checkBoxDBK;
    @FXML
    private CheckBox checkBoxUst;
    @FXML
    private CheckBox checkBoxGlub;
    @FXML
    private CheckBox checkBoxProch;
    @FXML
    private CheckBox checkBoxDGK;
    @FXML
    private MenuButton buttonEdit;
    
    public ProbyController(Stage primaryStage, String tablename){
        super(primaryStage, tablename);
        dataVm = new ArrayList<PodzemViewModel>();
        nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
        /*nameFieldsExcel.add(new NameFieldExcelStyle("№, скв",                          0, 1, 0, 0));
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
        nameFieldsExcel.add(new NameFieldExcelStyle("Примечание",                       0, 1, 18, 18));*/
    }
    
    @FXML
    private void initialize(){      
        if (User.flag_edit == 1) buttonEdit.setDisable(false);
        else buttonEdit.setDisable(true);
        // инициализируем колонки таблицы данными 
        n_skv.setCellValueFactory(cellData -> cellData.getValue().n_skv);
        point_ot.setCellValueFactory(cellData -> cellData.getValue().point_ot);
        note.setCellValueFactory(cellData -> cellData.getValue().note);
        dat_sel.setCellValueFactory(cellData -> cellData.getValue().dat_sel);
        dat_an.setCellValueFactory(cellData -> cellData.getValue().dat_an);
        pres_n.setCellValueFactory(cellData -> cellData.getValue().pres_n);
        pres_k.setCellValueFactory(cellData -> cellData.getValue().pres_k);
        plot.setCellValueFactory(cellData -> cellData.getValue().plot);
        v20.setCellValueFactory(cellData -> cellData.getValue().v20);
        v50.setCellValueFactory(cellData -> cellData.getValue().v50);
        prel.setCellValueFactory(cellData -> cellData.getValue().prel);
        mol_mass.setCellValueFactory(cellData -> cellData.getValue().mol_mass);
        voda.setCellValueFactory(cellData -> cellData.getValue().voda);
        asfal.setCellValueFactory(cellData -> cellData.getValue().asfal);
        smol.setCellValueFactory(cellData -> cellData.getValue().smol);
        paraf.setCellValueFactory(cellData -> cellData.getValue().paraf);
        masla.setCellValueFactory(cellData -> cellData.getValue().masla);
        ser_o.setCellValueFactory(cellData -> cellData.getValue().ser_o);
        ser_m.setCellValueFactory(cellData -> cellData.getValue().ser_m);
        ser_s.setCellValueFactory(cellData -> cellData.getValue().ser_s);
        hlor_s.setCellValueFactory(cellData -> cellData.getValue().hlor_s);
        m_prim.setCellValueFactory(cellData -> cellData.getValue().m_prim);
        kisl.setCellValueFactory(cellData -> cellData.getValue().kisl);
        t_nk.setCellValueFactory(cellData -> cellData.getValue().t_nk);
        v_100.setCellValueFactory(cellData -> cellData.getValue().v_100);
        v_120.setCellValueFactory(cellData -> cellData.getValue().v_120);
        v_140.setCellValueFactory(cellData -> cellData.getValue().v_140);
        v_150.setCellValueFactory(cellData -> cellData.getValue().v_150);
        v_160.setCellValueFactory(cellData -> cellData.getValue().v_160);
        v_180.setCellValueFactory(cellData -> cellData.getValue().v_180);
        v_200.setCellValueFactory(cellData -> cellData.getValue().v_200);
        v_220.setCellValueFactory(cellData -> cellData.getValue().v_220);
        v_240.setCellValueFactory(cellData -> cellData.getValue().v_240);
        v_250.setCellValueFactory(cellData -> cellData.getValue().v_250);
        v_260.setCellValueFactory(cellData -> cellData.getValue().v_260);
        v_280.setCellValueFactory(cellData -> cellData.getValue().v_280);
        v_300.setCellValueFactory(cellData -> cellData.getValue().v_300);
        v_350.setCellValueFactory(cellData -> cellData.getValue().v_350);
        t_10.setCellValueFactory(cellData -> cellData.getValue().t_10);
        t_20.setCellValueFactory(cellData -> cellData.getValue().t_20);
        t_30.setCellValueFactory(cellData -> cellData.getValue().t_30);
        t_40.setCellValueFactory(cellData -> cellData.getValue().t_40);
        t_50.setCellValueFactory(cellData -> cellData.getValue().t_50);
        t_60.setCellValueFactory(cellData -> cellData.getValue().t_60);
        t_70.setCellValueFactory(cellData -> cellData.getValue().t_70);
        t_80.setCellValueFactory(cellData -> cellData.getValue().t_80);
        t_90.setCellValueFactory(cellData -> cellData.getValue().t_90);
        t_96.setCellValueFactory(cellData -> cellData.getValue().t_96);
        t_kk.setCellValueFactory(cellData -> cellData.getValue().t_kk);
        vyh_300.setCellValueFactory(cellData -> cellData.getValue().vyh_300);
        vyh.setCellValueFactory(cellData -> cellData.getValue().vyh);
        ostat.setCellValueFactory(cellData -> cellData.getValue().ostat);
        poter.setCellValueFactory(cellData -> cellData.getValue().poter);
        conc.setCellValueFactory(cellData -> cellData.getValue().conc);
        
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
        
        // создаем событие для переключателя точки ФС
        toggleGroupFS.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                changedToggleGroupFS(newValue);
            }
        });
    }
    
    @FXML
    public void buttonViewAction(){ // событие просмотр данных
        viewTable("num_skv, n_skv, dat_ot");
    }
    
    @FXML
    public void buttonNewValueAction(){ // событие - ввод новых данных, открываем новое окно
        /*try{
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
        }*/
    }
    
    @FXML
    public void buttonChangeValueAction(){ // событие изменение данных, открываем новое окно
        /*String err = "id";
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
        }*/
    }
    
    @FXML
    public void buttonDeleteValueAction(){ // событие удаление строки
        try{
            var item = proby.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));
            DatabaseDriver.deleteRowFromDb(tablename, item.id.get());
            proby.getItems().remove(item); // обновляем визуализацию
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
        viewTable("num_skv, n_skv, dat_ot");
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
            labelTitle.setText("Пробы органического происхождения со скважин АГКМ");
            conc.setVisible(true);
            ostat.setVisible(true);
            poter.setVisible(true);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
            checkBoxDBK.setVisible(false);
            checkBoxDGK.setVisible(false);
        }
        else if (selectedBtn.getText().equals("К/С")){
            labelTitle.setText("Пробы органического происхождения с контрольного сепаратора");
            conc.setVisible(false);
            ostat.setVisible(true);
            poter.setVisible(true);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
            checkBoxDBK.setVisible(false);
            checkBoxDGK.setVisible(false);
        }
        else if (selectedBtn.getText().equals("Затруб")){
            labelTitle.setText("Пробы органического происхождения с затрубного пространства");
            conc.setVisible(true);
            ostat.setVisible(true);
            poter.setVisible(true);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
            checkBoxDBK.setVisible(false);
            checkBoxDGK.setVisible(false);
        }
        else if (selectedBtn.getText().equals("МКП")){
            labelTitle.setText("Пробы органического происхождения межколонных перетоков скважин АГКМ");
            conc.setVisible(false);
            ostat.setVisible(true);
            poter.setVisible(true);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(true);
            checkBox912.setVisible(true);
            checkBox1216.setVisible(true);
            checkBoxDBK.setVisible(false);
            checkBoxDGK.setVisible(false);
        }
        else if (selectedBtn.getText().equals("Нефть")){
            labelTitle.setText("Пробы органического происхождения со скважин АГКМ");
            conc.setVisible(false);
            ostat.setVisible(false);
            poter.setVisible(false);
            checkBoxUst.setVisible(false);
            checkBoxProch.setVisible(false);
            checkBoxGlub.setVisible(false);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
            checkBoxDBK.setVisible(false);
            checkBoxDGK.setVisible(false);
        }
        else{
            labelTitle.setText("Пробы органического происхождения со скважин АГКМ");
            conc.setVisible(false);
            ostat.setVisible(true);
            poter.setVisible(true);
            checkBoxUst.setVisible(true);
            checkBoxProch.setVisible(true);
            checkBoxGlub.setVisible(true);
            checkBox79.setVisible(false);
            checkBox912.setVisible(false);
            checkBox1216.setVisible(false);
            checkBoxDBK.setVisible(true);
            checkBoxDGK.setVisible(true);
        }
    }
    
    public void changedToggleGroupFS(Toggle newValue){ // обработка события переключателя точки отбора
        RadioButton selectedBtn = (RadioButton)newValue;
        if (selectedBtn.getText().equals("V, % 100...350")){
            volume.setVisible(true);
            temp.setVisible(false);
        } else{
            volume.setVisible(false);
            temp.setVisible(true);
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
        if (selectedBtnPoint.getText().equals("К/С") || selectedBtnPoint.getText().equals("Затруб") || selectedBtnPoint.getText().equals("Нефть")){ 
            listPointOt.add(selectedBtnPoint.getText());
        }
        else if(selectedBtnPoint.getText().equals("МКП")){
            if(checkBox79.isSelected()) listPointOt.add(checkBox79.getText());
            if(checkBox912.isSelected()) listPointOt.add(checkBox912.getText());
            if(checkBox1216.isSelected()) listPointOt.add(checkBox1216.getText());
        }
        else if(selectedBtnPoint.getText().equals("другие")){
            if(checkBoxUst.isSelected()) listPointOt.add(checkBoxUst.getText());
            if(checkBoxGlub.isSelected()) listPointOt.add(checkBoxGlub.getText());
            if(checkBoxProch.isSelected()) listPointOt.add(checkBoxProch.getText());
            if(checkBoxDBK.isSelected()) listPointOt.add(checkBoxDBK.getText());
            if(checkBoxDGK.isSelected()) listPointOt.add(checkBoxDGK.getText());
        }
        
        // получаем данные из БД отсортированные
        var data = DatabaseDriver.getDataFromDb(tablename, dateOne, dateB, dateE, uppg, skv, "", listPointOt, sortCrit);
        ArrayList<Proby> probyData = new ArrayList<Proby>();
        for (int i = 0; i < data.size(); i++) 
            probyData.add(new Proby(data.get(i)));
        
        // инициализируем представление
        dataVm = new ArrayList<ProbyViewModel>();
        for (int i=0; i< probyData.size(); i++)
            dataVm.add(makeViewModel(probyData.get(i)));
        
        // добавляем данные на форму
        proby.setItems(FXCollections.observableArrayList(dataVm));
        labelCount.setText(Integer.toString(dataVm.size()));
    }
    
    public ProbyViewModel makeViewModel(Proby probyData){
        return new ProbyViewModel(probyData.id, probyData.n_skv, probyData.point_ot, probyData.note, probyData.dat_sel, probyData.dat_an, probyData.pres_b, 
            probyData.pres_e, probyData.plot, probyData.v20, probyData.v50, probyData.prel, probyData.mol_m, probyData.voda, probyData.asfal, 
            probyData.smol, probyData.paraf, probyData.masla, probyData.ser_o, probyData.ser_m, probyData.ser_s, probyData.hlor_s, probyData.m_prim, probyData.kisl, probyData.vt_nk,
            probyData.v_100, probyData.v_120, probyData.v_140, probyData.v_150, probyData.v_160, probyData.v_180, probyData.v_200, probyData.v_220,
            probyData.v_240, probyData.v_250, probyData.v_260, probyData.v_280, probyData.v_300, probyData.v_350, probyData.t_10, probyData.t_20,
            probyData.t_30, probyData.t_40, probyData.t_50, probyData.t_60, probyData.t_70, probyData.t_80, probyData.t_90, probyData.t_96, 
            probyData.vt_kk, probyData.vyh_300, probyData.vyh, probyData.ostat, probyData.poter, probyData.konz);
    }
}
