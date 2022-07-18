package org.ioc.model;

public class Table_Discipline {
    int IdDisc;
    String NameUkr, IdDep;

    public Table_Discipline(int IdDep, int IdDisc, String NameUkr) {
        this.IdDep = String.valueOf(IdDep);
        this.IdDisc = IdDisc;
        this.NameUkr = NameUkr;
    }

    public String getIdDep() {
        return IdDep;
    }

    public int getIdDisc() {
        return IdDisc;
    }

    public String getNameUkr() {
        return NameUkr;
    }

    public void setIdDep(int idDep) {
        IdDep = String.valueOf(idDep);
    }

    public void setIdDisc(int idDisc) {
        IdDisc = idDisc;
    }

    public void setNameUkr(String nameUkr) {
        NameUkr = nameUkr;
    }

}
