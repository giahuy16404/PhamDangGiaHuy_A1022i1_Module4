package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBlog;
    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false,referencedColumnName = "idUser")
    private User user;
    private String title;
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "idStatusBlog",nullable = false,referencedColumnName = "idStatusBlog")
    private StatusBlog statusBlog;

    @ManyToOne
    @JoinColumn(name = "idCategory",nullable = false,referencedColumnName = "idCategory")
    private Category category;

    public Blog() {
    }

    public Blog(int idBlog, User user, String title, String description, String content, StatusBlog statusBlog, Category category) {
        this.idBlog = idBlog;
        this.user = user;
        this.title = title;
        this.description = description;
        this.content = content;
        this.statusBlog = statusBlog;
        this.category = category;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StatusBlog getStatusBlog() {
        return statusBlog;
    }

    public void setStatusBlog(StatusBlog statusBlog) {
        this.statusBlog = statusBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
