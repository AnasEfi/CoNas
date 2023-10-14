/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.podzem;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.Infowells;
import chemicalanalysisfx.java.model.Skv;
import chemicalanalysisfx.java.model.podzem.Podzem;
import chemicalanalysisfx.java.viewmodel.podzem.PodzemViewModel;
import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.model.ingibitor.Ingibitor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.time.*;
import java.time.format.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


/**
 *
 * @author ebondarenko
 */
public class PodzemNewController extends BaseNewController{
    private Podzem podzem;          // модель данных
    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private ComboBox <String> comboBoxSkv;
    @FXML
    private ComboBox<String> comboBoxPointOt;
    @FXML
    private TextField textFieldUppg;
    @FXML
    private DatePicker datePickerDatSel;
    @FXML
    private DatePicker datePickerDatAn;
    @FXML
    private TextField textFieldPlot;
    @FXML
    private TextField textFieldFe;
    @FXML
    private TextField textFieldPh;
    @FXML
    private TextField textFieldPresB;
    @FXML
    private TextField textFieldPresE;
    @FXML
    private TextField textFieldShel1;
    @FXML
    private TextField textFieldShel2;
    @FXML
    private ComboBox comboBoxCl;
    @FXML
    private ComboBox comboBoxS;
    @FXML
    private ComboBox comboBoxSulf;
    @FXML
    private ComboBox comboBoxCa;
    @FXML
    private ComboBox comboBoxMg;
    @FXML
    private ComboBox comboBoxNa;
    @FXML
    private ComboBox comboBoxK;
    @FXML
    private TextField textFieldCl1;
    @FXML
    private TextField textFieldCl2;
    @FXML
    private TextField textFieldS1;
    @FXML
    private TextField textFieldS2;
    @FXML
    private TextField textFieldSulf1;
    @FXML
    private TextField textFieldSulf2;
    @FXML
    private TextField textFieldCa1;
    @FXML
    private TextField textFieldCa2;
    @FXML
    private TextField textFieldMg1;
    @FXML
    private TextField textFieldMg2;
    @FXML
    private TextField textFieldNa1;
    @FXML
    private TextField textFieldNa2;
    @FXML
    private TextField textFieldK1;
    @FXML
    private TextField textFieldK2;
    @FXML
    private TextField textFieldCO32;
    @FXML
    private TextField textFieldHCO32;
    @FXML
    private TextField textFieldKation;
    @FXML
    private TextField textFieldAnion;
    @FXML
    private TextField textFieldIon_raz1;
    @FXML
    private TextField textFieldIon_raz2;
    @FXML
    private TextField textFieldMin_ves;
    @FXML
    private TextField textFieldMin_ras;
    @FXML
    private TextArea textAreaNote;
    
    
    public PodzemNewController(Stage primaryStage, String type, String tablename, Podzem podzem){
        super(primaryStage, type, tablename);
        this.podzem = podzem;
    }
    
