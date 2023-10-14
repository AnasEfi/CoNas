/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller.himanaliz;

import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.himanaliz.Himanaliz;
import chemicalanalysisfx.java.model.podzem.Podzem;
import chemicalanalysisfx.java.viewmodel.himanaliz.HimanalizViewModel;
import chemicalanalysisfx.java.viewmodel.podzem.PodzemViewModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ebondarenko
 */
public class HimanalizNewController extends BaseNewController{
    private Himanaliz himanaliz;        // модель данных
    private int input;                  // по 1 или 2 вводам
    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private ComboBox<String> comboBoxPointOt;
    @FXML
    private ComboBox<String> comboBoxSkv;
    @FXML
    private TextField textFieldUppg;
    @FXML
    private DatePicker datePickerDatSel;
    @FXML
    private DatePicker datePickerDatAn;
    @FXML
    private TextField textFieldPresB;
    @FXML
    private TextField textFieldPresE;
    @FXML
    private TextArea textAreaNote;
    @FXML
    private Label labelInput1;
    @FXML
    private Label labelInput2;
    @FXML
    private Label labelInputSred;
    @FXML
    private Label labelInput1_2;
    @FXML
    private Label labelInput2_2;
    @FXML
    private Label labelInputSred_2;
    @FXML
    private TextField textFieldHe_1;
    @FXML
    private TextField textFieldHe_2;
    @FXML
    private TextField textFieldHe_Sred;
    @FXML
    private TextField textFieldH2_1;
    @FXML
    private TextField textFieldH2_2;
    @FXML
    private TextField textFieldH2_Sred;
    @FXML
    private TextField textFieldN2_1;
    @FXML
    private TextField textFieldN2_2;
    @FXML
    private TextField textFieldN2_Sred;
    @FXML
    private TextField textFieldO2_1;
    @FXML
    private TextField textFieldO2_2;
    @FXML
    private TextField textFieldO2_Sred;
    @FXML
    private TextField textFieldC1_1;
    @FXML
    private TextField textFieldC1_2;
    @FXML
    private TextField textFieldC1_Sred;
    @FXML
    private TextField textFieldCO2_1;
    @FXML
    private TextField textFieldCO2_2;
    @FXML
    private TextField textFieldCO2_Sred;
    @FXML
    private TextField textFieldC2_1;
    @FXML
    private TextField textFieldC2_2;
    @FXML
    private TextField textFieldC2_Sred;
    @FXML
    private TextField textFieldH2S_1;
    @FXML
    private TextField textFieldH2S_2;
    @FXML
    private TextField textFieldH2S_Sred;
    @FXML
    private TextField textFieldC3_1;
    @FXML
    private TextField textFieldC3_2;
    @FXML
    private TextField textFieldC3_Sred;
    @FXML
    private TextField textFieldiC4_1;
    @FXML
    private TextField textFieldiC4_2;
    @FXML
    private TextField textFieldiC4_Sred;
    @FXML
    private TextField textFieldC4_1;
    @FXML
    private TextField textFieldC4_2;
    @FXML
    private TextField textFieldC4_Sred;
    @FXML
    private TextField textFieldiC5_1;
    @FXML
    private TextField textFieldiC5_2;
    @FXML
    private TextField textFieldiC5_Sred;
    @FXML
    private TextField textFieldC5_1;
    @FXML
    private TextField textFieldC5_2;
    @FXML
    private TextField textFieldC5_Sred;
    @FXML
    private TextField textFieldC6_1;
    @FXML
    private TextField textFieldC6_2;
    @FXML
    private TextField textFieldC6_Sred;
    @FXML
    private TextField textFieldC7_1;
    @FXML
    private TextField textFieldC7_2;
    @FXML
    private TextField textFieldC7_Sred;
    @FXML
    private TextField textFieldRsh_1;
    @FXML
    private TextField textFieldRsh_2;
    @FXML
    private TextField textFieldRsh_Sred;
    @FXML
    private TextField textFieldSum_comp;
    @FXML
    private TextField textFieldMolec_mass;
    @FXML
    private TextField textFieldAbs_density;
    @FXML
    private TextField textFieldOtn_density;
    @FXML
    private GridPane test;
    
    public HimanalizNewController(Stage primaryStage, String type, String tablename, int input, Himanaliz himanaliz){
        super(primaryStage, type, tablename);
        this.input = input;
        this.himanaliz = himanaliz;
    }
    
