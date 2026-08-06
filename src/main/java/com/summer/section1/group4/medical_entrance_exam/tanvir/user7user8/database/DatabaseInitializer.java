package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInitializer {

    private DatabaseInitializer() {
    }

    public static void initializeDatabase() {

        createTables();
        addDocumentsVerifiedColumnIfMissing();
        insertDefaultUsers();

        System.out.println(
                "Database initialization completed."
        );
    }

    public static void createTables() {

        String usersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                )
                """;

        String candidatesTable = """
                CREATE TABLE IF NOT EXISTS candidates (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    roll TEXT NOT NULL UNIQUE,
                    gpa REAL NOT NULL,
                    status TEXT NOT NULL DEFAULT 'Pending',
                    documents_verified INTEGER NOT NULL DEFAULT 0
                )
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement()) {

            statement.execute(usersTable);
            System.out.println("Users table ready.");

            statement.execute(candidatesTable);
            System.out.println("Candidates table ready.");

        } catch (Exception e) {

            System.out.println(
                    "Database table creation failed."
            );

            e.printStackTrace();
        }
    }

    private static void addDocumentsVerifiedColumnIfMissing() {

        boolean columnExists = false;

        String checkSql =
                "PRAGMA table_info(candidates)";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement();

             ResultSet resultSet =
                     statement.executeQuery(checkSql)) {

            while (resultSet.next()) {

                String columnName =
                        resultSet.getString("name");

                if ("documents_verified"
                        .equalsIgnoreCase(columnName)) {

                    columnExists = true;
                    break;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Could not inspect candidates table."
            );

            e.printStackTrace();
            return;
        }

        if (columnExists) {

            System.out.println(
                    "documents_verified column already exists."
            );

            return;
        }

        String alterSql = """
                ALTER TABLE candidates
                ADD COLUMN documents_verified
                INTEGER NOT NULL DEFAULT 0
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement()) {

            statement.executeUpdate(alterSql);

            System.out.println(
                    "documents_verified column added."
            );

        } catch (Exception e) {

            System.out.println(
                    "Could not add documents_verified column."
            );

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

            System.out.println(
                    "Default users ready."
            );

        } catch (Exception e) {

            System.out.println(
                    "Default user insertion failed."
            );

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
}