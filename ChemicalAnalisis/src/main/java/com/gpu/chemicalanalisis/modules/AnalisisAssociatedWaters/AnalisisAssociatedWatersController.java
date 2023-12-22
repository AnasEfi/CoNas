
package com.gpu.chemicalanalisis.modules.AnalisisAssociatedWaters;
import com.gpu.chemicalanalisis.*;
import java.io.IOException;

import com.gpu.chemicalanalisis.AppUtils.Controllers.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Anastasya
 */
public class AnalisisAssociatedWatersController extends MainController {

    @FXML
    private TableView<AnalisisAssociatedWatersMV> podzem;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> n_skv;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> point_ot;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> dat_sel_an;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> pres_be;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> plot;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> fe;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> ph;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> shel12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> cl12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> s12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> sulf12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> ca12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> mg12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> na12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> k12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> kat_an;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> raz_ion12;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> min_ves_ras;
    @FXML
    private TableColumn<AnalisisAssociatedWatersMV, String> note;
    @FXML
    private ToggleGroup toggleGroupDate;
    @FXML
    private DatePicker datePickerOneDate;
    @FXML
    private DatePicker datePickerRangeDateB;
    @FXML
    private DatePicker datePickerRangeDateE;
    @FXML
    private Label labelDateB;
    @FXML
    private Label labelDateE;
    @FXML
    private Label labelCount;
    @FXML
    private ComboBox<String> comboBoxSkv;
    @FXML
    private ComboBox<String> comboBoxUppg;
    @FXML
    private ToggleGroup toggleGroupPointOt;
    @FXML
    private CheckBox checkBoxKS;
    @FXML
    private CheckBox checkBoxZatr;
    @FXML
    private CheckBox checkBoxUst;
    @FXML
    private CheckBox checkBoxProch;
    @FXML
    private CheckBox checkBoxGlub;
    @FXML
    private CheckBox checkBox79;
    @FXML
    private CheckBox checkBox912;
    @FXML
    private CheckBox checkBox1216;
    @FXML
    private MenuButton buttonEdit;

    public AnalisisAssociatedWatersController(){

    }

    @FXML
    private void switchToEditor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gpu/chemicalanalisis/AnalisisAssociatedWaters/EditAnalisisAssociatedWaters.fxml"));
        Parent root = loader.load();
        App.setRootFromPackage(root, 1200,720);
    }

    @FXML
    void buttonCreateExcelAction(ActionEvent event) {

    }

    @FXML
    void buttonSortDateAnAction(ActionEvent event) {

    }

    @FXML
    void buttonSortPointOtAction(ActionEvent event) {

    }

    @FXML
    void buttonSortSkvDateSelAction(ActionEvent event) {

    }

    @FXML
    public void buttonChangeValueAction(ActionEvent event) {
        String err = "id";
        try {
            var item = podzem.getSelectionModel().getSelectedItem();
            System.out.println(String.valueOf(item.id.get()));

            err = "stage";
            Stage newStage = new Stage();
            newStage.setTitle("Изменение данных");
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gpu/chemicalanalisis/AnalisisAssociatedWaters/EditAnalisisAssocoatedWaters.fxml"));
            Parent root = loader.load();
            App.setRootFromPackage(root,1200,720);

            // обновляем визуализацию
          /*  var new_item = new Podzem(DatabaseDriver.getRowFromDb(tablename, item.id.get()));
            int index = podzem.getItems().indexOf(item);
            podzem.getItems().set(index, makeViewModel(new_item));
           */
            System.out.println("podzem_new stage closed!");
        } catch (Exception e) {
            if (err.equals("id")) {
                System.out.println("Ошибка изменения: Не выбрана точка отбора!");
            } else {
                // Другая логика обработки ошибки
                System.out.println("Ошибка: Другая ошибка");
                e.printStackTrace();
            }
        }
    }




}
