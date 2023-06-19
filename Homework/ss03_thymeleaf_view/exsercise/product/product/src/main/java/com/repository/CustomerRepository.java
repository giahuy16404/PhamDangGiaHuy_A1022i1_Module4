package com.repository;

import com.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> showList() {
        Connection connection = ConnectDB.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Customer> list = new ArrayList<>();
        if (connection != null){
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(QueryDB.SHOW_LIST_CUSTOMER);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    list.add(new Customer(id,name,email,address));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ConnectDB.close();
            }
        }
        return list;
    }

    @Override
    public boolean add(Customer customer) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement statement = null;
        if ( connection != null){
            try {
                statement = connection.prepareStatement(QueryDB.ADD_CUSTOMER);
                statement.setString(1,customer.getName());
                statement.setString(2,customer.getEmail());
                statement.setString(3,customer.getAddress());
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
    public boolean remove(int remove) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(QueryDB.REMOVE_CUSTOMER);
                statement.setInt(1,remove);
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
