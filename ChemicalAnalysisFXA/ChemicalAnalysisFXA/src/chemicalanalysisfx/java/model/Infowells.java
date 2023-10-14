/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ebondarenko
 */
public class Infowells {
    private ArrayList<Skv> list;
    
    public Infowells(){
        list = new ArrayList<Skv>();
    }
    
    public void add(Skv skv){
        list.add(skv);
    }
    
    public List getSkv(){
        ArrayList<String> skvs= new ArrayList<String>();
        for(var l: list){
            skvs.add(l.name);
        }
        return skvs;
    }
    
    public int getUppg(String name){
        for (var l: list){
            if (l.name.equals(name)) 
                return l.uppg;
        }
        return 0;
    }
    
    public String getHexWell(String name){
        for (var l: list){
            if (l.name.equals(name)) 
                return l.hexwell;
        }
        return "";
    }
}
