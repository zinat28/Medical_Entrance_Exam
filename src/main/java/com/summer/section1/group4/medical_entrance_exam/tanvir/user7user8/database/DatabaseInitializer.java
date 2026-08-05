package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void createTables() {

        String sql = """
                CREATE TABLE IF NOT EXISTS users(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                );
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);

            System.out.println("Users table created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertDefaultUsers() {

        String sql = """
                INSERT OR IGNORE INTO users
                (username, password, role)
                VALUES(?,?,?)
                """;


        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            createUser(statement,
                    "medical officer",
                    "1234",
                    "medical officer");


            createUser(statement,
                    "director",
                    "1234",
                    "director");


            createUser(statement,
                    "candidate",
                    "1234",
                    "candidate");


            System.out.println("Default users inserted");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void createUser(PreparedStatement statement,
                                   String username,
                                   String password,
                                   String role) throws Exception {


        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, role);

        statement.executeUpdate();
    }
}