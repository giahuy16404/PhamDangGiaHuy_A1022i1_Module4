package com.repository.itf;

import com.model.Author;

import java.util.List;

public interface IAuthorRepository {
    boolean create(Author author);
    List<Author> findAll();

    boolean edit(Author author);
    boolean remove(int id);
}
