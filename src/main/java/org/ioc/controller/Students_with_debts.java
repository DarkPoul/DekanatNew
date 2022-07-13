package org.ioc.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class Students_with_debts {

    @FXML
    private ChoiceBox<?> choose_course;

    @FXML
    private ChoiceBox<?> choose_faculty;

    @FXML
    private ChoiceBox<?> choose_group;

    @FXML
    private ChoiceBox<?> choose_group_number;

    @FXML
    private TableColumn<?, ?> column_fatherName;

    @FXML
    private TableColumn<?, ?> column_name;

    @FXML
    private TableColumn<?, ?> column_surName;

    @FXML
    private TableColumn<?, ?> column_year;

    @FXML
    private Label number_of_debts;

    @FXML
    private Label students_with_debts;

    @FXML
    private TableColumn<?, ?> table_reasons;

    @FXML
    void initialize() {
        assert choose_course != null : "fx:id=\"choose_course\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert choose_faculty != null : "fx:id=\"choose_faculty\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert choose_group != null : "fx:id=\"choose_group\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert choose_group_number != null : "fx:id=\"choose_group_number\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_fatherName != null : "fx:id=\"column_fatherName\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_name != null : "fx:id=\"column_name\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_surName != null : "fx:id=\"column_surName\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_year != null : "fx:id=\"column_year\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert number_of_debts != null : "fx:id=\"number_of_debts\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert students_with_debts != null : "fx:id=\"students_with_debts\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert table_reasons != null : "fx:id=\"table_reasons\" was not injected: check your FXML file 'Students_with_debts.fxml'.";

    }

}
