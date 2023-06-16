package com.model;

public class EndDay {
    private String day;
    private String month;
    private String year;

    public EndDay(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public EndDay() {

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
