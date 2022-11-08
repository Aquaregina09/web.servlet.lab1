package com.webshoppe.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.webshoppe.ecommerce.config.AppConfiguration;

public class JdbcConnectionManager {

    public JdbcConnectionManager() {
        try {
            Class.forName(AppConfiguration.getString("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            final Connection connection = DriverManager.getConnection(AppConfiguration.getString("jdbc.url"),
                                                                      AppConfiguration.getString("jdbc.username"),
                                                                      AppConfiguration.getString("jdbc.password"));
            return connection;
        } catch (SQLException e) {
            throw e;
        }
    }

}
