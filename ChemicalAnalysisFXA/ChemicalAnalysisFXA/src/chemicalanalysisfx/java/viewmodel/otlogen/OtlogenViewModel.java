/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemicalanalysisfx.java.viewmodel.otlogen;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author annab
 */
public class OtlogenViewModel extends BaseViewModel{
    public SimpleIntegerProperty id;
    public SimpleStringProperty n_skv;
    public SimpleStringProperty dat_sel;
    public SimpleStringProperty dat_an;
    public SimpleStringProperty point_ot;
    public SimpleStringProperty FE3_FE2;
    public SimpleStringProperty FE_FEzol;
    public SimpleStringProperty S_total;
    public SimpleStringProperty S_elem;
    public SimpleStringProperty Cl;
    public SimpleStringProperty CO3;
    public SimpleStringProperty SiO2;
    public SimpleStringProperty C_grafit;
    public SimpleStringProperty uglevod;
    public SimpleStringProperty water;
    public SimpleStringProperty p_100;
    public SimpleStringProperty p_300;
    public SimpleStringProperty p_500;
    public SimpleStringProperty p_800;
    public SimpleStringProperty H2S_CO2;
    public SimpleStringProperty note;
    public SimpleStringProperty vid;
    
    public OtlogenViewModel(){
        
    }
    
    public OtlogenViewModel(int id, String n_skv, String dat_sel, String dat_an, String point_ot, String FE3_FE2, String FE_FEzol,
            String S_total, String S_elem, String Cl, String CO3, String SiO2, String C_grafit, String uglevod, String water, 
            String p_100, String p_300, String p_500, String p_800, String H2S_CO2, String note, String vid){
        this.id         = new SimpleIntegerProperty(id);
        this.n_skv      = new SimpleStringProperty(n_skv);
        this.dat_sel    = new SimpleStringProperty(dat_sel);
        this.dat_an     = new SimpleStringProperty(dat_an);
        this.point_ot   = new SimpleStringProperty(point_ot);
        this.FE3_FE2    = new SimpleStringProperty(FE3_FE2);
        this.FE_FEzol   = new SimpleStringProperty(FE_FEzol);
        this.S_total    = new SimpleStringProperty(S_total);
        this.S_elem     = new SimpleStringProperty(S_elem);
        this.Cl         = new SimpleStringProperty(Cl);
        this.CO3        = new SimpleStringProperty(CO3);
        this.SiO2       = new SimpleStringProperty(SiO2);
        this.C_grafit   = new SimpleStringProperty(C_grafit);
        this.uglevod    = new SimpleStringProperty(uglevod);
        this.water      = new SimpleStringProperty(water);          
        this.p_100      = new SimpleStringProperty(p_100);
        this.p_300      = new SimpleStringProperty(p_300);
        this.p_500      = new SimpleStringProperty(p_500);
        this.p_800      = new SimpleStringProperty(p_800);
        this.H2S_CO2    = new SimpleStringProperty(H2S_CO2);
        this.note       = new SimpleStringProperty(note);
        this.vid        = new SimpleStringProperty(vid);
    }
    
    @Override
    public ArrayList<String> getValues(){ // возвращает строку в том порядке, каком необходимо выводить значения для отчета
        var values = new ArrayList<String>();
        values.add(n_skv.get());
        values.add(dat_sel.get());
        values.add(dat_an.get());
        values.add(point_ot.get());
        values.add(vid.get());
        values.add(FE3_FE2.get());
        values.add(FE_FEzol.get());
        values.add(S_total.get());
        values.add(S_elem.get());
        values.add(Cl.get());
        values.add(CO3.get());
        values.add(SiO2.get());
        values.add(C_grafit.get());
        values.add(dat_sel.get());
        values.add(uglevod.get());
        values.add(water.get());
        values.add(p_100.get());
        values.add(p_300.get());
        values.add(p_500.get());
        values.add(p_800.get());
        values.add(H2S_CO2.get());
        values.add(note.get());
        return values;
    }
}
