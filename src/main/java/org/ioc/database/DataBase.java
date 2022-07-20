package org.ioc.database;

//Імпорт необхідних класів
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import org.ini4j.Ini;
//import org.ioc.App;
import org.ioc.controller.*;

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
    public ResultSet Directory_Info_Department() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT DepartmentId, NameOfDepartment FROM Department";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet Directory_Info_Faculty() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet2 = null;
        String query = "SELECT NameOfFaculty, AbriviaturaOfFaculty_ukr FROM Faculty";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt2 = getConnection().prepareStatement(query);
            resultSet2 = prSt2.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet2;
    }

    public ResultSet Directory_Info_Discipline() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT DepartmentId, DisciplineId, NameOfDiscipline_ukr FROM Discipline";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet Directory_Info_Speciality() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT KodOfSpeciality, NameOfSpeciality FROM Speciality";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet Directory_Info_Education() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfEducationalProgram, ShortNameOfEducationalProgram, Qualification FROM EducationalProgram";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void AnketaInsert() {//Створення методу для отримання даних з бази даних
        String query = "INSERT INTO AnketaOfStudents (IdFO, LastName_ukr, LastName_eng, FirstName_ukr, FirstName_eng, " +
                "Surname_ukr, Surname_eng, SpecialityId, YearOfEntery, StudentBook, IdentificationCode, " +
                "DateOfBirth, UkrainianCitizenship, SocialStatus, Sex, SeriesOfPassport, NumberOfPassport, IssuanceDateOfPassport, " +
                "FormOfTraining, ObtainingDegree, Financing, SeriesOfDocumentOfEducation, NumbersOfDocumentOfEducation, " +
                "NameOfDocumentOfEducation, NameOfEducationalInstitution)" +
                "VALUES ('" + Registration_of_enrolled_students.anketa_1 + "', '" + Registration_of_enrolled_students.anketa_2 + "', '" + Registration_of_enrolled_students.anketa_3 + "', '" + Registration_of_enrolled_students.anketa_4 + "', '" + Registration_of_enrolled_students.anketa_5 + "', '" +
                Registration_of_enrolled_students.anketa_6 + "', '" + Registration_of_enrolled_students.anketa_7 + "', '" + Registration_of_enrolled_students.anketa_8 + "', '" + Registration_of_enrolled_students.anketa_9  + "', '" + Registration_of_enrolled_students.anketa_11 + "', '" + Registration_of_enrolled_students.anketa_12 +
                "', '" + Registration_of_enrolled_students.anketa_13 + "', '" + Registration_of_enrolled_students.anketa_14 + "', '" + Registration_of_enrolled_students.anketa_15 + "', '" + Registration_of_enrolled_students.anketa_16 + "', '" + Registration_of_enrolled_students.anketa_18 + "', '" +
                Registration_of_enrolled_students.anketa_19 + "', '" + Registration_of_enrolled_students.anketa_20 + "', '" + Registration_of_enrolled_students.anketa_21 + "', '" + Registration_of_enrolled_students.anketa_22 + "', '" + Registration_of_enrolled_students.anketa_27 + "', '" + Registration_of_enrolled_students.anketa_28 +
                "', '" + Registration_of_enrolled_students.anketa_29 + "', '" + Registration_of_enrolled_students.anketa_30 + "', '" + Registration_of_enrolled_students.anketa_31 +"')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet Spec_ID() throws SQLException {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT SpecialityId FROM Speciality WHERE KodOfSpeciality = '" + Registration_of_enrolled_students.Anketa_8_Name + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        assert resultSet != null;

        return resultSet;
    }
