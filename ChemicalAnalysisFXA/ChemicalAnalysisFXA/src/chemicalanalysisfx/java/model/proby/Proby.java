/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model.proby;

import chemicalanalysisfx.java.model.BaseChemAnalis;
import static chemicalanalysisfx.java.model.BaseChemAnalis.nameFields;
import chemicalanalysisfx.java.model.RowData;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ebondarenko
 */
public class Proby extends BaseChemAnalis{
    public int id;
    public String fs;
    public String hexWell;
    public String n_skv;
    public String num_skv;
    public String uppg;
    public String point_ot;
    public String dat_sel;
    public String dat_an;
    public String pres_atm;
    public String pres_b;
    public String pres_e;
    public String plot;
    public String v20;
    public String v50;
    public String prel;
    public String mol_m;
    public String kisl;
    public String konz;
    public String voda;
    public String asfal;
    public String smol;
    public String paraf;
    public String ser_o;
    public String ser_m;
    public String ser_s;
    public String hlor_s;
    public String m_prim;
    public String v_100;
    public String v_120;
    public String v_140;
    public String v_150;
    public String v_160;
    public String v_180;
    public String v_200;
    public String v_220;
    public String v_240;
    public String v_250;
    public String v_260;
    public String v_280;
    public String v_300;
    public String v_350;
    public String t_10;
    public String t_20;
    public String t_30;
    public String t_40;
    public String t_50;
    public String t_60;
    public String t_70;
    public String t_80;
    public String t_90;
    public String t_96;
    public String vt_nk;
    public String vt_kk;
    public String vyh_300;
    public String vyh;
    public String ostat;
    public String poter;
    public String note;
    public String c4_36;
    public String masla;
    
    static {
        nameFields = new String[]{/*0*/ "id" , /*1*/ "fs", /*2*/ "hexWell", /*3*/ "n_skv", /*4*/ "num_skv", /*5*/ "uppg", /*6*/ "point_ot", /*7*/"dat_ot", 
                                 /*8*/ "dat_an", /*9*/ "dav_a", /*10*/ "dav_n", /*11*/ "dav_k", /*12*/ "plot", /*13*/ "v_20", /*14*/ "v_50", /*15*/ "prel", 
                                 /*16*/ "mol_m", /*17*/ "kisl", /*18*/ "konz", /*19*/ "voda", /*20*/ "asfal", /*21*/ "smol", /*22*/ "paraf", /*23*/ "ser_o", 
                                 /*24*/ "ser_m", /*25*/ "ser_s", /*26*/ "hlor_s", /*27*/ "m_prim", /*28*/ "v_100", /*29*/ "v_120", /*30*/ "v_140", /*31*/ "v_150", 
                                 /*32*/ "v_160", /*33*/ "v_180", /*34*/ "v_200", /*35*/ "v_220", /*36*/ "v_240", /*37*/ "v_250", /*38*/ "v_260", /*39*/ "v_280",
                                 /*40*/ "v_300", /*41*/ "v_350", /*42*/ "t_10", /*43*/ "t_20", /*44*/ "t_30", /*45*/ "t_40", /*46*/ "t_50", /*47*/ "t_60",
                                 /*48*/ "t_70", /*49*/ "t_80", /*50*/ "t_90", /*51*/ "t_96", /*52*/ "vt_nk", /*53*/ "vt_kk", /*54*/ "vyh_300", /*55*/ "vyh",
                                 /*56*/ "ostat", /*57*/ "poter", /*58*/ "note", /*59*/ "c4_36", /*60*/ "masla"};
    }
    
