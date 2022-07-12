package org.ioc.model;

import javafx.scene.control.CheckBox;

public class Table_Edu_Advanced_Student {

    CheckBox Student_Check;
    String Student_String;

    public Table_Edu_Advanced_Student(String SS){
        this.Student_Check = new CheckBox();
        this.Student_String = SS;
    }

    public CheckBox getStudent_Check() {
        return Student_Check;
    }

    public void setStudent_Check(CheckBox student_Check) {
        Student_Check = student_Check;
    }

    public String getStudent_String() {
        return Student_String;
    }

    public void setStudent_String(String student_String) {
        Student_String = student_String;
    }
}
