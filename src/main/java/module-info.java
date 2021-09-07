module com.pethouse.pethouseapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.pethouse.pethouseapp to javafx.fxml;
    exports com.pethouse.pethouseapp;
    exports com.pethouse.pethouseapp.units;
    opens com.pethouse.pethouseapp.units to javafx.fxml;
    exports com.pethouse.pethouseapp.javafxclasses;
    opens com.pethouse.pethouseapp.javafxclasses to javafx.fxml;
}