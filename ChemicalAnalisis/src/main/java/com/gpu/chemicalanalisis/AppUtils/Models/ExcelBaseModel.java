package com.gpu.chemicalanalisis.AppUtils.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelBaseModel {
    //public RowData row;
    public static String[] nameFields;

    public String parseDate(String date_str, String formatIn, String formatOut) {
            String res = "....";
            SimpleDateFormat formatterIn = new SimpleDateFormat(formatIn);
            SimpleDateFormat formatterOut = new SimpleDateFormat(formatOut);
            try {
                Date date_res = formatterIn.parse(date_str);
                res = formatterOut.format(date_res);
            } catch (ParseException e) {
                res = "....";
            }
            return res;
        }

    }
