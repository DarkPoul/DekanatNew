package org.ioc.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.ioc.App;
import org.ioc.database.DataBase;


public class Registration_of_enrolled_students {

    public static String anketa_1;
    public static String anketa_2;
    public static String anketa_3;
    public static String anketa_4;
    public static String anketa_5;
    public static String anketa_6;
    public static String anketa_7;
    public static String anketa_8;
    public static String anketa_9;
    public static String anketa_11;
    public static String anketa_12;
    public static String anketa_13;
    public static String anketa_14;
    public static String anketa_15;
    public static String anketa_16;
    public static String anketa_18;
    public static String anketa_19;
    public static String anketa_20;
    public static String anketa_21;
    public static String anketa_22;
    public static String anketa_27;
    public static String anketa_28;
    public static String anketa_29;
    public static String anketa_30;
    public static String anketa_31;
    public static String Anketa_8_Name;

    @FXML
    private Button Diversification_of_students_into_groups;

    @FXML
    private Button Download_students_to_the_database;

    @FXML
    private Button CreateGroup_Button;

    @FXML
    private Button AddNewStudent_Button;

    @FXML
    private AnchorPane Scene_Anchor;

    @FXML
    void initialize() throws ClassNotFoundException{

        Download_students_to_the_database.setOnAction(ActionEvent -> {
            FileChooser student_to_DB = new FileChooser();
            student_to_DB.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XLS", "*.xls"));
            student_to_DB.setTitle("Завантажити файл .csv");
            String Student_to_DB_File = null;
            try {
                Student_to_DB_File = student_to_DB.showOpenDialog(Scene_Anchor.getScene().getWindow()).getAbsolutePath();
            } catch (NullPointerException throwables) {
                System.out.println("Файл не знайден, спробуйте ще раз!");
            }





            try {


                HSSFWorkbook wb;
                InputStream in;

                assert Student_to_DB_File != null;

                try {
                    in = Files.newInputStream(Paths.get(Student_to_DB_File));
                    wb = new HSSFWorkbook(in);
                    Sheet sheet = wb.getSheetAt(0);
                    DataBase dataBaseHandler4 = new DataBase();

                    for (Row row :sheet){




                        String[] Anketa_mass = AnketaOfStudent(row);

                        String Ukr;

                        if (parsingField(Anketa_mass[7]).equals("Україна")) {
                            Ukr = "true";
                        } else {
                            Ukr = "false";
                        }

                        Anketa_8_Name = (Anketa_mass[14].split(" ")[0]).substring(0, 3);

                        String[] NameAndSeriesOfEducation = (parsingField(Anketa_mass[16]).split(";")[0]).split(" ");

                        StringBuilder NameOfEducation = new StringBuilder();
                        for (String s : NameAndSeriesOfEducation) {
                            NameOfEducation.append(" ").append(s);
                        }

                        StringBuilder NameOfEducationDocument = new StringBuilder();
                        for (int n = 0; n < NameAndSeriesOfEducation.length -2; n ++) {
                            NameOfEducationDocument.append(" ").append(NameAndSeriesOfEducation[n]);
                        }

                        DataBase dataBaseHandler3 = new DataBase();
                        ResultSet SpecId = dataBaseHandler3.Spec_ID();
                        anketa_1 = Anketa_mass[0];
                        anketa_2 = parsingFieldPIB(Anketa_mass[1])[0];                                                      //PIB_P_UKR
                        anketa_3 = parsingFieldPIB(Anketa_mass[8])[0];                                                      //PIB_P_ENG
                        anketa_4 = parsingFieldPIB(Anketa_mass[1])[1];                                                      //PIB_I_UKR
                        anketa_5 = parsingFieldPIB(Anketa_mass[8])[1];                                                      //PIB_I_ENG
                        anketa_6 = parsingFieldPIB(Anketa_mass[1])[2];                                                      //PIB_B_UKR
                        anketa_7 = parsingFieldPIB(Anketa_mass[8])[2];                                                      //PIB_B_ENG
                        if (SpecId.next()){
                            anketa_8 = SpecId.getString("SpecialityId");                                         // speciality
                        }
                        anketa_9 = date(Anketa_mass[10]).split("\\.")[2];                                             // year of entry
                        anketa_11 = parsingField(Anketa_mass[17].split(";")[0]);                                      // StudentBook
                        anketa_12 = parsingField(Anketa_mass[9]);                                                           // Identification Cod
                        anketa_13 = date(parsingField(Anketa_mass[2]));                                                     // BirthDay
                        anketa_14 = Ukr;                                                                                    // Citizenship
                        anketa_15 = parsingField(Anketa_mass[15]);                                                          // Social Status
                        anketa_16 = parsingField(Anketa_mass[6]);                                                           // SEX
                        anketa_18 = parsingField(Anketa_mass[3]);                                                           // serial pass
                        anketa_19 = parsingField(Anketa_mass[4]);                                                           // number pass
                        anketa_20 = date(parsingField(Anketa_mass[5]));                                                     // date pass
                        anketa_21 = parsingField(Anketa_mass[12]);                                                          // Type of study
                        anketa_22 = parsingField(Anketa_mass[11]);                                                          // Obtaining Degree
                        anketa_27 = parsingField(Anketa_mass[13]);                                                          // Financing
                        anketa_28 = parsingField(NameAndSeriesOfEducation[NameAndSeriesOfEducation.length -2]);             // SeriesOfDocumentOfEducation
                        anketa_29 = parsingField(NameAndSeriesOfEducation[NameAndSeriesOfEducation.length -1]);             // NumbersOfDocumentOfEducation
                        anketa_30 = NameOfEducationDocument.toString();                                                                // Name Of Education Document
                        anketa_31 = parsingField(Anketa_mass[16]).split(";")[2].substring(13).replace("'", "`");                        // Name Of Educational Institution

                        System.out.println(anketa_1 + "     " + anketa_2 + "     " + anketa_3 + "     " + anketa_4 + "     " + anketa_5 + "     " + anketa_6 + "     " + anketa_7 + "     " + anketa_8 + "     " + anketa_9 + "     " + anketa_11 + "        " + anketa_12 + "    " + anketa_13 + "    " + anketa_14 + "    " + anketa_15 + "    " + anketa_16 + "    " + anketa_18 + "    " + anketa_19 + "    " + anketa_20 + "    " + anketa_21 + "    " + anketa_22 + "    " + anketa_27 + "    " + anketa_28 + "    " + anketa_29 + "    " + anketa_30 + "    " + anketa_31);

                        dataBaseHandler4.AnketaInsert();
                    }
                } catch (NullPointerException e){
                    System.out.println(" ");
                }




            } catch (IOException | SQLException | ParseException e) {
                e.printStackTrace();
            }

        });

        Diversification_of_students_into_groups.setOnAction(actionEvent -> {
            try {
                App.setRoot("gui/Diversification_of_students_by_groups");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CreateGroup_Button.setOnAction(actionEvent -> {
            try {
                App.setRoot("gui/Creating_group");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        AddNewStudent_Button.setOnAction(actionEvent -> {
            try {
                App.setRoot("gui/add_student");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


    public String[] AnketaOfStudent(Row Row_) throws IOException {
        String[] anketa = new String[18];

        DataFormatter df = new DataFormatter();
        Cell cell;


        cell = Row_.getCell(4);
        anketa[0] =  df.formatCellValue(cell); //id FO

        cell = Row_.getCell(5);
        anketa[1] = cell.getStringCellValue(); //PIB UKR

        cell = Row_.getCell(6);
        anketa[2] = df.formatCellValue(cell); //BirthDay

        cell = Row_.getCell(8);
        anketa[3] = null_string_type(cell, df); //Series Of Passport

        cell = Row_.getCell(9);
        anketa[4] =  null_int_type(cell, df); //Number Of Passport

        cell = Row_.getCell(10);
        anketa[5] = df.formatCellValue(cell); //Date Of Passport

        cell = Row_.getCell(12);
        anketa[6] = null_string_type(cell, df); //Sex

        cell = Row_.getCell(13);
        anketa[7] = null_string_type(cell, df); //Citizenship

        cell = Row_.getCell(14);
        anketa[8] = null_string_type(cell, df); //PIB ENG

        cell = Row_.getCell(15);
        anketa[9] =  null_int_type(cell, df); //Identification Cod

        cell = Row_.getCell(18);
        anketa[10] = df.formatCellValue(cell); //Start Study

        cell = Row_.getCell(23);
        anketa[11] = null_string_type(cell, df); //Degree

        cell = Row_.getCell(25);
        anketa[12] = null_string_type(cell, df); //Type of study

        cell = Row_.getCell(26);
        anketa[13] = null_string_type(cell, df); //Financing

        cell = Row_.getCell(29);
        anketa[14] = null_string_type(cell, df); //Speciality

        cell = Row_.getCell(37);
        anketa[15] =  null_int_type(cell, df); //Social Status

        cell = Row_.getCell(50);
        anketa[16] = null_string_type(cell, df); //Document of education

        cell = Row_.getCell(53);
        anketa[17] = null_string_type(cell, df); //StudyBook

        return anketa;
    }

    public String null_string_type(Cell cell, DataFormatter df){
        String anketa;
        try {
            anketa = cell.getStringCellValue();
        } catch (NullPointerException e){
            anketa = "";
        } catch (IllegalStateException e){
            anketa = df.formatCellValue(cell);
        }
        return anketa;
    }
    public String null_int_type(Cell cell, DataFormatter df){
        String anketa;
        try {
            anketa = df.formatCellValue(cell);
        } catch (NullPointerException e){
            anketa = "";
        } return anketa;
    }
    private static String[] parsingFieldPIB(String field){
        String[] fields = new String[3];
        String[] temp = field.split(" ");
        for(int i = 0; i < fields.length; i++){
            if(temp.length <= i){
                fields[i] = "-";
            }
            else {
                fields[i] = temp[i];
            }
        }
        return fields;
    }

    private static String parsingField(String field){
        if(field.equals("")){
            return "-";
        }
        if (field.equals(" ")){
            return "-";
        }
        else {
            return field;
        }
    }

    private static String date(String field) throws ParseException {
        if (Objects.equals(field, "-")){
            return "-";
        }
        else{
            Date date_new = new SimpleDateFormat("MM/dd/yy").parse(field);
            return new SimpleDateFormat("dd.MM.yyyy").format(date_new);
        }
    }



}

