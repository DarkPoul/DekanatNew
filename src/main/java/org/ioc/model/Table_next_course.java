package org.ioc.model;

public class Table_next_course {
    String P, I, B;

    public Table_next_course(String P, String I, String B){
        this.P = P;
        this.I = I;
        this.B = B;
    }

    public String getP() {
        return P;
    }

    public void setP(String p) {
        P = p;
    }

    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }
}
