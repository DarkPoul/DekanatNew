package org.ioc.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ioc.App;
import org.ioc.database.DataBase;
import org.ioc.model.Table_Edu_Advanced_Disc;
import org.ioc.model.Table_Edu_Advanced_Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EduProcess_Advanced_Add {

    @FXML
    private TableView<Table_Edu_Advanced_Disc> ListOfDisc_Advanced;

    @FXML
    private TableColumn<Table_Edu_Advanced_Disc, CheckBox> TableColumn_CheckBox_Disc;

    @FXML
    private TableColumn<Table_Edu_Advanced_Disc, String> TableColumn_ListOfDisc;

    @FXML
    private TableView<Table_Edu_Advanced_Student> ListOfStudent_Advanced;

    @FXML
    private TableColumn<Table_Edu_Advanced_Student, CheckBox> TableColumn_CheckBox_Student;

    @FXML
    private TableColumn<Table_Edu_Advanced_Student, String> TableColumn_ListOfStudent;

    @FXML
    private Button Button_SelectAllDisc;

    @FXML
    private Button Button_SelectAllStudent;

    private static boolean temp = false;
    private static boolean temp2 = false;

    @FXML
    void initialize() {


        TableColumn_CheckBox_Student.setCellValueFactory(new PropertyValueFactory<>("Student_Check"));
        TableColumn_ListOfStudent.setCellValueFactory(new PropertyValueFactory<>("Student_String"));

        TableColumn_CheckBox_Disc.setCellValueFactory(new PropertyValueFactory<>("Disc_CheckBox"));
        TableColumn_ListOfDisc.setCellValueFactory(new PropertyValueFactory<>("Disc_String"));


        DataBase DB = new DataBase();
        ResultSet PIB_Students_RS = DB.StudentsPIB();
        ObservableList<Table_Edu_Advanced_Student> Student = FXCollections.observableArrayList();

        String P_Student_Short;
        String I_Student_Short;
        String B_Student_Short;
        String PIB;

        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних

            try {
                if (!PIB_Students_RS.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                P_Student_Short = PIB_Students_RS.getString("LastName_ukr");
                I_Student_Short = PIB_Students_RS.getString("FirstName_ukr").substring(0,1);
                B_Student_Short = PIB_Students_RS.getString("Surname_ukr").substring(0,1);
                PIB = P_Student_Short + " " + I_Student_Short + "." + B_Student_Short + ".";
                Student.add(new Table_Edu_Advanced_Student(PIB));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ObservableList<Table_Edu_Advanced_Disc> Disc = FXCollections.observableArrayList();
            Disc.clear();
            for (int n = 0; EduProcessCuration.Discipline_for_Edu.size() > n; n++){
                Disc.add(new Table_Edu_Advanced_Disc(EduProcessCuration.Discipline_for_Edu.get(n)));
            }

            ListOfStudent_Advanced.setItems(Student);
            ListOfDisc_Advanced.setItems(Disc);

            Button_SelectAllStudent.setOnAction(ActiveEvent -> {
                if (!temp){
                    for (Table_Edu_Advanced_Student s :Student){
                        s.getStudent_Check().setSelected(true);
                    }
                    Button_SelectAllStudent.setText("Зняти з усіх студентів");
                    temp = true;
                } else {
                    for (Table_Edu_Advanced_Student s :Student){
                        s.getStudent_Check().setSelected(false);
                    }
                    Button_SelectAllStudent.setText("Вибрати всіх студентів");
                    temp = false;
                }
            });
            Button_SelectAllDisc.setOnAction(ActiveEvent -> {
                if (!temp2){
                    for (Table_Edu_Advanced_Disc s :Disc){
                        s.getDisc_CheckBox().setSelected(true);
                    }
                    Button_SelectAllDisc.setText("Зняти усі дисципліни");
                    temp2 = true;
                } else {
                    for (Table_Edu_Advanced_Disc s :Disc){
                        s.getDisc_CheckBox().setSelected(false);
                    }
                    Button_SelectAllDisc.setText("Вибрати всі дисципліни");
                    temp2 = false;
                }
            });
        }
    }

    public void divers() throws IOException {
        App.setRoot("gui/EduProcessCuration");
    }
}

