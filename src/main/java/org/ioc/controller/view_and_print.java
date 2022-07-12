package org.ioc.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;

public class view_and_print {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Export_printing;

    @FXML
    private ChoiceBox<?> Form_education_printing;

    @FXML
    private ChoiceBox<?> Group_printing;

    @FXML
    private ChoiceBox<?> Level_studing;

    @FXML
    private TableColumn<?, ?> Name_printing;

    @FXML
    private Button Rating_printing;

    @FXML
    private TableColumn<?, ?> Secondname_printing;

    @FXML
    private TableColumn<?, ?> Surname_printing;

    @FXML
    private Button To_exel;

    @FXML
    private Button journal_printing;

    @FXML
    private TableColumn<?, ?> rating_paper_printing;

    @FXML
    private Button scholarship_printing;

    @FXML
    void initialize() {
        assert Export_printing != null : "fx:id=\"Export_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Form_education_printing != null : "fx:id=\"Form_education_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Group_printing != null : "fx:id=\"Group_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Level_studing != null : "fx:id=\"Level_studing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Name_printing != null : "fx:id=\"Name_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Rating_printing != null : "fx:id=\"Rating_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Secondname_printing != null : "fx:id=\"Secondname_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Surname_printing != null : "fx:id=\"Surname_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert To_exel != null : "fx:id=\"To_exel\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert journal_printing != null : "fx:id=\"journal_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert rating_paper_printing != null : "fx:id=\"rating_paper_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert scholarship_printing != null : "fx:id=\"scholarship_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";

    }

}
