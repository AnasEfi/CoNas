/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.ingibitor;

import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.Infowells;
import chemicalanalysisfx.java.model.ingibitor.Ingibitor;
import chemicalanalysisfx.java.model.podzem.Podzem;
import chemicalanalysisfx.java.viewmodel.podzem.PodzemViewModel;
import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.viewmodel.ingibitor.IngibitorViewModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ebondarenko
 */
public class IngibitorNewController extends BaseNewController{
    private Ingibitor ingibitor;     // модель данных
    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private ComboBox <String> comboBoxSkv;
    @FXML
    private TextField textFieldUppg;
    @FXML
    private DatePicker datePickerDatSel;
    @FXML
    private DatePicker datePickerDatAn;
    @FXML
    private TextField textFieldConc;
    @FXML
    private TextField textFieldPlot;
    @FXML
    private TextArea textAreaNote;
    
    
    public IngibitorNewController(Stage primaryStage, String type, String tablename, Ingibitor ing){
        super(primaryStage, type, tablename);
        ingibitor = ing;
    }
    
    @FXML
    private void initialize(){
        // сначала заполняем все combobox списками данных
        comboBoxSkv.setItems(FXCollections.observableArrayList(infoWells.getSkv()));
        
        // далее добавляем на все элементы значения модели данных (необходимо при изменении, при добавлении новых данных - модель пустая)
        comboBoxSkv.setValue(ingibitor.n_skv);
        textFieldUppg.setText(ingibitor.uppg);
        try{
            datePickerDatSel.setValue(LocalDate.parse(ingibitor.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(ingibitor.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldConc.setText(ingibitor.conc);
        textFieldPlot.setText(ingibitor.plot);
        textAreaNote.setText(ingibitor.note);
    }
    
    @FXML
    private void comboBoxSkvAction(){ // при выборе скважины, выводим УППГ в текстовое окно
        int uppg = (int)infoWells.getUppg(comboBoxSkv.getValue());
        String text = "";
        if (uppg == -1) text = "";
        else text = "УППГ-" + String.valueOf(uppg);
        textFieldUppg.setText(text);
    }
    
    @FXML
    public void buttonSaveAction(){ // сохранить значение
        String skv = comboBoxSkv.getValue().replaceAll(" ", "");
        if (skv.equals("")) JOptionPane.showMessageDialog(null, "Не выбрана скважина!", "Ошибка добавления", JOptionPane.ERROR_MESSAGE);
        else {
            String num_skv=getNumSkv(skv);
            ingibitor = new Ingibitor(ingibitor.id, skv, num_skv, String.valueOf(datePickerDatSel.getValue()), 
                                String.valueOf(datePickerDatAn.getValue()), textFieldConc.getText(),
                                textFieldPlot.getText(),  textFieldUppg.getText(), textAreaNote.getText());
            if (type.equals("add"))
                IngibitorViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, ingibitor.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, ingibitor.row);
            }
            primaryStage.close();
        }
    }
}
