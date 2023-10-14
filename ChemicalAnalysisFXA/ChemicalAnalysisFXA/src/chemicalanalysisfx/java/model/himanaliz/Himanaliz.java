/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model.himanaliz;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import chemicalanalysisfx.java.model.RowData;

/**
 *
 * @author ebondarenko
 */
public class Himanaliz extends BaseChemAnalis {
    public int id;
    public String hexWell;
    public String point_ot;
    public String n_skv;
    public String num_skv;
    public String uppg;
    public String dat_sel;
    public String dat_an;
    public String pres_b;
    public String pres_e;
    public String he;
    public String h2;
    public String n2;
    public String o2;
    public String c1;
    public String co2;
    public String c2;
    public String h2s;
    public String c3;
    public String ic4;
    public String c4;
    public String ic5;
    public String c5;
    public String c6;
    public String c7;
    public String rsh;
    public String sum_comp;
    public String molec_mass;
    public String abs_density;
    public String otn_density;
    public String note;
    
    static {
        nameFields = new String[]{/*0*/ "id" ,    /*1*/ "hexWell", /*2*/ "point_ot", /*3*/ "n_skv", /*4*/ "num_skv", /*5*/ "uppg", /*6*/ "dat_sel",
                                  /*7*/ "dat_an", /*8*/ "pres_b",  /*9*/ "pres_e",   /*10*/ "he", /*11*/ "h2", /*12*/ "n2", /*13*/ "o2", /*14*/ "c1",
                                  /*15*/ "co2", /*16*/ "c2", /*17*/ "h2s", /*18*/ "c3", /*19*/ "ic4", /*20*/ "c4", /*21*/ "ic5", /*22*/ "c5", /*23*/ "c6",
                                  /*24*/ "c7", /*25*/ "rsh", /*26*/ "sum_comp", /*27*/ "molec_mass", /*28*/ "abs_density", /*29*/ "otn_density", /*30*/ "note"};
    }
    
