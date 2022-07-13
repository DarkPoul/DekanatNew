package org.ioc.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.ioc.database.DataBase;
import org.ioc.model.Group_Name;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Entering_estimates_from_the_information {

    @FXML
    private TableView<?> TableView_EnteringMark;

    @FXML
    private TableColumn<?, ?> column_ECTS;

    @FXML
    private TableColumn<?, ?> column_RGR;

    @FXML
    private TableColumn<?, ?> column_date;

    @FXML
    private TableColumn<?, ?> column_full_name;

    @FXML
    private TableColumn<?, ?> column_statment;

    @FXML
    private ComboBox<String> TypeOfControl;

    @FXML
    private Button assign_date_to_all;

    @FXML
    private Button assign_number_to_all;

    @FXML
    private Button convert_to_ECTS;

    @FXML
    private Button save_grades;

    @FXML
    private DatePicker choose_date;

    @FXML
    private ComboBox<String> choose_discipline;

    @FXML
    private ComboBox<String> choose_group;

    @FXML
    private ComboBox<String> choose_semester;

    @FXML
    private TextField statment_number_textfield;

    String DiscID;

    @FXML
    void initialize() {
        ObservableList<Group_Name> GroupName_OL = FXCollections.observableArrayList();
        DataBase DB = new DataBase();
        ResultSet group_name_rs = DB.GroupName_SQL();

        while (true) {
            try {
                if (!group_name_rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                GroupName_OL.add(new Group_Name(group_name_rs.getString("NameOfGroup"), group_name_rs.getString("NumberOfCourse"), group_name_rs.getString("NumberOfGroup"), group_name_rs.getString("YearOfGroup"), group_name_rs.getString("GroupId")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        List<String> Group_list = FXCollections.observableArrayList();

        for (Group_Name s : GroupName_OL){
            Group_list.add(s.getName() + "-" + s.getCourse() + "-" + s.getNumberGroup() + "-" + s.getYear());
        }

        choose_semester.setItems(FXCollections.observableArrayList("Літня", "Зимова"));
        choose_group.setItems(FXCollections.observableArrayList(Group_list));









        choose_group.setOnAction(actionEvent -> {
            //DiscID = Disc_OL.get(DiscName.indexOf(choose_discipline.getValue()));
            //ResultSet EnterMark_RS = DB.EnteringMark();

            ObservableList<String> TypeControl = FXCollections.observableArrayList();
            ObservableList<String> TypeControl_for_model = FXCollections.observableArrayList();
        });
        choose_semester.setOnAction(actionEvent -> {

        });
        choose_discipline.setOnAction(actionEvent -> {

        });
        TypeOfControl.setOnAction(actionEvent -> {

        });
        assign_date_to_all.setOnAction(actionEvent -> {

        });
        assign_number_to_all.setOnAction(actionEvent -> {

        });
        convert_to_ECTS.setOnAction(actionEvent -> {

        });
        save_grades.setOnAction(actionEvent -> {

        });
    }

}
