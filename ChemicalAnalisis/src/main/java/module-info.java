module com.gpu.chemicalanalisis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.gpu.chemicalanalisis to javafx.fxml;
    exports com.gpu.chemicalanalisis;
}
