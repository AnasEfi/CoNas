/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.diztop;

import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.diztop.Diztop;
import chemicalanalysisfx.java.viewmodel.diztop.DiztopViewModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author annab
 */
public class DiztopNewController extends BaseNewController{
    private Diztop diztop;
    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private ComboBox <String> comboBoxPointOt;
    @FXML
    private TextField textFieldNN;
    @FXML
    private TextField textFieldAvtoName;
    @FXML
    private ComboBox <String> comboBoxAvtoN;
    @FXML
    private TextField textFieldAvtoN;
    @FXML
    private DatePicker datePickerDatSel;
    @FXML
    private DatePicker datePickerDatAn;
    @FXML
    private TextField textFieldFrak1;
    @FXML
    private TextField textFieldFrak2;
    @FXML
    private TextField textFieldPlot;
    @FXML
    private TextField textFieldTemp;
    @FXML
    private TextField textFieldTemp2;
    @FXML
    private TextField textFieldH2o;
    @FXML
    private ComboBox <String> comboBoxUppg;
    @FXML
    private TextField textFieldNote;
    
    public DiztopNewController(Stage primaryStage, String type, String tablename, Diztop diz){
        super(primaryStage, type, tablename);
        diztop = diz;
    }
    
    @FXML
    private void initialize(){
        // сначала заполняем все combobox списками данных
        comboBoxPointOt.setItems(FXCollections.observableArrayList("Скважина", "Емкость", "Цистерна"));
        comboBoxUppg.setItems(FXCollections.observableArrayList("", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9", "ЦСЖ", "УСХР"));
        comboBoxAvtoN.setItems(FXCollections.observableArrayList("", "МАЗ", "КАМАЗ", "Татра", "КРАЗ"));
        comboBoxAvtoN.setValue("");
        
        // далее добавляем на все элементы значения модели данных (необходимо при изменении, при добавлении новых данных - модель пустая)
        comboBoxPointOt.setValue(diztop.point_ot);
        if (diztop.point_ot.equals("Скважина"))
            textFieldNN.setText(diztop.skv_n);
        else
            textFieldNN.setText(diztop.NN);
        int indexN = diztop.avto_N.indexOf("№");
        textFieldAvtoName.setText(indexN == -1 ? diztop.avto_N : diztop.avto_N.substring(0, indexN));
        textFieldAvtoN.setText(indexN == -1 ? "" : diztop.avto_N.substring(indexN + 1));
        try{
            datePickerDatSel.setValue(LocalDate.parse(diztop.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(diztop.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldFrak1.setText(diztop.frak1);
        textFieldFrak2.setText(diztop.frak2);
        textFieldPlot.setText(diztop.plot);
        textFieldTemp.setText(diztop.temp);
        textFieldTemp2.setText(diztop.temp2);
        textFieldH2o.setText(diztop.h2o);
        comboBoxUppg.setValue(diztop.uppg);
        textFieldNote.setText(diztop.note);
    }
    
    @FXML
    private void comboBoxAvtoNAction(){
        textFieldAvtoName.setText(comboBoxAvtoN.getValue());
        //comboBoxAvtoN.setValue("");
    }
    
    @FXML
    public void buttonSaveAction(){ // сохранить значение
        String pointOt = comboBoxPointOt.getValue().replaceAll(" ", "");
        if (pointOt.equals("")) JOptionPane.showMessageDialog(null, "Не выбрана точка отбора!", "Ошибка добавления", JOptionPane.ERROR_MESSAGE);
        else {
            String skv_n = comboBoxPointOt.getValue().equals("Скважина") ? textFieldNN.getText().strip() : "";
            String NN = comboBoxPointOt.getValue().equals("Скважина") ? "" : textFieldNN.getText().strip();
            String skv_num = skv_n.equals("") ? "0" : getNumSkv(skv_n);
            diztop = new Diztop(diztop.id, comboBoxPointOt.getValue(),  NN, skv_n, skv_num, textFieldAvtoName.getText().strip() + " №" + textFieldAvtoN.getText().strip(), 
                    comboBoxUppg.getValue(), String.valueOf(datePickerDatSel.getValue()), String.valueOf(datePickerDatAn.getValue()), textFieldPlot.getText(),  
                    textFieldFrak1.getText(), textFieldFrak2.getText(), textFieldTemp.getText(), textFieldTemp2.getText(),
                    textFieldH2o.getText(), textFieldNote.getText());
            if (type.equals("add"))
                DiztopViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, diztop.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, diztop.row);
            }
            primaryStage.close();
        }
    }
}
