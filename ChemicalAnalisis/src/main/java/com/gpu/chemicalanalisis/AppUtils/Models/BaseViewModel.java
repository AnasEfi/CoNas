package com.gpu.chemicalanalisis.AppUtils.Models;
import java.util.ArrayList;

public class BaseViewModel {
    public static int new_id;
    static {
        new_id = -1;
    }
    public ArrayList<String> getValues() {return new ArrayList<String>();};
}

