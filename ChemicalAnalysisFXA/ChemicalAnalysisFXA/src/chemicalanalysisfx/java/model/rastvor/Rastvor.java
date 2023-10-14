/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.model.rastvor;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import static chemicalanalysisfx.java.model.BaseChemAnalis.nameFields;
import chemicalanalysisfx.java.model.RowData;

/**
 *
 * @author annab
 */
public class Rastvor extends BaseChemAnalis{
    public int id;
    public String point_ot;
    public String NN;
    public String skv_n;
    public String skv_num;
    public String avto_N;
    public String ustan;
    public String dat_sel;
    public String dat_an;
    public String plot;
    public String kon_fak;
    public String kon_zad;
    public String rast;
    public String h2o;
    public String note;
    
    static {
        nameFields = new String[]{
            /*0*/ "id" , /*1*/ "point_ot", /*2*/ "NN", /*3*/ "skv_n", /*4*/ "skv_num", 
            /*5*/ "avto_N", /*6*/ "ustan", /*7*/"dat_sel", /*8*/ "dat_an", /*9*/ "plot", 
            /*10*/ "kon_fak", /*11*/ "kon_zad", /*12*/ "rast", /*13*/ "h2o", /*14*/ "note"
        };
    }
    
    public void init(int id, String point_ot, String NN, String skv_n, String skv_num, String avto_N,
            String ustan, String dat_sel, String dat_an, String plot, String kon_fak, String kon_zad, 
            String rast, String h2o, String note){
        row = new RowData();
        this.id = id;                       row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.point_ot = point_ot;           row.addKeyValue(nameFields[1], this.point_ot);
        this.NN = NN;                       row.addKeyValue(nameFields[2], this.NN);
        this.skv_n = skv_n;                 row.addKeyValue(nameFields[3], this.skv_n);
        this.skv_num = skv_num;             row.addKeyValue(nameFields[4], this.skv_num);
        this.avto_N = avto_N;               row.addKeyValue(nameFields[5], this.avto_N);
        this.ustan = ustan;                 row.addKeyValue(nameFields[6], this.ustan);
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");  row.addKeyValue(nameFields[7], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");   row.addKeyValue(nameFields[8], this.dat_an);
        this.plot = plot;                   row.addKeyValue(nameFields[9], this.plot);
        this.kon_fak = kon_fak;             row.addKeyValue(nameFields[10], this.kon_fak);
        this.kon_zad = kon_zad;             row.addKeyValue(nameFields[11], this.kon_zad);
        this.rast = rast;                   row.addKeyValue(nameFields[12], this.rast);
        this.h2o = h2o;                     row.addKeyValue(nameFields[13], this.h2o);
        this.note = note;                   row.addKeyValue(nameFields[14], this.note);   
    }
    
    public Rastvor(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public Rastvor(int id, String point_ot, String NN, String skv_n, String skv_num, String avto_N,
            String ustan, String dat_sel, String dat_an, String plot, String kon_fak, String kon_zad, 
            String rast, String h2o, String note){
        init(id, point_ot, NN, skv_n, skv_num, avto_N, ustan, dat_sel, dat_an, plot, kon_fak, kon_zad, rast, h2o, note);
    }
    
    public Rastvor(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.point_ot   = rowData.getValue(nameFields[1]);
        this.NN         = rowData.getValue(nameFields[2]);
        this.skv_n      = rowData.getValue(nameFields[3]);
        this.skv_num    = rowData.getValue(nameFields[4]);
        this.avto_N     = rowData.getValue(nameFields[5]);
        this.ustan      = rowData.getValue(nameFields[6]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[7]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[8]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.plot       = rowData.getValue(nameFields[9]);
        this.kon_fak    = rowData.getValue(nameFields[10]);
        this.kon_zad    = rowData.getValue(nameFields[11]);
        this.rast       = rowData.getValue(nameFields[12]);
        this.h2o        = rowData.getValue(nameFields[13]);
        this.note       = rowData.getValue(nameFields[14]);
    }
    
    public String getPointOt(){
        return point_ot;
    }
    
    public String getDatSel(){
        return dat_sel;
    }
}
