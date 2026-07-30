package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database.DatabaseConnection;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User login(String username, String password) {

        String query = "SELECT * FROM users WHERE username=? AND password=?";


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setString(1, username);
            stmt.setString(2, password);


            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {

                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );

            }


        } catch (Exception e) {

            e.printStackTrace();

        }


        return null;

    }



    // Get user information by username
    public User getUserByUsername(String username) {


        String query = "SELECT * FROM users WHERE username=?";


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setString(1, username);


            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {


                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );

            }


        } catch (Exception e) {

            e.printStackTrace();

        }


        return null;

    }



    // Add new user
    public boolean addUser(User user) {


        String query =
                "INSERT INTO users(username,password,role) VALUES(?,?,?)";


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());


            int rows = stmt.executeUpdate();


            return rows > 0;


        } catch(Exception e) {

            e.printStackTrace();

        }


        return false;

    }



    // Delete user
    public boolean deleteUser(int id) {


        String query = "DELETE FROM users WHERE id=?";


        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setInt(1,id);


            return stmt.executeUpdate() > 0;


        } catch(Exception e){

            e.printStackTrace();

        }


        return false;

    }



    // Update password
    public boolean updatePassword(int id, String newPassword) {


        String query =
                "UPDATE users SET password=? WHERE id=?";


        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setString(1,newPassword);
            stmt.setInt(2,id);


            return stmt.executeUpdate() > 0;


        }catch(Exception e){

            e.printStackTrace();

        }


        return false;

    }

}