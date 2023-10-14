/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model.podzem;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import chemicalanalysisfx.java.model.RowData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.*;

/**
 *
 * @author ebondarenko
 */
public class Podzem extends BaseChemAnalis{
    public int id;
    public String point_ot;
    public String n_skv;
    public String num_skv;
    public String uppg;
    public String dat_sel;
    public String dat_an;
    public String plot;
    public String fe;
    public String ph;
    public String pres_b;
    public String pres_e;
    public String shel1;
    public String shel2;
    public String cl1;
    public String cl2;
    public String s1;
    public String s2;
    public String sulf1;
    public String sulf2;
    public String ca1;
    public String ca2;
    public String mg1;
    public String mg2;
    public String na1;
    public String na2;
    public String k1;
    public String k2;
    public String kation;
    public String anion;
    public String raz_ion1;
    public String raz_ion2;
    public String min_ves;
    public String min_ras;
    public String note;
    public String hexWell;
    
    static {
        nameFields = new String[]{/*0*/ "id" , /*1*/ "point_ot", /*2*/ "n_skv", /*3*/ "num_skv", /*4*/ "uppg", /*5*/ "dat_sel", /*6*/ "dat_an", /*7*/"plot", 
                                 /*8*/ "fe", /*9*/ "ph", /*10*/ "pres_b", /*11*/ "pres_e", /*12*/ "shel1", /*13*/ "shel2", /*14*/ "cl1", /*15*/ "cl2", 
                                 /*16*/ "sulf1_1", /*17*/ "sulf1_2", /*18*/ "sulf2_1", /*19*/ "sulf2_2", /*20*/ "ca1", /*21*/ "ca2", /*22*/ "mg1", /*23*/ "mg2", 
                                 /*24*/ "na1", /*25*/ "na2", /*26*/ "k1", /*27*/ "k2", /*28*/ "kation", /*29*/ "anion", /*30*/ "raz_ion1", /*31*/ "raz_ion2", 
                                 /*32*/ "min_ves", /*33*/ "min_ras", /*34*/ "note", /*35*/ "hexWell"};
    }
    