//
    public ResultSet ShortNameOfGroup() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT ShortNameOfEducationalProgram FROM EducationalProgram WHERE Qualification = '" + Creating_group.DegreeName + "' and IdOfSpeciality = '" + Creating_group.N + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet FullNameAndIdOfGroup() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfEducationalProgram, EducationalProgramId FROM EducationalProgram WHERE ShortNameOfEducationalProgram = '" + Creating_group.GroupName_SQL + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet SpecialityOfFaculty() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT SpecialityId, NameOfSpeciality FROM Speciality WHERE FacultyID = '" + Id_User + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public void GroupInsert() {//Створення методу для отримання даних з бази даних
        String query = "INSERT INTO GroupOfStudents (FullNameOfGroup, NameOfGroup, NumberOfCourse, NumberOfGroup, YearOfGroup, " +
                "College, IdOfEducationalProgram)" +
                "VALUES ('" + Creating_group.GroupNameFull_SQL + "', '" + Creating_group.GroupName_SQL + "', '" + Creating_group.NumberOfCourse_SQL + "', '" + Creating_group.NumberOfGroup_SQL + "', '" + Creating_group.YearOfGroup_SQL + "', '" +
                Creating_group.College_SQL + "', '" + Creating_group.GroupID_SQL + "')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
//
    public ResultSet GroupName_SQL() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfGroup, NumberOfCourse, NumberOfGroup, YearOfGroup, GroupId FROM GroupOfStudents, EducationalProgram, Speciality WHERE GroupId > '1' AND IdOfEducationalProgram = EducationalProgramId AND IdOfSpeciality = SpecialityId AND FacultyID = '" + Id_User + "' ORDER BY NameOfGroup";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet Bring_the_student() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT IdFO, LastName_ukr, FirstName_ukr, Surname_ukr, GroupID FROM AnketaOfStudents WHERE ObtainingDegree = '"+ Diversification_of_students_by_groups.degree_panel_SQL+
                "' and FormOfTraining = '"+ Diversification_of_students_by_groups.FormOfStudy_SQL+"' and SpecialityId = '"+ Diversification_of_students_by_groups.Spec_ID_Name_SQL+"' and YearOfEntery = '"+ Diversification_of_students_by_groups.Year_of_entry_SQL+"' and GroupID = '1'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet Group_ID() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT GroupId FROM GroupOfStudents WHERE NameOfGroup = '"+ Diversification_of_students_by_groups.NameGroup_SQL +
                "' and NumberOfCourse = '"+ Diversification_of_students_by_groups.NumberCourse_SQL +"' and NumberOfGroup = '"+ Diversification_of_students_by_groups.NumberGroup_SQL +"' and YearOfGroup = '"+ Diversification_of_students_by_groups.YearGroup_SQL +"' ";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void BringStudentToDB() {//Створення методу для отримання даних з бази даних
        String query = "UPDATE AnketaOfStudents SET GroupID = '" + Diversification_of_students_by_groups.GroupID +"' WHERE IdFO = '" + Diversification_of_students_by_groups.ID_FO_ForSql+ "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
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
    public ResultSet Group_ID_StudentCard() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT GroupId FROM GroupOfStudents WHERE NameOfGroup = '"+ Student_Card.GroupName[0] +
                "' and NumberOfCourse = '"+ Student_Card.GroupName[1] +"' and NumberOfGroup = '"+ Student_Card.GroupName[2] +"' and YearOfGroup = '"+ Student_Card.GroupName[3] +"' ";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
//
    public ResultSet StudentsPIB_2() {
        ResultSet resultSet = null;
        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + Student_Card.GroupID + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet StudentsINFO() {
        ResultSet resultSet = null;
        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, LastName_eng, FirstName_eng, Surname_eng, StudentBook, " +
                "IdentificationCode, SeriesOfPassport, NumberOfPassport, DateOfBirth, IssuanceDateOfPassport, IdFO, Sex, UkrainianCitizenship, " +
                "MaritalStatus, ObtainingDegree, FormOfTraining FROM AnketaOfStudents where IdFO = '" + Student_Card.ID_Student + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet Disc() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfDiscipline_ukr FROM Discipline";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                   Запит на отримання ID студентів за номером групи                    ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ResultSet StudentsInGroup() {
        ResultSet resultSet = null;
        String query = "SELECT IdFO FROM Dekanat.AnketaOfStudents where GroupID = '" + EduProcessCuration.GroupID + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                             Запит на отримання ID дисципліни                          ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
    public ResultSet DiscID() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT DisciplineId FROM Discipline WHERE NameOfDiscipline_ukr = '" + EduProcessCuration.NameOfDisc_SQL + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet EduProgramAndSpec() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT IdOfEducationalProgram FROM GroupOfStudents WHERE GroupId = '" + EduProcessCuration.GroupID + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet Spec_ID_For_Edu() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT IdOfSpeciality FROM EducationalProgram WHERE EducationalProgramId = '" + EduProcessCuration.IdEduProgram + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet FacultyID() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT FacultyID FROM Speciality WHERE SpecialityId = '" + EduProcessCuration.IdSpec + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////              Запит на внесення навчального плану без ргр у базу даних                 ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Study_plan_Insert_null_RGR() {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + EduProcessCuration.IdFaculty + "', '" + EduProcessCuration.IdEduProgram + "', '" + EduProcessCuration.StudentFO + "', '" + EduProcessCuration.NumberOfSession + "', '" + EduProcessCuration.DisciplineIdSql + "', '" +
                EduProcessCuration.Hours + "', '" + EduProcessCuration.Test + "', '" + EduProcessCuration.Exam + "', '" + EduProcessCuration.CGW + "', '" + EduProcessCuration.CW + "', '" + EduProcessCuration.CP + "', '" + EduProcessCuration.Dif_Test + "', '"+ EduProcessCuration.Uni_cod +"', '" + EduProcessCuration.Kafedra + "')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 4 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Study_plan_Insert_four_RGR() {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, " +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + EduProcessCuration.IdFaculty + "', '" + EduProcessCuration.IdEduProgram + "', '" + EduProcessCuration.StudentFO + "', '" + EduProcessCuration.NumberOfSession + "', '" + EduProcessCuration.DisciplineIdSql + "', '" +
                EduProcessCuration.Hours + "', '" + EduProcessCuration.Test + "', '" + EduProcessCuration.Exam + "', '" + EduProcessCuration.CGW + "', '"+ EduProcessCuration.CGW_1 +"', '" + EduProcessCuration.CGW_2 +"', '"+ EduProcessCuration.CGW_3 +
                "', '"+ EduProcessCuration.CGW_4 +"', '" + EduProcessCuration.CW + "', '" + EduProcessCuration.CP + "', '" + EduProcessCuration.Dif_Test + "', '"+ EduProcessCuration.Uni_cod +"', '" + EduProcessCuration.Kafedra + "')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 6 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Study_plan_Insert_six_RGR() throws SQLException, IOException {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + EduProcessCuration.IdFaculty + "', '" + EduProcessCuration.IdEduProgram + "', '" + EduProcessCuration.StudentFO + "', '" + EduProcessCuration.NumberOfSession + "', '" + EduProcessCuration.DisciplineIdSql + "', '" +
                EduProcessCuration.Hours + "', '" + EduProcessCuration.Test + "', '" + EduProcessCuration.Exam + "', '" + EduProcessCuration.CGW + "', '"+ EduProcessCuration.CGW_1 +"', '" + EduProcessCuration.CGW_2 +"', '"+ EduProcessCuration.CGW_3 +"', '"+ EduProcessCuration.CGW_4 +"', '"+ EduProcessCuration.CGW_5 +"', '"+ EduProcessCuration.CGW_6 +"', '" + EduProcessCuration.CW + "', '" + EduProcessCuration.CP + "', '" + EduProcessCuration.Dif_Test + "', '"+ EduProcessCuration.Uni_cod +"', '" + EduProcessCuration.Kafedra + "')";//SQL запит на отримання інформації
        String query_2 = "UPDATE EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + EduProcessCuration.IdFaculty + "', '" + EduProcessCuration.IdEduProgram + "', '" + EduProcessCuration.StudentFO + "', '" + EduProcessCuration.NumberOfSession + "', '" + EduProcessCuration.DisciplineIdSql + "', '" +
                EduProcessCuration.Hours + "', '" + EduProcessCuration.Test + "', '" + EduProcessCuration.Exam + "', '" + EduProcessCuration.CGW + "', '"+ EduProcessCuration.CGW_1 +"', '" + EduProcessCuration.CGW_2 +"', '"+ EduProcessCuration.CGW_3 +"', '"+ EduProcessCuration.CGW_4 +"', '"+ EduProcessCuration.CGW_5 +"', '"+ EduProcessCuration.CGW_6 +"', '" + EduProcessCuration.CW + "', '" + EduProcessCuration.CP + "', '" + EduProcessCuration.Dif_Test + "', '"+ EduProcessCuration.Uni_cod +"', '" + EduProcessCuration.Kafedra + "')";//SQL запит на отримання інформації

        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            PreparedStatement prSt = getConnection().prepareStatement(query_2);
            prSt.executeUpdate();
            throwables.printStackTrace();
        }
    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                   Запит на отримання ID студентів за номером групи                    ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
    public ResultSet StudentsPIB() {
        ResultSet resultSet = null;
        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + EduProcessCuration.GroupID + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet StudentsByG() {
        ResultSet resultSet = null;
        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + for_next_course.GroupID + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////                  Запит на отримання навчального плану N-го студента                   ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
    public ResultSet StudentsEdu() {
        ResultSet resultSet = null;
        String query = "SELECT NameOfDiscipline_ukr, Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6, Coursework, CourseProject, DifferentiatedTest, NumberOfDepartment FROM EducationalPlan, Discipline where IdOfStudent = '" + EduProcessCuration.StudentFO +"' and NumberOfSemester ='" + EduProcessCuration.NumberOfSession + "'and Discipline.DisciplineId = EducationalPlan.DisciplineId";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public void AddStudent() {
        String query = "INSERT INTO AnketaOfStudents VALUES " + add_student.ID_FO +  ", " + add_student.sur_name_ukr + ", " + add_student.sur_name_eng
                + "," + add_student.name_ukr +  "," + add_student.name_eng +  "," + add_student.father_ukr +  ","
                + add_student.father_eng +  "," + add_student.name_ukr +  "," + add_student.professional_direction + ", " +
                add_student.group + "," + add_student.year + "," + add_student.zalik_book + ", " +
                add_student.ident + ", " + add_student.date_birth + ", " + add_student.nationality_student +
                ", " + add_student.sex + ", " + add_student.marital + ", " + add_student.pass_ser + ", " +
                add_student.pass_nam + ", " + add_student.pass_date + ", " + add_student.formStudy +
                ", " + add_student.Osv_stupin + ", " + add_student.index + ", " + add_student.Oblast +
                ", " + add_student.address + ", " + add_student.cost + ";";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
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
    public ResultSet StudentID() {
        ResultSet resultSet = null;
        String query = "SELECT IdFO FROM AnketaOfStudents WHERE LastName_ukr = '" + EduProcess_Advanced_Del.P +"' and FirstName_ukr = '" + EduProcess_Advanced_Del.I + "' and Surname_ukr = '" + EduProcess_Advanced_Del.B + "';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void InsertIntoTable() {
        String query = "insert into EducationalPlan_Delet select * from EducationalPlan where EducationalPlan.IdOfStudent = '" + EduProcess_Advanced_Del.ID_FO + "' and EducationalPlan.NumberOfSemester = '" + EduProcess_Advanced_Del.ID_Sem + "' and EducationalPlan.DisciplineId = '"+ EduProcess_Advanced_Del.ID_Disc +"';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteIntoTable() {
        String query = "delete from EducationalPlan where EducationalPlan.IdOfStudent = '" + EduProcess_Advanced_Del.ID_FO + "' and EducationalPlan.NumberOfSemester = '" + EduProcess_Advanced_Del.ID_Sem + "' and EducationalPlan.DisciplineId = '"+ EduProcess_Advanced_Del.ID_Disc +"';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

}







