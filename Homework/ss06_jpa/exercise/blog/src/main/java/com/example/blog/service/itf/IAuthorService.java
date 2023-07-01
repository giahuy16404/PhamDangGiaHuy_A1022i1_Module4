package com.example.blog.service.itf;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.model.StatusBlog;

import java.util.List;

public interface IAuthorService {
    boolean create(Author author);
    int showMaxId();
    boolean update(Author author);

    List<Author> findAll();

    boolean edit(Author author);
    boolean remove(int id);
    boolean delete(int id);


}
