package com.gpu.chemicalanalisis;

import java.util.ArrayList;
import java.util.List;

public class InfoWells {
    private ArrayList<Skv> list;

    public InfoWells(){
        list = new ArrayList<Skv>();
    }

    public void add(Skv skv){
        list.add(skv);
    }

    public List getSkv(){
        ArrayList<String> skvs = new ArrayList<String>();
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
