package com.repository;

import com.model.Borrowing;
import com.repository.itf.IBorrowingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                statement.setString(3,borrowing.getStatusBorrowing());
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
}
