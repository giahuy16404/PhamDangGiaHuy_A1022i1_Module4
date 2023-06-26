package com.service.itf;

import com.model.Author;

import java.util.List;

public interface IAuthorService {
    boolean create(Author author);
    int showMaxId();

    List<Author> findAll();

    boolean edit(Author author);
    boolean remove(int id);
}
