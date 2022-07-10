module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.ioc to javafx.fxml, javafx.graphics;
    exports org.ioc;
}
