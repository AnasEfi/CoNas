/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.viewmodel.himanaliz;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ebondarenko
 */
public class HimanalizViewModel extends BaseViewModel{
    public SimpleIntegerProperty id; 
    public SimpleStringProperty n_skv;
    public SimpleStringProperty uppg;
    public SimpleStringProperty point_ot;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty pres_b;
    public SimpleStringProperty pres_e;
    public SimpleStringProperty he;
    public SimpleStringProperty h2;
    public SimpleStringProperty n2;
    public SimpleStringProperty o2;
    public SimpleStringProperty c1;
    public SimpleStringProperty co2;
    public SimpleStringProperty c2;
    public SimpleStringProperty h2s;
    public SimpleStringProperty c3;
    public SimpleStringProperty ic4;
    public SimpleStringProperty c4;
    public SimpleStringProperty ic5;
    public SimpleStringProperty c5;
    public SimpleStringProperty c6;
    public SimpleStringProperty c7;
    public SimpleStringProperty rsh;
    public SimpleStringProperty sum_comp;
    public SimpleStringProperty molec_mass;
    public SimpleStringProperty abs_density;
    public SimpleStringProperty otn_density;
    public SimpleStringProperty note;
    
    public HimanalizViewModel(int id, String n_skv, String uppg, String point_ot, String dat_sel, String dat_an, 
            String pres_b, String pres_e, String he, String h2, String n2, String o2, String c1, String co2, String c2, String h2s, 
            String c3, String ic4, String c4, String ic5, String c5, String c6, String c7, String rsh, String sum_comp, String molec_mass,
            String abs_density, String otn_density, String note){
        this.id = new SimpleIntegerProperty(id);
        this.n_skv = new SimpleStringProperty(n_skv);
        this.uppg = new SimpleStringProperty(uppg);
        this.point_ot = new SimpleStringProperty(point_ot);
        this.dat_sel = new SimpleStringProperty(dat_sel);
        this.dat_an = new SimpleStringProperty(dat_an);
        this.pres_b = new SimpleStringProperty(pres_b);
        this.pres_e = new SimpleStringProperty(pres_e);
        this.he = new SimpleStringProperty(he);
        this.h2 = new SimpleStringProperty(h2);
        this.n2 = new SimpleStringProperty(n2);
        this.o2 = new SimpleStringProperty(o2);
        this.c1 = new SimpleStringProperty(c1);
        this.co2 = new SimpleStringProperty(co2);
        this.c2 = new SimpleStringProperty(c2);
        this.h2s = new SimpleStringProperty(h2s);
        this.c3 = new SimpleStringProperty(c3);
        this.ic4 = new SimpleStringProperty(ic4);
        this.c4 = new SimpleStringProperty(c4);
        this.ic5 = new SimpleStringProperty(ic5);
        this.c5 = new SimpleStringProperty(c5);
        this.c6 = new SimpleStringProperty(c6);
        this.c7 = new SimpleStringProperty(c7);
        this.rsh = new SimpleStringProperty(rsh);
        this.sum_comp = new SimpleStringProperty(sum_comp);
        this.molec_mass = new SimpleStringProperty(molec_mass);
        this.abs_density = new SimpleStringProperty(abs_density);
        this.otn_density = new SimpleStringProperty(otn_density);
        this.note = new SimpleStringProperty(note);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        values.add(n_skv.get());
        values.add(uppg.get());
        values.add(point_ot.get());
        values.add(dat_sel.get());
        values.add(dat_an.get());
        values.add(pres_b.get());
        values.add(pres_e.get());
        values.add(he.get());
        values.add(h2.get());
        values.add(n2.get());
        values.add(o2.get());
        values.add(c1.get());
        values.add(co2.get());
        values.add(c2.get());
        values.add(h2s.get());
        values.add(c3.get());
        values.add(ic4.get());
        values.add(c4.get());
        values.add(ic5.get());
        values.add(c5.get());
        values.add(c6.get());
        values.add(c7.get());
        values.add(rsh.get());
        values.add(sum_comp.get());
        values.add(molec_mass.get());
        values.add(abs_density.get());
        values.add(otn_density.get());
        values.add(note.get());
        return values;
    }
}
