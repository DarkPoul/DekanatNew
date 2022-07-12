package org.ioc.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Objects;

public class Table_Edu {

    public String NameOfDiscipline, NumberOfDiscipline;
    public CheckBox Zalik, Exam, KR, KP, D_Zalik;
    public TextField KF, HH;
    public ChoiceBox<String> RGR;

    public Table_Edu(String NameOfDiscipline) {
        ObservableList<String> six = FXCollections.observableArrayList("4", "6", "-");
        this.NameOfDiscipline = NameOfDiscipline;
        this.HH = new TextField();
        this.HH.setAlignment(Pos.CENTER);

        this.Zalik = new CheckBox();
        Zalik.setOnAction(actionEvent -> {
            if (Zalik.isSelected()){
                Exam.setVisible(false);
                D_Zalik.setVisible(false);
            } else {
                Exam.setVisible(true);
                D_Zalik.setVisible(true);
            }
        });


        this.Exam = new CheckBox();
        Exam.setOnAction(actionEvent -> {
            if (Exam.isSelected()){
                Zalik.setVisible(false);
                D_Zalik.setVisible(false);
            } else {
                Zalik.setVisible(true);
                D_Zalik.setVisible(true);
            }
        });

        this.D_Zalik = new CheckBox();
        D_Zalik.setOnAction(actionEvent -> {
            if (D_Zalik.isSelected()){
                Zalik.setVisible(false);
                Exam.setVisible(false);
            } else {
                Zalik.setVisible(true);
                Exam.setVisible(true);
            }
        });

        this.RGR = new ChoiceBox<>();
        this.RGR.setValue("-");
        this.RGR.setItems(six);
        RGR.setOnAction(actionEvent -> {
            if (!Objects.equals(RGR.getValue(), "-")){
                KR.setVisible(false);
                KP.setVisible(false);
            } else {
                KR.setVisible(true);
                KP.setVisible(true);
            }
        });

        this.KR = new CheckBox();
        KR.setOnAction(actionEvent -> {
            if (KR.isSelected()){
                KP.setVisible(false);
                RGR.setVisible(false);
            } else {
                KP.setVisible(true);
                RGR.setVisible(true);
            }
        });

        this.KP = new CheckBox();
        KP.setOnAction(actionEvent -> {
            if (KP.isSelected()){
                KR.setVisible(false);
                RGR.setVisible(false);
            } else {
                KR.setVisible(true);
                RGR.setVisible(true);
            }
        });

        this.KF = new TextField();
        this.KF.setAlignment(Pos.CENTER);
        this.KF.setText("");
        this.NumberOfDiscipline = "1";
    }

    public String getNumberOfDiscipline() {
        return NumberOfDiscipline;
    }

    public void setNumberOfDiscipline(String numberOfDiscipline) {
        NumberOfDiscipline = numberOfDiscipline;
    }

    public String getNameOfDiscipline() {
        return NameOfDiscipline;
    }

    public void setNameOfDiscipline(String nameOfDiscipline) {
        NameOfDiscipline = nameOfDiscipline;
    }

    public TextField getHH() {
        return HH;
    }

    public void setHH(TextField HH) {
        this.HH = HH;
    }

    public CheckBox getZalik() {
        return Zalik;
    }

    public void setZalik(CheckBox zalik) {
        Zalik = zalik;
    }

    public CheckBox getExam() {
        return Exam;
    }

    public void setExam(CheckBox exam) {
        Exam = exam;
    }

    public ChoiceBox<String> getRGR() {
        return RGR;
    }

    public void setRGR(ChoiceBox<String> RGR) {
        this.RGR = RGR;
    }

    public CheckBox getKR() {
        return KR;
    }

    public void setKR(CheckBox KR) {
        this.KR = KR;
    }

    public CheckBox getKP() {
        return KP;
    }

    public void setKP(CheckBox KP) {
        this.KP = KP;
    }

    public CheckBox getD_Zalik() {
        return D_Zalik;
    }

    public void setD_Zalik(CheckBox d_Zalik) {
        D_Zalik = d_Zalik;
    }

    public TextField getKF() {
        return KF;
    }

    public void setKF(TextField KF) {
        this.KF = KF;
    }
}