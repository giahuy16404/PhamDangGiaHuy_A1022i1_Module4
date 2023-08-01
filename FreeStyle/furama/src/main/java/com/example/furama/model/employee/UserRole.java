package com.example.furama.model.employee;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    private AppRole appRole;
    @ManyToOne
    @JoinColumn(name = "userName", nullable = false, referencedColumnName = "userName")
    private AppUser appUser;

    public UserRole(long id, AppRole appRole, AppUser appUser) {
        this.id = id;
        this.appRole = appRole;
        this.appUser = appUser;
    }

    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppRole getRole() {
        return appRole;
    }

    public void setRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role=" + appRole +
                ", user=" + appUser +
                '}';
    }
}
