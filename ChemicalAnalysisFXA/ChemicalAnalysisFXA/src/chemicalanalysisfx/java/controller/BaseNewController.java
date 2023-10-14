/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller;

import chemicalanalysisfx.java.model.DatabaseDriver;
import chemicalanalysisfx.java.model.Infowells;
import chemicalanalysisfx.java.model.ingibitor.Ingibitor;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 *
 * @author ebondarenko
 */
public class BaseNewController {
    //private Ingibitor ingibitor;     // модель данных
    protected Stage primaryStage;     // текущее окно (необходима ссылка для закрытия окна)
    protected String type;            // тип действия (добавление или изменение данных)
    protected String tablename;
    protected Infowells infoWells;    // список скважин (название, уппг, hexwell) из таблицы Infowells
    
    public BaseNewController(Stage primaryStage, String type, String tablename){
        this.primaryStage = primaryStage;
        this.type = type;
        this.tablename = tablename;
        this.infoWells = DatabaseDriver.getListSkvInfowells();
    }
    
    @FXML
    public void buttonCancelAction(){
        primaryStage.close();
    }
    
    protected String getNumSkv(String skv){
        String num_skv="";
        int i =0;
        while(i < skv.length() && Character.isDigit(skv.charAt(i))){
            num_skv+=skv.charAt(i++);
        }
        if (num_skv.equals("")) num_skv = "99999";
        return num_skv;
    }
}
