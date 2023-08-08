package com.example.shop.model.account;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(unique = true)
    private String username;
    private String password;

    public AppUser(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public AppUser() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}