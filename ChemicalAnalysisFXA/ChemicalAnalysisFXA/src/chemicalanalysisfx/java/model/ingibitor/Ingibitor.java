/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model.ingibitor;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import chemicalanalysisfx.java.model.RowData;

/**
 *
 * @author ebondarenko
 */
public class Ingibitor extends BaseChemAnalis{
    public int id;
    public String n_skv;
    public String num_skv;
    public String dat_sel;
    public String dat_an;
    public String conc;
    public String plot;
    public String uppg;
    public String note;
    
    static {
        nameFields = new String[]{/*0*/ "id" , /*1*/ "n_skv", /*2*/ "num_skv", /*3*/ "dat_sel", /*4*/ "dat_an", /*5*/ "conc", /*6*/ "plot", /*7*/"uppg", 
                                  /*8*/ "note"};
    }
    
    public void init(int id, String n_skv, String num_skv, String dat_sel, String dat_an, String conc, String plot, String uppg, String note){
        row = new RowData();
        this.id = id;                       row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.n_skv = n_skv;                 row.addKeyValue(nameFields[1], this.n_skv);
        this.num_skv = num_skv;             row.addKeyValue(nameFields[2], this.num_skv);
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");             row.addKeyValue(nameFields[3], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");              row.addKeyValue(nameFields[4], this.dat_an);
        this.conc = conc;                   row.addKeyValue(nameFields[5], this.conc);
        this.plot = plot;                   row.addKeyValue(nameFields[6], this.plot);
        this.uppg = uppg;                   row.addKeyValue(nameFields[7], this.uppg);
        this.note = note;                   row.addKeyValue(nameFields[8], this.note);
    }
    
    public Ingibitor(){
        init(-1, "", "", "", "", "", "", "", "");
    }
    
    public Ingibitor(int id, String n_skv, String num_skv, String dat_sel, String dat_an, String conc, String plot, String uppg, String note){ 
        init(id, n_skv, num_skv, dat_sel, dat_an, conc, plot, uppg, note);
    }
    
    public Ingibitor(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.n_skv      = rowData.getValue(nameFields[1]);
        this.num_skv    = rowData.getValue(nameFields[2]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[3]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[4]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.conc       = rowData.getValue(nameFields[5]);
        this.plot       = rowData.getValue(nameFields[6]);
        this.uppg       = rowData.getValue(nameFields[7]);
        this.note       = rowData.getValue(nameFields[8]);
    }
    
    public String getDatSel(){
        return dat_sel;
    }
    
    public String getSkv(){
        return n_skv;
    }
}
