/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gpu.chemicalanalisis.modules.CorrosionInhibitorAnalysis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

 import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Anastasya
 */
public class CorrosionInhibitorAnalysisController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem buttonCreateExcel;

    @FXML
    private MenuButton buttonEdit;

    @FXML
    private MenuItem buttonSortDateAnalysis;

    @FXML
    private MenuItem buttonSortSkvDateSel;

    @FXML
    private Button buttonView;

    @FXML
    private CheckBox checkBox1216;

    @FXML
    private CheckBox checkBox79;

    @FXML
    private CheckBox checkBox912;

    @FXML
    private CheckBox checkBoxGlub;

    @FXML
    private CheckBox checkBoxKS;

    @FXML
    private CheckBox checkBoxProch;

    @FXML
    private CheckBox checkBoxUst;

    @FXML
    private CheckBox checkBoxZatr;

    @FXML
    private ComboBox<?> comboBoxSkv;

    @FXML
    private ComboBox<?> comboBoxUppg;

    @FXML
    private TableColumn<?, ?> conc;

    @FXML
    private TableColumn<?, ?> dat_an;

    @FXML
    private TableColumn<?, ?> dat_sel;

    @FXML
    private DatePicker datePickerOneDate;

    @FXML
    private DatePicker datePickerRangeDateB;

    @FXML
    private DatePicker datePickerRangeDateE;

    @FXML
    private TableView<?> ingibitor;

    @FXML
    private Label labelCount;

    @FXML
    private Label labelDateB;

    @FXML
    private Label labelDateE;

    @FXML
    private TableColumn<?, ?> n_skv;

    @FXML
    private TableColumn<?, ?> note;

    @FXML
    private TableColumn<?, ?> plot;

    @FXML
    private ToggleGroup toggleGroupDate;

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
    void buttonSortSkvDateSelAction(ActionEvent event) {

    }

    @FXML
    void buttonViewAction(ActionEvent event) {

    }
    
}
