/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller;

import chemicalanalysisfx.java.controller.diztop.DiztopController;
import chemicalanalysisfx.java.controller.himanaliz.HimanalizController;
import chemicalanalysisfx.java.controller.ingibitor.IngibitorController;
import chemicalanalysisfx.java.controller.otlogen.OtlogenController;
import chemicalanalysisfx.java.controller.podzem.PodzemController;
import chemicalanalysisfx.java.controller.prob_DEG.ProbDEGController;
import chemicalanalysisfx.java.controller.proby.ProbyController;
import chemicalanalysisfx.java.controller.rastvor.RastvorController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ebondarenko
 */
public class MainMenuController {
    private Stage mainmenuStage;
    @FXML
    private AnchorPane rootPane;
    
    public MainMenuController(Stage mainmenuStage){
        this.mainmenuStage = mainmenuStage;
    }
    
    @FXML
    private void initialize(){
        
    }
    
    @FXML
    private void buttonPodzemAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/podzem/podzem_main.fxml"));
            loader.setController(new PodzemController(mainmenuStage, "podzem"));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonHimanalizAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/himanaliz/himanaliz_main.fxml"));
            loader.setController(new HimanalizController(mainmenuStage, "mainchem_list"));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonProbyAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/proby/proby_main.fxml"));
            loader.setController(new ProbyController(mainmenuStage, "proby"));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonOtlogenAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/otlogen/otlogen_main.fxml"));
            loader.setController(new OtlogenController(mainmenuStage, "measure"));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonRastvorAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/rastvor/rastvor_main.fxml"));
            loader.setController(new RastvorController(mainmenuStage, "rastvor"));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonIngibitorAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/ingibitor/ingibitor_main.fxml"));
            loader.setController(new IngibitorController(mainmenuStage, "ingibitor"));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonProbDEGAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/prob_DEG/deg_main.fxml"));
            loader.setController(new ProbDEGController(mainmenuStage, "\"prob_DEG\""));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void buttonDiztopAction(){
        try{
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/diztop/diztop_main.fxml"));
            loader.setController(new DiztopController(mainmenuStage, "\"diztop\""));
            loader.setRoot(rootPane);
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