    public void init(int id, String fs, String hexWell, String n_skv, String num_skv, String uppg, String point_ot, String dat_sel, String dat_an,
            String pres_atm, String pres_b, String pres_e, String plot, String v20, String v50, String prel, String mol_m, String kisl,
            String konz, String voda, String asfal, String smol, String paraf, String ser_o, String ser_m, String ser_s, String hlor_s,
            String m_prim, String v_100, String v_120, String v_140, String v_150, String v_160, String v_180, String v_200, String v_220,
            String v_240, String v_250, String v_260, String v_280, String v_300, String v_350, String t_10, String t_20, String t_30,
            String t_40, String t_50, String t_60, String t_70, String t_80, String t_90, String t_96, String vt_nk, String vt_kk,
            String vyh_300, String vyh, String ostat, String poter, String note, String c4_36, String masla){
        row = new RowData();
        this.id = id;               row.addKeyValue(nameFields[0], String.valueOf(this.id));
        this.fs = fs;               row.addKeyValue(nameFields[1], String.valueOf(this.fs));
        this.hexWell = hexWell;     row.addKeyValue(nameFields[2], String.valueOf(this.hexWell));
        this.n_skv = n_skv;         row.addKeyValue(nameFields[3], String.valueOf(this.n_skv));
        this.num_skv = num_skv;     row.addKeyValue(nameFields[4], String.valueOf(this.num_skv));
        this.uppg = uppg;           row.addKeyValue(nameFields[5], String.valueOf(this.uppg));
        this.point_ot = point_ot;   row.addKeyValue(nameFields[6], String.valueOf(this.point_ot));
        this.dat_sel = parseDate(dat_sel, "yyyy-MM-dd", "yyyy.MM.dd");  row.addKeyValue(nameFields[7], this.dat_sel);
        this.dat_an  = parseDate(dat_an, "yyyy-MM-dd", "yyyy.MM.dd");   row.addKeyValue(nameFields[8], this.dat_an);
        this.pres_atm = pres_atm;   row.addKeyValue(nameFields[9], String.valueOf(this.pres_atm));
        this.pres_b = pres_b;       row.addKeyValue(nameFields[10], String.valueOf(this.pres_b));
        this.pres_e = pres_e;       row.addKeyValue(nameFields[11], String.valueOf(this.pres_e));
        this.plot = plot;           row.addKeyValue(nameFields[12], String.valueOf(this.plot));
        this.v20 = v20;             row.addKeyValue(nameFields[13], String.valueOf(this.v20));
        this.v50 = v50;             row.addKeyValue(nameFields[14], String.valueOf(this.v50));
        this.prel = prel;           row.addKeyValue(nameFields[15], String.valueOf(this.prel));
        this.mol_m = mol_m;         row.addKeyValue(nameFields[16], String.valueOf(this.mol_m));
        this.kisl = kisl;           row.addKeyValue(nameFields[17], String.valueOf(this.kisl));
        this.konz = konz;           row.addKeyValue(nameFields[18], String.valueOf(this.konz));
        this.voda = voda;           row.addKeyValue(nameFields[19], String.valueOf(this.voda));
        this.asfal = asfal;         row.addKeyValue(nameFields[20], String.valueOf(this.asfal));
        this.smol = smol;           row.addKeyValue(nameFields[21], String.valueOf(this.smol));
        this.paraf = paraf;         row.addKeyValue(nameFields[22], String.valueOf(this.paraf));
        this.ser_o = ser_o;         row.addKeyValue(nameFields[23], String.valueOf(this.ser_o));
        this.ser_m = ser_m;         row.addKeyValue(nameFields[24], String.valueOf(this.ser_m));
        this.ser_s = ser_s;         row.addKeyValue(nameFields[25], String.valueOf(this.ser_s));
        this.hlor_s = hlor_s;       row.addKeyValue(nameFields[26], String.valueOf(this.hlor_s));
        this.m_prim = m_prim;       row.addKeyValue(nameFields[27], String.valueOf(this.m_prim));
        this.v_100 = v_100;         row.addKeyValue(nameFields[28], String.valueOf(this.v_100));
        this.v_120 = v_120;         row.addKeyValue(nameFields[29], String.valueOf(this.v_120));
        this.v_140 = v_140;         row.addKeyValue(nameFields[30], String.valueOf(this.v_140));
        this.v_150 = v_150;         row.addKeyValue(nameFields[31], String.valueOf(this.v_150));
        this.v_160 = v_160;         row.addKeyValue(nameFields[32], String.valueOf(this.v_160));
        this.v_180 = v_180;         row.addKeyValue(nameFields[33], String.valueOf(this.v_180));
        this.v_200 = v_200;         row.addKeyValue(nameFields[34], String.valueOf(this.v_200));
        this.v_220 = v_220;         row.addKeyValue(nameFields[35], String.valueOf(this.v_220));
        this.v_240 = v_240;         row.addKeyValue(nameFields[36], String.valueOf(this.v_240));
        this.v_250 = v_250;         row.addKeyValue(nameFields[37], String.valueOf(this.v_250));
        this.v_260 = v_260;         row.addKeyValue(nameFields[38], String.valueOf(this.v_260));
        this.v_280 = v_280;         row.addKeyValue(nameFields[39], String.valueOf(this.v_280));
        this.v_300 = v_300;         row.addKeyValue(nameFields[40], String.valueOf(this.v_300));
        this.v_350 = v_350;         row.addKeyValue(nameFields[41], String.valueOf(this.v_350));
        this.t_10 = t_10;           row.addKeyValue(nameFields[42], String.valueOf(this.t_10));
        this.t_20 = t_20;           row.addKeyValue(nameFields[43], String.valueOf(this.t_20));
        this.t_30 = t_30;           row.addKeyValue(nameFields[44], String.valueOf(this.t_30));
        this.t_40 = t_40;           row.addKeyValue(nameFields[45], String.valueOf(this.t_40));
        this.t_50 = t_50;           row.addKeyValue(nameFields[46], String.valueOf(this.t_50));
        this.t_60 = t_60;           row.addKeyValue(nameFields[47], String.valueOf(this.t_60));
        this.t_70 = t_70;           row.addKeyValue(nameFields[48], String.valueOf(this.t_70));
        this.t_80 = t_80;           row.addKeyValue(nameFields[49], String.valueOf(this.t_80));
        this.t_90 = t_90;           row.addKeyValue(nameFields[50], String.valueOf(this.t_90));
        this.t_96 = t_96;           row.addKeyValue(nameFields[51], String.valueOf(this.t_96));
        this.vt_nk = vt_nk;         row.addKeyValue(nameFields[52], String.valueOf(this.vt_nk));
        this.vt_kk = vt_kk;         row.addKeyValue(nameFields[53], String.valueOf(this.vt_kk));
        this.vyh_300 = vyh_300;     row.addKeyValue(nameFields[54], String.valueOf(this.vyh_300));
        this.vyh = vyh;             row.addKeyValue(nameFields[55], String.valueOf(this.vyh));
        this.ostat = ostat;         row.addKeyValue(nameFields[56], String.valueOf(this.ostat));
        this.poter = poter;         row.addKeyValue(nameFields[57], String.valueOf(this.poter));
        this.note = note;           row.addKeyValue(nameFields[58], String.valueOf(this.note));
        this.c4_36 = c4_36;         row.addKeyValue(nameFields[59], String.valueOf(this.c4_36));
        this.masla = masla;         row.addKeyValue(nameFields[60], String.valueOf(this.masla));   
    }
    
