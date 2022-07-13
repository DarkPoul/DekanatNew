package org.ioc.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class for_next_course {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button_for_next_course;

    @FXML
    private DatePicker Date_for_next_course;

    @FXML
    private Button Debtors;

    @FXML
    private ChoiceBox<?> Group_for_next_course;

    @FXML
    private TableColumn<?, ?> Lastname_for_next_course;

    @FXML
    private TableColumn<?, ?> Name_for_next_course;

    @FXML
    private TableColumn<?, ?> Surname_for_next_course;

    @FXML
    private TextField number_of_order;

    @FXML
    void initialize() {
        assert Button_for_next_course != null : "fx:id=\"Button_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Date_for_next_course != null : "fx:id=\"Date_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Debtors != null : "fx:id=\"Debtors\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Group_for_next_course != null : "fx:id=\"Group_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Lastname_for_next_course != null : "fx:id=\"Lastname_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Name_for_next_course != null : "fx:id=\"Name_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Surname_for_next_course != null : "fx:id=\"Surname_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert number_of_order != null : "fx:id=\"number_of_order\" was not injected: check your FXML file 'for_next_course.fxml'.";

    }

}

