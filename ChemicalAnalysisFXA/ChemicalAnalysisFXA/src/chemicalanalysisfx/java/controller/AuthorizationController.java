/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller;

import chemicalanalysisfx.java.model.DatabaseDriver;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import chemicalanalysisfx.java.model.User;
/**
 *
 * @author ebondarenko
 */
public class AuthorizationController {
    private Stage primaryStage;
    private Stage authStage;
    
    @FXML
    private TextField textfieldLogin;
    @FXML
    private TextField textfieldPassword;
    
    public AuthorizationController(Stage primaryStage, Stage authStage){
        this.primaryStage = primaryStage;
        this.authStage = authStage;
    }
    
    @FXML
    public void buttonLoginAction(){
        boolean isAuth = DatabaseDriver.getAuth(textfieldLogin.getText(), textfieldPassword.getText());
        isAuth = true;              // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! убрать после тестов
        User.flag_edit = 1;         // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! убрать после тестов
        if (isAuth) authStage.close();
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(authStage);
            alert.setTitle("Авторизация");
            alert.setHeaderText("Ошибка");
            alert.setContentText("Неверный логин или пароль! Пожалуйста, повторите попытку!");
            alert.showAndWait();
            textfieldPassword.setText("");
        }
    }
    
    @FXML
    public void buttonExitAction(){
        primaryStage.close();
    }
    
}
