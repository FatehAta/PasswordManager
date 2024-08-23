module org.atatree.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.atatree.passwordmanager to javafx.fxml;
    exports org.atatree.passwordmanager;
}