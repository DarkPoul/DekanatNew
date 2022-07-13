package org.ioc.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ioc.App;
import org.ioc.database.DataBase;
import org.ioc.model.Table_Edu;
import org.ioc.model.Table_Search_D;

public class EduProcessCuration {

    @FXML
    private Button Button_Add_D;
    @FXML
    private Button Del_expansion;
    @FXML
    private Button Button_Diversity_For_Group;
    @FXML
    private Button Button_Remove_Discipline;
    @FXML
    private Button Button_Remove_For_Group;
    @FXML
    private Button diversity_expansion;
    @FXML
    private ChoiceBox<String> choose_session;
    @FXML
    private ComboBox<String> performance_choose_group;
    @FXML
    private TextField Search_Box;
    @FXML
    private ProgressIndicator progress_bar;
    @FXML
    private TableView<Table_Search_D> TableV_Search_D;
    @FXML
    private TableColumn<Table_Search_D, String> Table_C_Search_D;
    @FXML
    private TableView<Table_Edu> TableView_Disc;
    @FXML
    private TableColumn<Table_Edu, String> NumberOfDiscipline;
    @FXML
    private TableColumn<Table_Edu, String> NumberOfKafedra;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_Df_Zalik;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_RGR;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_Zalik;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_course_project;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_course_work;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_discipline;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_exam;
    @FXML
    private TableColumn<Table_Edu, String> plan_table_hours;

// Змінні

    public static String GroupID;
    public static String NumberOfSession;
    public static String StudentFO;

// змінні на внесення даних до бази( таблиця EducationalPlan)

    public static String NameOfDisc_SQL;
    public static String IdEduProgram;
    public static String IdSpec;
    public static String IdFaculty;
    public static String Hours;
    public static String Kafedra;
    public static String Test;
    public static String Exam;
    public static String CGW;
    public static String CGW_1;
    public static String CGW_2;
    public static String CGW_3;
    public static String CGW_4;
    public static String CGW_5;
    public static String CGW_6;
    public static String CW;
    public static String CP;
    public static String Dif_Test;
    public static String Uni_cod;
    public static String DisciplineIdSql;

    public static ObservableList<String> Discipline_for_Edu = FXCollections.observableArrayList();


