/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.viewmodel.prob_DEG;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author annab
 */
public class ProbDEGViewModel extends BaseViewModel{
    public SimpleIntegerProperty id;
    public SimpleStringProperty n_skv;
    public SimpleStringProperty uppg;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty plot;
    public SimpleStringProperty pH;
    public SimpleStringProperty deg;
    public SimpleStringProperty h2o;
    public SimpleStringProperty met;
    public SimpleStringProperty prim;
    public SimpleStringProperty teg;
    public SimpleStringProperty note;
    
    public ProbDEGViewModel(){
        
    }
    
    public ProbDEGViewModel(int id, String n_skv, String uppg, String dat_sel, String dat_an, String plot, 
            String pH, String deg, String h2o, String met, String prim, String teg, String note){
        this.id         = new SimpleIntegerProperty(id);
        this.n_skv      = new SimpleStringProperty(n_skv);
        this.uppg       = new SimpleStringProperty(uppg);
        this.dat_sel    = new SimpleStringProperty(dat_sel);
        this.dat_an     = new SimpleStringProperty(dat_an);
        this.plot       = new SimpleStringProperty(plot);
        this.pH         = new SimpleStringProperty(pH);
        this.deg        = new SimpleStringProperty(deg);
        this.h2o        = new SimpleStringProperty(h2o);
        this.met        = new SimpleStringProperty(met);
        this.prim       = new SimpleStringProperty(prim);
        this.teg        = new SimpleStringProperty(teg);
        this.note       = new SimpleStringProperty(note);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        values.add(n_skv.get());
        values.add(uppg.get());
        values.add(dat_sel.get());
        values.add(dat_an.get());
        values.add(plot.get());
        values.add(pH.get());
        values.add(deg.get());
        values.add(h2o.get());
        values.add(met.get());
        values.add(prim.get());
        values.add(teg.get());
        values.add(note.get());
        return values;
    }
}
