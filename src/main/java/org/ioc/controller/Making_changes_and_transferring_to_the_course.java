package org.ioc.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.App;
import org.ioc.Main;

import java.io.IOException;

public class Making_changes_and_transferring_to_the_course {

    @FXML
    private Button Entering_estimates_from_the_information;

    @FXML
    private Button Supporting_documents;

    @FXML
    private Button Transfer_to_the_course;

    @FXML
    private Button View_and_edit_cards;

    @FXML
    private Button View_debtors;

    @FXML
    void initialize() {
        View_and_edit_cards.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/Student_Сard");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Entering_estimates_from_the_information.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/Entering_estimates_from_the_information");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        View_debtors.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/Students_with_debts");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Transfer_to_the_course.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/for_next_course");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
