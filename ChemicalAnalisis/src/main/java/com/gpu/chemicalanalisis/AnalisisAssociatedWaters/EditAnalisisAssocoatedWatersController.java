/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gpu.chemicalanalisis.AnalisisAssociatedWaters;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.gpu.chemicalanalisis.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Anastasya
 */
public class EditAnalisisAssocoatedWatersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void buttonCancelAction(ActionEvent event) throws IOException {
        App.setRoot("com/gpu/chemicalanalisis/AnalisisAssociatedWaters");
    }
    
}
