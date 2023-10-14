/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.viewmodel.ingibitor;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ebondarenko
 */
public class IngibitorViewModel extends BaseViewModel{
    public SimpleIntegerProperty id; 
    public SimpleStringProperty n_skv;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty conc;
    public SimpleStringProperty plot;
    public SimpleStringProperty note;
    
    public IngibitorViewModel(){
        
    }
    
    public IngibitorViewModel (int id, String n_skv, String dat_sel, String dat_an, String conc, String plot, String note){
        this.id = new SimpleIntegerProperty(id);
        this.n_skv = new SimpleStringProperty(n_skv);
        this.dat_sel = new SimpleStringProperty(dat_sel);
        this.dat_an = new SimpleStringProperty(dat_an);
        this.conc = new SimpleStringProperty(conc);
        this.plot = new SimpleStringProperty(plot);
        this.note = new SimpleStringProperty(note);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        values.add(n_skv.get());
        values.add(dat_sel.get());
        values.add(dat_an.get());
        values.add(conc.get());
        values.add(plot.get());
        values.add(note.get());
        return values;
    }
}
