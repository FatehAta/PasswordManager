module org.atatree.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.atatree.passwordmanager to javafx.fxml;
    exports org.atatree.passwordmanager;
    exports org.atatree.passwordmanager.controllers;
}