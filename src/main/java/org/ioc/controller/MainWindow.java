package org.ioc.controller;

//import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainWindow {


//    @FXML
//    private Button Registration_of_students;
//
//    @FXML
//    private Button Support_of_the_educational_process;
//
//    @FXML
//    private Button Making_changes_and_transferring_to_the_course;
//
//    @FXML
//    private Button View_and_print_information;
//
//    @FXML
//    private Button Visiting;
//
//    @FXML
//    private Button Modular_control;
//
//    @FXML
//    private Button Directory;
//
//    @FXML
//    private Label Dekanat_name;
//
//    @FXML
//    private Button Info;
//
//    @FXML
//    private AnchorPane MainWindow_anchor;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }



    @FXML
    void initialize() {
//        Dekanat_name.setText(Controller_authentication.Name_dekanat);

//        Info.setOnAction(ActionEvent -> {
//            Stage Info = new Stage();
//            Info.setTitle("Про розробників");
//
//        });
//
//        Directory.setOnAction(ActionEvent -> {
//            Stage Directory = new Stage();
//            Directory.setTitle("Довідник");
//
//        });
//
//        Making_changes_and_transferring_to_the_course.setOnAction(ActionEvent -> {
//            Stage Directory = new Stage();
//            Directory.setTitle("Внесення змін та переведення на курс");
//
//        });
//
//        Registration_of_students.setOnAction(actionEvent -> {
//            Stage Directory = new Stage();
//            Directory.setTitle("Реєстрація зарахованих студентів");
//
//        });
//
//        Support_of_the_educational_process.setOnAction(ActionEvent -> {
//            Stage Directory = new Stage();
//            Directory.setTitle("Cупровід навчального процессу");
//
//        });
//
//        Modular_control.setOnAction(ActionEvent -> {
//            Stage Directory = new Stage();
//            Directory.setTitle("Перегляд результатів модульного контролю");
//
//        });
//
//        View_and_print_information.setOnAction(ActionEvent -> {
//            Stage Directory = new Stage();
//            Directory.setTitle("Перегляд та друк інформації");
//
//        });
    }
}