    @FXML
    private void initialize(){
        // сначала заполняем все combobox списками данных
        comboBoxPointOt.setItems(FXCollections.observableArrayList("", "7/9", "9/12", "12/16", "К/С", "Затруб", "Устье", "Прочее", "Газ дебутанизации", "Газ дегазации", "Газ очищенный"));
        comboBoxSkv.setItems(FXCollections.observableArrayList(infoWells.getSkv()));
        
        // далее добавляем на все элементы значения модели данных (необходимо при изменении, при добавлении новых данных - модель пустая)
        comboBoxPointOt.setValue(himanaliz.point_ot);
        comboBoxSkv.setValue(himanaliz.n_skv);
        textFieldUppg.setText(himanaliz.uppg);
        try{
            datePickerDatSel.setValue(LocalDate.parse(himanaliz.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(himanaliz.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldPresB.setText(himanaliz.pres_b);
        textFieldPresE.setText(himanaliz.pres_e);
        textAreaNote.setText(himanaliz.note);
        
        textFieldHe_Sred.setText(himanaliz.he);
        textFieldH2_Sred.setText(himanaliz.h2);
        textFieldN2_Sred.setText(himanaliz.n2);
        textFieldO2_Sred.setText(himanaliz.o2);
        textFieldC1_Sred.setText(himanaliz.c1);
        textFieldCO2_Sred.setText(himanaliz.co2);
        textFieldC2_Sred.setText(himanaliz.c2);
        textFieldH2S_Sred.setText(himanaliz.h2s);
        textFieldC3_Sred.setText(himanaliz.c3);
        textFieldiC4_Sred.setText(himanaliz.ic4);
        textFieldC4_Sred.setText(himanaliz.c4);
        textFieldiC5_Sred.setText(himanaliz.ic5);
        textFieldC5_Sred.setText(himanaliz.c5);
        textFieldC6_Sred.setText(himanaliz.c6);
        textFieldC7_Sred.setText(himanaliz.c7);
        textFieldRsh_Sred.setText(himanaliz.rsh);
        textFieldSum_comp.setText(himanaliz.sum_comp);
        textFieldMolec_mass.setText(himanaliz.molec_mass);
        textFieldAbs_density.setText(himanaliz.abs_density);
        textFieldOtn_density.setText(himanaliz.otn_density);
        
        if (input == 1){
            labelInputSred.setText("Значение");
            labelInput1.setVisible(false);
            labelInput2.setVisible(false);
            labelInputSred_2.setText("Значение");
            labelInput1_2.setVisible(false);
            labelInput2_2.setVisible(false);
            textFieldHe_1.setVisible(false);
            textFieldHe_2.setVisible(false);
            textFieldH2_1.setVisible(false);
            textFieldH2_2.setVisible(false);
            textFieldN2_1.setVisible(false);
            textFieldN2_2.setVisible(false);
            textFieldO2_1.setVisible(false);
            textFieldO2_2.setVisible(false);
            textFieldC1_1.setVisible(false);
            textFieldC1_2.setVisible(false);
            textFieldCO2_1.setVisible(false);
            textFieldCO2_2.setVisible(false);
            textFieldC2_1.setVisible(false);
            textFieldC2_2.setVisible(false);
            textFieldH2S_1.setVisible(false);
            textFieldH2S_2.setVisible(false);
            textFieldC3_1.setVisible(false);
            textFieldC3_2.setVisible(false);
            textFieldiC4_1.setVisible(false);
            textFieldiC4_2.setVisible(false);
            textFieldC4_1.setVisible(false);
            textFieldC4_2.setVisible(false);
            textFieldiC5_1.setVisible(false);
            textFieldiC5_2.setVisible(false);
            textFieldC5_1.setVisible(false);
            textFieldC5_2.setVisible(false);
            textFieldC6_1.setVisible(false);
            textFieldC6_2.setVisible(false);
            textFieldC7_1.setVisible(false);
            textFieldC7_2.setVisible(false);
            textFieldRsh_1.setVisible(false);
            textFieldRsh_2.setVisible(false);
        }
        
        // обработка события потеря фокуса
        TextField[] arr_txt = new TextField[]{ textFieldHe_1, textFieldHe_2, textFieldHe_Sred, textFieldH2_1, textFieldH2_2, textFieldH2_Sred, textFieldN2_1, textFieldN2_2,
        textFieldN2_Sred, textFieldO2_1, textFieldO2_2, textFieldO2_Sred, textFieldC1_1, textFieldC1_2, textFieldC1_Sred, textFieldCO2_1, textFieldCO2_2, textFieldCO2_Sred,
        textFieldC2_1, textFieldC2_2, textFieldC2_Sred, textFieldH2S_1, textFieldH2S_2, textFieldH2S_Sred, textFieldC3_1, textFieldC3_2, textFieldC3_Sred, textFieldiC4_1,
        textFieldiC4_2, textFieldiC4_Sred, textFieldC4_1, textFieldC4_2, textFieldC4_Sred, textFieldiC5_1, textFieldiC5_2, textFieldiC5_Sred, textFieldC5_1, textFieldC5_2,
        textFieldC5_Sred, textFieldC6_1, textFieldC6_2, textFieldC6_Sred, textFieldC7_1, textFieldC7_2, textFieldC7_Sred, textFieldRsh_1, textFieldRsh_2, textFieldRsh_Sred,
        textFieldMolec_mass, textFieldSum_comp, textFieldAbs_density, textFieldOtn_density };
        
        for(var t: arr_txt){
            t.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (oldPropertyValue) t.setText(formatValue(t.getText(), 3));
                }
            });
        }
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
    private void buttonCountAction(){ // расчет значений
        float const1 = 1.205f;
        float Elem1  = 4.00f;    	//He Гелий
        float Elem2  = 2.016f;		//H2 Водород
        float Elem3  = 28.016f;	 	//N2 Азот
        float Kisl   = 32.00f;		//KISLOROD
        float Elem4  = 16.043f;		//C1 Метан
        float Elem5  = 44.011f;		//CO2 Двуокись углерода
        float Elem6  = 30.068f;		//C2 Этан
        float Elem7  = 34.082f;		//H2S Сероводород
        float Elem8  = 44.094f;		//C3 Пропан
        float Elem9  = 58.120f;		//iC4 Бутан
        float Elem10 = 58.120f;		//C4 Бутан
        float Elem11 = 72.151f;		//iC5 Пентан
        float Elem12 = 72.151f;		//C5 Пентан
        float Elem13 = 86.178f;		//C6 Гексан
        float Elem14 = 100.198f;	//C7 Гептан
        
        if(input == 2){ // если новые исследования по 2 вводам, то сначала считаем среднее значение
            textFieldHe_Sred.setText(averageValue(textFieldHe_1.getText(), textFieldHe_2.getText()));
            textFieldH2_Sred.setText(averageValue(textFieldH2_1.getText(), textFieldH2_2.getText()));
            textFieldN2_Sred.setText(averageValue(textFieldN2_1.getText(), textFieldN2_2.getText()));
            textFieldO2_Sred.setText(averageValue(textFieldO2_1.getText(), textFieldO2_2.getText()));
            textFieldC1_Sred.setText(averageValue(textFieldC1_1.getText(), textFieldC1_2.getText()));
            textFieldCO2_Sred.setText(averageValue(textFieldCO2_1.getText(), textFieldCO2_2.getText()));
            textFieldC2_Sred.setText(averageValue(textFieldC2_1.getText(), textFieldC2_2.getText()));
            textFieldH2S_Sred.setText(averageValue(textFieldH2S_1.getText(), textFieldH2S_2.getText()));
            textFieldC3_Sred.setText(averageValue(textFieldC3_1.getText(), textFieldC3_2.getText()));
            textFieldiC4_Sred.setText(averageValue(textFieldiC4_1.getText(), textFieldiC4_2.getText()));
            textFieldC4_Sred.setText(averageValue(textFieldC4_1.getText(), textFieldC4_2.getText()));
            textFieldiC5_Sred.setText(averageValue(textFieldiC5_1.getText(), textFieldiC5_2.getText()));
            textFieldC5_Sred.setText(averageValue(textFieldC5_1.getText(), textFieldC5_2.getText()));
            textFieldC6_Sred.setText(averageValue(textFieldC6_1.getText(), textFieldC6_2.getText()));
            textFieldC7_Sred.setText(averageValue(textFieldC7_1.getText(), textFieldC7_2.getText()));
            textFieldRsh_Sred.setText(averageValue(textFieldRsh_1.getText(), textFieldRsh_2.getText()));
        }
        
	float He  = parseFloat(textFieldHe_Sred.getText()); // comp1
	float H2  = parseFloat(textFieldH2_Sred.getText()); // comp2
	float N2  = parseFloat(textFieldN2_Sred.getText()); // comp3
	float O2  = parseFloat(textFieldO2_Sred.getText()); // comp15
	float C1  = parseFloat(textFieldC1_Sred.getText()); // comp4
	float CO2 = parseFloat(textFieldCO2_Sred.getText());// comp5
	float C2  = parseFloat(textFieldC2_Sred.getText()); // comp6
	float H2S = parseFloat(textFieldH2S_Sred.getText());// comp7
	float C3  = parseFloat(textFieldC3_Sred.getText()); // comp8
	float iC4 = parseFloat(textFieldiC4_Sred.getText());// comp9
	float C4  = parseFloat(textFieldC4_Sred.getText()); // comp10
	float iC5 = parseFloat(textFieldiC5_Sred.getText());// comp11
	float C5  = parseFloat(textFieldC5_Sred.getText()); // comp12
	float C6  = parseFloat(textFieldC6_Sred.getText()); // comp13
	float C7  = parseFloat(textFieldC7_Sred.getText()); // comp14
	
	float Sum_Comp = He + H2 + N2 + O2 + C1 + CO2 + C2 + H2S + C3 + iC4 + C4 + iC5 + C5 + C6 + C7;
        textFieldSum_comp.setText(formatValue(String.valueOf(Sum_Comp), 2));
	    
        float Molec_Mass1= (He * Elem1) + (H2 * Elem2) + (N2 * Elem3) + (C1 * Elem4) + (CO2 * Elem5) + (C2 * Elem6) + (H2S * Elem7) +
	    (C3 * Elem8) + (iC4 * Elem9) + (C4 * Elem10) + (iC5 * Elem11) + (C5 * Elem12) + (C6 * Elem13) + (C7 * Elem14) + (O2 * Kisl);
	textFieldMolec_mass.setText(formatValue(String.valueOf(Math.round(Molec_Mass1)/100.f), 2));
		
	float p_abs=(Math.round((Molec_Mass1 * 10 / 22.4) * 100))/100.0f;
	p_abs=Math.round(p_abs)/1000.0f;
	textFieldAbs_density.setText(formatValue(String.valueOf(p_abs), 3));
		
	float p_otn=(Math.round((p_abs/const1)*1000))/1000.0f;
	textFieldOtn_density.setText(formatValue(String.valueOf(p_otn), 3));
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
        return String.format("%." + String.valueOf(count) + "f", parseFloat(value));
    }
    
    String averageValue(String str1, String str2){
        float val1 = parseFloat(str1);
        float val2 = parseFloat(str2);
        float val = (val1 + val2) / 2.0f;
        return formatValue(String.valueOf(val), 3);
    }
    
    @FXML
    public void buttonSaveAction(){ // сохранить значение
        String skv = comboBoxSkv.getValue().replaceAll(" ", "");
        if (skv.equals("")) JOptionPane.showMessageDialog(null, "Не выбрана скважина!", "Ошибка добавления", JOptionPane.ERROR_MESSAGE);
        else {
            String num_skv = getNumSkv(skv);
            himanaliz = new Himanaliz(himanaliz.id, "", comboBoxPointOt.getValue(), skv, num_skv, textFieldUppg.getText(), 
                    String.valueOf(datePickerDatSel.getValue()), String.valueOf(datePickerDatAn.getValue()),
                    textFieldPresB.getText(), textFieldPresE.getText(), textFieldHe_Sred.getText(), textFieldH2_Sred.getText(),
                    textFieldN2_Sred.getText(), textFieldO2_Sred.getText(), textFieldC1_Sred.getText(), textFieldCO2_Sred.getText(),
                    textFieldC2_Sred.getText(), textFieldH2S_Sred.getText(), textFieldC3_Sred.getText(), textFieldiC4_Sred.getText(),
                    textFieldC4_Sred.getText(), textFieldiC5_Sred.getText(), textFieldC5_Sred.getText(), textFieldC6_Sred.getText(),
                    textFieldC7_Sred.getText(), textFieldRsh_Sred.getText(), textFieldSum_comp.getText(), textFieldMolec_mass.getText(),
                    textFieldAbs_density.getText(), textFieldOtn_density.getText(), textAreaNote.getText());
            if (type.equals("add"))
                HimanalizViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, himanaliz.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, himanaliz.row);
            }
            primaryStage.close();
        }
    }
    
    @FXML
    public void buttonCancelAction(){
        primaryStage.close();
    }
}
