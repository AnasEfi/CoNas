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
public class NameFieldExcelStyle {
    public String name;
    public int firstRow;
    public int lastRow;
    public int firstColumn;
    public int lastColumn;
    
    public NameFieldExcelStyle(String name, int firstRow, int lastRow, int firstColumn, int lastColumn){
        this.name = name;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstColumn = firstColumn;
        this.lastColumn = lastColumn;
    }
}
