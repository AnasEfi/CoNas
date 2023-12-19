/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gpu.chemicalanalisis;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * FXML Controller class

 * @author Anastasya
 */
public class MainMenuController  {

    /**
     * Initializes the controller class.
     */
   // @Override
    //public void initialize(URL url, ResourceBundle rb) {
        // TODO
   // }
    @FXML
    private void switchToAnalisisAssociatedWaters() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gpu/chemicalanalisis/AnalisisAssociatedWaters/AnalisisAssociatedWaters.fxml"));
        Parent root = loader.load();
        App.setRootFromPackage(root);
    }
    @FXML
    private void switchToCompositionOfResevoirGas() throws IOException {
        App.setRoot("CompositionOfReservoirGas");
    }
    @FXML 
    private void switchToSedimentAnalisis() throws IOException{
        App.setRoot("SedimentAnalisis");
    }
    @FXML 
    private void switchToFluidCorrosionInhibitorAnalysis() throws IOException{
        App.setRoot("FluidCorrosionInhibitorAnalysis");
    }
    @FXML
    private void switchToSamplesOfOrganicOrigin() throws IOException{
        App.setRoot("SamplesOfOrganicOrigin");
    }
    @FXML 
    private void  switchToCorrosionInhibitorAnalysis() throws IOException{
        App.setRoot("CorrosionInhibitorAnalysis");
    }
    @FXML 
    private void switchToAnalisisOfDiethyleneglycol() throws IOException{
        App.setRoot("AnalisisOfDiethyleneglycol");
    }
    @FXML 
    private void switchToDieselFuelAnalisis() throws IOException{
        App.setRoot("DieselFuelAnalysis");
    }
    
    
}
