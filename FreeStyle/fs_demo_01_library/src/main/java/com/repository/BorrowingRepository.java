package com.repository;

import com.model.Book;
import com.model.Borrowing;
import com.model.Student;
import com.repository.itf.IBorrowingRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BorrowingRepository implements IBorrowingRepository {
    @Override
    public boolean add(Borrowing borrowing) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(QueryDB.INSERT_INTO_BORROWING);
                statement.setInt(1,borrowing.getBook().getIdBook());
                statement.setInt(2,borrowing.getStudent().getIdStudent());
                statement.setBoolean(3,borrowing.getStatusBorrowing());
                statement.setString(4,borrowing.getStarBorrowing());
                statement.setString(5,borrowing.getEndBorrowing());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ConnectDB.close();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Borrowing> findAll() {
        Connection connection = ConnectDB.getConnection();
        List<Borrowing> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(QueryDB.SELECT_BORROWING);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_borrowing");
                    String name = resultSet.getString("name_book");
                    String tacGia = resultSet.getString("author_book");
                    String tenHocSinh = resultSet.getString("name_student");
                    String lop = resultSet.getString("class_student");
                    String starDate = resultSet.getString("star_borrowing");
                    String endDate = resultSet.getString("end_borrowing");
                    Student student = new Student();
                    Book book = new Book();
                    student.setNameStudent(tenHocSinh);
                    student.setClassStudent(lop);
                    book.setNameBook(name);
                    book.setAuthorBook(tacGia);
                    list.add(new Borrowing(id,book,student,true,starDate,endDate));
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
