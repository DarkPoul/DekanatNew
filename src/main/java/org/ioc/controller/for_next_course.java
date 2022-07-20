package org.ioc.controller;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.ioc.database.DataBase;
import org.ioc.model.Table_next_course;


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
    private ComboBox<String> Group_for_next_course;

    @FXML
    private TableView <Table_next_course> TableView_for_next_course;

    @FXML
    private TableColumn<String, Table_next_course> Lastname_for_next_course;

    @FXML
    private TableColumn<String, Table_next_course> Name_for_next_course;

    @FXML
    private TableColumn<String, Table_next_course> Surname_for_next_course;

    @FXML
    private TextField number_of_order;

    public static String GroupID;
    public static String P;
    public static String I;
    public static String B;
    public static String Order_num;
    public static String Order_date;


    @FXML
    void initialize() {
        Lastname_for_next_course.setCellValueFactory(new PropertyValueFactory<>("P"));
        Name_for_next_course.setCellValueFactory(new PropertyValueFactory<>("I"));
        Surname_for_next_course.setCellValueFactory(new PropertyValueFactory<>("B"));

        DataBase db = new DataBase();
        ResultSet AllGroups = db.GroupName_SQL();

        ObservableList<Table_next_course> Table_next_courseOL = FXCollections.observableArrayList();
        ObservableList<String> Group = FXCollections.observableArrayList();
        ObservableList<String> GroupIds = FXCollections.observableArrayList();
        ObservableList<String> Students = FXCollections.observableArrayList();
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
        Group_for_next_course.setItems(Group);
        Group_for_next_course.setVisibleRowCount(10);

        Group_for_next_course.setOnAction(actionEvent -> {
            for (int i =0; i < GroupIds.size(); i++){
                if (Objects.equals(Group_for_next_course.getValue(), Group.get(i))){
                    GroupID = GroupIds.get(i);
                    System.out.println(GroupID);
                }
            }
            ResultSet AllStudents = db.StudentsByG();
            while (true) {
                try {
                    if (!AllStudents.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    Table_next_courseOL.add(new Table_next_course(AllStudents.getString("Surname_ukr"), AllStudents.getString("FirstName_ukr"), AllStudents.getString("LastName_ukr")));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                TableView_for_next_course.setItems(Table_next_courseOL);
            }

        });
        Button_for_next_course.setOnAction(actionEvent -> {
            Order_date = Date_for_next_course.getEditor().getText();
            Order_num = number_of_order.getText();
            if (!Objects.equals(Order_date, "") && !Objects.equals(Order_num, "")){
                for (Table_next_course s: Table_next_courseOL){
                    P = s.getP();
                    I = s.getI();
                    B = s.getB();
                    System.out.println(B + " " + I + " " + P + " " + Order_num + " " +Order_date);
                }
            }
        });

    }

}

