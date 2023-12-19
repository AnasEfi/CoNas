/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gpu.chemicalanalisis;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author Anastasya
 */


public class AutorizationController implements Initializable {
    private Stage primaryStage;
    private Stage authStage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private TextField textfieldLogin;
    @FXML
    private TextField textfieldPassword;
    @FXML
    public void SignUpAction(){  //Авторизация пользователя
  
    String url = "jdbc:postgresql://localhost:5432/ChemicalAnalisis";
    String login = "postgres";
    String password = "Lone5864";
    System.out.println("Connecting.. ");
    
    try (Connection connection = DriverManager.getConnection(url,login,password)){ //Попытка подключения к БД
        System.out.println("Connection");
    }
    catch (SQLException e)
    {
        System.out.println("Connection failed!");
        e.printStackTrace();
    }
   }
    @FXML
    void buttonExitAction(ActionEvent event) {

    }

    @FXML
    void buttonLoginAction(ActionEvent event) throws IOException {

        var login = textfieldLogin.getText();
        var pass =textfieldPassword.getText();
        boolean isAuth = DataBaseDriver.getAuth(textfieldLogin.getText(), textfieldPassword.getText());
        if (isAuth) App.setRoot("MainMenu");
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(authStage);
            alert.setTitle("Авторизация");
            alert.setHeaderText("Ошибка");
            alert.setContentText("Неверный логин или пароль, повторите попытку!");
            alert.showAndWait();
            textfieldPassword.setText("");
        }
    }
   @FXML
   public void exitBtnAction() throws IOException {
        App.setRoot("secondary");
   }

}
