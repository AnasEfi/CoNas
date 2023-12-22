package com.gpu.chemicalanalisis.AppUtils;

import com.gpu.chemicalanalisis.Utils.InfoWells;
import com.gpu.chemicalanalisis.Utils.Skv;
import com.gpu.chemicalanalisis.Utils.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseDriver {
    final static String driver = "org.postgresql.Driver";
    final static String url = "jdbc:postgresql://localhost:5432/ChemicalAnalisis"; //#check a name
    final static String login = "postgres";
    final static String password = "Lone5864";

    public static boolean getAuth(String ulogin, String upassw){
        boolean res = false;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, password);
            try{
                Statement stmt = con.createStatement();
                String sqlQuery = "select * from autorization where login='" + ulogin + "' and pass = '" + upassw + "'";
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    User.login = rs.getString("login");
                    User.flag_edit = rs.getInt("flag_edit");
                    res = true;
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
    public static InfoWells getListSkvInfoWells(){
    var listSkv = new InfoWells();
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
}
