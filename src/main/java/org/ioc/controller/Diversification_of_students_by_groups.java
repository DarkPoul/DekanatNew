package org.ioc.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.database.DataBase;
import org.ioc.model.Table_Bring_Student;

public class Diversification_of_students_by_groups {

    @FXML
    private Button Search_student;

    @FXML
    private TableView <Table_Bring_Student> Student_Table;

    @FXML
    private TableColumn<Table_Bring_Student, String> Individual_ID;

    @FXML
    private TableColumn<Table_Bring_Student, String> Lastname_of_Student;

    @FXML
    private TableColumn<Table_Bring_Student, String> Name_of_Student;

    @FXML
    private TableColumn<Table_Bring_Student, String> Surname_of_Student;

    @FXML
    private TableColumn<Table_Bring_Student, String> CheckBoxForStudent;

    @FXML
    private ChoiceBox<String> Name_of_Group;

    @FXML
    private ChoiceBox<String> Spec_ID_Name;

    @FXML
    private ChoiceBox<String> Year_of_entry;

    @FXML
    private ChoiceBox<String> degree_panel;

    @FXML
    private ChoiceBox<String> FormOfStudy;

    @FXML
    private Button GroupToStudent_to_DB;

    public static String ID_FO_ForSql;

    public Boolean Spec_ID_Name_Bool;
    public Boolean Year_of_entry_Bool;
    public Boolean degree_panel_Bool;
    public Boolean FormOfStudy_Bool;

    public static String Spec_ID_Name_SQL;
    public static String Year_of_entry_SQL;
    public static String degree_panel_SQL;
    public static String FormOfStudy_SQL;

    public static String NameGroup_SQL;
    public static String YearGroup_SQL;
    public static String NumberCourse_SQL;
    public static String NumberGroup_SQL;
    public static String GroupID;

    public static ObservableList<Table_Bring_Student> BringStudent;

