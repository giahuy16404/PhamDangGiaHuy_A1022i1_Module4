package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Category(int idCategory, String name, Set<Blog> blogs) {
        this.idCategory = idCategory;
        this.name = name;
        this.blogs = blogs;
    }

    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