    public Podzem(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public Podzem(int id, String point_ot, String n_skv, String num_skv, String uppg, String dat_sel, String dat_an,
            String plot, String fe, String ph, String pres_b, String pres_e, String shel1, String shel2, 
            String cl1, String cl2, String s1, String s2, String sulf1, String sulf2, 
            String ca1, String ca2, String mg1, String mg2, String na1, String na2, String k1, String k2, 
            String kation, String anion, String raz_ion1, String raz_ion2, String min_ves, String min_ras, String note, String hexWell){
        
        init(id, point_ot, n_skv, num_skv, uppg, dat_sel, dat_an, plot, fe, ph, pres_b, pres_e, shel1, shel2, cl1, cl2, s1, s2, sulf1, sulf2, 
             ca1, ca2, mg1, mg2, na1, na2, k1, k2, kation, anion, raz_ion1, raz_ion2, min_ves, min_ras, note, hexWell);
    }
    
    public void init(int id, String point_ot, String n_skv, String num_skv, String uppg, String dat_sel, String dat_an,
            String plot, String fe, String ph, String pres_b, String pres_e, String shel1, String shel2, 
            String cl1, String cl2, String s1, String s2, String sulf1, String sulf2, 
            String ca1, String ca2, String mg1, String mg2, String na1, String na2, String k1, String k2, 
            String kation, String anion, String raz_ion1, String raz_ion2, String min_ves, String min_ras, String note, String hexWell){
        row = new RowData();
        this.id = id;                       row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.point_ot = point_ot;           row.addKeyValue(nameFields[1], this.point_ot);
        this.n_skv = n_skv;                 row.addKeyValue(nameFields[2], this.n_skv);
        this.num_skv = num_skv;             row.addKeyValue(nameFields[3], this.num_skv);
        this.uppg = uppg;                   row.addKeyValue(nameFields[4], this.uppg);
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");  row.addKeyValue(nameFields[5], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");    row.addKeyValue(nameFields[6], this.dat_an);
        this.plot = plot;                   row.addKeyValue(nameFields[7], this.plot);
        this.fe = fe;                       row.addKeyValue(nameFields[8], this.fe);
        this.ph = ph;                       row.addKeyValue(nameFields[9], this.ph);
        this.pres_b = pres_b;               row.addKeyValue(nameFields[10], this.pres_b);
        this.pres_e = pres_e;               row.addKeyValue(nameFields[11], this.pres_e);
        this.shel1 = shel1;                 row.addKeyValue(nameFields[12], this.shel1);
        this.shel2 = shel2;                 row.addKeyValue(nameFields[13], this.shel2);
        this.cl1 = cl1;                     row.addKeyValue(nameFields[14], this.cl1);
        this.cl2 = cl2;                     row.addKeyValue(nameFields[15], this.cl2);
        this.s1 = s1;                       row.addKeyValue(nameFields[16], this.s1);
        this.s2 = s2;                       row.addKeyValue(nameFields[17], this.s2);
        this.sulf1 = sulf1;                 row.addKeyValue(nameFields[18], this.sulf1);
        this.sulf2= sulf2;                  row.addKeyValue(nameFields[19], this.sulf2);
        this.ca1 = ca1;                     row.addKeyValue(nameFields[20], this.ca1);
        this.ca2 = ca2;                     row.addKeyValue(nameFields[21], this.ca2);
        this.mg1 = mg1;                     row.addKeyValue(nameFields[22], this.mg1);
        this.mg2 = mg2;                     row.addKeyValue(nameFields[23], this.mg2);
        this.na1 = na1;                     row.addKeyValue(nameFields[24], this.na1);
        this.na2 = na2;                     row.addKeyValue(nameFields[25], this.na2);
        this.k1 = k1;                       row.addKeyValue(nameFields[26], this.k1);
        this.k2 = k2;                       row.addKeyValue(nameFields[27], this.k2);
        this.kation = kation;               row.addKeyValue(nameFields[28], this.kation);
        this.anion = anion;                 row.addKeyValue(nameFields[29], this.anion);
        this.raz_ion1 = raz_ion1;           row.addKeyValue(nameFields[30], this.raz_ion1);
        this.raz_ion2 = raz_ion2;           row.addKeyValue(nameFields[31], this.raz_ion2);
        this.min_ves = min_ves;             row.addKeyValue(nameFields[32], this.min_ves);
        this.min_ras = min_ras;             row.addKeyValue(nameFields[33], this.min_ras);
        this.note = note;                   row.addKeyValue(nameFields[34], this.note);
        this.hexWell = hexWell;             row.addKeyValue(nameFields[35], this.hexWell);
    }
    
    
    public Podzem(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.point_ot   = rowData.getValue(nameFields[1]);
        this.n_skv      = rowData.getValue(nameFields[2]);
        this.num_skv    = rowData.getValue(nameFields[3]);
        this.uppg       = rowData.getValue(nameFields[4]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[5]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[6]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.plot       = rowData.getValue(nameFields[7]);
        this.fe         = rowData.getValue(nameFields[8]);
        this.ph         = rowData.getValue(nameFields[9]);
        this.pres_b     = rowData.getValue(nameFields[10]);
        this.pres_e     = rowData.getValue(nameFields[11]);
        this.shel1      = rowData.getValue(nameFields[12]);
        this.shel2      = rowData.getValue(nameFields[13]);
        this.cl1        = rowData.getValue(nameFields[14]);
        this.cl2        = rowData.getValue(nameFields[15]);
        this.s1         = rowData.getValue(nameFields[16]);
        this.s2         = rowData.getValue(nameFields[17]);
        this.sulf1      = rowData.getValue(nameFields[18]);
        this.sulf2      = rowData.getValue(nameFields[19]);
        this.ca1        = rowData.getValue(nameFields[20]);
        this.ca2        = rowData.getValue(nameFields[21]);
        this.mg1        = rowData.getValue(nameFields[22]);
        this.mg2        = rowData.getValue(nameFields[23]);
        this.na1        = rowData.getValue(nameFields[24]);
        this.na2        = rowData.getValue(nameFields[25]);
        this.k1         = rowData.getValue(nameFields[26]);
        this.k2         = rowData.getValue(nameFields[27]);
        this.kation     = rowData.getValue(nameFields[28]);
        this.anion      = rowData.getValue(nameFields[29]);
        this.raz_ion1   = rowData.getValue(nameFields[30]);
        this.raz_ion2   = rowData.getValue(nameFields[31]);
        this.min_ves    = rowData.getValue(nameFields[32]);
        this.min_ras    = rowData.getValue(nameFields[33]);
        this.note       = rowData.getValue(nameFields[34]);
        this.hexWell    = rowData.getValue(nameFields[35]);
    }
    
    public String getPointOt(){
        return point_ot;
    }
    
    public String getDatAn(){
        return dat_an;
    }
    
    public String getDatSel(){
        return dat_sel;
    }
    
    public String getSkv(){
        return n_skv;
    }
}