    public Proby(){
        init(-1, "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
    
    public Proby(int id, String fs, String hexWell, String n_skv, String num_skv, String uppg, String point_ot, String dat_sel, String dat_an,
            String pres_atm, String pres_b, String pres_e, String plot, String v20, String v50, String prel, String mol_m, String kisl,
            String konz, String voda, String asfal, String smol, String paraf, String ser_o, String ser_m, String ser_s, String hlor_s,
            String m_prim, String v_100, String v_120, String v_140, String v_150, String v_160, String v_180, String v_200, String v_220,
            String v_240, String v_250, String v_260, String v_280, String v_300, String v_350, String t_10, String t_20, String t_30,
            String t_40, String t_50, String t_60, String t_70, String t_80, String t_90, String t_96, String vt_nk, String vt_kk,
            String vyh_300, String vyh, String ostat, String poter, String note, String c4_36, String masla){
        
        init( id, fs, hexWell, n_skv, num_skv, uppg, point_ot, dat_sel, dat_an, pres_atm, pres_b, pres_e, plot, v20, v50, prel, mol_m, kisl,
            konz, voda, asfal, smol, paraf, ser_o, ser_m, ser_s, hlor_s, m_prim, v_100, v_120, v_140, v_150, v_160, v_180, v_200, v_220,
            v_240, v_250, v_260, v_280, v_300, v_350, t_10, t_20, t_30, t_40, t_50, t_60, t_70, t_80, t_90, t_96, vt_nk, vt_kk,
            vyh_300, vyh, ostat, poter, note, c4_36, masla);
    }  
    
    public Proby(RowData rowData){
        row = rowData;
        this.id         = Integer.valueOf(rowData.getValue(nameFields[0]));
        this.fs         = rowData.getValue(nameFields[1]);
        this.hexWell    = rowData.getValue(nameFields[2]);
        this.n_skv      = rowData.getValue(nameFields[3]);
        this.num_skv    = rowData.getValue(nameFields[4]);
        this.uppg       = rowData.getValue(nameFields[5]);
        this.point_ot   = rowData.getValue(nameFields[6]);
        this.dat_sel    = parseDate(rowData.getValue(nameFields[7]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.dat_an     = parseDate(rowData.getValue(nameFields[8]), "yyyy.MM.dd", "dd.MM.yyyy");
        this.pres_atm   = rowData.getValue(nameFields[9]);
        this.pres_b     = rowData.getValue(nameFields[10]);
        this.pres_e     = rowData.getValue(nameFields[11]);
        this.plot       = rowData.getValue(nameFields[12]);
        this.v20        = rowData.getValue(nameFields[13]);
        this.v50        = rowData.getValue(nameFields[14]);
        this.prel       = rowData.getValue(nameFields[15]);
        this.mol_m      = rowData.getValue(nameFields[16]);
        this.kisl       = rowData.getValue(nameFields[17]);
        this.konz       = rowData.getValue(nameFields[18]);
        this.voda       = rowData.getValue(nameFields[19]);
        this.asfal      = rowData.getValue(nameFields[20]);
        this.smol       = rowData.getValue(nameFields[21]);
        this.paraf      = rowData.getValue(nameFields[22]);
        this.ser_o      = rowData.getValue(nameFields[23]);
        this.ser_m      = rowData.getValue(nameFields[24]);
        this.ser_s      = rowData.getValue(nameFields[25]);
        this.hlor_s     = rowData.getValue(nameFields[26]);
        this.m_prim     = rowData.getValue(nameFields[27]);
        this.v_100      = rowData.getValue(nameFields[28]);
        this.v_120      = rowData.getValue(nameFields[29]);
        this.v_140      = rowData.getValue(nameFields[30]);
        this.v_150      = rowData.getValue(nameFields[31]);
        this.v_160      = rowData.getValue(nameFields[32]);
        this.v_180      = rowData.getValue(nameFields[33]);
        this.v_200      = rowData.getValue(nameFields[34]);
        this.v_220      = rowData.getValue(nameFields[35]);
        this.v_240      = rowData.getValue(nameFields[36]);
        this.v_250      = rowData.getValue(nameFields[37]);
        this.v_260      = rowData.getValue(nameFields[38]);
        this.v_280      = rowData.getValue(nameFields[39]);
        this.v_300      = rowData.getValue(nameFields[40]);
        this.v_350      = rowData.getValue(nameFields[41]);
        this.t_10       = rowData.getValue(nameFields[42]);
        this.t_20       = rowData.getValue(nameFields[43]);
        this.t_30       = rowData.getValue(nameFields[44]);
        this.t_40       = rowData.getValue(nameFields[45]);
        this.t_50       = rowData.getValue(nameFields[46]);
        this.t_60       = rowData.getValue(nameFields[47]);
        this.t_70       = rowData.getValue(nameFields[48]);
        this.t_80       = rowData.getValue(nameFields[49]);
        this.t_90       = rowData.getValue(nameFields[50]);
        this.t_96       = rowData.getValue(nameFields[51]);
        this.vt_nk      = rowData.getValue(nameFields[52]);
        this.vt_kk      = rowData.getValue(nameFields[53]);
        this.vyh_300    = rowData.getValue(nameFields[54]);
        this.vyh        = rowData.getValue(nameFields[55]);
        this.ostat      = rowData.getValue(nameFields[56]);
        this.poter      = rowData.getValue(nameFields[57]);
        this.note       = rowData.getValue(nameFields[58]);
        this.c4_36      = rowData.getValue(nameFields[59]);
        this.masla      = rowData.getValue(nameFields[60]);
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
