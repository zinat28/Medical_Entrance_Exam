package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database.DatabaseConnection;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    // Add candidate
    public boolean addCandidate(Candidate candidate) {

        String sql = """
                INSERT INTO candidates(name, roll, gpa, status)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getRoll());
            statement.setDouble(3, candidate.getGpa());
            statement.setString(4, candidate.getStatus());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Candidate added successfully");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Candidate insertion failed");
            e.printStackTrace();
        }

        return false;
    }

    // Get all candidates
    public List<Candidate> getAllCandidates() {

        List<Candidate> candidateList = new ArrayList<>();

        String sql = """
                SELECT id, name, roll, gpa, status
                FROM candidates
                ORDER BY id ASC
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Candidate candidate = new Candidate(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("roll"),
                        resultSet.getDouble("gpa"),
                        resultSet.getString("status")
                );

                candidateList.add(candidate);
            }

        } catch (Exception e) {
            System.out.println("Failed to load candidates");
            e.printStackTrace();
        }

        return candidateList;
    }

    // Update complete candidate information
    public boolean updateCandidate(Candidate candidate) {

        String sql = """
                UPDATE candidates
                SET name = ?,
                    roll = ?,
                    gpa = ?,
                    status = ?
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getRoll());
            statement.setDouble(3, candidate.getGpa());
            statement.setString(4, candidate.getStatus());
            statement.setInt(5, candidate.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Candidate updated successfully");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Candidate update failed");
            e.printStackTrace();
        }

        return false;
    }

    // Update candidate status only
    public boolean updateStatus(int candidateId, String status) {

        String sql = """
                UPDATE candidates
                SET status = ?
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, candidateId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Candidate status updated");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Candidate status update failed");
            e.printStackTrace();
        }

        return false;
    }

    // Delete candidate
    public boolean deleteCandidate(int candidateId) {

        String sql = """
                DELETE FROM candidates
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, candidateId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Candidate deleted successfully");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Candidate deletion failed");
            e.printStackTrace();
        }

        return false;
    }
}