module com.gpu.chemicalanalisis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.gpu.chemicalanalisis to javafx.fxml;
    opens com.gpu.chemicalanalisis.modules.AnalisisAssociatedWaters to javafx.fxml;
    exports com.gpu.chemicalanalisis;
    exports com.gpu.chemicalanalisis.modules.AnalisisAssociatedWaters;
    exports com.gpu.chemicalanalisis.modules;
    opens com.gpu.chemicalanalisis.modules to javafx.fxml;
    exports com.gpu.chemicalanalisis.Utils;
    opens com.gpu.chemicalanalisis.Utils to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.Autorization;
    opens com.gpu.chemicalanalisis.modules.Autorization to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.AnalisisOfDiethyleneglycol;
    opens com.gpu.chemicalanalisis.modules.AnalisisOfDiethyleneglycol to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.CompositionOfReservoirGas;
    opens com.gpu.chemicalanalisis.modules.CompositionOfReservoirGas to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.CorrosionInhibitorAnalysis;
    opens com.gpu.chemicalanalisis.modules.CorrosionInhibitorAnalysis to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.DieselFuelAnalysis;
    opens com.gpu.chemicalanalisis.modules.DieselFuelAnalysis to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.FluidCorrosionInhibitorAnalysis;
    opens com.gpu.chemicalanalisis.modules.FluidCorrosionInhibitorAnalysis to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.SamplesOfOrganicOrigin;
    opens com.gpu.chemicalanalisis.modules.SamplesOfOrganicOrigin to javafx.fxml;
    exports com.gpu.chemicalanalisis.modules.SedimentAnalisis;
    opens com.gpu.chemicalanalisis.modules.SedimentAnalisis to javafx.fxml;
    exports com.gpu.chemicalanalisis.AppUtils.Controllers;
    opens com.gpu.chemicalanalisis.AppUtils.Controllers to javafx.fxml;
    exports com.gpu.chemicalanalisis.AppUtils;
    opens com.gpu.chemicalanalisis.AppUtils to javafx.fxml;
    exports com.gpu.chemicalanalisis.AppUtils.Models;
    opens com.gpu.chemicalanalisis.AppUtils.Models to javafx.fxml;
}
