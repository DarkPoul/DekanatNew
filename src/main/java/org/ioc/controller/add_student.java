package org.ioc.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.ioc.database.DataBase;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Objects;

public class add_student {

    @FXML
    private ChoiceBox<String> Course;

    @FXML
    private DatePicker Date_of_birth;

    @FXML
    private DatePicker Date_of_issued;

    @FXML
    private ChoiceBox<String> Educational_level;

    @FXML
    private ChoiceBox<String> Enrollment_conditions;

    @FXML
    private ChoiceBox<String> Enrollment_conditions_for;

    @FXML
    private TextField First_name_eng;

    @FXML
    private TextField First_name_ukr;

    @FXML
    private ChoiceBox<String> Form_of_education;

    @FXML
    private TextField Gradebook;

    @FXML
    private ChoiceBox<String> Group_Choice;

    @FXML
    private TextField Home_address;

    @FXML
    private TextField Identify_number;

    @FXML
    private TextField Index;

    @FXML
    private ChoiceBox<String> Marital_status;

    @FXML
    private TextField Name_eng;

    @FXML
    private TextField Name_ukr;

    @FXML
    private ChoiceBox<String> Nationality;

    @FXML
    private TextField Pasport_number;

    @FXML
    private TextField Passport_series;

    @FXML
    private TextField Person_ID;

    @FXML
    private ChoiceBox<String> Professional_direction;

    @FXML
    private ChoiceBox<String> Region;

    @FXML
    private ChoiceBox<String> Sex;

    @FXML
    private TextField Surname_eng;

    @FXML
    private TextField Surname_ukr;

    @FXML
    private CheckBox Technical_school;

    @FXML
    private TextField Telephone_number;

    @FXML
    private ChoiceBox<String> Year;

    @FXML
    private Button add_student;

    @FXML
    private Text studentcard;

    @FXML
    private Tab tabank;

    public static String name_ukr;
    public static String name_eng;
    public static String sur_name_ukr;
    public static String sur_name_eng;
    public static String father_ukr;
    public static String father_eng;
    public static String sex;
    public static String marital;
    public static String date_birth;
    public static String pass_ser;
    public static String pass_nam;
    public static String pass_date;
    public static String ident;
    public static String zalik_book;
    public static String ID_FO;
    public static String nationality_student;
    public static String number_phone;
    public static String Oblast;
    public static String address;
    public static String index;
    public static String professional_direction;
    public static String course;
    public static String group;
    public static String year;
    public static String texnikum;
    public static String formStudy;
    public static String Osv_stupin;
    public static String Umov_Zarah;
    public static String cost;

    @FXML
    void initialize() {

        Sex.setItems(FXCollections.observableArrayList("Чоловіча", "Жіноча"));
        Marital_status.setItems(FXCollections.observableArrayList("Одружений", "Заміжня", "Не одружений", "Не заміжня"));
        Educational_level.setItems(FXCollections.observableArrayList("Бакалавр", "Магістр"));

        Professional_direction.setItems(FXCollections.observableArrayList("27", "28"));
        Course.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
        Group_Choice.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5"));
        int year_int = Calendar.getInstance().get(Calendar.YEAR);
        int yearOfStudy_int = Integer.parseInt(String.valueOf(year_int).substring(2));
        ObservableList<String> YearOfGroup_Var= FXCollections.observableArrayList( String.valueOf(yearOfStudy_int),
                String.valueOf(yearOfStudy_int-1),
                String.valueOf(yearOfStudy_int-2),
                String.valueOf(yearOfStudy_int-3),
                String.valueOf(yearOfStudy_int-4));


        Year.setItems(YearOfGroup_Var);
        Form_of_education.setItems(FXCollections.observableArrayList("Денна", "Заочна"));

        Enrollment_conditions.setItems(FXCollections.observableArrayList("За конкурсом", "За конкурсом без стажу", "У порядку переведення", "У порядку позаконкусного набору", "Як відмінника"));
        Enrollment_conditions_for.setItems(FXCollections.observableArrayList("Держбюджету", "Фізичної особи", "Юридичної особи"));
        Nationality.setItems(FXCollections.observableArrayList("Українець", "Іноземець"));
        //Region.setItems(FXCollections.observableArrayList("Чоловіча", "Жіноча"));




        add_student.setOnAction(actionEvent -> {
            if (!Objects.equals(Surname_ukr.getText(), "") && !Objects.equals(Name_ukr.getText(), "") && !Objects.equals(Person_ID.getText(), "")){
                name_eng = Check(Name_eng.getText());
                sur_name_eng = Check(Surname_eng.getText());
                father_eng = Check(First_name_eng.getText());

                name_ukr = Name_ukr.getText();
                sur_name_ukr = Surname_ukr.getText();
                father_ukr = First_name_ukr.getText();

                sex = Check(Sex.getValue());
                marital = Check(Marital_status.getValue());
                date_birth = Check(Date_of_birth.getEditor().getText());
                pass_ser = Check(Passport_series.getText());
                pass_nam = Check(Pasport_number.getText());
                pass_date = Check(Date_of_issued.getEditor().getText());
                ident = Check(Identify_number.getText());
                zalik_book = Check(Gradebook.getText());
                ID_FO = Check(Person_ID.getText());
                nationality_student = Check(Nationality.getValue());
                number_phone = Check(Telephone_number.getText());
                Oblast = Check(Region.getValue());
                address = Check(Home_address.getText());
                index = Check(Index.getText());
                professional_direction = Check(Professional_direction.getValue());
                course = Check(Course.getValue());
                group = Check(Group_Choice.getValue());
                texnikum = Check(Technical_school.getText());
                year = Check(Year.getValue());
                formStudy = Check(Form_of_education.getValue());
                Osv_stupin = Check(Educational_level.getValue());
                Umov_Zarah = Check(Enrollment_conditions.getValue());
                cost = Check(Enrollment_conditions_for.getValue());

                DataBase db = new DataBase();
                db.AddStudent();

            }

        });

    }

    public String Check (String temp){
        if(Objects.equals(temp, "")){
            temp = "-";
        } else if (Objects.equals(temp, null)) {
            temp = "-";
        }
        return temp;
    }

}
