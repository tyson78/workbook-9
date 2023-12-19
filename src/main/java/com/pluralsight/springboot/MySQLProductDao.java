package com.pluralsight.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component @Qualifier("mysql")
public class MySQLProductDao implements ProductDao {
    Connection connection;

    @Autowired
    public MySQLProductDao(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                            SELECT * FROM Products
                            """
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                productList.add(new Product(resultSet.getInt("ProductID"),
                        resultSet.getString("ProductName"),
                        resultSet.getString("CategoryID"),
                        resultSet.getDouble("UnitPrice")
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
