/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.viewmodel.proby;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ebondarenko
 */
public class ProbyViewModel extends BaseViewModel {
    public SimpleIntegerProperty id;
    public SimpleStringProperty n_skv;
    public SimpleStringProperty point_ot;
    public SimpleStringProperty note;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty pres_n;
    public SimpleStringProperty pres_k;
    public SimpleStringProperty plot;
    public SimpleStringProperty v20;
    public SimpleStringProperty v50;
    public SimpleStringProperty prel;
    public SimpleStringProperty mol_mass;
    
    public SimpleStringProperty voda;
    public SimpleStringProperty asfal;
    public SimpleStringProperty smol;
    public SimpleStringProperty paraf;
    public SimpleStringProperty masla;
    public SimpleStringProperty ser_o;
    public SimpleStringProperty ser_m;
    public SimpleStringProperty ser_s;
    public SimpleStringProperty hlor_s;
    public SimpleStringProperty m_prim;
    public SimpleStringProperty kisl;
    public SimpleStringProperty t_nk;
    public SimpleStringProperty v_100;
    public SimpleStringProperty v_120;
    public SimpleStringProperty v_140;
    public SimpleStringProperty v_150;
    public SimpleStringProperty v_160;
    public SimpleStringProperty v_180;
    public SimpleStringProperty v_200;
    public SimpleStringProperty v_220;
    public SimpleStringProperty v_240;
    public SimpleStringProperty v_250;
    public SimpleStringProperty v_260;
    public SimpleStringProperty v_280;
    public SimpleStringProperty v_300;
    public SimpleStringProperty v_350;
     
    public SimpleStringProperty t_10;
    public SimpleStringProperty t_20;
    public SimpleStringProperty t_30;
    public SimpleStringProperty t_40;
    public SimpleStringProperty t_50;
    public SimpleStringProperty t_60;
    public SimpleStringProperty t_70;
    public SimpleStringProperty t_80;
    public SimpleStringProperty t_90;
    public SimpleStringProperty t_96;
    
    public SimpleStringProperty t_kk;
    public SimpleStringProperty vyh_300;
    public SimpleStringProperty vyh;
    public SimpleStringProperty ostat;
    public SimpleStringProperty poter;
    public SimpleStringProperty conc;
    
    public ProbyViewModel(){
        
    }
    
    public ProbyViewModel (int id, String n_skv, String point_ot, String note, String dat_sel, String dat_an, String pres_n, 
            String pres_k, String plot, String v20, String v50, String prel, String mol_mass, String voda, String asfal, 
            String smol, String paraf, String masla, String ser_o, String ser_m, String ser_s, String hlor_s, String m_prim, String kisl, String t_nk,
            String v_100, String v_120, String v_140, String v_150, String v_160, String v_180, String v_200, String v_220,
            String v_240, String v_250, String v_260, String v_280, String v_300, String v_350, String t_10, String t_20,
            String t_30, String t_40, String t_50, String t_60, String t_70, String t_80, String t_90, String t_96, 
            String t_kk, String vyh_300, String vyh, String ostat, String poter, String conc){
        this.id = new SimpleIntegerProperty(id);
        this.n_skv = new SimpleStringProperty(n_skv);
        this.point_ot = new SimpleStringProperty(point_ot);
        this.note = new SimpleStringProperty(note);
        this.dat_sel = new SimpleStringProperty(dat_sel);
        this.dat_an = new SimpleStringProperty(dat_an);
        this.pres_n = new SimpleStringProperty(pres_n);
        this.pres_k = new SimpleStringProperty(pres_k);
        this.plot = new SimpleStringProperty(plot);
        this.v20 = new SimpleStringProperty(v20);
        this.v50 = new SimpleStringProperty(v50);
        this.prel = new SimpleStringProperty(prel);
        this.mol_mass = new SimpleStringProperty(mol_mass);
        this.voda = new SimpleStringProperty(voda);
        this.asfal = new SimpleStringProperty(asfal);
        this.smol = new SimpleStringProperty(smol);
        this.paraf = new SimpleStringProperty(paraf);
        this.masla = new SimpleStringProperty(masla);
        this.ser_o = new SimpleStringProperty(ser_o);
        this.ser_m = new SimpleStringProperty(ser_m);
        this.ser_s = new SimpleStringProperty(ser_s);
        this.hlor_s = new SimpleStringProperty(hlor_s);
        this.m_prim = new SimpleStringProperty(m_prim);
        this.kisl = new SimpleStringProperty(kisl);
        this.t_nk = new SimpleStringProperty(t_nk);
        this.v_100 = new SimpleStringProperty(v_100);
        this.v_120 = new SimpleStringProperty(v_120);
        this.v_140 = new SimpleStringProperty(v_140);
        this.v_150 = new SimpleStringProperty(v_150);
        this.v_160 = new SimpleStringProperty(v_160);
        this.v_180 = new SimpleStringProperty(v_180);
        this.v_200 = new SimpleStringProperty(v_200);
        this.v_220 = new SimpleStringProperty(v_220);
        this.v_240 = new SimpleStringProperty(v_240);
        this.v_250 = new SimpleStringProperty(v_250);
        this.v_260 = new SimpleStringProperty(v_260);
        this.v_280 = new SimpleStringProperty(v_280);
        this.v_300 = new SimpleStringProperty(v_300);
        this.v_350 = new SimpleStringProperty(v_350);
        this.t_10 = new SimpleStringProperty(t_10);
        this.t_20 = new SimpleStringProperty(t_20);
        this.t_30 = new SimpleStringProperty(t_30);
        this.t_40 = new SimpleStringProperty(t_40);
        this.t_50 = new SimpleStringProperty(t_50);
        this.t_60 = new SimpleStringProperty(t_60);
        this.t_70 = new SimpleStringProperty(t_70);
        this.t_80 = new SimpleStringProperty(t_80);
        this.t_90 = new SimpleStringProperty(t_90);
        this.t_96 = new SimpleStringProperty(t_96);
        this.t_kk = new SimpleStringProperty(t_kk);
        this.vyh_300 = new SimpleStringProperty(vyh_300);
        this.vyh = new SimpleStringProperty(vyh);
        this.ostat = new SimpleStringProperty(ostat);
        this.poter = new SimpleStringProperty(poter);
        this.conc = new SimpleStringProperty(conc);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        /*values.add(n_skv.get());
        values.add(point_ot.get());
        values.add(dat_sel_an.get());
        values.add(pres_be.get());
        values.add(plot.get());
        values.add(fe.get());
        values.add(ph.get());
        values.add(shel12.get());
        values.add(cl12.get());
        values.add(s12.get());
        values.add(sulf12.get());
        values.add(ca12.get());
        values.add(mg12.get());
        values.add(na12.get());
        values.add(k12.get());
        values.add(kat_an.get());
        values.add(raz_ion12.get());
        values.add(min_ves_ras.get());
        values.add(note.get());*/
        return values;
    }
}
