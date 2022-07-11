module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ini4j;
    requires mysql.connector.java;

    opens org.ioc to javafx.fxml, javafx.graphics;
    opens org.ioc.controller to javafx.fxml;
    exports org.ioc;
}
