
package com.gpu.chemicalanalisis.AnalisisAssociatedWaters;
import com.gpu.chemicalanalisis.*;
import com.gpu.chemicalanalisis.editing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;

/**
 * FXML Controller class
 *
 * @author Anastasya
 */
public class AnalisisAssociatedWatersController extends MainController{
    
    @FXML
    private void switchToEditor() throws IOException {
        Parent fxmlPath = loadFXML("EditAnalisisAssocoatedWaters");
        App.setRootFromPackage(fxmlPath);
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
}
