package com.example.furama.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppUser {
    @Id
    private String userName;
    private String passWord;
    public AppUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    public AppUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
