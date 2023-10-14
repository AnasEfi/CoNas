/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.model;

import chemicalanalysisfx.java.viewmodel.BaseViewModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ebondarenko
 */
public class ExportExcel {
    ArrayList<NameFieldExcelStyle> nameFields;
    
    public ExportExcel(ArrayList<NameFieldExcelStyle> nameFields){
        this.nameFields = nameFields;
    }
    
    public void export(String filename, String sheetname, List data) throws FileNotFoundException, IOException{
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetname);
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short)12);
        font.setBold(true);
        font.setFontName("Times New Roman");
        cellStyle.setFont(font);

        int i = 0, countCol=0;
        XSSFCell cell;
        XSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(sheet.getDefaultRowHeightInPoints()*3);
        
        for (var field: nameFields){
            if (countCol < field.firstColumn) countCol = field.firstColumn;
            if (field.firstRow > i){
                i++;
                row = sheet.createRow(field.firstRow);
                //row.setHeightInPoints(sheet.getDefaultRowHeightInPoints()*3);
            } else if (field.firstRow < i){
                row = sheet.getRow(field.firstRow);
            }
            cell = row.createCell(field.firstColumn, CellType.STRING);
            cell.setCellValue(field.name);
            cell.setCellStyle(cellStyle);
            sheet.autoSizeColumn(field.firstColumn);
            if (field.lastRow - field.firstRow > 0 || field.lastColumn - field.firstColumn > 0)
                sheet.addMergedRegion(new CellRangeAddress(field.firstRow, field.lastRow, field.firstColumn, field.lastColumn));
        }
        
        font.setFontHeightInPoints((short)10);
        row = sheet.createRow(++i);
        for (int k = 0; k <= countCol; k++){
            cell = row.createCell(k, CellType.STRING);
            cell.setCellValue(k+1);
            cell.setCellStyle(cellStyle);
        }
        
        font.setFontHeightInPoints((short)12);
        font.setBold(false);
        for(var d: data){
            row = sheet.createRow(++i);
            var values = ((BaseViewModel)d).getValues();
            for (int k = 0; k < values.size(); k++){
                cell = row.createCell(k, CellType.STRING);
                cell.setCellValue(values.get(k));
                cell.setCellStyle(cellStyle);
                sheet.autoSizeColumn(k);
            }
        }
        
        FileOutputStream fout = new FileOutputStream(filename);
        wb.write(fout);
        wb.close();
        fout.close();
    }
}
