/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.controller.otlogen;

import chemicalanalysisfx.java.controller.BaseNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.otlogen.Otlogen;
import chemicalanalysisfx.java.viewmodel.otlogen.OtlogenViewModel;
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
public class OtlogenNewController extends BaseNewController {
    private Otlogen otlogen;        // модель данных
    
    // элементы с формы ( должны совпадать с fx:id )
    @FXML
    private ComboBox <String> comboBoxSkv;
    @FXML
    private TextField textFieldPointOt;
    @FXML
    private DatePicker datePickerDatSel;
    @FXML
    private DatePicker datePickerDatAn;
    @FXML
    private TextField textFieldVid;
    @FXML
    private TextField textFieldFe3_Fe2;
    @FXML
    private TextField textFieldFe_Fezol;
    @FXML
    private TextField textFieldS_total;
    @FXML
    private TextField textFieldS_elem;
    @FXML
    private TextField textFieldCl;
    @FXML
    private TextField textFieldCO3;
    @FXML
    private TextField textFieldSiO2;
    @FXML
    private TextField textFieldC_grafit;
    @FXML
    private TextField textFielduglevod;
    @FXML
    private TextField textFieldwater;
    @FXML
    private TextField textFieldH2S_CO2;
    @FXML
    private TextField textFieldp100;
    @FXML
    private TextField textFieldp300;
    @FXML
    private TextField textFieldp500;
    @FXML
    private TextField textFieldp800;
    @FXML
    private TextField textFieldnote;
    
    public OtlogenNewController(Stage primaryStage, String type, String tablename, Otlogen otlogen){
        super(primaryStage, type, tablename);
        this.otlogen = otlogen;
    }
    
    @FXML
    private void initialize(){
        comboBoxSkv.setItems(FXCollections.observableArrayList(infoWells.getSkv()));
        
        comboBoxSkv.setValue(otlogen.n_skv);
        textFieldPointOt.setText(otlogen.point_ot);
        try{
            datePickerDatSel.setValue(LocalDate.parse(otlogen.dat_sel, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            datePickerDatAn.setValue(LocalDate.parse(otlogen.dat_an, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        catch (Exception e){}
        textFieldVid.setText(otlogen.vid);
        textFieldFe3_Fe2.setText(otlogen.FE3_FE2);
        textFieldFe_Fezol.setText(otlogen.FE_FEzol);
        textFieldS_total.setText(otlogen.S_total);
        textFieldS_elem.setText(otlogen.S_elem);
        textFieldCl.setText(otlogen.Cl);
        textFieldCO3.setText(otlogen.CO3);
        textFieldSiO2.setText(otlogen.SiO2);
        textFieldC_grafit.setText(otlogen.C_grafit);
        textFielduglevod.setText(otlogen.uglevod);
        textFieldwater.setText(otlogen.water);
        textFieldH2S_CO2.setText(otlogen.H2S_CO2);
        textFieldp100.setText(otlogen.p_100);
        textFieldp300.setText(otlogen.p_300);
        textFieldp500.setText(otlogen.p_500);
        textFieldp800.setText(otlogen.p_800);
        textFieldnote.setText(otlogen.note);
    }
    
    @FXML
    public void buttonSaveAction(){ // сохранить значение
        String skv = comboBoxSkv.getValue().replaceAll(" ", "");
        if (skv.equals("")) JOptionPane.showMessageDialog(null, "Не выбрана скважина!", "Ошибка добавления", JOptionPane.ERROR_MESSAGE);
        else {
            String num_skv = getNumSkv(skv);
            otlogen = new Otlogen(otlogen.id, skv, num_skv, 
                                String.valueOf(datePickerDatSel.getValue()), String.valueOf(datePickerDatAn.getValue()),
                                textFieldPointOt.getText(), textFieldFe3_Fe2.getText(), textFieldFe_Fezol.getText(),
                                textFieldS_total.getText(), textFieldS_elem.getText(), textFieldCl.getText(),
                                textFieldCO3.getText(), textFieldSiO2.getText(), textFieldC_grafit.getText(),
                                textFielduglevod.getText(), textFieldwater.getText(), textFieldp100.getText(),
                                textFieldp300.getText(), textFieldp500.getText(), textFieldp800.getText(),
                                textFieldH2S_CO2.getText(), textFieldnote.getText(), textFieldVid.getText());
            if (type.equals("add"))
                OtlogenViewModel.new_id = DatabaseDriver.insertDataIntoDb(tablename, otlogen.row);
            else{
                DatabaseDriver.updateDataInDb(tablename, otlogen.row);
            }
            primaryStage.close();
        }
    }
}
