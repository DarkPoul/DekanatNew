package org.ioc.controller;
import javafx.collections.FXCollections;
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
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Student_Card {

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
    private TextField Nationality;

    @FXML
    private Button Next_student;

    @FXML
    private TextField Pasport_number;

    @FXML
    private TextField Passport_series;

    @FXML
    private TextField Person_ID;

    @FXML
    private Button Prev_student;


    @FXML
    private ChoiceBox<String> Professional_direction;


    @FXML
    private ChoiceBox<String> Region;

    @FXML
    private ChoiceBox<String> Sex;

    @FXML
    private TextField Social_situation;

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
    private ChoiceBox<String> group_ChoiceBox;

    @FXML
    private ChoiceBox<String> student_ChoiceBox;

    @FXML
    private Text studentcard;

    @FXML
    private Tab tabank;

    public static String[] GroupName;
    public static String GroupID;
    public static String ID_Student;

    public static String GroupID_SQL;

    public static List<String> Student = new LinkedList<>();
    public static List<String> StudentFull = new LinkedList<>();


    @FXML
    void initialize() {

        DataBase DB = new DataBase();
        ResultSet NameGroup = DB.GroupName_SQL();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> Group = new LinkedList<>();
        List<String> GroupNameList = new LinkedList<>();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        while (true) {
            try {
                if (!NameGroup.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String str1 = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            try {
                str1 = NameGroup.getString("NameOfGroup");
                str2 = NameGroup.getString("NumberOfCourse");
                str3 = NameGroup.getString("NumberOfGroup");
                str4 = NameGroup.getString("YearOfGroup");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Group.add(str1 +"-"+ str2 +"-"+ str3 +"-"+ str4);
            GroupNameList.add(str1);
        }
        group_ChoiceBox.setItems(FXCollections.observableArrayList(Group));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        group_ChoiceBox.setOnMouseClicked(MouseClicked -> {
            ClearText();
        });



        group_ChoiceBox.setOnAction(actionEvent -> {
            ClearText();
            Student.clear();
            StudentFull.clear();
            ////////////////////////////////////////////////////////////////////////////////////
            GroupName = group_ChoiceBox.getValue().split("-");
            ResultSet IDGroup = DB.Group_ID_StudentCard();

            while (true) {
                try {
                    if (!IDGroup.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    GroupID = IDGroup.getString("GroupId");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                /////////////////////////////////////////////////////////////////////////////////////////////

            }

            ResultSet Students = DB.StudentsPIB_2();

            while (true) {
                try {
                    if (!Students.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String str1 = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                try {
                    str1 = Students.getString("LastName_ukr");
                    str2 = Students.getString("FirstName_ukr");
                    str3 = Students.getString("Surname_ukr");
                    str4 = Students.getString("IdFO");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                assert str2 != null;
                assert str3 != null;
                Student.add(str1+" "+str2.charAt(0)+"."+str3.charAt(0) + ".");
                StudentFull.add(str1+" "+str2.charAt(0)+"."+str3.charAt(0) + "." + "-" + str4);


                /////////////////////////////////////////////////////////////////////////////////////////////
            }

            student_ChoiceBox.setItems(FXCollections.observableArrayList(Student));
        });




        student_ChoiceBox.setOnAction(actionEvent -> {
            int n = 0;
            Technical_school.setSelected(false);
            for (String s : Student){
                if (Objects.equals(s, student_ChoiceBox.getValue())) {
                    ID_Student = StudentFull.get(n).split("-")[1];
                }
                n++;
            }
            ////////////////////////////////////////////////

            ResultSet StudentInfo_RS = DB.StudentsINFO();

            List<String> InfoStudent = new LinkedList<>();

            while (true) {
                try {
                    if (!StudentInfo_RS.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String str1 = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                String str12 = null;
                String str13 = null;
                String str14 = null;
                String str15 = null;
                String str16 = null;
                String str17 = null;
                String str18 = null;
                try {
                    str1 = StudentInfo_RS.getString("LastName_ukr");
                    str2 = StudentInfo_RS.getString("FirstName_ukr");
                    str3 = StudentInfo_RS.getString("Surname_ukr");
                    str4 = StudentInfo_RS.getString("LastName_eng");
                    str5 = StudentInfo_RS.getString("FirstName_eng");
                    str6 = StudentInfo_RS.getString("Surname_eng");
                    str7 = StudentInfo_RS.getString("StudentBook");
                    str8 = StudentInfo_RS.getString("IdentificationCode");
                    str9 = StudentInfo_RS.getString("SeriesOfPassport");
                    str10 = StudentInfo_RS.getString("NumberOfPassport");
                    str11 = StudentInfo_RS.getString("DateOfBirth");
                    str12 = StudentInfo_RS.getString("IssuanceDateOfPassport");
                    str13 = StudentInfo_RS.getString("IdFO");
                    str14 = StudentInfo_RS.getString("Sex");
                    str15 = StudentInfo_RS.getString("UkrainianCitizenship");
                    str16 = StudentInfo_RS.getString("MaritalStatus");
                    str17 = StudentInfo_RS.getString("ObtainingDegree");
                    str18 = StudentInfo_RS.getString("FormOfTraining");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                InfoStudent.add(str1 + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + str6 + "|" + str7 + "|" + str8 + "|" + str9 + "|" + str10 + "|" + str11
                        + "|" + str12 + "|" + str13 + "|" + str14 + "|" + str15 + "|" + str16 + "|" + str17 + "|" + str18);
                System.out.println(InfoStudent.get(0));
                Sex.setItems(FXCollections.observableArrayList("Жіноча", "Чоловіча"));
                Marital_status.setItems(FXCollections.observableArrayList("Одружений", "Заміжня", "Не одружений", "Не заміжня"));
                Educational_level.setItems(FXCollections.observableArrayList("Бакалавр", "Магістр"));
                Surname_ukr.setText(InfoStudent.get(0).split("\\|")[0]);
                Name_ukr.setText(InfoStudent.get(0).split("\\|")[1]);
                First_name_ukr.setText(InfoStudent.get(0).split("\\|")[2]);
                Surname_eng.setText(InfoStudent.get(0).split("\\|")[3]);
                Name_eng.setText(InfoStudent.get(0).split("\\|")[4]);
                First_name_eng.setText(InfoStudent.get(0).split("\\|")[5]);
                Gradebook.setText(InfoStudent.get(0).split("\\|")[6]);
                Identify_number.setText(InfoStudent.get(0).split("\\|")[7]);
                Passport_series.setText(InfoStudent.get(0).split("\\|")[8]);
                Pasport_number.setText(InfoStudent.get(0).split("\\|")[9]);
                Date_of_birth.getEditor().setText(InfoStudent.get(0).split("\\|")[10]);
                Date_of_issued.getEditor().setText(InfoStudent.get(0).split("\\|")[11]);
                Person_ID.setText(InfoStudent.get(0).split("\\|")[12]);
                Sex.setValue(InfoStudent.get(0).split("\\|")[13]);

                if (Objects.equals(InfoStudent.get(0).split("\\|")[14], "true") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Чоловіча")){
                    Nationality.setText("Українець");
                } else if (Objects.equals(InfoStudent.get(0).split("\\|")[14], "true") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Жіноча")) {
                    Nationality.setText("Українка");
                } else if (Objects.equals(InfoStudent.get(0).split("\\|")[14], "false") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Чоловіча")) {
                    Nationality.setText("Іноземець");
                } else if (Objects.equals(InfoStudent.get(0).split("\\|")[14], "false") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Жіноча")) {
                    Nationality.setText("Іноземка");
                }

                if (Objects.equals(InfoStudent.get(0).split("\\|")[15], "true") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Чоловіча")){
                    Marital_status.setValue("Одружений");
                } else if (Objects.equals(InfoStudent.get(0).split("\\|")[15], "true") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Жіноча")) {
                    Marital_status.setValue("Заміжня");
                } else if (Objects.equals(InfoStudent.get(0).split("\\|")[15], "false") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Чоловіча")) {
                    Marital_status.setValue("Не одружений");
                } else if (Objects.equals(InfoStudent.get(0).split("\\|")[15], "false") && Objects.equals(InfoStudent.get(0).split("\\|")[13], "Жіноча")) {
                    Marital_status.setValue("Не заміжня");
                }

                Educational_level.setValue(InfoStudent.get(0).split("\\|")[16]);
                //GroupID_SQL = InfoStudent.get(0).split("\\|")[17];
                Professional_direction.setItems(FXCollections.observableArrayList(GroupNameList));
                Professional_direction.setValue(group_ChoiceBox.getValue().split("-")[0]);
                Course.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
                Course.setValue(group_ChoiceBox.getValue().split("-")[1]);
                Group_Choice.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5"));
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int yearOfStudy = Integer.parseInt(String.valueOf(year).substring(2));
                Group_Choice.setValue(group_ChoiceBox.getValue().split("-")[2]);
                Year.setItems(FXCollections.observableArrayList( String.valueOf(yearOfStudy),
                        String.valueOf(yearOfStudy-1),
                        String.valueOf(yearOfStudy-2),
                        String.valueOf(yearOfStudy-3),
                        String.valueOf(yearOfStudy-4)));
                Year.setValue(group_ChoiceBox.getValue().split("-")[3]);
                Form_of_education.setItems(FXCollections.observableArrayList("Денна", "Заочна"));
                Form_of_education.setValue(InfoStudent.get(0).split("\\|")[17]);

                for (int temp = 0; temp<group_ChoiceBox.getValue().split("-")[0].length(); temp ++) {
                    if (group_ChoiceBox.getValue().split("-")[0].charAt(temp) == 'т') {
                        Technical_school.setSelected(true);
                    }
                }


                /////////////////////////////////////////////////////////////////////////////////////////////
            }


        });
    }

    public void ClearText(){
        Surname_ukr.setText("");
        Surname_eng.clear();
        Name_ukr.clear();
        Name_eng.clear();
        First_name_ukr.clear();
        First_name_eng.clear();
        Sex.setValue(null);
        Marital_status.setValue(null);
        Date_of_birth.getEditor().clear();
        Passport_series.clear();
        Pasport_number.clear();
        Date_of_issued.getEditor().clear();
        Identify_number.clear();
        Gradebook.clear();
        Person_ID.clear();
        Nationality.clear();
        Telephone_number.clear();
        Region.setValue(null);
        Home_address.clear();
        Index.clear();
        Professional_direction.setValue(null);
        Course.setValue(null);
        Group_Choice.setValue(null);
        Technical_school.setSelected(false);
        Year.setValue(null);
        Form_of_education.setValue(null);
        Educational_level.setValue(null);
        Enrollment_conditions.setValue(null);
        Enrollment_conditions_for.setValue(null);
        student_ChoiceBox.setValue(null);
    }
}
