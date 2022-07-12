module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.ioc to javafx.fxml, javafx.graphics, java.sql;
    opens org.ioc.controller to javafx.fxml;
    exports org.ioc;
}
