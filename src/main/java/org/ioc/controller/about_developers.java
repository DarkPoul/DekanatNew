package org.ioc.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.ioc.App;

import java.io.IOException;

public class about_developers {

    public void GoBack(ActionEvent actionEvent) throws IOException {
            App.setRoot("gui/MainWindow");
    }
}
