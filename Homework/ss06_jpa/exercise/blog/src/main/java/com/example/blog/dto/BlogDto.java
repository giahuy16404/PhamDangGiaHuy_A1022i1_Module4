package com.example.blog.dto;

import com.example.blog.model.Category;
import com.example.blog.model.StatusBlog;
import com.example.blog.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BlogDto implements Validator {
    private int idBlog;
    private int idUser;
    private String title;
    private String description;
    private String content;
    private StatusBlog statusBlog;

    private Category category;

    public BlogDto(int idBlog, int idUser, String title, String description, String content, StatusBlog statusBlog, Category category) {
        this.idBlog = idBlog;
        this.idUser = idUser;
        this.title = title;
        this.description = description;
        this.content = content;
        this.statusBlog = statusBlog;
        this.category = category;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public BlogDto() {
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
