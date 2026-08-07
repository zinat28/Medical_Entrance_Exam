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

    // =========================================================
    // ADD CANDIDATE
    // =========================================================
    public boolean addCandidate(Candidate candidate) {

        String sql = """
                INSERT INTO candidates
                (
                    name,
                    roll,
                    gpa,
                    status,
                    documents_verified,
                    director_approved
                )
                VALUES (?, ?, ?, ?, ?, ?)
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
                    candidate.isDocumentsVerified()
                            ? 1
                            : 0
            );

            statement.setInt(
                    6,
                    candidate.isDirectorApproved()
                            ? 1
                            : 0
            );

            int rowsAffected =
                    statement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println(
                        "Candidate added successfully."
                );

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Candidate insertion failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // GET ALL CANDIDATES
    // =========================================================
    public List<Candidate> getAllCandidates() {

        List<Candidate> candidateList =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    name,
                    roll,
                    gpa,
                    status,
                    documents_verified,
                    director_approved
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

                candidateList.add(
                        createCandidate(resultSet)
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to load candidates."
            );

            e.printStackTrace();
        }

        return candidateList;
    }


    // =========================================================
    // GET CANDIDATE BY ID
    // =========================================================
    public Candidate getCandidateById(
            int candidateId
    ) {

        String sql = """
                SELECT
                    id,
                    name,
                    roll,
                    gpa,
                    status,
                    documents_verified,
                    director_approved
                FROM candidates
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(
                    1,
                    candidateId
            );

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {

                    return createCandidate(
                            resultSet
                    );
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


    // =========================================================
    // UPDATE COMPLETE CANDIDATE
    // =========================================================
    public boolean updateCandidate(
            Candidate candidate
    ) {

        String sql = """
                UPDATE candidates
                SET name = ?,
                    roll = ?,
                    gpa = ?,
                    status = ?,
                    documents_verified = ?,
                    director_approved = ?
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
                    candidate.isDocumentsVerified()
                            ? 1
                            : 0
            );

            statement.setInt(
                    6,
                    candidate.isDirectorApproved()
                            ? 1
                            : 0
            );

            statement.setInt(
                    7,
                    candidate.getId()
            );

            int rowsAffected =
                    statement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println(
                        "Candidate updated successfully."
                );

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Candidate update failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // UPDATE STATUS ONLY
    // =========================================================
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

            statement.setString(
                    1,
                    status
            );

            statement.setInt(
                    2,
                    candidateId
            );

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Candidate status update failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // VERIFY DOCUMENTS
    // Medical Officer
    // =========================================================
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

            statement.setInt(
                    1,
                    candidateId
            );

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


    // =========================================================
    // MARK DOCUMENTS NOT VERIFIED
    // =========================================================
    public boolean markDocumentsNotVerified(
            int candidateId
    ) {

        String sql = """
                UPDATE candidates
                SET documents_verified = 0,
                    director_approved = 0,
                    status = 'Pending'
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(
                    1,
                    candidateId
            );

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Verification removal failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // APPROVE CANDIDATE
    // Director
    // Candidate can only be approved when documents are verified
    // =========================================================
    public boolean approveCandidate(
            int candidateId
    ) {

        String sql = """
                UPDATE candidates
                SET director_approved = 1,
                    status = 'Approved'
                WHERE id = ?
                  AND documents_verified = 1
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(
                    1,
                    candidateId
            );

            int rowsAffected =
                    statement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println(
                        "Candidate approved successfully."
                );

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Candidate approval failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // REMOVE DIRECTOR APPROVAL
    // =========================================================
    public boolean removeCandidateApproval(
            int candidateId
    ) {

        String sql = """
                UPDATE candidates
                SET director_approved = 0,
                    status = CASE
                        WHEN documents_verified = 1
                        THEN 'Verified'
                        ELSE 'Pending'
                    END
                WHERE id = ?
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(
                    1,
                    candidateId
            );

            int rowsAffected =
                    statement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println(
                        "Candidate approval removed."
                );

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Approval removal failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // DELETE CANDIDATE
    // =========================================================
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

            statement.setInt(
                    1,
                    candidateId
            );

            int rowsAffected =
                    statement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println(
                        "Candidate deleted successfully."
                );

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Candidate deletion failed."
            );

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // HOUR 10 - REPORT GENERATION
    // =========================================================

    // Total number of candidates
    public int getTotalCandidates() {

        String sql = """
                SELECT COUNT(*) AS total
                FROM candidates
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement();

             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            if (resultSet.next()) {

                return resultSet.getInt(
                        "total"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to count total candidates."
            );

            e.printStackTrace();
        }

        return 0;
    }


    // Number of candidates whose documents are verified
    public int getVerifiedCandidatesCount() {

        String sql = """
                SELECT COUNT(*) AS total
                FROM candidates
                WHERE documents_verified = 1
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement();

             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            if (resultSet.next()) {

                return resultSet.getInt(
                        "total"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to count verified candidates."
            );

            e.printStackTrace();
        }

        return 0;
    }


    // Number of candidates approved by Director
    public int getApprovedCandidatesCount() {

        String sql = """
                SELECT COUNT(*) AS total
                FROM candidates
                WHERE director_approved = 1
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement();

             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            if (resultSet.next()) {

                return resultSet.getInt(
                        "total"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to count approved candidates."
            );

            e.printStackTrace();
        }

        return 0;
    }


    // Number of candidates still pending
    public int getPendingCandidatesCount() {

        String sql = """
                SELECT COUNT(*) AS total
                FROM candidates
                WHERE status = 'Pending'
                """;

        try (Connection connection =
                     DatabaseConnection.getConnection();

             Statement statement =
                     connection.createStatement();

             ResultSet resultSet =
                     statement.executeQuery(sql)) {

            if (resultSet.next()) {

                return resultSet.getInt(
                        "total"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to count pending candidates."
            );

            e.printStackTrace();
        }

        return 0;
    }


    // =========================================================
    // CREATE CANDIDATE OBJECT FROM RESULTSET
    // =========================================================
    private Candidate createCandidate(
            ResultSet resultSet
    ) throws Exception {

        return new Candidate(

                resultSet.getInt(
                        "id"
                ),

                resultSet.getString(
                        "name"
                ),

                resultSet.getString(
                        "roll"
                ),

                resultSet.getDouble(
                        "gpa"
                ),

                resultSet.getString(
                        "status"
                ),

                resultSet.getInt(
                        "documents_verified"
                ) == 1,

                resultSet.getInt(
                        "director_approved"
                ) == 1
        );
    }
}