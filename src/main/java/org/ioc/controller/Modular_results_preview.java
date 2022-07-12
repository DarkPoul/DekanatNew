package org.ioc.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;

public class Modular_results_preview {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> choose_control_type;

    @FXML
    private ChoiceBox<?> choose_faculty;

    @FXML
    private ChoiceBox<?> choose_group;

    @FXML
    private Spinner<?> choose_semester;

    @FXML
    private Button consolidated_table;

    @FXML
    private Button departments;

    @FXML
    private Button exit;

    @FXML
    private Button faculties;

    @FXML
    private Button general_table_button;

    @FXML
    private Button not_inputed_data;

    @FXML
    private Button schedule;

    @FXML
    private Button students_with_unsatisfying_results;

    @FXML
    private Button table;

    @FXML
    void initialize() {
        assert choose_control_type != null : "fx:id=\"choose_control_type\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert choose_faculty != null : "fx:id=\"choose_faculty\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert choose_group != null : "fx:id=\"choose_group\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert choose_semester != null : "fx:id=\"choose_semester\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert consolidated_table != null : "fx:id=\"consolidated_table\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert departments != null : "fx:id=\"departments\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert faculties != null : "fx:id=\"faculties\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert general_table_button != null : "fx:id=\"general_table_button\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert not_inputed_data != null : "fx:id=\"not_inputed_data\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert schedule != null : "fx:id=\"schedule\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert students_with_unsatisfying_results != null : "fx:id=\"students_with_unsatisfying_results\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'module_results_preview.fxml'.";

    }

}
