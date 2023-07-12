package com.example.furama.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;
    private String passWord;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    public User(String userName, String passWord, Set<UserRole> userRoles) {
        this.userName = userName;
        this.passWord = passWord;
        this.userRoles = userRoles;
    }
    public User() {
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
