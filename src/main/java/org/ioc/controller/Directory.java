package org.ioc.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ioc.database.DataBase;
import org.ioc.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Directory {

    @FXML
    private TableColumn<Table_Department, String> Number_of_Chair;

    @FXML
    private TableColumn<Table_Department, String> Name_Of_Chair;

    @FXML
    private TableView<Table_Department> Table_Department;

    @FXML
    private TableView<org.ioc.model.Table_Faculty> Table_Faculty;

    @FXML
    private TableColumn<Table_Faculty, String> Abbreviation_Faculty;

    @FXML
    private TableColumn<Table_Faculty, String> Name_Faculty;

    @FXML
    private TableView<org.ioc.model.Table_Discipline> Table_Discipline;

    @FXML
    private TableColumn<Table_Discipline, String> NumberOfDepartment;

    @FXML
    private TableColumn<Table_Discipline, String> NumberOfDiscipline;

    @FXML
    private TableColumn<Table_Discipline, String> FulNameOfDiscipline;

    @FXML
    private TextField SearchDepartment;

    @FXML
    private TextField SearchDiscipline;


    @FXML
    private TableView<org.ioc.model.Table_Speciality> Table_Speciality;

    @FXML
    private TableColumn<Table_Speciality, String> NumberOfSpeciality;

    @FXML
    private TableColumn<Table_Speciality, String> NameOfSpeciality;


    @FXML
    private TableView<Table_Education> Table_Eduction;

    @FXML
    private TableColumn<Table_Education, String> NameOfEducationProgram;

    @FXML
    private TableColumn<Table_Education, String> ShortName;

    @FXML
    private TableColumn<Table_Education, String> NameOfQualification;

    public Directory() {
    }

    @FXML
    void initialize() {
        //////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////       Довідник кафедра     ///////////////////////
        //////////////////////////////////////////////////////////////////////////////////
        DataBase dataBaseHandler = new DataBase();//Створюємо нову змінну на основі створеного нами класу
        ResultSet Department_Id_Name = dataBaseHandler.Directory_Info_Department();//Викликаємо функцію з іншого класу
        ObservableList<Table_Department> Department_ID_and_Name = FXCollections.observableArrayList();
        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
            try {
                if (!Department_Id_Name.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                Department_ID_and_Name.add(new Table_Department(Department_Id_Name.getString("DepartmentId"), Department_Id_Name.getString("NameOfDepartment")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Number_of_Chair.setCellValueFactory(new PropertyValueFactory<>("id"));
            Name_Of_Chair.setCellValueFactory(new PropertyValueFactory<>("name"));
            Table_Department.setItems(Department_ID_and_Name);
        }
        //////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////     Довідник факультетів     ///////////////////////
        //////////////////////////////////////////////////////////////////////////////////
        DataBase dataBaseHandler2 = new DataBase();
        ResultSet Faculty_Name_Abr = dataBaseHandler2.Directory_Info_Faculty();
        ObservableList<Table_Faculty> Faculty_Name_and_Abr = FXCollections.observableArrayList();
        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
            try {
                if (!Faculty_Name_Abr.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                Faculty_Name_and_Abr.add(new Table_Faculty(Faculty_Name_Abr.getString("NameOfFaculty"), Faculty_Name_Abr.getString("AbriviaturaOfFaculty_ukr")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Abbreviation_Faculty.setCellValueFactory(new PropertyValueFactory<>("abbreviation"));
            Name_Faculty.setCellValueFactory(new PropertyValueFactory<>("name"));
            Table_Faculty.setItems(Faculty_Name_and_Abr);
        }

        DataBase dataBaseHandler3 = new DataBase();
        ResultSet DisciplineID_DepartmentID_FullName = dataBaseHandler3.Directory_Info_Discipline();
        ObservableList<Table_Discipline> DisciplineID_And_DepartmentID_And_FullName = FXCollections.observableArrayList();

        NumberOfDepartment.setCellValueFactory(new PropertyValueFactory<>("IdDep"));
        NumberOfDiscipline.setCellValueFactory(new PropertyValueFactory<>("IdDisc"));
        FulNameOfDiscipline.setCellValueFactory(new PropertyValueFactory<>("NameUkr"));

        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
            try {
                if (!DisciplineID_DepartmentID_FullName.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                DisciplineID_And_DepartmentID_And_FullName.add(new Table_Discipline(DisciplineID_DepartmentID_FullName.getInt("DepartmentId"), DisciplineID_DepartmentID_FullName.getInt("DisciplineId"), DisciplineID_DepartmentID_FullName.getString("NameOfDiscipline_ukr")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Table_Discipline.setItems(DisciplineID_And_DepartmentID_And_FullName);
        }
        FilteredList<Table_Discipline> Filter = new FilteredList<>(DisciplineID_And_DepartmentID_And_FullName, b -> true);
        SearchDiscipline.textProperty().addListener((observable, oldValue, newValue )-> Filter.setPredicate(Table_Discipline -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String LowerCase = newValue.toLowerCase();
            return Table_Discipline.getNameUkr().toLowerCase().contains(LowerCase);
        }));
        SortedList<Table_Discipline> sortedData = new SortedList<>(Filter);
        sortedData.comparatorProperty().bind(Table_Discipline.comparatorProperty());
        Table_Discipline.setItems(sortedData);

//        FilteredList<Table_Discipline> Filter2 = new FilteredList<>(DisciplineID_And_DepartmentID_And_FullName, b -> true);
//        SearchDepartment.textProperty().addListener((observable, oldValue, newValue )-> Filter2.setPredicate(Table_Discipline -> {
//            if (newValue == null || newValue.isEmpty()) {
//                return true;
//            }
//            String LowerCase = newValue.toLowerCase();
//            return Table_Discipline.getIdDep().toLowerCase().contains(LowerCase);
//        }));
//        SortedList<Table_Discipline> sortedData2 = new SortedList<>(Filter2);
//        sortedData.comparatorProperty().bind(Table_Discipline.comparatorProperty());
//        Table_Discipline.setItems(sortedData2);




        DataBase dataBaseHandler4 = new DataBase();
        ResultSet SpecialityId_Name = dataBaseHandler4.Directory_Info_Speciality();
        ObservableList<Table_Speciality> SpecialityId_And_Name = FXCollections.observableArrayList();
        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
            try {
                if (!SpecialityId_Name.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                SpecialityId_And_Name.add(new Table_Speciality(SpecialityId_Name.getInt("KodOfSpeciality"), SpecialityId_Name.getString("NameOfSpeciality")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            NumberOfSpeciality.setCellValueFactory(new PropertyValueFactory<>("IdSpec"));
            NameOfSpeciality.setCellValueFactory(new PropertyValueFactory<>("NameSpec"));
            Table_Speciality.setItems(SpecialityId_And_Name);
        }

        DataBase dataBaseHandler5 = new DataBase();
        ResultSet EducationalProgram_Name = dataBaseHandler5.Directory_Info_Education();
        ObservableList<Table_Education> EducationalProgram_And_Name = FXCollections.observableArrayList();
        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
            try {
                if (!EducationalProgram_Name.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                EducationalProgram_And_Name.add(new Table_Education(EducationalProgram_Name.getString("NameOfEducationalProgram"), EducationalProgram_Name.getString("ShortNameOfEducationalProgram"), EducationalProgram_Name.getString("Qualification")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            NameOfEducationProgram.setCellValueFactory(new PropertyValueFactory<>("NameProgram"));
            ShortName.setCellValueFactory(new PropertyValueFactory<>("ShortName"));
            NameOfQualification.setCellValueFactory(new PropertyValueFactory<>("Qualifications"));
            Table_Eduction.setItems(EducationalProgram_And_Name);
        }

    }
}
