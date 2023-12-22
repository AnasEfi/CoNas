package com.gpu.chemicalanalisis.AppUtils.Controllers;

import com.gpu.chemicalanalisis.AppUtils.DataBaseDriver;
import com.gpu.chemicalanalisis.Utils.InfoWells;

public class NewMainController {
    protected InfoWells infoWells;

    public NewMainController() {
        this.infoWells = DataBaseDriver.getListSkvInfoWells();
    }
}
