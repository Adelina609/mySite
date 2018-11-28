package ru.kpfu.itis1.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionBuilder {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "123456";
        return DriverManager.getConnection(url, login, password);
    }
}
