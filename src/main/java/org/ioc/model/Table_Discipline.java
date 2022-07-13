package org.ioc.model;

public class Table_Discipline {
    int IdDep, IdDisc;
    String NameUkr;

    public Table_Discipline(int IdDep, int IdDisc, String NameUkr) {
        this.IdDep = IdDep;
        this.IdDisc = IdDisc;
        this.NameUkr = NameUkr;
    }

    public int getIdDep() {
        return IdDep;
    }

    public int getIdDisc() {
        return IdDisc;
    }

    public String getNameUkr() {
        return NameUkr;
    }

    public void setIdDep(int idDep) {
        IdDep = idDep;
    }

    public void setIdDisc(int idDisc) {
        IdDisc = idDisc;
    }

    public void setNameUkr(String nameUkr) {
        NameUkr = nameUkr;
    }

    public String getNameOfDisc() {
        return null;
    }
}
