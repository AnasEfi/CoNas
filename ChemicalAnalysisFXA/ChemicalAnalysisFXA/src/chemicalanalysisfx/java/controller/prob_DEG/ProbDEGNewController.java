/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.prob_DEG;

import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.prob_DEG.ProbDEG;
import chemicalanalysisfx.java.viewmodel.prob_DEG.ProbDEGViewModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author annab
 */
public class ProbDEGNewController extends BaseNewController{
    private ProbDEG probDEG;        // модель данных
    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private TextField textFieldSkv;
    @FXML
    private TextArea textAreaProch;
    @FXML
    private ComboBox <String> comboBoxUppg;
    @FXML
    private DatePicker datePickerDatSel;
    @FXML
    private DatePicker datePickerDatAn;
    @FXML
    private TextField textFieldPlot;
    @FXML
    private TextField textFieldpH;
    @FXML
    private TextField textFieldDeg;
    @FXML
    private TextField textFieldH2o;
    @FXML
    private TextField textFieldMet;
    @FXML
    private TextField textFieldPrim;
    @FXML
    private TextField textFieldTeg;
    @FXML
    private TextArea textAreaNote;
    @FXML
    private ToggleGroup toggleGroupSkv;
    @FXML
    private RadioButton radioButtonSkv;
    @FXML
    private RadioButton radioButtonProch;
    
    public ProbDEGNewController(Stage primaryStage, String type, String tablename, ProbDEG probDeg){
        super(primaryStage, type, tablename);
        this.probDEG = probDeg;
    }
    
    @FXML
    private void initialize(){
        // сначала заполняем все combobox списками данных
        comboBoxUppg.setItems(FXCollections.observableArrayList("-", "УППГ-1", "УППГ-2", "УППГ-3", "УППГ-4", "УППГ-6", "УППГ-9"));
        
        // далее добавляем на все элементы значения модели данных (необходимо при изменении, при добавлении новых данных - модель пустая)
        if (probDEG.num_skv.equals("0") || probDEG.num_skv.equals("99999")){
            toggleGroupSkv.selectToggle(radioButtonProch);
            textAreaProch.setVisible(true);
            textAreaProch.setText(probDEG.n_skv);
            textFieldSkv.setVisible(false);
        } else {
            toggleGroupSkv.selectToggle(radioButtonSkv);
            textFieldSkv.setVisible(true);
            textFieldSkv.setText(probDEG.n_skv);
            textAreaProch.setVisible(false);
        }
        comboBoxUppg.setValue(probDEG.uppg);
        try{
            datePickerDatSel.setValue(LocalDate.parse(probDEG.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(probDEG.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldPlot.setText(probDEG.plot);
        textFieldpH.setText(probDEG.pH);
        textFieldDeg.setText(probDEG.deg);
        textFieldH2o.setText(probDEG.h2o);
        textFieldMet.setText(probDEG.met);
        textFieldPrim.setText(probDEG.prim);
        textFieldTeg.setText(probDEG.teg);
        textAreaNote.setText(probDEG.note);
        
        // создаем событие для переключателя даты
        toggleGroupSkv.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed (ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){
                RadioButton selectedBtn = (RadioButton)newValue;
                if (selectedBtn.getText().equals("Скважина №")){
                    textFieldSkv.setVisible(true);
                    textAreaProch.setVisible(false);
                } else{
                    textAreaProch.setVisible(true);
                    textFieldSkv.setVisible(false);
                }
            }
        });
    }
    
    @FXML
    public void buttonSaveAction(){ // сохранить значение
        RadioButton selectedBtnSkv = (RadioButton)toggleGroupSkv.getSelectedToggle();
        String n_skv = selectedBtnSkv.getText().equals("Скважина №") ? textFieldSkv.getText().strip() :
                textAreaProch.getText().strip();
        if (n_skv.equals("")) JOptionPane.showMessageDialog(null, "Не выбран объект!", "Ошибка добавления", JOptionPane.ERROR_MESSAGE);
        else {
            String num_skv = selectedBtnSkv.getText().equals("Скважина №") ? getNumSkv(n_skv) : "99999";
            probDEG = new ProbDEG(probDEG.id, n_skv, num_skv, comboBoxUppg.getValue(), String.valueOf(datePickerDatSel.getValue()), 
                                String.valueOf(datePickerDatAn.getValue()), textFieldPlot.getText(),
                                textFieldpH.getText(),  textFieldDeg.getText(),  textFieldH2o.getText(), 
                                textFieldMet.getText(), textFieldPrim.getText(), textFieldTeg.getText(), 
                                textAreaNote.getText());
            if (type.equals("add"))
                ProbDEGViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, probDEG.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, probDEG.row);
            }
            primaryStage.close();
        }
    }
}
