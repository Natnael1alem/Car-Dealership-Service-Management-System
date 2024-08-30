module com.carshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    // requires javafx.graphics;

    opens com.carshop to javafx.fxml;
    exports com.carshop;
}
