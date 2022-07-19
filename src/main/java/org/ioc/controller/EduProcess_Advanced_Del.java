package org.ioc.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ioc.App;
import org.ioc.database.DataBase;
import org.ioc.model.Table_Edu;
import org.ioc.model.Table_Edu_Advanced_Disc;
import org.ioc.model.Table_Edu_Advanced_Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.ioc.controller.EduProcessCuration.*;


public class EduProcess_Advanced_Del {


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

    public static String P = "";
    public static String I = "";
    public static String B = "";

    public static String ID_FO;
    public static String ID_Disc;
    public static String ID_Sem;

    @FXML
    void initialize() throws SQLException {


        TableColumn_CheckBox_Student.setCellValueFactory(new PropertyValueFactory<>("Student_Check"));
        TableColumn_ListOfStudent.setCellValueFactory(new PropertyValueFactory<>("Student_String"));

        TableColumn_CheckBox_Disc.setCellValueFactory(new PropertyValueFactory<>("Disc_CheckBox"));
        TableColumn_ListOfDisc.setCellValueFactory(new PropertyValueFactory<>("Disc_String"));


        DataBase DB = new DataBase();
        ResultSet PIB_Students_RS = DB.StudentsPIB();
        ObservableList<Table_Edu_Advanced_Student> Student = FXCollections.observableArrayList();

        String PIB;

        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних

            try {
                if (!PIB_Students_RS.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                PIB = PIB_Students_RS.getString("LastName_ukr") + " " + PIB_Students_RS.getString("FirstName_ukr") + " " + PIB_Students_RS.getString("Surname_ukr");
                Student.add(new Table_Edu_Advanced_Student(PIB));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ObservableList<Table_Edu_Advanced_Disc> Disc = FXCollections.observableArrayList();
            for (int n = 0; EduProcessCuration.Discipline_for_Edu.size() > n; n++) {
                Disc.add(new Table_Edu_Advanced_Disc(EduProcessCuration.Discipline_for_Edu.get(n)));
            }

            ListOfStudent_Advanced.setItems(Student);
            ListOfDisc_Advanced.setItems(Disc);


            Button_SelectAllStudent.setOnAction(ActiveEvent -> {
                if (!temp) {
                    for (Table_Edu_Advanced_Student s : Student) {
                        s.getStudent_Check().setSelected(true);
                    }
                    Button_SelectAllStudent.setText("Зняти з усіх студентів");
                    temp = true;
                } else {
                    for (Table_Edu_Advanced_Student s : Student) {
                        s.getStudent_Check().setSelected(false);
                    }
                    Button_SelectAllStudent.setText("Вибрати всіх студентів");
                    temp = false;
                }

            });
            Button_SelectAllDisc.setOnAction(ActiveEvent -> {
                if (!temp2) {
                    for (Table_Edu_Advanced_Disc s : Disc) {
                        s.getDisc_CheckBox().setSelected(true);
                    }
                    Button_SelectAllDisc.setText("Зняти усі дисципліни");
                    temp2 = true;
                } else {
                    for (Table_Edu_Advanced_Disc s : Disc) {
                        s.getDisc_CheckBox().setSelected(false);
                    }
                    Button_SelectAllDisc.setText("Вибрати всі дисципліни");
                    temp2 = false;
                }
            });
        }
    }

    public void divers() throws IOException, SQLException {
        System.out.println(NumberOfSession);
        System.out.println(GroupID);

        App.setRoot("gui/EduProcessCuration");
        ObservableList<String> Student = FXCollections.observableArrayList();
        DataBase db = new DataBase();
        ResultSet PIB_Students_RS = db.StudentsPIB();
        String PIB;
        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних

            try {
                if (!PIB_Students_RS.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                PIB = PIB_Students_RS.getString("LastName_ukr") + " " + PIB_Students_RS.getString("FirstName_ukr") + " " + PIB_Students_RS.getString("Surname_ukr");
                if (!Student.contains(PIB)) {
                    Student.add(PIB);
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        ObservableList<Table_Edu_Advanced_Student> ID = FXCollections.observableArrayList();
        for (String student : Student) {
            P = student.split(" ")[0];
            I = student.split(" ")[1];
            B = student.split(" ")[2];


            String id_fo;
            ResultSet id_fo_rs = db.StudentID();
            while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних

                try {
                    if (!id_fo_rs.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    id_fo = id_fo_rs.getString("IdFO");
                    ID.add(new Table_Edu_Advanced_Student(id_fo));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        ObservableList<Table_Edu_Advanced_Disc> Disc = ListOfDisc_Advanced.getItems();
        List<String> DiscIdForSql = new LinkedList<>();
        for (Table_Edu_Advanced_Disc s : Disc) {
            if (s.getDisc_CheckBox().isSelected()){
                NameOfDisc_SQL = s.getDisc_String();
                ResultSet IdOfDisc = db.DiscID();
                try {
                    if (!IdOfDisc.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String str11 = null;
                try {
                    str11 = IdOfDisc.getString("DisciplineId");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DiscIdForSql.add(str11);
                System.out.println(str11);
            }
        }

        for (Table_Edu_Advanced_Student student : ID){
            System.out.println(student.getStudent_Check().isSelected());
            if (student.getStudent_Check().isSelected()){
                ID_FO = student.getStudent_String();
                ID_Sem =NumberOfSession;
                System.out.println("ggg");
                for (String s : DiscIdForSql) {
                    ID_Disc = s;
                    //db.InsertIntoTable();
                    //db.DeleteIntoTable();
                    System.out.println("True");
                }
            }
        }
    }
}

