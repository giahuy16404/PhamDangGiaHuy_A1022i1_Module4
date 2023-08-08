package com.example.shop.model.account;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserRole_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    private AppRole appRole;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private AppUser appUser;

    public UserRole(Long id, AppRole appRole, AppUser appUser) {
        this.id = id;
        this.appRole = appRole;
        this.appUser = appUser;
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "UserRoleKey{" +
                "role=" + appRole +
                ", user=" + appUser +
                '}';
    }
}
