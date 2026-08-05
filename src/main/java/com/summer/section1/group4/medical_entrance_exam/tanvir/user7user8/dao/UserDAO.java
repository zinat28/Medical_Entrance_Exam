package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;


import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database.DatabaseConnection;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserDAO {


    public User login(
            String username,
            String password){



        String sql =
                "SELECT * FROM users WHERE username=? AND password=?";



        try(Connection connection =
                    DatabaseConnection.getConnection();


            PreparedStatement statement =
                    connection.prepareStatement(sql)){



            statement.setString(1,username);

            statement.setString(2,password);



            ResultSet result =
                    statement.executeQuery();



            if(result.next()){


                return new User(

                        result.getInt("id"),

                        result.getString("username"),

                        result.getString("password"),

                        result.getString("role")

                );

            }



        }
        catch(Exception e){

            e.printStackTrace();

        }


        return null;

    }

}