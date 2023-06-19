package com.repository;

import com.model.Book;
import com.model.Student;
import com.repository.itf.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        Connection connection = ConnectDB.getConnection();
        List<Student> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(QueryDB.SELECT_STUDENT);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_student");
                    String name = resultSet.getString("name_student");
                    String classStudent = resultSet.getString("class_student");

                    list.add(new Student(id, name, classStudent));
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
