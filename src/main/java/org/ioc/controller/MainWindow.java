package org.ioc.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.App;


public class MainWindow {


    @FXML
    private Button Registration_of_students;

    @FXML
    private Button Support_of_the_educational_process;

    @FXML
    private Button Making_changes_and_transferring_to_the_course;

    @FXML
    private Button View_and_print_information;

    @FXML
    private Button Visiting;

    @FXML
    private Button Modular_control;

    @FXML
    private Button Directory;

    @FXML
    private Label Dekanat_name;

    @FXML
    private Button Info;

    @FXML
    private AnchorPane MainWindow_anchor;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }



    @FXML
    void initialize() {
//        Dekanat_name.setText(Controller_authentication.Name_dekanat);

        Info.setOnAction(ActionEvent -> {

            try {
                App.setRoot("gui/about_developers");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
//
        Directory.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/Directory");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
//
        Making_changes_and_transferring_to_the_course.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/Making_changes_and_transferring_to_the_course");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
//
        Registration_of_students.setOnAction(actionEvent -> {
            try {
                App.setRoot("gui/Registration_of_enrolled_students");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });
//
        Support_of_the_educational_process.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/EduProcessCuration");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        Modular_control.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/Modular_results_preview");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        View_and_print_information.setOnAction(ActionEvent -> {
            try {
                App.setRoot("gui/view_and_print");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
