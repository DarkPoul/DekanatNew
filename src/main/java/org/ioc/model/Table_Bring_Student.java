package org.ioc.model;

import javafx.scene.control.CheckBox;

public class Table_Bring_Student {
    String LastName, FirstName, SurName, IdFO;
    CheckBox Select;
    public Table_Bring_Student(String IdF, String SN, String FN, String LN){
        this.IdFO = IdF;
        this.SurName = SN;
        this.FirstName = FN;
        this.LastName = LN;
        this.Select = new CheckBox();
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getIdFO() {
        return IdFO;
    }

    public void setIdFO(String idFO) {
        IdFO = idFO;
    }

    public CheckBox getSelect() {
        return Select;
    }

    public void setSelect(CheckBox select) {
        this.Select = select;
    }
}
