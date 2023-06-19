package com.repository.itf;

import com.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBookRepository {
    List<Book> findAll();
}
