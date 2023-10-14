/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.model.diztop;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import static chemicalanalysisfx.java.model.BaseChemAnalis.nameFields;
import chemicalanalysisfx.java.model.RowData;

/**
 *
 * @author annab
 */
public class Diztop extends BaseChemAnalis {
    public int id;
    public String point_ot;
    public String NN;
    public String skv_n;
    public String skv_num;
    public String avto_N;
    public String uppg;
    public String dat_sel;
    public String dat_an;
    public String plot;
    public String frak1;
    public String frak2;
    public String temp;
    public String temp2;
    public String h2o;
    public String note;
    
    static {
        nameFields = new String[]{
            /*0*/ "id" , /*1*/ "point_ot", /*2*/ "NN", /*3*/ "skv_n", /*4*/ "skv_num", 
            /*5*/ "avto_N", /*6*/ "uppg", /*7*/"dat_sel", /*8*/ "dat_an", /*9*/ "plot", 
            /*10*/ "frak1", /*11*/ "frak2", /*12*/ "temp", /*13*/ "temp2", /*14*/ "h2o", /*15*/ "note"
        };
    }
    
    public void init(int id, String point_ot, String NN, String skv_n, String skv_num, String avto_N,
            String uppg, String dat_sel, String dat_an, String plot, String frak1, String frak2, 
            String temp, String temp2, String h2o, String note){
        row = new RowData();
        this.id = id;                       row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.point_ot = point_ot;           row.addKeyValue(nameFields[1], this.point_ot);
        this.NN = NN;                       row.addKeyValue(nameFields[2], this.NN);
        this.skv_n = skv_n;                 row.addKeyValue(nameFields[3], this.skv_n);
        this.skv_num = skv_num;             row.addKeyValue(nameFields[4], this.skv_num);
        this.avto_N = avto_N;               row.addKeyValue(nameFields[5], this.avto_N);
        this.uppg = uppg;                   row.addKeyValue(nameFields[6], this.uppg);
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");  row.addKeyValue(nameFields[7], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");   row.addKeyValue(nameFields[8], this.dat_an);
        this.plot = plot;                   row.addKeyValue(nameFields[9], this.plot);
        this.frak1 = frak1;                 row.addKeyValue(nameFields[10], this.frak1);
        this.frak2 = frak2;                 row.addKeyValue(nameFields[11], this.frak2);
        this.temp = temp;                   row.addKeyValue(nameFields[12], this.temp);
        this.temp2 = temp2;                 row.addKeyValue(nameFields[13], this.temp2);
        this.h2o = h2o;                     row.addKeyValue(nameFields[14], this.h2o);
        this.note = note;                   row.addKeyValue(nameFields[15], this.note);   
    }
    
    public Diztop(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public Diztop(int id, String point_ot, String NN, String skv_n, String skv_num, String avto_N,
            String uppg, String dat_sel, String dat_an, String plot, String frak1, String frak2, 
            String temp, String temp2, String h2o, String note){
        init(id, point_ot, NN, skv_n, skv_num, avto_N, uppg, dat_sel, dat_an, plot, frak1, frak2, temp, temp2, h2o, note);
    }
    
    public Diztop(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.point_ot   = rowData.getValue(nameFields[1]);
        this.NN         = rowData.getValue(nameFields[2]);
        this.skv_n      = rowData.getValue(nameFields[3]);
        this.skv_num    = rowData.getValue(nameFields[4]);
        this.avto_N     = rowData.getValue(nameFields[5]);
        this.uppg       = rowData.getValue(nameFields[6]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[7]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[8]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.plot       = rowData.getValue(nameFields[9]);
        this.frak1      = rowData.getValue(nameFields[10]);
        this.frak2      = rowData.getValue(nameFields[11]);
        this.temp       = rowData.getValue(nameFields[12]);
        this.temp2      = rowData.getValue(nameFields[13]);
        this.h2o        = rowData.getValue(nameFields[14]);
        this.note       = rowData.getValue(nameFields[15]);
    }
    
    public String getPointOt(){
        return point_ot;
    }
    
    public String getDatSel(){
        return dat_sel;
    }
}
