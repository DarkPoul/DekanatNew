package org.ioc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.ioc.App;
import java.io.IOException;

public class error_connection {
    @FXML
    void GoBack(ActionEvent event) throws IOException {
        App.setRoot("gui/authentication");
    }


}
