package com.repository;

import com.model.Book;
import com.repository.itf.IBookRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository {
    @Override
    public List<Book> findAll() {
        Connection connection = ConnectDB.getConnection();
        List<Book> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(QueryDB.SELECT_BOOK);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_Book");
                    String name = resultSet.getString("name_book");
                    String author = resultSet.getString("author_book");
                    String describe = resultSet.getString("describe_book");
                    int quantity = resultSet.getInt("quanlity");
                    list.add(new Book(id, name, author, describe, quantity));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ConnectDB.close();
            }
        }
        return list;
    }
}
