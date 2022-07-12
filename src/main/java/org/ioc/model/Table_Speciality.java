package org.ioc.model;

public class Table_Speciality {
    int IdSpec;
    String NameSpec;


    public Table_Speciality(int IdSpec, String NameSpec) {
        this.IdSpec = IdSpec;
        this.NameSpec = NameSpec;
    }

    public int getIdSpec() {
        return IdSpec;
    }

    public String getNameSpec() {
        return NameSpec;
    }

    public void setIdSpec(int idSpec) {
        IdSpec = idSpec;
    }

    public void setNameSpec(String nameSpec) {
        NameSpec = nameSpec;
    }
}
