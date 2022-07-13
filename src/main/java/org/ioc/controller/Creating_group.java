package org.ioc.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import org.ioc.database.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Creating_group {

    @FXML
    private Button Create_button;

    @FXML
    private CheckBox College_Type;

    @FXML
    private ChoiceBox<String> Name_of_Group;

    @FXML
    private ChoiceBox<String> NumberOfCourse;

    @FXML
    private ChoiceBox<String> NumberOfGroup;

    @FXML
    private ChoiceBox<String> YearOfGroup;

    @FXML
    private ChoiceBox<String> DegreeID;

    public static String N;
    public static String DegreeName;

    public static String GroupNameFull_SQL;
    public static String GroupID_SQL;
    public static String GroupName_SQL;
    public static String NumberOfCourse_SQL;
    public static String NumberOfGroup_SQL;
    public static String YearOfGroup_SQL;

    public static Boolean GroupName_bool = false;
    public static Boolean NumberOfCourse_bool = false;
    public static Boolean NumberOfGroup_bool = false;
    public static Boolean YearOfGroup_bool = false;

    public static Boolean College_SQL;

    @FXML
    void initialize() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int yearOfStudy = Integer.parseInt(String.valueOf(year).substring(2));
        ObservableList<String> Degree_Var= FXCollections.observableArrayList("Бакалавр", "Магістр");
        ObservableList<String> NumberOfCourse_Var= FXCollections.observableArrayList("1", "2","3", "4");
        ObservableList<String> NumberOfGroup_Var= FXCollections.observableArrayList("1", "2","3", "4", "5");
        ObservableList<String> YearOfGroup_Var= FXCollections.observableArrayList( String.valueOf(yearOfStudy),
                String.valueOf(yearOfStudy-1),
                String.valueOf(yearOfStudy-2),
                String.valueOf(yearOfStudy-3),
                String.valueOf(yearOfStudy-4));


        DegreeID.setItems(Degree_Var);
        NumberOfCourse.setItems(NumberOfCourse_Var);
        NumberOfGroup.setItems(NumberOfGroup_Var);
        YearOfGroup.setItems(YearOfGroup_Var);

        DegreeID.setOnAction(ActionEvent ->{
            DegreeName = DegreeID.getValue();
            if (Objects.equals(DegreeName, Degree_Var.get(0))){
                College_Type.setText("Технікум");
            }
            if (Objects.equals(DegreeName, Degree_Var.get(1))){
                College_Type.setText("Наукоці");
            }


            System.out.println(DegreeName);

            DataBase ID_OF_SPEC = new DataBase();
            ResultSet ID_Of_group = ID_OF_SPEC.SpecialityOfFaculty();
            List<String> idOfGroup = new LinkedList<>();
            while (true) {
                try {
                    if (!ID_Of_group.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String str1 = null;
                try {
                    str1 = ID_Of_group.getString("SpecialityId");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                idOfGroup.add(str1);
                System.out.println(str1);
            }



            DataBase ShortName = new DataBase();
            List<String> ShortNameGroup = new LinkedList<>();

            for (String s : idOfGroup) {
                N = s;
                ResultSet ShortNameOfGroup = ShortName.ShortNameOfGroup();
                while (true) {
                    try {
                        if (!ShortNameOfGroup.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    String str1 = null;
                    try {
                        str1 = ShortNameOfGroup.getString("ShortNameOfEducationalProgram");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    ShortNameGroup.add(str1);
                }
            }
            ObservableList<String> NameOfGroup = FXCollections.observableList(ShortNameGroup);
            Name_of_Group.setItems(FXCollections.observableList(NameOfGroup));
        });

        Name_of_Group.setOnAction(actionEvent -> {
            GroupName_SQL = Name_of_Group.getValue();
            DataBase nameAndIdOfGroup = new DataBase();
            ResultSet FullName = nameAndIdOfGroup.FullNameAndIdOfGroup();
            try {
                if (FullName.next()){
                    GroupNameFull_SQL = FullName.getString("NameOfEducationalProgram");
                    GroupID_SQL = FullName.getString("EducationalProgramId");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            GroupName_bool = true;
        });

        NumberOfCourse.setOnAction(actionEvent -> {
            NumberOfCourse_SQL = NumberOfCourse.getValue();
            NumberOfCourse_bool = true;
        });

        NumberOfGroup.setOnAction(actionEvent -> {
            NumberOfGroup_SQL = NumberOfGroup.getValue();
            NumberOfGroup_bool = true;
        });

        YearOfGroup.setOnAction(actionEvent -> {
            YearOfGroup_SQL = YearOfGroup.getValue();
            YearOfGroup_bool = true;
        });

        Create_button.setOnAction(actionEvent -> {
            College_SQL= College_Type.isSelected();
            if (College_Type.isSelected()){
                GroupName_SQL = Name_of_Group.getValue();
                if (Objects.equals(DegreeName, Degree_Var.get(0))){
                    GroupName_SQL = GroupName_SQL + "т";
                }
                if (Objects.equals(DegreeName, Degree_Var.get(1))){
                    GroupName_SQL = GroupName_SQL + "н";
                }

            } else{GroupName_SQL = Name_of_Group.getValue();}
            if (GroupName_bool && NumberOfCourse_bool && NumberOfGroup_bool && YearOfGroup_bool){
                System.out.println(GroupName_SQL);
                System.out.println(NumberOfCourse_SQL);
                System.out.println(NumberOfGroup_SQL);
                System.out.println(YearOfGroup_SQL);
                System.out.println(College_SQL);
                GroupNameFull_SQL = GroupNameFull_SQL.replace("'", "`");
                System.out.println(GroupNameFull_SQL);
                System.out.println(GroupID_SQL);
                DataBase CreateGroup = new DataBase();
                CreateGroup.GroupInsert();
            }
        });





    }

}
