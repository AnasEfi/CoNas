/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.model.prob_DEG;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import static chemicalanalysisfx.java.model.BaseChemAnalis.nameFields;
import chemicalanalysisfx.java.model.RowData;

/**
 *
 * @author annab
 */
public class ProbDEG extends BaseChemAnalis{
    public int id;
    public String n_skv;
    public String num_skv;
    public String uppg;
    public String dat_sel;
    public String dat_an;
    public String plot;
    public String pH;
    public String deg;
    public String h2o;
    public String met;
    public String prim;
    public String teg;
    public String note;
    
    static {
        nameFields = new String[]{/*0*/ "id" , /*1*/ "n_skv", /*2*/ "num_skv", /*3*/ "uppg", /*4*/ "dat_sel", /*5*/ "dat_an", /*6*/ "plot", /*7*/"pH", 
                                  /*8*/ "deg", /*9*/ "h2o", /*10*/ "met", /*11*/ "prim", /*12*/ "teg", /*13*/ "note"};
    }
    
    public void init(int id, String n_skv, String num_skv, String uppg, String dat_sel, String dat_an,
            String plot, String pH, String deg, String h2o, String met, String prim, String teg, String note){
        row = new RowData();
        this.id = id;           row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.n_skv = n_skv;     row.addKeyValue(nameFields[1], this.n_skv);
        this.num_skv = num_skv; row.addKeyValue(nameFields[2], this.num_skv);
        this.uppg = uppg;       row.addKeyValue(nameFields[3], this.uppg);
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");             row.addKeyValue(nameFields[4], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");              row.addKeyValue(nameFields[5], this.dat_an);
        this.plot = plot;       row.addKeyValue(nameFields[6], this.plot);
        this.pH = pH;           row.addKeyValue(nameFields[7], this.pH);
        this.deg = deg;         row.addKeyValue(nameFields[8], this.deg);
        this.h2o = h2o;         row.addKeyValue(nameFields[9], this.h2o);
        this.met = met;         row.addKeyValue(nameFields[10], this.met);
        this.prim = prim;       row.addKeyValue(nameFields[11], this.prim);
        this.teg = teg;         row.addKeyValue(nameFields[12], this.teg);
        this.note = note;       row.addKeyValue(nameFields[13], this.note);
    }
    
    public ProbDEG(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public ProbDEG(int id, String n_skv, String num_skv, String uppg, String dat_sel, String dat_an,
            String plot, String pH, String deg, String h2o, String met, String prim, String teg, String note){
        init(id, n_skv, num_skv, uppg, dat_sel, dat_an, plot, pH, deg, h2o, met, prim, teg, note);
    }
    
    public ProbDEG(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.n_skv      = rowData.getValue(nameFields[1]);
        this.num_skv    = rowData.getValue(nameFields[2]);
        this.uppg       = rowData.getValue(nameFields[3]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[4]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[5]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.plot       = rowData.getValue(nameFields[6]);
        this.pH         = rowData.getValue(nameFields[7]);
        this.deg        = rowData.getValue(nameFields[8]);
        this.h2o        = rowData.getValue(nameFields[9]);
        this.met        = rowData.getValue(nameFields[10]);
        this.prim       = rowData.getValue(nameFields[11]);
        this.teg        = rowData.getValue(nameFields[12]);
        this.note       = rowData.getValue(nameFields[13]);
    }
}
