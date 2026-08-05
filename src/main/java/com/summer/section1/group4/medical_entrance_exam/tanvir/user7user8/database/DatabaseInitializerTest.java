package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;


public class DatabaseInitializerTest {

    public static void main(String[] args) {

        System.out.println(
                "Starting database table initialization..."
        );


        DatabaseInitializer.createTables();

        DatabaseInitializer.insertDefaultUsers();


        System.out.println(
                "Database table test completed."
        );
    }
}