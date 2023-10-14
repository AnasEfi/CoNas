/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.viewmodel;

import java.util.ArrayList;

/**
 *
 * @author ebondarenko
 */
public class BaseViewModel {
    public static int new_id;
    
    static{
        new_id = -1;
    }
    
    public ArrayList<String> getValues()
    {
        return new ArrayList<String>();
    };
}