    @FXML
    void initialize() throws SQLException {


        Discipline_for_Edu.clear();

        plan_table_discipline.setCellValueFactory(new PropertyValueFactory<>("NameOfDiscipline"));
        plan_table_hours.setCellValueFactory(new PropertyValueFactory<>("HH"));
        plan_table_Zalik.setCellValueFactory(new PropertyValueFactory<>("Zalik"));
        plan_table_exam.setCellValueFactory(new PropertyValueFactory<>("Exam"));
        plan_table_RGR.setCellValueFactory(new PropertyValueFactory<>("RGR"));
        plan_table_course_work.setCellValueFactory(new PropertyValueFactory<>("KR"));
        plan_table_course_project.setCellValueFactory(new PropertyValueFactory<>("KP"));
        plan_table_Df_Zalik.setCellValueFactory(new PropertyValueFactory<>("D_Zalik"));
        NumberOfKafedra.setCellValueFactory(new PropertyValueFactory<>("KF"));
        NumberOfDiscipline.setCellValueFactory(new PropertyValueFactory<>("NumberOfDiscipline"));

        ObservableList<Table_Edu> Disc = FXCollections.observableArrayList();
//Завантаження номеру сесії
        ObservableList<String> Var_Of_Sessions= FXCollections.observableArrayList("Зимова", "Літня");
        choose_session.setItems(Var_Of_Sessions);
        choose_session.setValue("Зимова");
//Завантаження номеру групи
        DataBase DB = new DataBase();
        ResultSet Group_Identification = DB.GroupName_SQL();

        List<String> GroupIdentification_List = new LinkedList<>();
        List<String> Group_ID_List = new LinkedList<>();
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
            String str5 = null;
            try {
                str1 = Group_Identification.getString("NameOfGroup");
                str2 = Group_Identification.getString("NumberOfCourse");
                str3 = Group_Identification.getString("NumberOfGroup");
                str4 = Group_Identification.getString("YearOfGroup");
                str5 = Group_Identification.getString("GroupId");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            GroupIdentification_List.add(str1 + "-" + str2 + "-" + str3 + "-" + str4);
            Group_ID_List.add(str5);
        }

        performance_choose_group.setItems(FXCollections.observableArrayList(GroupIdentification_List));
        performance_choose_group.setVisibleRowCount(10);

//Завантаження дисциплін
        ResultSet Name_Of_Disc = DB.Disc();
        ObservableList<Table_Search_D> NameOdDiscOL = FXCollections.observableArrayList();
        while (true) {
            try {
                if (!Name_Of_Disc.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                NameOdDiscOL.add(new Table_Search_D(Name_Of_Disc.getString("NameOfDiscipline_ukr").replace("`", "'")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        Table_C_Search_D.setCellValueFactory(new PropertyValueFactory<>("NameOfDisc"));
        TableV_Search_D.setItems(NameOdDiscOL);

//Фільтр дисциплін
        FilteredList<Table_Search_D> Filter = new FilteredList<>(NameOdDiscOL, b -> true);
        Search_Box.textProperty().addListener((observable, oldValue, newValue )-> Filter.setPredicate(Model_Table_Search_D -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String LowerCase = newValue.toLowerCase();
            return Model_Table_Search_D.getNameOfDisc().toLowerCase().contains(LowerCase);
        }));

        SortedList<Table_Search_D> sortedData = new SortedList<>(Filter);
        sortedData.comparatorProperty().bind(TableV_Search_D.comparatorProperty());
        TableV_Search_D.setItems(sortedData);
// Налаштування моделі даних



        TableView_Disc.setEditable(true);
        plan_table_discipline.setEditable(true);


        TableView_Disc.setOnMouseClicked(MouseEvent -> {
            System.out.println(TableView_Disc.getFocusModel().getFocusedIndex());
            System.out.println(TableView_Disc.getColumns().get(3));
        });


        for (Table_Edu s: TableView_Disc.getItems()){
            s.getExam().setOnAction(actionEvent2 -> {
                s.getZalik().setVisible(false);
                TableView_Disc.refresh();
            });
        }




//Кнопки
        performance_choose_group.setOnAction(actionEvent -> {

            Disc.clear();

            TableView_Disc.setItems(null);
            TableView_Disc.getSelectionModel().clearSelection();

            if (!Objects.equals(performance_choose_group.getValue(), "")){
                for (int i = 0; i < GroupIdentification_List.size(); i++){
                    if (Objects.equals(performance_choose_group.getValue(), GroupIdentification_List.get(i))){
                        GroupID = Group_ID_List.get(i);
                        if (Objects.equals(choose_session.getValue(), "Зимова")){
                            NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2 - 1);//NumberOfSemester
                        } else if (Objects.equals(choose_session.getValue(), "Літня")) {
                            NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2); //NumberOfSemester
                        }
                        if (!Objects.equals(performance_choose_group.getValue(), "")){
                            int temp = 0;
                            for (String ignored : GroupIdentification_List){
                                if (Objects.equals(GroupIdentification_List.get(temp), performance_choose_group.getValue())){
                                    GroupID = Group_ID_List.get(temp);
                                    break;
                                }else temp ++;
                            }
                            ResultSet PIB_Students_RS= DB.StudentsPIB();
                            String P_Student_Short;
                            String I_Student_Short;
                            String B_Student_Short;
                            String ID_Student_Short;
                            List<String> PIB_Student_Full = new LinkedList<>();
                            while (true) {
                                try {
                                    if (!PIB_Students_RS.next()) break;
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    P_Student_Short = PIB_Students_RS.getString("LastName_ukr");
                                    I_Student_Short = PIB_Students_RS.getString("FirstName_ukr").substring(0, 1);
                                    B_Student_Short = PIB_Students_RS.getString("Surname_ukr").substring(0, 1);
                                    ID_Student_Short = PIB_Students_RS.getString("IdFO");
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                PIB_Student_Full.add(P_Student_Short + " " + I_Student_Short + "." + B_Student_Short + "." + "-" + ID_Student_Short);
                            }
                            ObservableList<Table_Edu> Discipline = FXCollections.observableArrayList();

                            if (Objects.equals(choose_session.getValue(), "Зимова")){
                                NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2 - 1); //NumberOfSemester
                            } else if (Objects.equals(choose_session.getValue(), "Літня")) {
                                NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2); //NumberOfSemester
                            }

                            try {
                                StudentFO = PIB_Student_Full.get(0).split("-")[1];
                            } catch (IndexOutOfBoundsException e){
                                e.printStackTrace();
                            }



                            ResultSet StudentEdu_RS = DB.StudentsEdu();

                            int nx = 0;

                            while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
                                try {
                                    if (!StudentEdu_RS.next()){
                                        break;
                                    }
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                try {
                                    Discipline.add(new Table_Edu (StudentEdu_RS.getString("NameOfDiscipline_ukr")));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }






                                TableView_Disc.setItems(Discipline);

                                Disc.add(nx, Discipline.get(nx));


                                try{
                                    Disc.get(nx).KF.setText(StudentEdu_RS.getString("NumberOfDepartment"));
                                    Disc.get(nx).HH.setText(StudentEdu_RS.getString("Hours"));

                                    if (Objects.equals(StudentEdu_RS.getString("Test"), "0")){
                                        Disc.get(nx).getZalik().setSelected(true);
                                        Disc.get(nx).getExam().setVisible(false);
                                        Disc.get(nx).getD_Zalik().setVisible(false);
                                    }
                                    if (Objects.equals(StudentEdu_RS.getString("Exam"), "0")){
                                        Disc.get(nx).getExam().setSelected(true);
                                        Disc.get(nx).getZalik().setVisible(false);
                                        Disc.get(nx).getD_Zalik().setVisible(false);
                                    }



                                    if (Objects.equals(StudentEdu_RS.getString("CalculationGraphicWork"), "0")) {
                                        Disc.get(nx).RGR.setValue(StudentEdu_RS.getString("CalculationGraphicWork"));
                                        if (Objects.equals(StudentEdu_RS.getString("CalculationGraphicWork_4"), "0")){
                                            Disc.get(nx).RGR.setValue("4");
                                            Disc.get(nx).KR.setVisible(false);
                                            Disc.get(nx).KP.setVisible(false);
                                        }
                                        if (Objects.equals(StudentEdu_RS.getString("CalculationGraphicWork_6"), "0")) {
                                            Disc.get(nx).RGR.setValue("6");
                                            Disc.get(nx).KR.setVisible(false);
                                            Disc.get(nx).KP.setVisible(false);
                                        }
                                    } else Disc.get(nx).RGR.setValue("-");

                                    if (Objects.equals(StudentEdu_RS.getString("Coursework"), "0")){
                                        Disc.get(nx).KR.setSelected(true);
                                        Disc.get(nx).KP.setVisible(false);
                                        Disc.get(nx).RGR.setVisible(false);
                                    }
                                    if (Objects.equals(StudentEdu_RS.getString("CourseProject"), "0")){
                                        Disc.get(nx).KP.setSelected(true);
                                        Disc.get(nx).KR.setVisible(false);
                                        Disc.get(nx).RGR.setVisible(false);
                                    }
                                    if (Objects.equals(StudentEdu_RS.getString("DifferentiatedTest"), "0")){
                                        Disc.get(nx).D_Zalik.setSelected(true);
                                        Disc.get(nx).Exam.setVisible(false);
                                        Disc.get(nx).Zalik.setVisible(false);
                                    }
                                    Disc.get(Disc.size()-1).setNumberOfDiscipline(String.valueOf(nx+1));


                                    nx++;


                                } catch (SQLException e){
                                    e.printStackTrace();
                                }

                            }
                        }

                    }
                }
            }

        });


        choose_session.setOnAction(actionEvent -> {
            Disc.clear();
            TableView_Disc.setItems(null);
            TableView_Disc.getSelectionModel().clearSelection();

            if (!(performance_choose_group.getValue() == null)){
                for (int i = 0; i < GroupIdentification_List.size(); i++){
                    if (Objects.equals(performance_choose_group.getValue(), GroupIdentification_List.get(i))){
                        GroupID = Group_ID_List.get(i);
                        //NumberOfSession = choose_session.getValue();
                        if (Objects.equals(choose_session.getValue(), "Зимова")){
                            NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2 - 1);//NumberOfSemester
                        } else if (Objects.equals(choose_session.getValue(), "Літня")) {
                            NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2); //NumberOfSemester
                        }

                        Disc.removeAll();

                        TableView_Disc.setItems(null);

                        if (!Objects.equals(performance_choose_group.getValue(), "")){
                            for (int n = 0; n < GroupIdentification_List.size(); n++){
                                if (Objects.equals(performance_choose_group.getValue(), GroupIdentification_List.get(n))){
                                    GroupID = Group_ID_List.get(n);
                                    if (Objects.equals(choose_session.getValue(), "Зимова")){
                                        NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2 - 1);//NumberOfSemester
                                    } else if (Objects.equals(choose_session.getValue(), "Літня")) {
                                        NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2); //NumberOfSemester
                                    }
                                    if (!Objects.equals(performance_choose_group.getValue(), "")){
                                        int temp = 0;
                                        for (String ignored : GroupIdentification_List){
                                            if (Objects.equals(GroupIdentification_List.get(temp), performance_choose_group.getValue())){
                                                GroupID = Group_ID_List.get(temp);
                                                break;
                                            }else temp ++;
                                        }
                                        ResultSet PIB_Students_RS= DB.StudentsPIB();
                                        String P_Student_Short;
                                        String I_Student_Short;
                                        String B_Student_Short;
                                        String ID_Student_Short;
                                        List<String> PIB_Student_Full = new LinkedList<>();
                                        while (true) {
                                            try {
                                                if (!PIB_Students_RS.next()) break;
                                            } catch (SQLException e) {
                                                throw new RuntimeException(e);
                                            }
                                            try {
                                                P_Student_Short = PIB_Students_RS.getString("LastName_ukr");
                                                I_Student_Short = PIB_Students_RS.getString("FirstName_ukr").substring(0, 1);
                                                B_Student_Short = PIB_Students_RS.getString("Surname_ukr").substring(0, 1);
                                                ID_Student_Short = PIB_Students_RS.getString("IdFO");
                                            } catch (SQLException e) {
                                                throw new RuntimeException(e);
                                            }
                                            PIB_Student_Full.add(P_Student_Short + " " + I_Student_Short + "." + B_Student_Short + "." + "-" + ID_Student_Short);
                                        }
                                        ObservableList<Table_Edu> Discipline = FXCollections.observableArrayList();

                                        if (Objects.equals(choose_session.getValue(), "Зимова")){
                                            NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2 - 1); //NumberOfSemester
                                        } else if (Objects.equals(choose_session.getValue(), "Літня")) {
                                            NumberOfSession = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("-")[1]) * 2); //NumberOfSemester
                                        }

                                        try {
                                            StudentFO = PIB_Student_Full.get(0).split("-")[1];
                                        } catch (IndexOutOfBoundsException e){
                                            e.printStackTrace();
                                        }



                                        ResultSet StudentEdu_RS = DB.StudentsEdu();

                                        int nx = 0;

                                        while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
                                            try {
                                                if (!StudentEdu_RS.next()){
                                                    break;
                                                }
                                            } catch (SQLException throwables) {
                                                throwables.printStackTrace();
                                            }
                                            try {
                                                Discipline.add(new Table_Edu (StudentEdu_RS.getString("NameOfDiscipline_ukr")));
                                            } catch (SQLException throwables) {
                                                throwables.printStackTrace();
                                            }






                                            TableView_Disc.setItems(Discipline);

                                            Disc.add(nx, Discipline.get(nx));
                                            try{
                                                Disc.get(nx).KF.setText(StudentEdu_RS.getString("NumberOfDepartment"));
                                                Disc.get(nx).HH.setText(StudentEdu_RS.getString("Hours"));

                                                if (!Objects.equals(StudentEdu_RS.getString("Test"), "false")){
                                                    Disc.get(nx).getZalik().setSelected(true);
                                                    Disc.get(nx).getExam().setVisible(false);
                                                    Disc.get(nx).getD_Zalik().setVisible(false);
                                                }
                                                if (!Objects.equals(StudentEdu_RS.getString("Exam"), "false")){
                                                    Disc.get(nx).getExam().setSelected(true);
                                                    Disc.get(nx).getZalik().setVisible(false);
                                                    Disc.get(nx).getD_Zalik().setVisible(false);
                                                }
                                                if (!Objects.equals(StudentEdu_RS.getString("CalculationGraphicWork"), "false")) {
                                                    Disc.get(nx).RGR.setValue(StudentEdu_RS.getString("CalculationGraphicWork"));
                                                    if (!Objects.equals(StudentEdu_RS.getString("CalculationGraphicWork_4"), "false")){
                                                        Disc.get(nx).RGR.setValue("4");
                                                        Disc.get(nx).KR.setVisible(false);
                                                        Disc.get(nx).KP.setVisible(false);
                                                    }
                                                    if (!Objects.equals(StudentEdu_RS.getString("CalculationGraphicWork_6"), "false")) {
                                                        Disc.get(nx).RGR.setValue("6");
                                                        Disc.get(nx).KR.setVisible(false);
                                                        Disc.get(nx).KP.setVisible(false);
                                                    }
                                                } else Disc.get(nx).RGR.setValue("-");
                                                if (!Objects.equals(StudentEdu_RS.getString("Coursework"), "false")){
                                                    Disc.get(nx).KR.setSelected(true);
                                                    Disc.get(nx).KP.setVisible(false);
                                                    Disc.get(nx).RGR.setVisible(false);
                                                }
                                                if (!Objects.equals(StudentEdu_RS.getString("CourseProject"), "false")){
                                                    Disc.get(nx).KP.setSelected(true);
                                                    Disc.get(nx).KR.setVisible(false);
                                                    Disc.get(nx).RGR.setVisible(false);
                                                }
                                                if (!Objects.equals(StudentEdu_RS.getString("DifferentiatedTest"), "false")){
                                                    Disc.get(nx).getD_Zalik().setSelected(true);
                                                    Disc.get(nx).getExam().setVisible(false);
                                                    Disc.get(nx).getZalik().setVisible(false);
                                                }
                                                Disc.get(Disc.size()-1).setNumberOfDiscipline(String.valueOf(nx+1));
                                                nx++;
                                            } catch (SQLException e){
                                                e.printStackTrace();
                                            }

                                        }
                                    }

                                }
                            }
                        }
                        break;
                    }
                }
            }


        });


        Button_Diversity_For_Group.setOnAction(ActionEvent ->  {

            if (!(Disc.size() == 0) && !Objects.equals(performance_choose_group.getValue(), null)){
                progress_bar.setVisible(true);
//Створення вікна підтвердження
//
//                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("warning.fxml"));
//
//                warning.getIcons().add(new Image("warning.png"));
//


//Всі студенти які є в групі
                ResultSet IdOfEduProgram = DB.EduProgramAndSpec();
                while (true){
                    try {
                        if (!IdOfEduProgram.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        IdEduProgram = IdOfEduProgram.getString("IdOfEducationalProgram");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                ResultSet IdOfSpec = DB.Spec_ID_For_Edu();
                while (true){
                    try {
                        if (!IdOfSpec.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        IdSpec = IdOfSpec.getString("IdOfSpeciality");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                ResultSet FacultyId = DB.FacultyID();
                while (true){
                    try {
                        if (!FacultyId.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        IdFaculty = FacultyId.getString("FacultyID");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }



                ResultSet students = DB.StudentsInGroup();
                while (true) {
                    try {
                        if (!students.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    String str1 = null;
                    try {
                        str1 = students.getString("IdFO");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }



                    StudentFO = str1;


                    List<String> DiscIdForSql = new LinkedList<>();
                    for (Table_Edu Edu : Disc) {
                        NameOfDisc_SQL = Edu.getNameOfDiscipline();

                        ResultSet IdOfDisc = DB.DiscID();
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
                        DiscIdForSql.add(0 ,str11);
                        DisciplineIdSql = DiscIdForSql.get(0);

                        Hours = Edu.getHH().getText();
                        Kafedra = Edu.getKF().getText();
                        if (String.valueOf(Edu.getZalik().isSelected()).equals("true")){
                            Test = "0";
                        } else Test = "false";

                        if (String.valueOf(Edu.getExam().isSelected()).equals("true")){
                            Exam = "0";
                        } else Exam = "false";

                        CGW = String.valueOf(Edu.getRGR().getValue());
                        if (!Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")){
                            if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "4")){
                                CGW = "0";
                                CGW_1 = "0";
                                CGW_2 = "0";
                                CGW_3 = "0";
                                CGW_4 = "0";

                            } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "6")) {
                                CGW = "0";
                                CGW_1 = "0";
                                CGW_2 = "0";
                                CGW_3 = "0";
                                CGW_4 = "0";
                                CGW_5 = "0";
                                CGW_6 = "0";

                            }
                        } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")) {
                            CGW = "false";
                        }

                        if (String.valueOf(Edu.getKR().isSelected()).equals("true")){
                            CW = "0";
                        } else CW = "false";


                        if (String.valueOf(Edu.getKP().isSelected()).equals("true")){
                            CP = "0";
                        } else CP = "false";


                        if (String.valueOf(Edu.getD_Zalik().isSelected()).equals("true")){
                            Dif_Test = "0";
                        } else Dif_Test = "false";

                        Uni_cod = IdFaculty + "-" + IdEduProgram + "-" + NumberOfSession + "-" + DisciplineIdSql + "-" + StudentFO; //Для забезпечення бездубляжного додавання

                        if (!Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")){
                            if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "4")){
                                DB.Study_plan_Insert_four_RGR();
                            } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "6")) {
                                try {
                                    DB.Study_plan_Insert_six_RGR();
                                } catch (SQLException | IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")) {
                            DB.Study_plan_Insert_null_RGR();
                        }
                    }
                }
            }
            progress_bar.setVisible(false);
        });

//Додавання дисципліни в модель

        Button_Add_D.setOnAction(actionEvent -> {

            Disc.add(new Table_Edu(Table_C_Search_D.getCellData(TableV_Search_D.getSelectionModel().getFocusedIndex()).replace("'", "`")));
            Disc.get(Disc.size()-1).setNumberOfDiscipline(String.valueOf(Disc.size()));
            TableView_Disc.setItems(Disc);

        });
//Видалення дисципліни з моделі
        Button_Remove_Discipline.setOnAction(actionEvent -> Disc.remove(TableView_Disc.getSelectionModel().getFocusedIndex()));

        Button_Remove_For_Group.setOnAction(actionEvent -> {

        });

        diversity_expansion.setOnAction(ActionEvent ->{
            if (Disc.size() != 0){
                for (Table_Edu s : TableView_Disc.getItems()){
                    Discipline_for_Edu.add(Discipline_for_Edu.size(), s.getNameOfDiscipline());
                }
                try {
                    App.setRoot("gui/EduProcess_Advanced_Add");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Del_expansion.setOnAction(actionEvent -> {
            if (Disc.size() != 0){
                for (Table_Edu s : TableView_Disc.getItems()){
                    Discipline_for_Edu.add(Discipline_for_Edu.size(), s.getNameOfDiscipline());
                }
                try {
                    App.setRoot("gui/EduProcess_Advanced_Del");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

