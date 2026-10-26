package com.placementhub.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = getEnv(
            "DB_URL",
            "jdbc:mysql://localhost:3306/placementhub"
    );

    private static final String USER = getEnv("DB_USER", "root");

    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    private static String getEnv(String name, String defaultValue) {
        String value = System.getenv(name);
        return (value == null || value.isBlank())
                ? defaultValue
                : value;
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.", e);
        }

        if (PASSWORD == null) {
            throw new SQLException(
                    "DB_PASSWORD environment variable is not configured."
            );
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}