package org.ioc.model;

public class Table_Education {
    String NameProgram, ShortName, Qualifications;

    public Table_Education(String NameProgram, String ShortName, String Qualifications) {
        this.NameProgram = NameProgram;
        this.ShortName = ShortName;
        this.Qualifications = Qualifications;
    }

    public String getNameProgram() {
        return NameProgram;
    }

    public String getShortName() {
        return ShortName;
    }

    public String getQualifications() {
        return Qualifications;
    }

    public void setNameProgram(String nameProgram) {
        NameProgram = nameProgram;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public void setQualifications(String qualifications) {
        Qualifications = qualifications;
    }
}
