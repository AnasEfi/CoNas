/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java;

import chemicalanalysisfx.java.controller.AuthorizationController;
import chemicalanalysisfx.java.controller.MainMenuController;
import chemicalanalysisfx.java.controller.podzem.PodzemController;
import chemicalanalysisfx.java.controller.podzem.PodzemNewController;
import chemicalanalysisfx.java.model.DatabaseDriver;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;


/**
 * @author ebondarenko
 */
public class ChemicalAnalysisFX extends Application{
   
    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    public static void main(String[] args) {
        Application.launch();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ХИМИЧЕСКИЙ АНАЛИЗ");
        showBaseWindow();
    }
    
    public void showBaseWindow() {
        
        try{
            FXMLLoader loader = new FXMLLoader(); 
            loader.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/main_menu.fxml"));
            loader.setController(new MainMenuController(primaryStage));
            
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            primaryStage.show();
            
            Stage authStage = new Stage();
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("/chemicalanalysisfx/resources/maket/authorization.fxml"));
            loader2.setController(new AuthorizationController(primaryStage, authStage));
            AnchorPane page = (AnchorPane)loader2.load();
            authStage.setTitle("Авторизация");
            authStage.initModality(Modality.WINDOW_MODAL);
            authStage.initOwner(primaryStage);
            authStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event){
                    primaryStage.close();
                }
            });
            Scene scene2 = new Scene(page);
            authStage.setScene(scene2);
            authStage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
