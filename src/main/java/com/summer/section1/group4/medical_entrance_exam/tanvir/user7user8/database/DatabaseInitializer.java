package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseInitializer {


    // ===============================
    // Create Database Tables
    // ===============================

    public static void createTables() {


        String usersTable = """
                CREATE TABLE IF NOT EXISTS users(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                );
                """;


        String candidatesTable = """
                CREATE TABLE IF NOT EXISTS candidates(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    email TEXT UNIQUE,
                    phone TEXT,
                    status TEXT DEFAULT 'Pending'
                );
                """;


        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement()) {


            statement.execute(usersTable);
            System.out.println("Users table created");


            statement.execute(candidatesTable);
            System.out.println("Candidates table created");


        } catch(Exception e){

            e.printStackTrace();

        }

    }



    // ===============================
    // Insert Default Users
    // ===============================

    public static void insertDefaultUsers(){


        String sql = """
                INSERT OR IGNORE INTO users
                (username,password,role)
                VALUES(?,?,?)
                """;


        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql)){



            createUser(statement,
                    "medical_officer",
                    "1234",
                    "Medical Officer");


            createUser(statement,
                    "director",
                    "1234",
                    "Director");



            System.out.println("Default users inserted");



        }catch(Exception e){

            e.printStackTrace();

        }

    }



    private static void createUser(
            PreparedStatement statement,
            String username,
            String password,
            String role
    ) throws Exception{


        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, role);

        statement.executeUpdate();

    }




    // ===============================
    // Insert Sample Candidates
    // ===============================


    public static void insertDefaultCandidates(){


        String sql = """
                INSERT OR IGNORE INTO candidates
                (name,email,phone,status)
                VALUES
                ('Rahim Ahmed',
                 'rahim@gmail.com',
                 '01711111111',
                 'Pending'),

                ('Karim Hasan',
                 'karim@gmail.com',
                 '01822222222',
                 'Pending'),

                ('Nusrat Jahan',
                 'nusrat@gmail.com',
                 '01933333333',
                 'Approved');
                """;



        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement()){


            statement.execute(sql);


            System.out.println("Default candidates inserted");


        }catch(Exception e){

            e.printStackTrace();

        }

    }




    // ===============================
    // Run All Initialization
    // ===============================


    public static void initializeDatabase(){

        System.out.println("Starting database initialization...");


        createTables();

        insertDefaultUsers();

        insertDefaultCandidates();


        System.out.println(
                "Database initialization completed successfully."
        );

    }


}