    @FXML
    private void initialize(){
        // сначала заполняем все combobox списками данных
        comboBoxSkv.setItems(FXCollections.observableArrayList(infoWells.getSkv()));
        comboBoxPointOt.setItems(FXCollections.observableArrayList("", "7/9", "9/12", "12/16", "К/С", "Затруб", "Устье", "Глуб.", "Прочее"));
        comboBoxCl.setItems(FXCollections.observableArrayList("", "н/опр", "отс"));
        comboBoxS.setItems(FXCollections.observableArrayList("", "н/опр", "отс"));
        comboBoxSulf.setItems(FXCollections.observableArrayList("", "н/опр", "отс"));
        comboBoxCa.setItems(FXCollections.observableArrayList("", "н/опр", "отс"));
        comboBoxMg.setItems(FXCollections.observableArrayList("", "н/опр", "отс"));
        comboBoxNa.setItems(FXCollections.observableArrayList("", "н/опр", "следы"));
        comboBoxK.setItems(FXCollections.observableArrayList("", "н/опр", "следы"));
        
        // далее добавляем на все элементы значения модели данных (необходимо при изменении, при добавлении новых данных - модель пустая)
        comboBoxSkv.setValue(podzem.n_skv);
        textFieldUppg.setText(podzem.uppg);
        comboBoxPointOt.setValue(podzem.point_ot);
        try{
            datePickerDatSel.setValue(LocalDate.parse(podzem.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(podzem.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldPlot.setText(podzem.plot);
        textFieldFe.setText(podzem.fe);
        textFieldPh.setText(podzem.ph);
        textFieldPresB.setText(podzem.pres_b);
        textFieldPresE.setText(podzem.pres_e);
        textFieldShel1.setText(podzem.shel1);
        textFieldShel2.setText(podzem.shel2);
        textFieldCl1.setText(podzem.cl1);
        textFieldCl2.setText(podzem.cl2);
        textFieldS1.setText(podzem.s1);
        textFieldS2.setText(podzem.s2);
        textFieldSulf1.setText(podzem.sulf1);
        textFieldSulf2.setText(podzem.sulf2);
        textFieldCa1.setText(podzem.ca1);
        textFieldCa2.setText(podzem.ca2);
        textFieldMg1.setText(podzem.mg1);
        textFieldMg2.setText(podzem.mg2);
        textFieldNa1.setText(podzem.na1);
        textFieldNa2.setText(podzem.na2);
        textFieldK1.setText(podzem.k1);
        textFieldK2.setText(podzem.k2);
        textFieldKation.setText(podzem.kation);
        textFieldAnion.setText(podzem.anion);
        textFieldIon_raz1.setText(podzem.raz_ion1);
        textFieldIon_raz2.setText(podzem.raz_ion2);
        textFieldMin_ves.setText(podzem.min_ves);
        textFieldMin_ras.setText(podzem.min_ras);
        textAreaNote.setText(podzem.note);
        
        // обработка события потеря фокуса - вариант компактнее не нашла((
        textFieldPlot.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldPlot.setText(formatValue(textFieldPlot.getText(), 3));
            }
        });
        
        textFieldFe.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldFe.setText(formatValue(textFieldFe.getText(), 2));
            }
        });
        
        textFieldPh.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldPh.setText(formatValue(textFieldPh.getText(), 2));
            }
        });
        
        textFieldPresB.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldPresB.setText(formatValue(textFieldPresB.getText(), 2));
            }
        });
        
        textFieldPresE.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldPresE.setText(formatValue(textFieldPresE.getText(), 2));
            }
        });
        
        textFieldShel1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldShel1.setText(formatValue(textFieldShel1.getText(), 2));
            }
        });
        
        textFieldShel2.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldShel2.setText(formatValue(textFieldShel2.getText(), 2));
            }
        });
        
        textFieldCl1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldCl1.setText(formatValue(textFieldCl1.getText(), 2));
                    textFieldCl2.setText(formatValue2(textFieldCl1.getText(), 35.5f, 2));
                }
            }
        });
        
        textFieldS1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldS1.setText(formatValue(textFieldS1.getText(), 2));
                    textFieldS2.setText(formatValue2(textFieldS1.getText(), 16f, 2));
                }
            }
        });
        
        textFieldSulf1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldSulf1.setText(formatValue(textFieldSulf1.getText(), 2));
                    textFieldSulf2.setText(formatValue2(textFieldSulf1.getText(), 48f, 2));
                }
            }
        });
        
        textFieldCa1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldCa1.setText(formatValue(textFieldCa1.getText(), 2));
                    textFieldCa2.setText(formatValue2(textFieldCa1.getText(), 20f, 2));
                }
            }
        });
        
        textFieldMg1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldMg1.setText(formatValue(textFieldMg1.getText(), 2));
                    textFieldMg2.setText(formatValue2(textFieldMg1.getText(), 12f, 2));
                }
            }
        });
        
        textFieldNa1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldNa1.setText(formatValue(textFieldNa1.getText(), 2));
                    textFieldNa2.setText(formatValue2(textFieldNa1.getText(), 23f, 2));
                }
            }
        });
        
        textFieldK1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) {
                    textFieldK1.setText(formatValue(textFieldK1.getText(), 2));
                    textFieldK2.setText(formatValue2(textFieldK1.getText(), 39f, 2));
                }
            }
        });
        
        textFieldKation.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldKation.setText(formatValue(textFieldKation.getText(), 2));
            }
        });
        
        textFieldAnion.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldAnion.setText(formatValue(textFieldAnion.getText(), 2));
            }
        });
        
        textFieldIon_raz1.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldIon_raz1.setText(formatValue(textFieldIon_raz1.getText(), 2));
            }
        });
        
        textFieldIon_raz2.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldIon_raz2.setText(formatValue(textFieldIon_raz2.getText(), 2));
            }
        });
        
        textFieldMin_ves.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldMin_ves.setText(formatValue(textFieldMin_ves.getText(), 2));
            }
        });
        
        textFieldMin_ras.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (oldPropertyValue) textFieldMin_ras.setText(formatValue(textFieldMin_ras.getText(), 2));
            }
        });
    }
    
    @FXML
    private void comboBoxSkvAction(){ // при выборе скважины, выводим УППГ в текстовое окно
        int uppg = (int)infoWells.getUppg(comboBoxSkv.getValue());
        String text = "";
        if (uppg == -1) text = "";
        else if (uppg == 0) text = "ЛЭС";
        else text = "УППГ-" + String.valueOf(uppg);
        textFieldUppg.setText(text);
    }
    
    @FXML
    private void comboBoxClAction(){ // вставка значений из combobox в поле для хим элементов
        textFieldCl1.setText((String)comboBoxCl.getValue());
        textFieldCl2.setText((String)comboBoxCl.getValue());
    }
    
    @FXML
    private void comboBoxSAction(){
        textFieldS1.setText((String)comboBoxS.getValue());
        textFieldS2.setText((String)comboBoxS.getValue());
    }
    
    @FXML
    private void comboBoxSulfAction(){
        textFieldSulf1.setText((String)comboBoxSulf.getValue());
        textFieldSulf2.setText((String)comboBoxSulf.getValue());
    }
    
    @FXML
    private void comboBoxCaAction(){
        textFieldCa1.setText((String)comboBoxCa.getValue());
        textFieldCa2.setText((String)comboBoxCa.getValue());
    }
    
    @FXML
    private void comboBoxMgAction(){
        textFieldMg1.setText((String)comboBoxMg.getValue());
        textFieldMg2.setText((String)comboBoxMg.getValue());
    }
    
    @FXML
    private void comboBoxNaAction(){
        textFieldNa1.setText((String)comboBoxNa.getValue());
        textFieldNa2.setText((String)comboBoxNa.getValue());
    }
    
    @FXML
    private void comboBoxKAction(){
        textFieldK1.setText((String)comboBoxK.getValue());
        textFieldK2.setText((String)comboBoxK.getValue());
    }
    
    @FXML
    private void buttonCountAction(){ // расчет значений
        float Shel1, Shel2, OH = 0, HCO3 = 0, CO3 = 0, Cl1, Cl2, S1, S2, Sulf1, Sulf2, Ca1, Ca2, Mg1, Mg2, Na1, Na2, K1, K2, Kation, Anion, Min_ras, Ion_raz1, Ion_raz2;
        Shel1 = parseFloat(textFieldShel1.getText());
        Shel2 = parseFloat(textFieldShel2.getText());
        if (Shel1 == 0.0f) { OH = 0; HCO3 = Shel2 * 61; CO3 = 0.0f; }
        if (Shel1 < Shel2) { OH = 0; HCO3 = (Shel2 - Shel1) * 61; CO3 = 2 * Shel1 * 30; }
	if (Shel1 == Shel2) { OH = 0; HCO3 = 0; CO3 = 2 * Shel1 * 30; }
	if (Shel1 > Shel2) { OH = (Shel1 - Shel2) * 17; HCO3 = 0; CO3 = 2 * Shel2 * 30; }
	if (Shel2 == 0) { OH = Shel1 * 17; HCO3 = 0; CO3 = 0; }
        
        Cl1 = parseFloat(textFieldCl1.getText());
        Cl2 = Cl1 * 35.5f;
        S1 = parseFloat(textFieldS1.getText());
        S2 = S1 * 16;
        Sulf1 = parseFloat(textFieldSulf1.getText());
        Sulf2 = Sulf1 * 48;
        Ca1 = parseFloat(textFieldCa1.getText());
        Ca2 = Ca1 * 20;
        Mg1 = parseFloat(textFieldMg1.getText());
        Mg2 = Mg1 * 12;
        Na1 = parseFloat(textFieldNa1.getText());
        Na2 = Na1 * 23;
        K1 = parseFloat(textFieldK1.getText());
        K2 = K1 * 39;
        
        Kation = (Na1 + K1 + Ca1 + Mg1);
	Anion = (Shel1 + Shel2 + Cl1 + Sulf1);
        
        textFieldCO32.setText(String.format("%.2f", Math.round(CO3 * 100)/100.0));
        textFieldHCO32.setText(String.format("%.2f", Math.round(HCO3 * 100)/100.0));
        
        Min_ras = Na2 + K2 + Ca2 + Mg2 + Cl2 + Sulf2 + OH + HCO3 + CO3;
        
        if (Kation > Anion) {
            Ion_raz1 = Kation - Anion;
            Ion_raz2 = (Ion_raz1 * 100) / Anion;
	} else {
            Ion_raz1 = Anion - Kation;
            Ion_raz2 = (Ion_raz1 * 100)/Kation;
	}
        
        textFieldKation.setText(String.format("%.2f", Math.round(Kation*100)/100.0));
        textFieldAnion.setText(String.format("%.2f", Math.round(Anion*100)/100.0));
        textFieldIon_raz1.setText(String.format("%.2f", Math.round(Ion_raz1*100)/100.0));
        textFieldIon_raz2.setText(String.format("%.2f", Math.round(Ion_raz2*100)/100.0));
        textFieldMin_ras.setText(String.format("%.2f", Math.round(Min_ras*100)/100.0));        
    }
    
    float parseFloat(String str_value){ // если некорректное число, то возвращает 0, иначе число float
        float value;
        try{
            value = Float.valueOf(str_value.replaceAll(",", "."));
        }
        catch (NumberFormatException e){
            value = 0.0f;
        }
        return value;
    }
    
    String formatValue(String value, int count){ // форматирует число 
        if (value.equals("") || value.equals("н/опр") || value.equals("отс") || value.equals("следы")) return value;
        return String.format("%." + String.valueOf(count) + "f", parseFloat(value));
    }
    
    String formatValue2(String value1, float mult, int count){ // форматирует число (хим элемент 2)
        if (value1.equals("") || value1.equals("н/опр") || value1.equals("отс") || value1.equals("следы")) return value1;
        return String.format("%." + String.valueOf(count) + "f", parseFloat(value1) * mult);
    }
    
    @FXML
    public void buttonSaveAction(){ // сохранить значение
        String skv = comboBoxSkv.getValue().replaceAll(" ", "");
        if (skv.equals("")) JOptionPane.showMessageDialog(null, "Не выбрана скважина!", "Ошибка добавления", JOptionPane.ERROR_MESSAGE);
        else {
            String num_skv = getNumSkv(skv);
            podzem = new Podzem(podzem.id, comboBoxPointOt.getValue(), skv, num_skv, textFieldUppg.getText(), 
                                String.valueOf(datePickerDatSel.getValue()), String.valueOf(datePickerDatAn.getValue()), 
                                textFieldPlot.getText(),  textFieldFe.getText(),    textFieldPh.getText(),    textFieldPresB.getText(), 
                                textFieldPresE.getText(), textFieldShel1.getText(), textFieldShel2.getText(), textFieldCl1.getText(), 
                                textFieldCl2.getText(),   textFieldS1.getText(),    textFieldS2.getText(),    textFieldSulf1.getText(),
                                textFieldSulf2.getText(), textFieldCa1.getText(),   textFieldCa2.getText(),   textFieldMg1.getText(), 
                                textFieldMg2.getText(),   textFieldNa1.getText(),   textFieldNa2.getText(),   textFieldK1.getText(), 
                                textFieldK2.getText(),    textFieldKation.getText(),  textFieldAnion.getText(), textFieldIon_raz1.getText(), 
                                textFieldIon_raz2.getText(), textFieldMin_ves.getText(), textFieldMin_ras.getText(), textAreaNote.getText(), "");
            if (type.equals("add"))
                PodzemViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, podzem.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, podzem.row);
            }
            primaryStage.close();
        }
    }
}
