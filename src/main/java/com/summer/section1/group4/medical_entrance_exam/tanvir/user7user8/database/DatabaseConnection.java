package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String URL =
            "jdbc:sqlite:medical_entrance_exam.db";

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {

        Connection connection =
                DriverManager.getConnection(URL);

        System.out.println("Connected Database: " + URL);

        return connection;
    }
}