package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserTableTest {

    public static void main(String[] args) {

        String sql = "SELECT * FROM users";


        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery(sql)
        ) {


            boolean found = false;


            while(resultSet.next()) {

                found = true;

                System.out.println("-------------------");

                System.out.println(
                        "ID: "
                                + resultSet.getInt("id")
                );

                System.out.println(
                        "Username: "
                                + resultSet.getString("username")
                );

                System.out.println(
                        "Password: "
                                + resultSet.getString("password")
                );

                System.out.println(
                        "Role: "
                                + resultSet.getString("role")
                );
            }


            if(!found){

                System.out.println(
                        "No users found in database"
                );

            }


        } catch(Exception e){

            e.printStackTrace();

        }

    }
}