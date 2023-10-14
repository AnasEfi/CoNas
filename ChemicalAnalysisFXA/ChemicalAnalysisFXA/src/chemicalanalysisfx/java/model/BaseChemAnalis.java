/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ebondarenko
 */
public class BaseChemAnalis {
    public RowData row;
    public static String[] nameFields;
    
    public String parseDate(String date_str, String formatIn, String formatOut){
        String res = "....";
        SimpleDateFormat formatterIn  = new SimpleDateFormat(formatIn);
        SimpleDateFormat formatterOut = new SimpleDateFormat(formatOut);
        try {
            Date date_res = formatterIn.parse(date_str);
            res = formatterOut.format(date_res);
        }
        catch (ParseException e){
            res = "....";
        }
        return res;
    }
    
}
