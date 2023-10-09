package com.example.furama.dto.acountDto;

import com.example.furama.model.account.AppRole;

import java.util.List;

public class UserRoleDto {
    private long id;
    private String username;
    private String password;
    private AppRole role;

    private String gmail;

    public UserRoleDto(long id, String username, String password, AppRole role, String gmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public UserRoleDto() {
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

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole roleList) {
        this.role = roleList;
    }
}
