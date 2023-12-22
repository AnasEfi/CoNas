package com.gpu.chemicalanalisis.AnalisisAssociatedWaters;

import com.gpu.chemicalanalisis.App;
import com.gpu.chemicalanalisis.NewMainController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.IOException;

public class EditAnalisisAssociatedWatersController extends NewMainController {

public EditAnalisisAssociatedWatersController() {
    super();
}
    @FXML
    void buttonCancelAction(ActionEvent event) throws IOException {
        App.setRoot("com/gpu/chemicalanalisis/AnalisisAssociatedWaters");
    }
    @FXML
    private ComboBox<String> comboBoxCa;

    @FXML
    private ComboBox<String> comboBoxCl;

    @FXML
    private ComboBox<String> comboBoxK;

    @FXML
    private ComboBox<String> comboBoxMg;

    @FXML
    private ComboBox<String> comboBoxNa;

    @FXML
    private ComboBox<String> comboBoxPointOt;

    @FXML
    private ComboBox<String> comboBoxS;

    @FXML
    private ComboBox<String> comboBoxSkv;

    @FXML
    private ComboBox<String> comboBoxSulf;

    @FXML
    private DatePicker datePickerDatAn;

    @FXML
    private DatePicker datePickerDatSel;

    @FXML
    private AnchorPane mainFrame;

    @FXML
    private TextArea textAreaNote;

    @FXML
    private TextField textFieldAnion;

    @FXML
    private TextField textFieldCO32;

    @FXML
    private TextField textFieldCa1;

    @FXML
    private TextField textFieldCa2;

    @FXML
    private TextField textFieldCl1;

    @FXML
    private TextField textFieldCl2;

    @FXML
    private TextField textFieldFe;

    @FXML
    private TextField textFieldHCO32;

    @FXML
    private TextField textFieldIon_raz1;

    @FXML
    private TextField textFieldIon_raz2;

    @FXML
    private TextField textFieldK1;

    @FXML
    private TextField textFieldK2;

    @FXML
    private TextField textFieldKation;

    @FXML
    private TextField textFieldMg1;

    @FXML
    private TextField textFieldMg2;

    @FXML
    private TextField textFieldMin_ras;

    @FXML
    private TextField textFieldMin_ves;

    @FXML
    private TextField textFieldNa1;

    @FXML
    private TextField textFieldNa2;

    @FXML
    private TextField textFieldPh;

    @FXML
    private TextField textFieldPlot;

    @FXML
    private TextField textFieldPresB;

    @FXML
    private TextField textFieldPresE;

    @FXML
    private TextField textFieldS1;

    @FXML
    private TextField textFieldS2;

    @FXML
    private TextField textFieldShel1;

    @FXML
    private TextField textFieldShel2;

    @FXML
    private TextField textFieldSulf1;

    @FXML
    private TextField textFieldSulf2;

    @FXML
    private TextField textFieldUppg;

    @FXML
    void buttonCountAction(ActionEvent event) {

    }

    @FXML
    void buttonSaveAction(ActionEvent event) {

    }

    @FXML
    void comboBoxCaAction(ActionEvent event) {

    }

    @FXML
    void comboBoxClAction(ActionEvent event) {

    }

    @FXML
    void comboBoxKAction(ActionEvent event) {

    }

    @FXML
    void comboBoxMgAction(ActionEvent event) {

    }

    @FXML
    void comboBoxNaAction(ActionEvent event) {

    }

    @FXML
    void comboBoxSAction(ActionEvent event) {

    }

    @FXML
    void comboBoxSkvAction(ActionEvent event) {

    }

    @FXML
    void comboBoxSulfAction(ActionEvent event) {

    }
    @FXML
    private void initialize() {
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


    }



}

