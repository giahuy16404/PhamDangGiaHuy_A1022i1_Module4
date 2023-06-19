package com.model;

public class Student {
    private int idStudent;
    private String nameStudent;
    private String classStudent;

    public Student() {
    }

    public Student(int idStudent, String nameStudent, String classStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.classStudent = classStudent;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }
}
