package com.model;

public class Borrowing {
    private int idBorrowing;
    private Book book;
    private Student student;
    private boolean statusBorrowing;
    private String starBorrowing;
    private String endBorrowing;

    public Borrowing(int idBorrowing, Book book, Student student,
                     boolean statusBorrowing, String starBorrowing, String endBorrowing) {
        this.idBorrowing = idBorrowing;
        this.book = book;
        this.student = student;
        this.statusBorrowing = statusBorrowing;
        this.starBorrowing = starBorrowing;
        this.endBorrowing = endBorrowing;
    }

    public Borrowing() {
    }

    public int getIdBorrowing() {
        return idBorrowing;
    }

    public void setIdBorrowing(int idBorrowing) {
        this.idBorrowing = idBorrowing;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean getStatusBorrowing() {
        return statusBorrowing;
    }

    public void setStatusBorrowing(boolean statusBorrowing) {
        this.statusBorrowing = statusBorrowing;
    }

    public String getStarBorrowing() {
        return starBorrowing;
    }

    public void setStarBorrowing(String starBorrowing) {
        this.starBorrowing = starBorrowing;
    }

    public String getEndBorrowing() {
        return endBorrowing;
    }

    public void setEndBorrowing(String endBorrowing) {
        this.endBorrowing = endBorrowing;
    }
}
