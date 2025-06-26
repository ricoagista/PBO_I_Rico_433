module com.belajar {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.belajar to javafx.fxml;
    opens com.belajar.controller to javafx.fxml;
    opens com.belajar.model to javafx.base;
    exports com.belajar;
    exports com.belajar.controller;
}