module com.mock.demomock {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.mock.demomock to javafx.fxml;
    exports com.mock.demomock;
}