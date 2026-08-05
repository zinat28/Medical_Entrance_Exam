package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database.DatabaseConnection;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {


    // Add candidate
    public void addCandidate(Candidate candidate) {

        String sql = """
                INSERT INTO candidates(name,email,phone,status)
                VALUES(?,?,?,?)
                """;

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getEmail());
            statement.setString(3, candidate.getPhone());
            statement.setString(4, candidate.getStatus());

            statement.executeUpdate();

            System.out.println("Candidate added successfully");

        } catch(Exception e){
            e.printStackTrace();
        }
    }



    // Get all candidates
    public List<Candidate> getAllCandidates(){

        List<Candidate> candidates = new ArrayList<>();

        String sql = "SELECT * FROM candidates";


        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql)){


            while(result.next()){

                Candidate candidate = new Candidate(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("phone"),
                        result.getString("status")
                );

                candidates.add(candidate);
            }


        }catch(Exception e){
            e.printStackTrace();
        }


        return candidates;
    }



    // Update candidate status

    public void updateStatus(int id,String status){

        String sql =
                "UPDATE candidates SET status=? WHERE id=?";


        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setString(1,status);
            statement.setInt(2,id);

            statement.executeUpdate();


            System.out.println("Candidate status updated");


        }catch(Exception e){
            e.printStackTrace();
        }

    }



    // Delete candidate

    public void deleteCandidate(int id){

        String sql =
                "DELETE FROM candidates WHERE id=?";


        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setInt(1,id);

            statement.executeUpdate();


            System.out.println("Candidate deleted");


        }catch(Exception e){
            e.printStackTrace();
        }

    }

}