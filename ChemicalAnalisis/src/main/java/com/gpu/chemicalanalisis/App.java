package com.gpu.chemicalanalisis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    private static Stage _primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        _primaryStage = primaryStage;
        scene = new Scene(loadFXML("Autorization"),421, 254); // width, height
        _primaryStage.setTitle("ХИМИЧЕСКИЙ АНАЛИЗ");
        _primaryStage.setScene(scene);
        _primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    public static void  setRoot(String fxml, int w, int h) throws IOException {
        scene.setRoot(loadFXML(fxml));
        _primaryStage.setWidth(w);
        _primaryStage.setHeight(h);

        javafx.geometry.Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        _primaryStage.centerOnScreen();
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
    
 