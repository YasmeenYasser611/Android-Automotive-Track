module com.mycompany.regester {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires derbyclient;
    requires java.base;
    
    opens com.mycompany.regester to javafx.fxml;
    exports com.mycompany.regester;
}
