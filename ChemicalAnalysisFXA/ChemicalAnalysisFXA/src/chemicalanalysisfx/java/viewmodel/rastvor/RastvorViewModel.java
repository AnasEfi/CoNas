/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.viewmodel.rastvor;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author annab
 */
public class RastvorViewModel extends BaseViewModel {
    public SimpleIntegerProperty id;
    public SimpleStringProperty point_ot_full;
    public SimpleStringProperty avto_N;
    public SimpleStringProperty ustan;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty plot;
    public SimpleStringProperty kon_fak;
    public SimpleStringProperty kon_zad;
    public SimpleStringProperty rast;
    public SimpleStringProperty h2o;
    public SimpleStringProperty note;
    
    public RastvorViewModel(){
        
    }
    
    public RastvorViewModel(int id, String point_ot_full, String avto_N, String ustan, String dat_sel, String dat_an,
            String plot, String kon_fak, String kon_zad, String rast, String h2o, String note){
        this.id             = new SimpleIntegerProperty(id);
        this.point_ot_full  = new SimpleStringProperty(point_ot_full);
        this.avto_N         = new SimpleStringProperty(avto_N);
        this.ustan          = new SimpleStringProperty(ustan);
        this.dat_sel        = new SimpleStringProperty(dat_sel);
        this.dat_an         = new SimpleStringProperty(dat_an);
        this.plot           = new SimpleStringProperty(plot);
        this.kon_fak        = new SimpleStringProperty(kon_fak);
        this.kon_zad        = new SimpleStringProperty(kon_zad);
        this.rast           = new SimpleStringProperty(rast);
        this.h2o            = new SimpleStringProperty(h2o);
        this.note           = new SimpleStringProperty(note);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        values.add(point_ot_full.get());
        values.add(dat_sel.get());
        values.add(dat_an.get());
        values.add(avto_N.get());
        values.add(ustan.get());
        values.add(plot.get());
        values.add(kon_fak.get());
        values.add(kon_zad.get());
        values.add(rast.get());
        values.add(h2o.get());
        values.add(note.get());
        return values;
    }
}
