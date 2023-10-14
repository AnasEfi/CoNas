/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.model.otlogen;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import chemicalanalysisfx.java.model.RowData;

/**
 *
 * @author annab
 */
public class Otlogen extends BaseChemAnalis{
    public int id;
    public String n_skv;
    public String num_skv;
    public String dat_sel;
    public String dat_an;
    public String point_ot;
    public String FE3_FE2;
    public String FE_FEzol;
    public String S_total;
    public String S_elem;
    public String Cl;
    public String CO3;
    public String SiO2;
    public String C_grafit;
    public String uglevod;
    public String water;
    public String p_100;
    public String p_300;
    public String p_500;
    public String p_800;
    public String H2S_CO2;
    public String note;
    public String vid;
    
    static {
        nameFields = new String[]{/*0*/ "id" , /*1*/ "n_skv", /*2*/ "num_skv", /*3*/ "date_sel", /*4*/ "date_an", /*5*/ "point_sel", /*6*/ "FE3_FE2", /*7*/"FE_FEzol", 
                                 /*8*/ "S_total", /*9*/ "S_elem", /*10*/ "Cl", /*11*/ "CO3", /*12*/ "SiO2", /*13*/ "C_grafit", /*14*/ "uglevod", /*15*/ "water", 
                                 /*16*/ "p_100", /*17*/ "p_300", /*18*/ "p_500", /*19*/ "p_800", /*20*/ "H2S_CO2", /*21*/ "note", /*22*/ "vid"};
    }
    
    public void init(int id, String n_skv, String num_skv, String dat_sel, String dat_an, String point_ot, String FE3_FE2, String FE_FEzol,
            String S_total, String S_elem, String Cl, String CO3, String SiO2, String C_grafit, String uglevod, String water, 
            String p_100, String p_300, String p_500, String p_800, String H2S_CO2, String note, String vid)
    {
        row = new RowData();
        this.id = id;                       row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.n_skv = n_skv;                 row.addKeyValue(nameFields[1], String.valueOf(this.n_skv));
        this.num_skv = num_skv;             row.addKeyValue(nameFields[2], String.valueOf(this.num_skv));
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");   row.addKeyValue(nameFields[3], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");    row.addKeyValue(nameFields[4], this.dat_an);
        this.point_ot = point_ot;           row.addKeyValue(nameFields[5], String.valueOf(this.point_ot));
        this.FE3_FE2 = FE3_FE2;             row.addKeyValue(nameFields[6], String.valueOf(this.FE3_FE2));
        this.FE_FEzol = FE_FEzol;           row.addKeyValue(nameFields[7], String.valueOf(this.FE_FEzol));
        this.S_total = S_total;             row.addKeyValue(nameFields[8], String.valueOf(this.S_total));
        this.S_elem = S_elem;               row.addKeyValue(nameFields[9], String.valueOf(this.S_elem));
        this.Cl = Cl;                       row.addKeyValue(nameFields[10], String.valueOf(this.Cl));
        this.CO3 = CO3;                     row.addKeyValue(nameFields[11], String.valueOf(this.CO3));
        this.SiO2 = SiO2;                   row.addKeyValue(nameFields[12], String.valueOf(this.SiO2));
        this.C_grafit = C_grafit;           row.addKeyValue(nameFields[13], String.valueOf(this.C_grafit));
        this.uglevod = uglevod;             row.addKeyValue(nameFields[14], String.valueOf(this.uglevod));
        this.water = water;                 row.addKeyValue(nameFields[15], String.valueOf(this.water));
        this.p_100 = p_100;                 row.addKeyValue(nameFields[16], String.valueOf(this.p_100));
        this.p_300 = p_300;                 row.addKeyValue(nameFields[17], String.valueOf(this.p_300));
        this.p_500 = p_500;                 row.addKeyValue(nameFields[18], String.valueOf(this.p_500));
        this.p_800 = p_800;                 row.addKeyValue(nameFields[19], String.valueOf(this.p_800));
        this.H2S_CO2 = H2S_CO2;             row.addKeyValue(nameFields[20], String.valueOf(this.H2S_CO2));
        this.note = note;                   row.addKeyValue(nameFields[21], String.valueOf(this.note));
        this.vid = vid;                     row.addKeyValue(nameFields[22], String.valueOf(this.vid));
    }
    
    public Otlogen(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public Otlogen(int id, String n_skv, String num_skv, String dat_sel, String dat_an, String point_ot, String FE3_FE2, String FE_FEzol,
            String S_total, String S_elem, String Cl, String CO3, String SiO2, String C_grafit, String uglevod, String water, 
            String p_100, String p_300, String p_500, String p_800, String H2S_CO2, String note, String vid){
        init(id, n_skv, num_skv, dat_sel, dat_an, point_ot, FE3_FE2, FE_FEzol, S_total, S_elem, Cl, CO3, SiO2, 
                C_grafit, uglevod, water, p_100, p_300, p_500, p_800, H2S_CO2, note, vid);
    }
    
    public Otlogen(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.n_skv      = rowData.getValue(nameFields[1]);
        this.num_skv    = rowData.getValue(nameFields[2]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[3]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[4]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.point_ot   = rowData.getValue(nameFields[5]);
        this.FE3_FE2    = rowData.getValue(nameFields[6]);
        this.FE_FEzol   = rowData.getValue(nameFields[7]);
        this.S_total    = rowData.getValue(nameFields[8]);
        this.S_elem     = rowData.getValue(nameFields[9]);
        this.Cl         = rowData.getValue(nameFields[10]);
        this.CO3        = rowData.getValue(nameFields[11]);
        this.SiO2       = rowData.getValue(nameFields[12]);
        this.C_grafit   = rowData.getValue(nameFields[13]);
        this.uglevod    = rowData.getValue(nameFields[14]);
        this.water      = rowData.getValue(nameFields[15]);           
        this.p_100      = rowData.getValue(nameFields[16]);
        this.p_300      = rowData.getValue(nameFields[17]);
        this.p_500      = rowData.getValue(nameFields[18]);
        this.p_800      = rowData.getValue(nameFields[19]);
        this.H2S_CO2    = rowData.getValue(nameFields[20]);
        this.note       = rowData.getValue(nameFields[21]);
        this.vid        = rowData.getValue(nameFields[22]);
    }
    
    public String getSkv(){
        return n_skv;
    }
    
    public String getDatSel(){
        return dat_sel;
    }
}
