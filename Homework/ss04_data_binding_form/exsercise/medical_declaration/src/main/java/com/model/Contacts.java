package com.model;

import org.springframework.context.annotation.Bean;

public class Contacts {
    private String tinh;
    private String quan;
    private String phuong;

    public Contacts() {
    }

    public Contacts(String tinh, String quan, String phuong) {
        this.tinh = tinh;
        this.quan = quan;
        this.phuong = phuong;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }
}
