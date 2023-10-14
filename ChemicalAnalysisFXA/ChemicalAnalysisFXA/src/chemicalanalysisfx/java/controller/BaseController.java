/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemicalanalysisfx.java.controller;

import javafx.stage.Stage;
/**
 *
 * @author ebondarenko
 */
public class BaseController {
    protected Stage primaryStage;           // текущее окно (ссылка нужна, чтобы передавать окно как родительское для новых окон)
    protected String tablename;             // название таблицы для запросов к БД
   // protected List dataVm;                  // модель данных 
    //protected ArrayList<NameFieldExcelStyle> nameFieldsExcel; // список заголовков полей для вывода отчета в excel
    
    public BaseController(Stage primaryStage, String tablename){
        this.primaryStage = primaryStage;
        this.tablename = tablename;
     //   dataVm = new ArrayList<BaseViewModel>();
     //   nameFieldsExcel = new ArrayList<NameFieldExcelStyle>();
    }
    
    /*@FXML
    public void buttonCreateExcelAction(){       // вывести отчет в файл excel
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите файл");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx"));
            File file = fileChooser.showSaveDialog(primaryStage);

            ExportExcel excel = new ExportExcel(nameFieldsExcel);
            excel.export(file.getAbsolutePath(), "Отчёт", dataVm);
            JOptionPane.showMessageDialog(null, "Отчёт был успешно выгружен!", "Выгрузка отчёта", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
*/
}
