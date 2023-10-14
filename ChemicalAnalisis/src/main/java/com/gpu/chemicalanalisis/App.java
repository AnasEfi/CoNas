package com.gpu.chemicalanalisis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
   
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("MainMenu"),1080, 720); // width, height
        primaryStage.setTitle("ХИМИЧЕСКИЙ АНАЛИЗ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void setRootFromPackage(Parent rootToFXML) throws IOException {
        scene.setRoot(rootToFXML);
    }
  
    public static void main(String[] args) {
        launch();
    }
}
    
 