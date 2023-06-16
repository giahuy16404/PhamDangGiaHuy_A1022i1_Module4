package com.model;

public class Symptom {
    private String yes;
    private String no;

    public Symptom(String yes, String no) {
        this.yes = yes;
        this.no = no;
    }

    public Symptom() {
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
