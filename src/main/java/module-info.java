module com.pethouse.pethouseapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.pethouse.pethouseapp to javafx.fxml;
    exports com.pethouse.pethouseapp;
}