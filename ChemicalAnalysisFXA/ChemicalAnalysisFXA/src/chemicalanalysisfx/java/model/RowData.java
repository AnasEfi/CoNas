/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author ebondarenko
 */
public class RowData {
    private HashMap<String, String> fields;
    
    public Set getAll(){
        var keys = fields.keySet();
        return keys;
    }
    
    public RowData(){
        fields = new HashMap<>();
    }
    
    public void addKeyValue(String key, String value){
        fields.put(key, value);
    }
    
    public String getValue(String key){
        return fields.get(key);
    }
    
}
