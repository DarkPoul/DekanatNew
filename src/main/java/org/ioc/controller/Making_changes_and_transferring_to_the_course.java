package org.ioc.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
            Stage Info = new Stage();
            Info.setTitle("Перегляд та правка карток");
            Info.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Student_Сard.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 1024, 768);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Info.setScene(scene);
            Info.showAndWait();
        });

        Entering_estimates_from_the_information.setOnAction(ActionEvent -> {
            Stage Info = new Stage();
            Info.setTitle("Введення оцінок з відомості");
            Info.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Entering_estimates_from_the_information.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 1024, 768);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Info.setScene(scene);
            Info.showAndWait();
        });

        View_debtors.setOnAction(ActionEvent -> {
            Stage Info = new Stage();
            Info.setTitle("Перегляд боржників");
            Info.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Students_with_debts.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 1024, 768);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Info.setScene(scene);
            Info.showAndWait();
        });

        Transfer_to_the_course.setOnAction(ActionEvent -> {
            Stage Info = new Stage();
            Info.setTitle("Переведення на наступний курс");
            Info.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("for_next_course.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 600, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Info.setScene(scene);
            Info.showAndWait();
        });
    }

}
