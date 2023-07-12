package com.example.furama.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
    @Id
    @ManyToOne
    @JoinColumn(name = "id",nullable = false,referencedColumnName = "id" )
    private Role role;
    @ManyToOne
    @JoinColumn(name = "userName",nullable = false,referencedColumnName = "userName" )
    private User user;

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public UserRole() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role=" + role +
                ", user=" + user +
                '}';
    }
}
