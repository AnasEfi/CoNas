/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gpu.chemicalanalisis.modules.DieselFuelAnalysis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


/**
 * FXML Controller class
 *
 * @author Anastasya
 */
public class DieselFuelAnalysisController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private TableColumn<?, ?> avto_N;

    @FXML
    private MenuItem buttonCreateExcel;

    @FXML
    private MenuButton buttonEdit;

    @FXML
    private MenuItem buttonSortDateSel;

    @FXML
    private MenuItem buttonSortPointOt;

    @FXML
    private Button buttonView;

    @FXML
    private CheckBox checkBox1216;

    @FXML
    private CheckBox checkBox79;

    @FXML
    private CheckBox checkBox912;

    @FXML
    private CheckBox checkBoxCist;

    @FXML
    private CheckBox checkBoxEmk;

    @FXML
    private CheckBox checkBoxGlub;

    @FXML
    private CheckBox checkBoxKS;

    @FXML
    private CheckBox checkBoxProch;

    @FXML
    private CheckBox checkBoxSkv;

    @FXML
    private CheckBox checkBoxUst;

    @FXML
    private CheckBox checkBoxZatr;

    @FXML
    private ComboBox<?> comboBoxAvto_N;

    @FXML
    private ComboBox<?> comboBoxUppg;

    @FXML
    private TableColumn<?, ?> dat_an;

    @FXML
    private TableColumn<?, ?> dat_sel;

    @FXML
    private TableColumn<?, ?> dat_sel_an;

    @FXML
    private DatePicker datePickerOneDate;

    @FXML
    private DatePicker datePickerRangeDateB;

    @FXML
    private DatePicker datePickerRangeDateE;

    @FXML
    private TableView<?> diztop;

    @FXML
    private TableColumn<?, ?> frak1;

    @FXML
    private TableColumn<?, ?> frak2;

    @FXML
    private TableColumn<?, ?> h2o;

    @FXML
    private Label labelCount;

    @FXML
    private Label labelDateB;

    @FXML
    private Label labelDateE;

    @FXML
    private TableColumn<?, ?> note;

    @FXML
    private TableColumn<?, ?> plot;

    @FXML
    private TableColumn<?, ?> point_ot;

    @FXML
    private TableColumn<?, ?> temp;

    @FXML
    private TableColumn<?, ?> temp2;

    @FXML
    private TextField textFieldAvto_N;

    @FXML
    private TextField textFieldAvto_Name;

    @FXML
    private TextField textFieldCist;

    @FXML
    private TextField textFieldEmk;

    @FXML
    private TextField textFieldSkv;

    @FXML
    private ToggleGroup toggleGroupDate;

    @FXML
    private TableColumn<?, ?> uppg;

    @FXML
    void buttonChangeValueAction(ActionEvent event) {

    }

    @FXML
    void buttonCreateExcelAction(ActionEvent event) {

    }

    @FXML
    void buttonDeleteValueAction(ActionEvent event) {

    }

    @FXML
    void buttonNewValueAction(ActionEvent event) {

    }

    @FXML
    void buttonSortDateSelAction(ActionEvent event) {

    }

    @FXML
    void buttonSortPointOtAction(ActionEvent event) {

    }

    @FXML
    void buttonViewAction(ActionEvent event) {

    }

    @FXML
    void comboBoxAvto_NAction(ActionEvent event) {

    }
    
}
