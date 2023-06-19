package com.repository;

import com.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> showList() {
        Connection connection = ConnectDB.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Product> list = new ArrayList<>();
        if (connection != null){
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(QueryDB.SHOW_LIST_PRODUCT);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("price");
                    String address = resultSet.getString("quantity");
                    list.add(new Product(id,name,email,address));
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
    public boolean add(Product product) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement statement = null;
        if ( connection != null){
            try {
                statement = connection.prepareStatement(QueryDB.ADD_PRODUCT);
                statement.setString(1, product.getName());
                statement.setString(2, product.getPrice());
                statement.setString(3, product.getQuantity());
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
                statement = connection.prepareStatement(QueryDB.REMOVE_PRODUCT);
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
