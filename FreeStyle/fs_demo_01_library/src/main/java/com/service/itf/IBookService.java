package com.service.itf;

import com.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
}
