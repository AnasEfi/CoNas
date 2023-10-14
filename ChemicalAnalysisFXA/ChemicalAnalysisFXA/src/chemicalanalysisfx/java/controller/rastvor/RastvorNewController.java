/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.rastvor;

import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.rastvor.Rastvor;
import chemicalanalysisfx.java.viewmodel.rastvor.RastvorViewModel;
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
public class RastvorNewController extends BaseNewController{
    private Rastvor rastvor;
    
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
    private TextField textFieldKonFak;
    @FXML
    private TextField textFieldKonZad;
    @FXML
    private TextField textFieldPlot;
    @FXML
    private TextField textFieldRast;
    @FXML
    private TextField textFieldH2o;
    @FXML
    private ComboBox <String> comboBoxUstan;
    @FXML
    private TextField textFieldNote;
    
    public RastvorNewController(Stage primaryStage, String type, String tablename, Rastvor rast){
        super(primaryStage, type, tablename);
        rastvor = rast;
    }
    
    @FXML
    private void initialize(){
        // сначала заполняем все combobox списками данных
        comboBoxPointOt.setItems(FXCollections.observableArrayList("Скважина", "Емкость", "Цистерна"));
        comboBoxUstan.setItems(FXCollections.observableArrayList("", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9", "ЦСЖ", "УСХР"));
        comboBoxAvtoN.setItems(FXCollections.observableArrayList("", "МАЗ", "КАМАЗ", "Татра", "КРАЗ"));
        comboBoxAvtoN.setValue("");
        
        // далее добавляем на все элементы значения модели данных (необходимо при изменении, при добавлении новых данных - модель пустая)
        comboBoxPointOt.setValue(rastvor.point_ot);
        if (rastvor.point_ot.equals("Скважина"))
            textFieldNN.setText(rastvor.skv_n);
        else
            textFieldNN.setText(rastvor.NN);
        int indexN = rastvor.avto_N.indexOf("№");
        textFieldAvtoName.setText(indexN == -1 ? rastvor.avto_N : rastvor.avto_N.substring(0, indexN));
        textFieldAvtoN.setText(indexN == -1 ? "" : rastvor.avto_N.substring(indexN + 1));
        try{
            datePickerDatSel.setValue(LocalDate.parse(rastvor.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(rastvor.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldKonFak.setText(rastvor.kon_fak);
        textFieldKonZad.setText(rastvor.kon_zad);
        textFieldPlot.setText(rastvor.plot);
        textFieldRast.setText(rastvor.rast);
        textFieldH2o.setText(rastvor.h2o);
        comboBoxUstan.setValue(rastvor.ustan);
        textFieldNote.setText(rastvor.note);
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
            rastvor = new Rastvor(rastvor.id, comboBoxPointOt.getValue(),  NN, skv_n, skv_num, textFieldAvtoName.getText().strip() + " №" + textFieldAvtoN.getText().strip(), 
                    comboBoxUstan.getValue(), String.valueOf(datePickerDatSel.getValue()), String.valueOf(datePickerDatAn.getValue()), textFieldPlot.getText(),  
                    textFieldKonFak.getText(), textFieldKonZad.getText(), textFieldRast.getText(),
                    textFieldH2o.getText(), textFieldNote.getText());
            if (type.equals("add"))
                RastvorViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, rastvor.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, rastvor.row);
            }
            primaryStage.close();
        }
    }
}
