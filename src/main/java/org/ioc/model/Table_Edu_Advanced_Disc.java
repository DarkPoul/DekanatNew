package org.ioc.model;

import javafx.scene.control.*;

public class Table_Edu_Advanced_Disc {

    CheckBox Disc_CheckBox;
    String Disc_String;

    public Table_Edu_Advanced_Disc(String SS){
        this.Disc_CheckBox = new CheckBox();
        this.Disc_String = SS;
    }

    public CheckBox getDisc_CheckBox() {
        return Disc_CheckBox;
    }

    public void setDisc_CheckBox(CheckBox disc_CheckBox) {
        Disc_CheckBox = disc_CheckBox;
    }

    public String getDisc_String() {
        return Disc_String;
    }

    public void setDisc_String(String disc_String) {
        Disc_String = disc_String;
    }
}
