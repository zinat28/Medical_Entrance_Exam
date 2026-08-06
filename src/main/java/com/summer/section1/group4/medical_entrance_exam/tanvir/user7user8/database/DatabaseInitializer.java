package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void createUsersTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                )
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();
             Statement statement =
                     connection.createStatement()) {

            statement.execute(sql);

            System.out.println("Users table created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recreateCandidatesTable() {

        String dropTable = """
                DROP TABLE IF EXISTS candidates
                """;

        String createTable = """
                CREATE TABLE candidates (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    roll TEXT NOT NULL UNIQUE,
                    gpa REAL NOT NULL,
                    status TEXT NOT NULL DEFAULT 'Pending'
                )
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();
             Statement statement =
                     connection.createStatement()) {

            statement.execute(dropTable);

            System.out.println("Old candidates table removed");

            statement.execute(createTable);

            System.out.println("New candidates table created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertDefaultUsers() {

        String sql = """
                INSERT OR IGNORE INTO users
                (username, password, role)
                VALUES (?, ?, ?)
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            insertUser(
                    statement,
                    "medical_officer",
                    "1234",
                    "medical_officer"
            );

            insertUser(
                    statement,
                    "director",
                    "1234",
                    "director"
            );

            System.out.println("Default users inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertUser(
            PreparedStatement statement,
            String username,
            String password,
            String role
    ) throws Exception {

        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, role);

        statement.executeUpdate();
    }

    public static void initializeDatabase() {

        System.out.println(
                "Starting database table initialization..."
        );

        createUsersTable();

        recreateCandidatesTable();

        insertDefaultUsers();

        System.out.println(
                "Database table initialization completed."
        );
    }
}