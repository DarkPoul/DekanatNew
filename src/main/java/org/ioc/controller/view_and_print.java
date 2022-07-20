package org.ioc.controller;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import org.ioc.database.DataBase;
import org.ioc.model.Table_next_course;

public class view_and_print {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Export_printing;

    @FXML
    private ChoiceBox<String> Form_education_printing;

    @FXML
    private ChoiceBox<String> Group_printing;

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

    public static String GroupID;

    @FXML
    void initialize() {
        DataBase db = new DataBase();
        ResultSet AllGroups = db.GroupName_SQL();

        ObservableList<String> Group = FXCollections.observableArrayList();
        ObservableList<String> GroupIds = FXCollections.observableArrayList();

        while (true) {
            try {
                if (!AllGroups.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String str1 = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            try {
                str1 = AllGroups.getString("NameOfGroup");
                str2 = AllGroups.getString("NumberOfCourse");
                str3 = AllGroups.getString("NumberOfGroup");
                str4 = AllGroups.getString("YearOfGroup");
                str5 = AllGroups.getString("GroupId");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Group.add(str1 + "-" + str2 + "-" + str3 + "-" + str4);
            GroupIds.add(str5);
        }
        Group_printing.setItems(Group);

        ObservableList<String> Var_Of_Sessions= FXCollections.observableArrayList("Всі","Держзамовлення", "Контракт");
        Form_education_printing.setItems(Var_Of_Sessions);
        Form_education_printing.setValue("Всі");


    }

}
