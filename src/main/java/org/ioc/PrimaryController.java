package org.ioc;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("gui/secondary");
    }
    @FXML
    private void switchToAut() throws IOException {
        App.setRoot("gui/authentication");
    }

}
