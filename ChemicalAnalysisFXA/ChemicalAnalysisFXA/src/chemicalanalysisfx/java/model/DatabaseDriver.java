/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model;

import chemicalanalysisfx.java.model.himanaliz.Himanaliz;
import chemicalanalysisfx.java.model.podzem.Podzem;
import chemicalanalysisfx.java.model.proby.Proby;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ebondarenko
 */
public class DatabaseDriver {
    
    final static String driver = "org.postgresql.Driver";
    //final static String url = "jdbc:postgresql://10.25.11.210:5432/chemican";
    final static String url = "jdbc:postgresql://localhost:5432/chemican";
    final static String login = "postgres";
    final static String password = "postgres";
    
    public static ArrayList<String> getListSkv(String tablename){
        ArrayList<String> listSkv = new ArrayList();
        listSkv.add("");
        try(Connection con = DriverManager.getConnection(url, login, password)){
            Class.forName(driver);
            try(Statement stmt = con.createStatement()){
                String sqlQuery = "select distinct num_skv,n_skv from " + tablename + " order by num_skv,n_skv";
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    listSkv.add(rs.getString("n_skv"));
                }
                rs.close();
                stmt.close();
            }         } catch(Exception e){
            e.printStackTrace();
        }
        return listSkv;
    }

    public static Infowells getListSkvInfowells(){
        var listSkv = new Infowells();
        listSkv.add(new Skv("", 0, ""));
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                String sqlQuery = "select \"nameSkv\", uppg, \"hexWell\" from \"infoWells\"  where \"hexWell\" LIKE 'r%' or \"nameSkv\" LIKE 'СКВ%'  order by \"nameSkv\"";
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    listSkv.add(new Skv(rs.getString("nameSkv"), rs.getInt("uppg"), rs.getString("hexWell")));
                }
                rs.close();
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listSkv;
    }
    
    public static boolean getAuth(String ulogin, String upassw){
        boolean res = false;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,login, password);
            try{
                Statement stmt = con.createStatement();
                String sqlQuery = "select * from http_group_auth where login='" + ulogin + "' and pass = '" + upassw + "'";
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    User.login = rs.getString("login");
                    User.flag_edit = rs.getInt("flag_edit");
                    res= true;
                }
                rs.close();
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
    public static ArrayList<RowData> getDataFromDb(String nameTable, String dateOne, String dateB, String dateE, String uppgC, String skvC, String skvProch, ArrayList<String> listPointOt, String sortCrit){
        ArrayList<RowData> data = new ArrayList<RowData>();
        String nameFieldDatSel = ""; // полная дичь, в Postgre различаются названия стандартных полей, лучше конечно поменять в БД
        switch(nameTable){
            case "measure": nameFieldDatSel = "date_sel";   break;
            case "proby":   nameFieldDatSel = "dat_ot";     break;
            default:        nameFieldDatSel = "dat_sel";    break;
        }
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                String sqlQuery = "SELECT * FROM " + nameTable + " ";
                String condition= "";
                boolean isWhere=false;
                if (!dateOne.equals("")) {
                    condition = nameFieldDatSel + " = '" + dateOne + "' ";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!dateB.equals("") && !dateE.equals("")) {
                    condition = nameFieldDatSel + " >= '" + dateB + "' and " + nameFieldDatSel + " <= '" + dateE +"' ";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!uppgC.equals("Все")) {
                    condition =  " uppg = '" + uppgC + "'";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!skvC.equals("")) {
                    condition = " n_skv = '" + skvC + "'";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!skvProch.equals("")) {
                    condition = " n_skv LIKE '%" + skvProch + "'";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!listPointOt.isEmpty()){
                    condition = "(";
                    for (int i=0; i<listPointOt.size(); i++){
                        condition += " point_ot = '" + listPointOt.get(i) + "' or";
                    }
                    condition = condition.substring(0, condition.length()-2) + ") ";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (sortCrit.length() > 0) sqlQuery += " ORDER BY " + sortCrit;
                System.out.println(sqlQuery);
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    var rsmd = rs.getMetaData();
                    var row = new RowData();
                    int count = rsmd.getColumnCount();
                    for (int i = 0; i < count; i++){
                        String key = rsmd.getColumnName(i+1);
                        //System.out.println(key);
                        String value = rs.getString(key);
                        row.addKeyValue(key, value);
                    }
                    data.add(row);
                }
                rs.close();
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    
    public static ArrayList<RowData> getDataFromRastDizt(String nameTable, String dateOne, String dateB, String dateE, ArrayList<String> listPointOt, String skv_n, String NN_emk, String NN_cis, String uppg, String avto_N, String sortCrit){
        ArrayList<RowData> data = new ArrayList<RowData>();
        String nameFieldUppg = nameTable.equals("rastvor") ? "ustan" : "uppg"; // полная дичь, в Postgre различаются названия стандартных полей, лучше конечно поменять в БД 
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                String sqlQuery = "SELECT * FROM " + nameTable + " ";
                String condition= "";
                boolean isWhere=false;
                if (!dateOne.equals("")) {
                    condition = "dat_sel = '" + dateOne + "' ";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!dateB.equals("") && !dateE.equals("")) {
                    condition = " dat_sel >= '" + dateB + "' and dat_sel <= '" + dateE +"' ";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!uppg.equals("Все")) {
                    condition =  " " + nameFieldUppg + " = '" + uppg + "'";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!avto_N.equals("")) {
                    condition = " \"avto_N\" LIKE '" + avto_N + "'";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (!listPointOt.isEmpty()){
                    condition = "(";
                    for (int i=0; i<listPointOt.size(); i++){
                        condition += " point_ot = '" + listPointOt.get(i) + "' ";
                        if (listPointOt.get(i).equals("Скважина") && !skv_n.equals("")) 
                            condition += " and skv_n = '" + skv_n + "'";
                        if (listPointOt.get(i).equals("Емкость") && !NN_emk.equals(""))
                            condition += " and \"NN\" = '" + NN_emk + "'";   
                        if (listPointOt.get(i).equals("Цистерна") && !NN_cis.equals(""))
                            condition += " and \"NN\" = '" + NN_cis + "'"; 
                        condition += " or";
                    }
                    condition = condition.substring(0, condition.length()-2) + ") ";
                    if (isWhere) sqlQuery += " and " + condition;
                    else {
                        sqlQuery += " WHERE " + condition;
                        isWhere = true;
                    }
                }
                if (sortCrit.length() > 0) sqlQuery += " ORDER BY " + sortCrit;
                System.out.println(sqlQuery);
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    var rsmd = rs.getMetaData();
                    var row = new RowData();
                    int count = rsmd.getColumnCount();
                    for (int i = 0; i < count; i++){
                        String key = rsmd.getColumnName(i+1);
                        //System.out.println(key);
                        String value = rs.getString(key);
                        row.addKeyValue(key, value);
                    }
                    data.add(row);
                }
                rs.close();
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    
    public static int insertDataIntoDb(String tableName, RowData data){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                var rs = stmt.executeQuery("SELECT id FROM " + tableName + " ORDER BY id DESC");
                rs.next();
                int id = rs.getInt("id") + 1;
                System.out.println(id);
                rs.close();
                stmt.close();
                
                stmt = con.createStatement();
                Set keys = data.getAll();
                String query="INSERT INTO " + tableName + " (";
                for (var key: keys){
                    query += "\"" + key + "\", ";
                }
                query = query.substring(0, query.length() - 2);
                query += ") VALUES (";
                for (var key: keys){
                    if (key.equals("id")) 
                        query += String.valueOf(id) + ", ";
                    else if (key.equals("num_skv") || key.equals("skv_num"))
                        query += data.getValue((String)key) + ", "; 
                    else
                        query += "'" + data.getValue((String)key) + "', "; 
                }
                query = query.substring(0, query.length() - 2);
                query += ");";
                System.out.println(query);
                stmt.executeUpdate(query);
                stmt.close();
                return id;
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void updateDataInDb(String tableName, RowData data){ 
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                String id = data.getValue("id");
                Statement stmt = con.createStatement();
                Set keys = data.getAll();
                
                String query="UPDATE " + tableName + " SET ";
                for (var key: keys){
                    if (!key.equals("id")){
                        query += "\"" + key + "\" = ";
                        if (key.equals("num_skv"))
                            query += data.getValue((String)key) + ", "; 
                        else
                            query += "'" + data.getValue((String)key) + "', ";
                    }
                }
                query = query.substring(0, query.length() - 2);
                query += " WHERE id = " + String.valueOf(id) + ";";
                System.out.println(query);
                stmt.executeUpdate(query);
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static RowData getRowFromDb(String nameTable, int id){
        RowData row = new RowData();
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                String sqlQuery = "SELECT * FROM " + nameTable + " WHERE id = " + String.valueOf(id);
                System.out.println(sqlQuery);
                ResultSet rs = stmt.executeQuery(sqlQuery);
                rs.next();
                var rsmd = rs.getMetaData();
                int count = rsmd.getColumnCount();
                for (int i = 0; i < count; i++){
                    String key = rsmd.getColumnName(i+1);
                    String value = rs.getString(key);
                    row.addKeyValue(key, value);
                }
                rs.close();
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return row;
    }
    
    public static void deleteRowFromDb(String tableName, int id){ 
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                String query="DELETE FROM " + tableName + " WHERE id = " + String.valueOf(id);
                System.out.println(query);
                stmt.executeUpdate(query);
                stmt.close();
            } finally{
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
