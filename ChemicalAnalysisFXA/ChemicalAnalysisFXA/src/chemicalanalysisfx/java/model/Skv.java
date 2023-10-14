/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model;

/**
 *
 * @author ebondarenko
 */
public class Skv {
    public String name;
    public int uppg;
    public String hexwell;
    
    public Skv(String _name, int _uppg, String _hexwell){
        _name = _name.replace("СКВ", "").replaceAll(" ", "");
        System.out.print(_name + " : ");
        int i =0;
        while(i < _name.length() && _name.charAt(i) == '0'){
            i++;
        }
        this.name = _name.length() > 0 ? _name.substring(i, _name.length()) : _name;
        System.out.print(name + "\n");
        this.uppg = _uppg;
        this.hexwell = _hexwell;
        
    }
}
