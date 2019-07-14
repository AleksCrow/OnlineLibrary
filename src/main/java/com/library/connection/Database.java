package com.library.connection;
import java.sql.*;

public class Database {

    private static Connection connection;

    public static Connection getConnection() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
            }
        } catch (SQLException e) {
            System.out.println("Чтото с драйвером");
            e.printStackTrace();
        }
        return connection;
    }
}
