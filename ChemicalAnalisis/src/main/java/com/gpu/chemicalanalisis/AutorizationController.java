/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.gpu.chemicalanalisis;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author Anastasya
 */
public class AutorizationController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
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
   public void exitBtnAction() throws IOException {
        App.setRoot("secondary");
   }  
}
