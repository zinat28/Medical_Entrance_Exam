package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseInitializer {

    private DatabaseInitializer() {
        // Prevent creation of objects from this utility class.
    }

    public static void initializeDatabase() {

        createUsersTable();
        createCandidatesTable();
        createMedicalDocumentsTable();
        createVerificationRecordsTable();

        System.out.println("Database initialization completed successfully.");
    }

    private static void createUsersTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    full_name TEXT NOT NULL,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL,
                    account_status TEXT NOT NULL DEFAULT 'ACTIVE',
                    created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
                );
                """;

        executeTableCreation(sql, "users");
    }

    private static void createCandidatesTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS candidates (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    application_id TEXT NOT NULL UNIQUE,
                    full_name TEXT NOT NULL,
                    father_name TEXT,
                    mother_name TEXT,
                    date_of_birth TEXT,
                    gender TEXT,
                    mobile_number TEXT,
                    email TEXT,
                    ssc_gpa REAL,
                    hsc_gpa REAL,
                    medical_status TEXT NOT NULL DEFAULT 'PENDING',
                    created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
                );
                """;

        executeTableCreation(sql, "candidates");
    }

    private static void createMedicalDocumentsTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS medical_documents (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    candidate_id INTEGER NOT NULL,
                    document_type TEXT NOT NULL,
                    file_name TEXT NOT NULL,
                    file_path TEXT NOT NULL,
                    document_format TEXT,
                    document_status TEXT NOT NULL DEFAULT 'PENDING',
                    is_complete INTEGER NOT NULL DEFAULT 0,
                    uploaded_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
                    verified_by INTEGER,
                    verified_at TEXT,

                    FOREIGN KEY (candidate_id)
                        REFERENCES candidates(id)
                        ON DELETE CASCADE,

                    FOREIGN KEY (verified_by)
                        REFERENCES users(id)
                        ON DELETE SET NULL
                );
                """;

        executeTableCreation(sql, "medical_documents");
    }

    private static void createVerificationRecordsTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS verification_records (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    candidate_id INTEGER NOT NULL,
                    document_id INTEGER,
                    medical_officer_id INTEGER NOT NULL,
                    decision TEXT NOT NULL,
                    remarks TEXT,
                    previous_status TEXT,
                    new_status TEXT,
                    verification_date TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,

                    FOREIGN KEY (candidate_id)
                        REFERENCES candidates(id)
                        ON DELETE CASCADE,

                    FOREIGN KEY (document_id)
                        REFERENCES medical_documents(id)
                        ON DELETE SET NULL,

                    FOREIGN KEY (medical_officer_id)
                        REFERENCES users(id)
                        ON DELETE RESTRICT
                );
                """;

        executeTableCreation(sql, "verification_records");
    }

    private static void executeTableCreation(
            String sql,
            String tableName
    ) {

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                Statement statement =
                        connection.createStatement()
        ) {

            statement.execute(sql);

            System.out.println(
                    "SUCCESS: " + tableName + " table is ready."
            );

        } catch (SQLException exception) {

            System.out.println(
                    "ERROR: Could not create "
                            + tableName
                            + " table."
            );

            System.out.println(
                    "Reason: " + exception.getMessage()
            );

            exception.printStackTrace();
        }
    }
}