    public void init(int id, String hexWell, String point_ot, String n_skv, String num_skv, String uppg, String dat_sel, String dat_an, String pres_b, String pres_e,
                     String he, String h2, String n2, String o2, String c1, String co2, String c2, String h2s, String c3, String ic4, String c4, String ic5, String c5,
                     String c6, String c7, String rsh, String sum_comp, String molec_mass, String abs_density, String otn_density, String note){
        row = new RowData();
        this.id = id;                       row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.hexWell = hexWell;             row.addKeyValue(nameFields[1], String.valueOf(this.hexWell));
        this.point_ot = point_ot;           row.addKeyValue(nameFields[2], String.valueOf(this.point_ot));
        this.n_skv = n_skv;                 row.addKeyValue(nameFields[3], String.valueOf(this.n_skv));
        this.num_skv = num_skv;             row.addKeyValue(nameFields[4], String.valueOf(this.num_skv));
        this.uppg = uppg;                   row.addKeyValue(nameFields[5], String.valueOf(this.uppg));
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");             row.addKeyValue(nameFields[6], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");              row.addKeyValue(nameFields[7], this.dat_an);
        this.pres_b = pres_b;               row.addKeyValue(nameFields[8], String.valueOf(this.pres_b));
        this.pres_e = pres_e;               row.addKeyValue(nameFields[9], String.valueOf(this.pres_e));
        this.he = he;                       row.addKeyValue(nameFields[10], String.valueOf(this.he));
        this.h2 = h2;                       row.addKeyValue(nameFields[11], String.valueOf(this.h2));
        this.n2 = n2;                       row.addKeyValue(nameFields[12], String.valueOf(this.n2));
        this.o2 = o2;                       row.addKeyValue(nameFields[13], String.valueOf(this.o2));
        this.c1 = c1;                       row.addKeyValue(nameFields[14], String.valueOf(this.c1));
        this.co2 = co2;                     row.addKeyValue(nameFields[15], String.valueOf(this.co2));
        this.c2 = c2;                       row.addKeyValue(nameFields[16], String.valueOf(this.c2));
        this.h2s = h2s;                     row.addKeyValue(nameFields[17], String.valueOf(this.h2s));
        this.c3 = c3;                       row.addKeyValue(nameFields[18], String.valueOf(this.c3));
        this.ic4 = ic4;                     row.addKeyValue(nameFields[19], String.valueOf(this.ic4));
        this.c4 = c4;                       row.addKeyValue(nameFields[20], String.valueOf(this.c4));
        this.ic5 = ic5;                     row.addKeyValue(nameFields[21], String.valueOf(this.ic5));
        this.c5 = c5;                       row.addKeyValue(nameFields[22], String.valueOf(this.c5));
        this.c6 = c6;                       row.addKeyValue(nameFields[23], String.valueOf(this.c6));
        this.c7 = c7;                       row.addKeyValue(nameFields[24], String.valueOf(this.c7));
        this.rsh = rsh;                     row.addKeyValue(nameFields[25], String.valueOf(this.rsh));
        this.sum_comp = sum_comp;           row.addKeyValue(nameFields[26], String.valueOf(this.sum_comp));
        this.molec_mass = molec_mass;       row.addKeyValue(nameFields[27], String.valueOf(this.molec_mass));
        this.abs_density = abs_density;     row.addKeyValue(nameFields[28], String.valueOf(this.abs_density));
        this.otn_density = otn_density;     row.addKeyValue(nameFields[29], String.valueOf(this.otn_density));
        this.note = note;                   row.addKeyValue(nameFields[30], String.valueOf(this.note));
    }
    
    public Himanaliz(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public Himanaliz(int id, String hexWell, String point_ot, String n_skv, String num_skv, String uppg, String dat_sel, String dat_an, 
            String pres_b, String pres_e, String he, String h2, String n2, String o2, String c1, String co2, String c2, String h2s, 
            String c3, String ic4, String c4, String ic5, String c5, String c6, String c7, String rsh, String sum_comp, String molec_mass,
            String abs_density, String otn_density, String note){
        
        init(id, hexWell, point_ot, n_skv, num_skv, uppg, dat_sel, dat_an, pres_b, pres_e, he, h2, n2, o2, c1, co2, c2, h2s, 
             c3, ic4, c4, ic5, c5, c6, c7, rsh, sum_comp, molec_mass, abs_density, otn_density, note);
    }
    
    public Himanaliz(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.hexWell    = rowData.getValue(nameFields[1]);
        this.point_ot   = rowData.getValue(nameFields[2]);
        this.n_skv      = rowData.getValue(nameFields[3]);
        this.num_skv    = rowData.getValue(nameFields[4]);
        this.uppg       = rowData.getValue(nameFields[5]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[6]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[7]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.pres_b     = rowData.getValue(nameFields[8]);
        this.pres_e     = rowData.getValue(nameFields[9]);
        this.he         = rowData.getValue(nameFields[10]);
        this.h2         = rowData.getValue(nameFields[11]);
        this.n2         = rowData.getValue(nameFields[12]);
        this.o2         = rowData.getValue(nameFields[13]);
        this.c1         = rowData.getValue(nameFields[14]);
        this.co2        = rowData.getValue(nameFields[15]);
        this.c2         = rowData.getValue(nameFields[16]);
        this.h2s        = rowData.getValue(nameFields[17]);
        this.c3         = rowData.getValue(nameFields[18]);
        this.ic4        = rowData.getValue(nameFields[19]);
        this.c4         = rowData.getValue(nameFields[20]);
        this.ic5        = rowData.getValue(nameFields[21]);
        this.c5         = rowData.getValue(nameFields[22]);
        this.c6         = rowData.getValue(nameFields[23]);
        this.c7         = rowData.getValue(nameFields[24]);
        this.rsh        = rowData.getValue(nameFields[25]);
        this.sum_comp   = rowData.getValue(nameFields[26]);
        this.molec_mass = rowData.getValue(nameFields[27]);
        this.abs_density = rowData.getValue(nameFields[28]);
        this.otn_density = rowData.getValue(nameFields[29]);  
        this.note       = rowData.getValue(nameFields[30]); 
        
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
    
    public String getUppg(){
        return uppg;
    }
    
}
