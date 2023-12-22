package com.gpu.chemicalanalisis;

import javafx.stage.Stage;

public class NewMainController {
    protected InfoWells infoWells;

    public NewMainController() {
        this.infoWells = DataBaseDriver.getListSkvInfoWells();
    }
}
