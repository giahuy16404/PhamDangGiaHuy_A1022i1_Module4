package com.example.blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBlog;
    @OneToOne()
    @JoinColumn(name = "idAuthor",nullable = false,referencedColumnName = "idAuthor")
    private Author author;
    private String title;
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @OneToOne
    @JoinColumn(name = "idStatusBlog",nullable = false,referencedColumnName = "idStatusBlog")
    private StatusBlog statusBlog;

    @ManyToOne
    @JoinColumn(name = "idCategory",nullable = false,referencedColumnName = "idCategory")
    private Category category;

    public Blog() {
    }

    public Blog(int idBlog, Author author, String title, String description, String content, StatusBlog statusBlog, Category category) {
        this.idBlog = idBlog;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
