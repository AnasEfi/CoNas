/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gpu.chemicalanalisis.AppUtils.Controllers;

//import java.util.ArrayList;
//import java.util.List;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Anastasya
 */
public class MainController {
   //protected Stage primaryStage;           // текущее окно (ссылка нужна, чтобы передавать окно как родительское для новых окон)
   //protected String tablename;             // название таблицы для запросов к БД

          // список скважин (название, уппг, hexwell) из таблицы Infowells
    public MainController()
    {

    }

    //protected List dataVm;                  // модель данных 
    //protected ArrayList<NameFieldExcelStyle> nameFieldsExcel; // список заголовков полей для вывода отчета в excel
    public Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
    