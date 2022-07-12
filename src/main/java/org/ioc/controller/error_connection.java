package org.ioc.controller;

import javafx.fxml.FXML;
import org.ioc.App;
import java.io.IOException;

public class error_connection {
    @FXML
    void GoBack() throws IOException {
        App.setRoot("gui/authentication");
    }
}