    @FXML
    void initialize() {
        ObservableList<String> FormStudy_Var= FXCollections.observableArrayList("Денна", "Заочна"); ////Добавить
        FormOfStudy.setItems(FormStudy_Var);

        DataBase NameOfSpec = new DataBase();
        ResultSet ID_Of_group = NameOfSpec.SpecialityOfFaculty();
        List<String> NameOfGroup = new LinkedList<>();
        List<String> ID_Of_Group = new LinkedList<>();
        while (true) {
            try {
                if (!ID_Of_group.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String str1 = null;
            String str2 = null;
            try {
                str1 = ID_Of_group.getString("NameOfSpeciality");
                str2 = ID_Of_group.getString("SpecialityId");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            NameOfGroup.add(str1);
            ID_Of_Group.add(str2);
            System.out.println(str1);
            System.out.println(str2);
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int yearOfStudy = Integer.parseInt(String.valueOf(year));
        ObservableList<String> YearOfGroup_Var= FXCollections.observableArrayList( String.valueOf(yearOfStudy),
                String.valueOf(yearOfStudy-1),
                String.valueOf(yearOfStudy-2),
                String.valueOf(yearOfStudy-3),
                String.valueOf(yearOfStudy-4));

        Year_of_entry.setItems(YearOfGroup_Var);

        ObservableList<String> SpecialityName = FXCollections.observableList(NameOfGroup);
        Spec_ID_Name.setItems(SpecialityName);

        ObservableList<String> GroupName= FXCollections.observableList(NameOfGroup);
        Name_of_Group.setItems(GroupName);

        DataBase GroupIdentification = new DataBase();
        ResultSet Group_Identification = GroupIdentification.GroupName_SQL();
        List<String> GroupIdentification_List = new LinkedList<>();
        while (true) {
            try {
                if (!Group_Identification.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String str1 = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            try {
                str1 = Group_Identification.getString("NameOfGroup");
                str2 = Group_Identification.getString("NumberOfCourse");
                str3 = Group_Identification.getString("NumberOfGroup");
                str4 = Group_Identification.getString("YearOfGroup");


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            GroupIdentification_List.add(str1 + "-" + str2 + "-" + str3 + "-" + str4);
            System.out.println(str1);
        }

        ObservableList<String> GroupIdentification_Ob_List= FXCollections.observableList(GroupIdentification_List);
        Name_of_Group.setItems(GroupIdentification_Ob_List);

        ObservableList<String> Degree_Var= FXCollections.observableArrayList("Бакалавр", "Магістр"); ////Добавить
        degree_panel.setItems(Degree_Var);

        Search_student.setOnAction(actionEvent -> {
            if (degree_panel.getValue().length() > 1){
                degree_panel_Bool = true;
            }
            if (FormOfStudy.getValue().length() > 1){
                FormOfStudy_Bool = true;
            }
            if (Spec_ID_Name.getValue().length() > 1){
                Spec_ID_Name_Bool = true;
            }
            if (Year_of_entry.getValue().length() > 1){
                Year_of_entry_Bool = true;
            }

            if (degree_panel_Bool && FormOfStudy_Bool && Spec_ID_Name_Bool && Year_of_entry_Bool){
                degree_panel_SQL = degree_panel.getValue();
                FormOfStudy_SQL = FormOfStudy.getValue();
                for (int i = 0; i < NameOfGroup.size(); i++){
                    if (Objects.equals(Spec_ID_Name.getValue(), NameOfGroup.get(i))){
                        Spec_ID_Name_SQL = ID_Of_Group.get(i);
                    }
                }

                Year_of_entry_SQL = Year_of_entry.getValue();
                System.out.println(degree_panel_SQL+FormOfStudy_SQL+Spec_ID_Name_SQL+Year_of_entry_SQL);

                DataBase dataBaseHandler = new DataBase();//Створюємо нову змінну на основі створеного нами класу
                ResultSet SelectGroup = dataBaseHandler.Bring_the_student();//Викликаємо функцію з іншого класу
                BringStudent = FXCollections.observableArrayList();
                while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
                    try {
                        if (!SelectGroup.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        BringStudent.add(new Table_Bring_Student(
                                SelectGroup.getString("IdFO"),
                                SelectGroup.getString("LastName_ukr"),
                                SelectGroup.getString("FirstName_ukr"),
                                SelectGroup.getString("Surname_ukr")));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    Individual_ID.setCellValueFactory(new PropertyValueFactory<>("IdFO"));
                    Lastname_of_Student.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                    Name_of_Student.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                    Surname_of_Student.setCellValueFactory(new PropertyValueFactory<>("SurName"));
                    CheckBoxForStudent.setCellValueFactory(new PropertyValueFactory<>("Select"));
                    Student_Table.setItems(BringStudent);
                }
            }
        });



        Name_of_Group.setOnAction(actionEvent -> {
            NameGroup_SQL = Name_of_Group.getValue().split("-")[0];
            NumberCourse_SQL = Name_of_Group.getValue().split("-")[1];
            NumberGroup_SQL = Name_of_Group.getValue().split("-")[2];
            YearGroup_SQL = Name_of_Group.getValue().split("-")[3];
            System.out.println(NameGroup_SQL);
            System.out.println(NumberCourse_SQL);
            System.out.println(NumberGroup_SQL);
            System.out.println(YearGroup_SQL);

            DataBase dataBaseHandler = new DataBase();//Створюємо нову змінну на основі створеного нами класу
            ResultSet GroupID_ResultSet = dataBaseHandler.Group_ID();//Викликаємо функцію з іншого класу

            while (true){
                try {
                    if (!GroupID_ResultSet.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    GroupID = GroupID_ResultSet.getString("GroupId");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(GroupID);

        });

        GroupToStudent_to_DB.setOnAction(actionEvent -> {
            for (Table_Bring_Student bean : BringStudent){
                if (bean.getSelect().isSelected()){
                    ID_FO_ForSql = bean.getIdFO();
                    DataBase DB = new DataBase();
                    DB.BringStudentToDB();
                    System.out.println(bean.getFirstName()+" "+bean.getLastName()+" "+bean.getIdFO()+" "+ bean.getSelect().isSelected());
                }
            }
        });





    }

}
