module org.ioc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.poi;

    opens org.ioc to javafx.fxml, javafx.graphics, java.sql;
    opens org.ioc.controller to javafx.fxml;
    opens org.ioc.model to javafx.base;
    exports org.ioc;
}
