package com.service;

import com.model.Book;
import com.repository.ConnectDB;
import com.repository.QueryDB;
import com.repository.itf.IBookRepository;
import com.service.itf.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> list = iBookRepository.findAll();
        return list;
    }
}
