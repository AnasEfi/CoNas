/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.viewmodel.diztop;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author annab
 */
public class DiztopViewModel extends BaseViewModel {
    public SimpleIntegerProperty id;
    public SimpleStringProperty point_ot_full;
    public SimpleStringProperty avto_N;
    public SimpleStringProperty uppg;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty plot;
    public SimpleStringProperty frak1;
    public SimpleStringProperty frak2;
    public SimpleStringProperty temp;
    public SimpleStringProperty temp2;
    public SimpleStringProperty h2o;
    public SimpleStringProperty note;
    
    public DiztopViewModel(){
        
    }
    
    public DiztopViewModel(int id, String point_ot_full, String avto_N, String uppg, String dat_sel, String dat_an,
            String plot, String frak1, String frak2, String temp, String temp2, String h2o, String note){
        this.id             = new SimpleIntegerProperty(id);
        this.point_ot_full  = new SimpleStringProperty(point_ot_full);
        this.avto_N         = new SimpleStringProperty(avto_N);
        this.uppg           = new SimpleStringProperty(uppg);
        this.dat_sel        = new SimpleStringProperty(dat_sel);
        this.dat_an         = new SimpleStringProperty(dat_an);
        this.plot           = new SimpleStringProperty(plot);
        this.frak1          = new SimpleStringProperty(frak1);
        this.frak2          = new SimpleStringProperty(frak2);
        this.temp           = new SimpleStringProperty(temp);
        this.temp2          = new SimpleStringProperty(temp2);
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
        values.add(uppg.get());
        values.add(plot.get());
        values.add(temp.get());
        values.add(frak1.get());
        values.add(frak2.get());
        values.add(temp2.get());
        values.add(h2o.get());
        values.add(note.get());
        return values;
    }
}
