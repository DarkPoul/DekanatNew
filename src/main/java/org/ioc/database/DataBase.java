package org.ioc.database;

//Імпорт необхідних класів
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import org.ini4j.Ini;
//import org.ioc.App;
import org.ioc.controller.authentication;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DataBase extends authentication {//Головний клас підключення бази даних

    public static boolean True_connection;

    public static void Open_DB() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//підключення драйверу
            try (Connection ignored = getConnection()){
                System.out.println("Connection to Store DB successfully!");
                True_connection = true;
            }
        }
        catch(Exception ex){
//            True_connection = false;
//            Stage Test_connection = new Stage();
//            Test_connection.setTitle("Помилка");
//            Test_connection.initModality(Modality.APPLICATION_MODAL);
//            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Error_connection.fxml"));
//            Scene scene = null;
//            try {
//                scene = new Scene(fxmlLoader.load(), 250, 100);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Test_connection.setScene(scene);
//            Test_connection.showAndWait();


            System.out.println("Connection failed...");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {

//        Ini properties = new Ini(new File("src/main/resources/org/ioc/property/Config.ini"));
//
//        String open_Login = properties.get("login", "login");
//        String open_Password = properties.get("password", "password");
//        String open_Host = properties.get("host", "host");
//        String url = "jdbc:mysql://" + open_Host;
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";

        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public ResultSet Connection_Dekanat() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT Login, password, ID_Faculty FROM Users_dekanat";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//    public ResultSet Directory_Info_Department() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT DepartmentId, NameOfDepartment FROM Department";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Directory_Info_Faculty() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet2 = null;
//        String query = "SELECT NameOfFaculty, AbriviaturaOfFaculty_ukr FROM Faculty";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt2 = getConnection().prepareStatement(query);
//            resultSet2 = prSt2.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet2;
//    }
//
//    public ResultSet Directory_Info_Discipline() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT DepartmentId, DisciplineId, NameOfDiscipline_ukr FROM Discipline";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Directory_Info_Speciality() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT KodOfSpeciality, NameOfSpeciality FROM Speciality";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Directory_Info_Education() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT NameOfEducationalProgram, ShortNameOfEducationalProgram, Qualification FROM EducationalProgram";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public void AnketaInsert() {//Створення методу для отримання даних з бази даних
//        String query = "INSERT INTO AnketaOfStudents (IdFO, LastName_ukr, LastName_eng, FirstName_ukr, FirstName_eng, " +
//                "Surname_ukr, Surname_eng, SpecialityId, YearOfEntery, StudentBook, IdentificationCode, " +
//                "DateOfBirth, UkrainianCitizenship, SocialStatus, Sex, SeriesOfPassport, NumberOfPassport, IssuanceDateOfPassport, " +
//                "FormOfTraining, ObtainingDegree, Financing, SeriesOfDocumentOfEducation, NumbersOfDocumentOfEducation, " +
//                "NameOfDocumentOfEducation, NameOfEducationalInstitution)" +
//                "VALUES ('" + Registration_of_enrolled_students_Controller.anketa_1 + "', '" + Registration_of_enrolled_students_Controller.anketa_2 + "', '" + Registration_of_enrolled_students_Controller.anketa_3 + "', '" + Registration_of_enrolled_students_Controller.anketa_4 + "', '" + Registration_of_enrolled_students_Controller.anketa_5 + "', '" +
//                Registration_of_enrolled_students_Controller.anketa_6 + "', '" + Registration_of_enrolled_students_Controller.anketa_7 + "', '" + Registration_of_enrolled_students_Controller.anketa_8 + "', '" + Registration_of_enrolled_students_Controller.anketa_9  + "', '" + Registration_of_enrolled_students_Controller.anketa_11 + "', '" + Registration_of_enrolled_students_Controller.anketa_12 +
//                "', '" + Registration_of_enrolled_students_Controller.anketa_13 + "', '" + Registration_of_enrolled_students_Controller.anketa_14 + "', '" + Registration_of_enrolled_students_Controller.anketa_15 + "', '" + Registration_of_enrolled_students_Controller.anketa_16 + "', '" + Registration_of_enrolled_students_Controller.anketa_18 + "', '" +
//                Registration_of_enrolled_students_Controller.anketa_19 + "', '" + Registration_of_enrolled_students_Controller.anketa_20 + "', '" + Registration_of_enrolled_students_Controller.anketa_21 + "', '" + Registration_of_enrolled_students_Controller.anketa_22 + "', '" + Registration_of_enrolled_students_Controller.anketa_27 + "', '" + Registration_of_enrolled_students_Controller.anketa_28 +
//                "', '" + Registration_of_enrolled_students_Controller.anketa_29 + "', '" + Registration_of_enrolled_students_Controller.anketa_30 + "', '" + Registration_of_enrolled_students_Controller.anketa_31 +"')";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    public ResultSet Spec_ID() throws SQLException {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT SpecialityId FROM Speciality WHERE KodOfSpeciality = '" + Registration_of_enrolled_students_Controller.Anketa_8_Name + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        assert resultSet != null;
//
//        return resultSet;
//    }
//
//    public ResultSet ShortNameOfGroup() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT ShortNameOfEducationalProgram FROM EducationalProgram WHERE Qualification = '" + Create_Group_Controller.DegreeName + "' and IdOfSpeciality = '" + Create_Group_Controller.N + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet FullNameAndIdOfGroup() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT NameOfEducationalProgram, EducationalProgramId FROM EducationalProgram WHERE ShortNameOfEducationalProgram = '" + Create_Group_Controller.GroupName_SQL + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet SpecialityOfFaculty() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT SpecialityId, NameOfSpeciality FROM Speciality WHERE FacultyID = '" + Id_User + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public void GroupInsert() {//Створення методу для отримання даних з бази даних
//        String query = "INSERT INTO GroupOfStudents (FullNameOfGroup, NameOfGroup, NumberOfCourse, NumberOfGroup, YearOfGroup, " +
//                "College, IdOfEducationalProgram)" +
//                "VALUES ('" + Create_Group_Controller.GroupNameFull_SQL + "', '" + Create_Group_Controller.GroupName_SQL + "', '" + Create_Group_Controller.NumberOfCourse_SQL + "', '" + Create_Group_Controller.NumberOfGroup_SQL + "', '" + Create_Group_Controller.YearOfGroup_SQL + "', '" +
//                Create_Group_Controller.College_SQL + "', '" + Create_Group_Controller.GroupID_SQL + "')";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public ResultSet GroupName_SQL() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT NameOfGroup, NumberOfCourse, NumberOfGroup, YearOfGroup, GroupId FROM GroupOfStudents, EducationalProgram, Speciality WHERE GroupId > '1' AND IdOfEducationalProgram = EducationalProgramId AND IdOfSpeciality = SpecialityId AND FacultyID = '" + Id_User + "' ORDER BY NameOfGroup";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Bring_the_student() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT IdFO, LastName_ukr, FirstName_ukr, Surname_ukr, GroupID FROM AnketaOfStudents WHERE ObtainingDegree = '"+ Diversification_of_students_by_groups.degree_panel_SQL+
//                "' and FormOfTraining = '"+ Diversification_of_students_by_groups.FormOfStudy_SQL+"' and SpecialityId = '"+ Diversification_of_students_by_groups.Spec_ID_Name_SQL+"' and YearOfEntery = '"+ Diversification_of_students_by_groups.Year_of_entry_SQL+"' and GroupID = '1'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Group_ID() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT GroupId FROM GroupOfStudents WHERE NameOfGroup = '"+ Diversification_of_students_by_groups.NameGroup_SQL +
//                "' and NumberOfCourse = '"+ Diversification_of_students_by_groups.NumberCourse_SQL +"' and NumberOfGroup = '"+ Diversification_of_students_by_groups.NumberGroup_SQL +"' and YearOfGroup = '"+ Diversification_of_students_by_groups.YearGroup_SQL +"' ";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public void BringStudentToDB() {//Створення методу для отримання даних з бази даних
//        String query = "UPDATE AnketaOfStudents SET GroupID = '" + Diversification_of_students_by_groups.GroupID +"' WHERE IdFO = '" + Diversification_of_students_by_groups.ID_FO_ForSql+ "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
///*
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    ///////////// Запит на отримання номеру групи у базі даних Деканат, через назву групи, курс та ін.  ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public ResultSet GetIdOfGroup() {
//        ResultSet resultSet = null;
//        String query = "SELECT GroupId FROM GroupOfStudents where NameOfGroup = '" + EduProcessCuration_Controller.GetNameGroup[0] + "' and NumberOfCourse = '" + EduProcessCuration_Controller.GetNameGroup[1] + "' and NumberOfGroup = '" + EduProcessCuration_Controller.GetNameGroup[2] + "' and YearOfGroup = '" + EduProcessCuration_Controller.GetNameGroup[3] + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//
//
//
//
//
//
//
//
//
//*/
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                   Запит на отримання номеру групи для StudentCard                     ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public ResultSet Group_ID_StudentCard() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT GroupId FROM GroupOfStudents WHERE NameOfGroup = '"+ Studentcard_Controller.GroupName[0] +
//                "' and NumberOfCourse = '"+ Studentcard_Controller.GroupName[1] +"' and NumberOfGroup = '"+ Studentcard_Controller.GroupName[2] +"' and YearOfGroup = '"+ Studentcard_Controller.GroupName[3] +"' ";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//
//    public ResultSet StudentsPIB_2() {
//        ResultSet resultSet = null;
//        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + Studentcard_Controller.GroupID + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet StudentsINFO() {
//        ResultSet resultSet = null;
//        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, LastName_eng, FirstName_eng, Surname_eng, StudentBook, " +
//                "IdentificationCode, SeriesOfPassport, NumberOfPassport, DateOfBirth, IssuanceDateOfPassport, IdFO, Sex, UkrainianCitizenship, " +
//                "MaritalStatus, ObtainingDegree, FormOfTraining FROM AnketaOfStudents where IdFO = '" + Studentcard_Controller.ID_Student + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Disc() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT NameOfDiscipline_ukr FROM Discipline";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                   Запит на отримання ID студентів за номером групи                    ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public ResultSet StudentsInGroup() {
//        ResultSet resultSet = null;
//        String query = "SELECT IdFO FROM Dekanat.AnketaOfStudents where GroupID = '" + EduProcessCuration_Controller.GroupID + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                             Запит на отримання ID дисципліни                          ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public ResultSet DiscID() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT DisciplineId FROM Discipline WHERE NameOfDiscipline_ukr = '" + EduProcessCuration_Controller.NameOfDisc_SQL + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet EduProgramAndSpec() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT IdOfEducationalProgram FROM GroupOfStudents WHERE GroupId = '" + EduProcessCuration_Controller.GroupID + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet Spec_ID_For_Edu() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT IdOfSpeciality FROM EducationalProgram WHERE EducationalProgramId = '" + EduProcessCuration_Controller.IdEduProgram + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public ResultSet FacultyID() {//Створення методу для отримання даних з бази даних
//        ResultSet resultSet = null;
//        String query = "SELECT FacultyID FROM Speciality WHERE SpecialityId = '" + EduProcessCuration_Controller.IdSpec + "'";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////              Запит на внесення навчального плану без ргр у базу даних                 ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void Study_plan_Insert_null_RGR() {
//        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
//                "Hours, Test, Exam, CalculationGraphicWork, Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
//                "VALUES ('" + EduProcessCuration_Controller.IdFaculty + "', '" + EduProcessCuration_Controller.IdEduProgram + "', '" + EduProcessCuration_Controller.StudentFO + "', '" + EduProcessCuration_Controller.NumberOfSession + "', '" + EduProcessCuration_Controller.DisciplineIdSql + "', '" +
//                EduProcessCuration_Controller.Hours + "', '" + EduProcessCuration_Controller.Test + "', '" + EduProcessCuration_Controller.Exam + "', '" + EduProcessCuration_Controller.CGW + "', '" + EduProcessCuration_Controller.CW + "', '" + EduProcessCuration_Controller.CP + "', '" + EduProcessCuration_Controller.Dif_Test + "', '"+ EduProcessCuration_Controller.Uni_cod +"', '" + EduProcessCuration_Controller.Kafedra + "')";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 4 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void Study_plan_Insert_four_RGR() {
//        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
//                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, " +
//                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
//                "VALUES ('" + EduProcessCuration_Controller.IdFaculty + "', '" + EduProcessCuration_Controller.IdEduProgram + "', '" + EduProcessCuration_Controller.StudentFO + "', '" + EduProcessCuration_Controller.NumberOfSession + "', '" + EduProcessCuration_Controller.DisciplineIdSql + "', '" +
//                EduProcessCuration_Controller.Hours + "', '" + EduProcessCuration_Controller.Test + "', '" + EduProcessCuration_Controller.Exam + "', '" + EduProcessCuration_Controller.CGW + "', '"+ EduProcessCuration_Controller.CGW_1 +"', '" + EduProcessCuration_Controller.CGW_2 +"', '"+ EduProcessCuration_Controller.CGW_3 +
//                "', '"+ EduProcessCuration_Controller.CGW_4 +"', '" + EduProcessCuration_Controller.CW + "', '" + EduProcessCuration_Controller.CP + "', '" + EduProcessCuration_Controller.Dif_Test + "', '"+ EduProcessCuration_Controller.Uni_cod +"', '" + EduProcessCuration_Controller.Kafedra + "')";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 6 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void Study_plan_Insert_six_RGR() throws SQLException, IOException {
//        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
//                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
//                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
//                "VALUES ('" + EduProcessCuration_Controller.IdFaculty + "', '" + EduProcessCuration_Controller.IdEduProgram + "', '" + EduProcessCuration_Controller.StudentFO + "', '" + EduProcessCuration_Controller.NumberOfSession + "', '" + EduProcessCuration_Controller.DisciplineIdSql + "', '" +
//                EduProcessCuration_Controller.Hours + "', '" + EduProcessCuration_Controller.Test + "', '" + EduProcessCuration_Controller.Exam + "', '" + EduProcessCuration_Controller.CGW + "', '"+ EduProcessCuration_Controller.CGW_1 +"', '" + EduProcessCuration_Controller.CGW_2 +"', '"+ EduProcessCuration_Controller.CGW_3 +"', '"+ EduProcessCuration_Controller.CGW_4 +"', '"+ EduProcessCuration_Controller.CGW_5 +"', '"+ EduProcessCuration_Controller.CGW_6 +"', '" + EduProcessCuration_Controller.CW + "', '" + EduProcessCuration_Controller.CP + "', '" + EduProcessCuration_Controller.Dif_Test + "', '"+ EduProcessCuration_Controller.Uni_cod +"', '" + EduProcessCuration_Controller.Kafedra + "')";//SQL запит на отримання інформації
//        String query_2 = "UPDATE EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
//                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
//                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
//                "VALUES ('" + EduProcessCuration_Controller.IdFaculty + "', '" + EduProcessCuration_Controller.IdEduProgram + "', '" + EduProcessCuration_Controller.StudentFO + "', '" + EduProcessCuration_Controller.NumberOfSession + "', '" + EduProcessCuration_Controller.DisciplineIdSql + "', '" +
//                EduProcessCuration_Controller.Hours + "', '" + EduProcessCuration_Controller.Test + "', '" + EduProcessCuration_Controller.Exam + "', '" + EduProcessCuration_Controller.CGW + "', '"+ EduProcessCuration_Controller.CGW_1 +"', '" + EduProcessCuration_Controller.CGW_2 +"', '"+ EduProcessCuration_Controller.CGW_3 +"', '"+ EduProcessCuration_Controller.CGW_4 +"', '"+ EduProcessCuration_Controller.CGW_5 +"', '"+ EduProcessCuration_Controller.CGW_6 +"', '" + EduProcessCuration_Controller.CW + "', '" + EduProcessCuration_Controller.CP + "', '" + EduProcessCuration_Controller.Dif_Test + "', '"+ EduProcessCuration_Controller.Uni_cod +"', '" + EduProcessCuration_Controller.Kafedra + "')";//SQL запит на отримання інформації
//
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            PreparedStatement prSt = getConnection().prepareStatement(query_2);
//            prSt.executeUpdate();
//            throwables.printStackTrace();
//        }
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                   Запит на отримання ID студентів за номером групи                    ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public ResultSet StudentsPIB() {
//        ResultSet resultSet = null;
//        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + EduProcessCuration_Controller.GroupID + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                  Запит на отримання навчального плану N-го студента                   ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public ResultSet StudentsEdu() {
//        ResultSet resultSet = null;
//        String query = "SELECT NameOfDiscipline_ukr, Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6, Coursework, CourseProject, DifferentiatedTest, NumberOfDepartment FROM EducationalPlan, Discipline where IdOfStudent = '" + EduProcessCuration_Controller.StudentFO +"' and NumberOfSemester ='" + EduProcessCuration_Controller.NumberOfSession + "'and Discipline.DisciplineId = EducationalPlan.DisciplineId";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            resultSet = prSt.executeQuery();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }
//
//    public void AddStudent() {
//        String query = "INSERT INTO AnketaOfStudents VALUES " + Controller_Add_Student.ID_FO +  ", " + Controller_Add_Student.sur_name_ukr + ", " + Controller_Add_Student.sur_name_eng
//                + "," + Controller_Add_Student.name_ukr +  "," + Controller_Add_Student.name_eng +  "," + Controller_Add_Student.father_ukr +  ","
//                + Controller_Add_Student.father_eng +  "," + Controller_Add_Student.name_ukr +  "," + Controller_Add_Student.professional_direction + ", " +
//                Controller_Add_Student.group + "," + Controller_Add_Student.year + "," + Controller_Add_Student.zalik_book + ", " +
//                Controller_Add_Student.ident + ", " + Controller_Add_Student.date_birth + ", " + Controller_Add_Student.nationality_student +
//                ", " + Controller_Add_Student.sex + ", " + Controller_Add_Student.marital + ", " + Controller_Add_Student.pass_ser + ", " +
//                Controller_Add_Student.pass_nam + ", " + Controller_Add_Student.pass_date + ", " + Controller_Add_Student.formStudy +
//                ", " + Controller_Add_Student.Osv_stupin + ", " + Controller_Add_Student.index + ", " + Controller_Add_Student.Oblast +
//                ", " + Controller_Add_Student.address + ", " + Controller_Add_Student.cost + ";";//SQL запит на отримання інформації
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//
//
////    public ResultSet StudentsPIB_Entering() {
////        ResultSet resultSet = null;
////        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + Entering_estimates_from_the_information.GroupID + "'";//SQL запит на отримання інформації
////        try {
////            PreparedStatement prSt = getConnection().prepareStatement(query);
////            resultSet = prSt.executeQuery();
////        } catch (SQLException | IOException throwables) {
////            throwables.printStackTrace();
////        }
////        return resultSet;
////    }
//
////    public ResultSet DiscForEnteringMark() {
////        ResultSet resultSet = null;
////        String query = "SELECT DisciplineId FROM EducationalPlan where IdOfStudent  = '" + Entering_estimates_from_the_information.StudentFO + "' and NumberOfSemester = '" + Entering_estimates_from_the_information.NumberOfSession + "'";//SQL запит на отримання інформації
////        try {
////            PreparedStatement prSt = getConnection().prepareStatement(query);
////            resultSet = prSt.executeQuery();
////        } catch (SQLException | IOException throwables) {
////            throwables.printStackTrace();
////        }
////        return resultSet;
////    }
//
////    public ResultSet DiscNameForEnteringMark() {
////        ResultSet resultSet = null;
////        String query = "SELECT NameOfDiscipline_ukr FROM Discipline where DisciplineId = '" + Entering_estimates_from_the_information.DiscID + "'";//SQL запит на отримання інформації
////        try {
////            PreparedStatement prSt = getConnection().prepareStatement(query);
////            resultSet = prSt.executeQuery();
////        } catch (SQLException | IOException throwables) {
////            throwables.printStackTrace();
////        }
////        return resultSet;
////    }
//
////    public ResultSet EnteringMark() {
////        ResultSet resultSet = null;
////        String query = "SELECT Exam, Exam_D, Exam_V, Test, Test_D, Test_V, Coursework, Coursework_D, Coursework_V, CourseProject, CourseProject_D, CourseProject_V, DifferentiatedTest, DifferentiatedTest_D, DifferentiatedTest_V, CalculationGraphicWork, CalculationGraphicWork_D, CalculationGraphicWork_V, LastName_ukr, FirstName_ukr, Surname_ukr FROM EducationalPlan, AnketaOfStudents where DisciplineId = '" + Entering_estimates_from_the_information.DiscID + "' and NumberOfSemester = '" + Entering_estimates_from_the_information.NumberOfSession + "' and EducationalPlan.IdOfStudent = AnketaOfStudents.IdFO ";//SQL запит на отримання інформації
////        try {
////            PreparedStatement prSt = getConnection().prepareStatement(query);
////            resultSet = prSt.executeQuery();
////        } catch (SQLException | IOException throwables) {
////            throwables.printStackTrace();
////        }
////        return resultSet;
////    }
//
////    public void EnterMark_Exam() throws SQLException, IOException {
////        String query = "UPDATE EducationalPlan SET Exam = '" + Entering_estimates_from_the_information.Exam + "', Exam_D = '" + Entering_estimates_from_the_information.DataOf + "', Exam_V = '" + Entering_estimates_from_the_information.Vidomist + "' WHERE IdOfStudent = '" + Entering_estimates_from_the_information.StudentFO + "' and DisciplineId = '" + Entering_estimates_from_the_information.DiscID + "'";//SQL запит на отримання інформації
////        try {
////            PreparedStatement prSt = getConnection().prepareStatement(query);
////            prSt.executeUpdate();
////        } catch (SQLException | IOException throwables) {
////            throwables.printStackTrace();
////        }
////    }

}







