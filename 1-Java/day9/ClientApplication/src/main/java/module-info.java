module com.mycompany.clientapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.clientapplication to javafx.fxml;
    exports com.mycompany.clientapplication;
}
