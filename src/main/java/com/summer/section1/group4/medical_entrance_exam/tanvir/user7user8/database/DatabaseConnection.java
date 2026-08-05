package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseConnection {

    private static final String DATABASE_URL =
            "jdbc:sqlite:medical_entrance_exam.db";


    private DatabaseConnection() {
        // Prevent object creation
    }


    public static Connection getConnection() throws SQLException {

        Connection connection =
                DriverManager.getConnection(DATABASE_URL);

        System.out.println(
                "Connected Database: "
                        + connection.getMetaData().getURL()
        );


        // Enable foreign key support
        try (Statement statement = connection.createStatement()) {

            statement.execute(
                    "PRAGMA foreign_keys = ON"
            );
        }


        return connection;
    }
}