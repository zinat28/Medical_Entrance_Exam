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

    public boolean addCandidate(Candidate candidate) {

        String sql = """
                INSERT INTO candidates
                (name, roll, gpa, status, documents_verified)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    candidate.getName()
            );

            statement.setString(
                    2,
                    candidate.getRoll()
            );

            statement.setDouble(
                    3,
                    candidate.getGpa()
            );

            statement.setString(
                    4,
                    candidate.getStatus()
            );

            statement.setInt(
                    5,
                    candidate.isDocumentsVerified() ? 1 : 0
            );

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            System.out.println(
                    "Candidate insertion failed."
            );

            e.printStackTrace();
            return false;
        }
    }

    public List<Candidate> getAllCandidates() {

        List<Candidate> candidates =
                new ArrayList<>();

        String sql = """
                SELECT id,
                       name,
                       roll,
                       gpa,
                       status,
                       documents_verified
                FROM candidates
                ORDER BY id ASC
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement();

             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Candidate candidate =
                        createCandidate(resultSet);

                candidates.add(candidate);
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to load candidates."
            );

            e.printStackTrace();
        }

        return candidates;
    }

    public Candidate getCandidateById(int candidateId) {

        String sql = """
                SELECT id,
                       name,
                       roll,
                       gpa,
                       status,
                       documents_verified
                FROM candidates
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, candidateId);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {
                    return createCandidate(resultSet);
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Candidate search failed."
            );

            e.printStackTrace();
        }

        return null;
    }

    public boolean updateCandidate(
            Candidate candidate
    ) {

        String sql = """
                UPDATE candidates
                SET name = ?,
                    roll = ?,
                    gpa = ?,
                    status = ?,
                    documents_verified = ?
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    candidate.getName()
            );

            statement.setString(
                    2,
                    candidate.getRoll()
            );

            statement.setDouble(
                    3,
                    candidate.getGpa()
            );

            statement.setString(
                    4,
                    candidate.getStatus()
            );

            statement.setInt(
                    5,
                    candidate.isDocumentsVerified() ? 1 : 0
            );

            statement.setInt(
                    6,
                    candidate.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Candidate update failed."
            );

            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatus(
            int candidateId,
            String status
    ) {

        String sql = """
                UPDATE candidates
                SET status = ?
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, candidateId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Candidate status update failed."
            );

            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyDocuments(
            int candidateId
    ) {

        String sql = """
                UPDATE candidates
                SET documents_verified = 1,
                    status = CASE
                        WHEN status = 'Pending'
                        THEN 'Verified'
                        ELSE status
                    END
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, candidateId);

            int rowsAffected =
                    statement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println(
                        "Candidate documents verified."
                );

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Document verification failed."
            );

            e.printStackTrace();
        }

        return false;
    }

    public boolean markDocumentsNotVerified(
            int candidateId
    ) {

        String sql = """
                UPDATE candidates
                SET documents_verified = 0,
                    status = CASE
                        WHEN status = 'Verified'
                        THEN 'Pending'
                        ELSE status
                    END
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, candidateId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Verification removal failed."
            );

            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCandidate(
            int candidateId
    ) {

        String sql = """
                DELETE FROM candidates
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, candidateId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Candidate deletion failed."
            );

            e.printStackTrace();
            return false;
        }
    }

    private Candidate createCandidate(
            ResultSet resultSet
    ) throws Exception {

        return new Candidate(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("roll"),
                resultSet.getDouble("gpa"),
                resultSet.getString("status"),
                resultSet.getInt(
                        "documents_verified"
                ) == 1
        );
    }
}