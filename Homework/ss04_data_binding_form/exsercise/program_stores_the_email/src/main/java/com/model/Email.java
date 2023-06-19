package com.model;

public class Email {
    private int idEmail;
    private String Language;
    private String pageSize;
    private String spamFilter;
    private String signature;

    public Email(int idEmail, String language, String pageSize, String spamFilter, String signature) {
        this.idEmail = idEmail;
        Language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public Email() {
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(String spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "idEmail=" + idEmail +
                ", Language='" + Language + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", spamFilter='" + spamFilter + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}