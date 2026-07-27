package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {

        System.out.println("Testing SQLite database connection...");

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            if (connection != null && !connection.isClosed()) {

                System.out.println(
                        "SUCCESS: SQLite database connected."
                );

                System.out.println(
                        "Database URL: "
                                + connection.getMetaData().getURL()
                );

            } else {

                System.out.println(
                        "ERROR: Database connection was not created."
                );
            }

        } catch (SQLException exception) {

            System.out.println(
                    "ERROR: Could not connect to SQLite."
            );

            System.out.println(
                    "Reason: " + exception.getMessage()
            );

            exception.printStackTrace();
        }
    }
}
