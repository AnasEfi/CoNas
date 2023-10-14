/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.viewmodel.podzem;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.*;

/**
 *
 * @author ebondarenko
 */
public class PodzemViewModel extends BaseViewModel{
    public SimpleIntegerProperty id; 
    public SimpleStringProperty n_skv;
    public SimpleStringProperty point_ot;
    public SimpleStringProperty dat_sel_an;
    public SimpleStringProperty pres_be;
    public SimpleStringProperty plot;
    public SimpleStringProperty fe;
    public SimpleStringProperty ph;
    public SimpleStringProperty shel12;
    public SimpleStringProperty cl12;
    public SimpleStringProperty s12;
    public SimpleStringProperty sulf12;
    public SimpleStringProperty ca12;;
    public SimpleStringProperty mg12;
    public SimpleStringProperty na12;
    public SimpleStringProperty k12;
    public SimpleStringProperty kat_an;
    public SimpleStringProperty raz_ion12;
    public SimpleStringProperty min_ves_ras;
    public SimpleStringProperty note;
    
    public PodzemViewModel(){
        
    }
    
    public PodzemViewModel (int id, String point_ot, String n_skv, String dat_sel_an, String pres_be, String plot, String fe, 
            String ph, String shel12, String cl12, String s12, String sulf12, String ca12, String mg12, String na12, 
            String k12, String kat_an, String raz_ion12, String min_ves_ras, String note){
        this.id = new SimpleIntegerProperty(id);
        this.point_ot = new SimpleStringProperty(point_ot);
        this.n_skv = new SimpleStringProperty(n_skv);
        this.dat_sel_an = new SimpleStringProperty(dat_sel_an);
        this.pres_be = new SimpleStringProperty(pres_be);
        this.plot = new SimpleStringProperty(plot);
        this.fe = new SimpleStringProperty(fe);
        this.ph = new SimpleStringProperty(ph);
        this.shel12 = new SimpleStringProperty(shel12);
        this.cl12 = new SimpleStringProperty(cl12);
        this.s12 = new SimpleStringProperty(s12);
        this.sulf12 = new SimpleStringProperty(sulf12);
        this.ca12 = new SimpleStringProperty(ca12);
        this.mg12 = new SimpleStringProperty(mg12);
        this.na12 = new SimpleStringProperty(na12);
        this.k12 = new SimpleStringProperty(k12);
        this.kat_an = new SimpleStringProperty(kat_an);
        this.raz_ion12 = new SimpleStringProperty(raz_ion12);
        this.min_ves_ras = new SimpleStringProperty(min_ves_ras);
        this.note = new SimpleStringProperty(note);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        values.add(n_skv.get());
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
        values.add(note.get());
        return values;
    }
}
