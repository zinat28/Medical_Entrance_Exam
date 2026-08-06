package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Optional;

public class VerifyDocumentsController {

    @FXML
    private TableView<Candidate> candidateTable;

    @FXML
    private TableColumn<Candidate, Integer> idColumn;

    @FXML
    private TableColumn<Candidate, String> nameColumn;

    @FXML
    private TableColumn<Candidate, String> rollColumn;

    @FXML
    private TableColumn<Candidate, String> statusColumn;

    @FXML
    private TableColumn<Candidate, String> verificationColumn;

    private final CandidateDAO candidateDAO =
            new CandidateDAO();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        rollColumn.setCellValueFactory(
                new PropertyValueFactory<>("roll")
        );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        verificationColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "verificationStatus"
                )
        );

        loadCandidates();
    }

    private void loadCandidates() {

        candidateTable.setItems(
                FXCollections.observableArrayList(
                        candidateDAO.getAllCandidates()
                )
        );
    }

    @FXML
    private void handleVerifyDocuments() {

        Candidate selectedCandidate =
                getSelectedCandidate();

        if (selectedCandidate == null) {
            return;
        }

        if (selectedCandidate
                .isDocumentsVerified()) {

            showInformation(
                    "Already Verified",
                    "This candidate's documents are already verified."
            );

            return;
        }

        Alert confirmation =
                new Alert(Alert.AlertType.CONFIRMATION);

        confirmation.setTitle(
                "Verify Documents"
        );

        confirmation.setHeaderText(
                "Confirm candidate document verification"
        );

        confirmation.setContentText(
                "Candidate: "
                        + selectedCandidate.getName()
                        + "\nRoll: "
                        + selectedCandidate.getRoll()
                        + "\n\nMark the documents as verified?"
        );

        Optional<ButtonType> result =
                confirmation.showAndWait();

        if (result.isPresent()
                && result.get() == ButtonType.OK) {

            boolean verified =
                    candidateDAO.verifyDocuments(
                            selectedCandidate.getId()
                    );

            if (verified) {

                loadCandidates();

                showInformation(
                        "Verification Successful",
                        "Candidate documents verified successfully."
                );

            } else {

                showError(
                        "Verification Failed",
                        "Candidate documents could not be verified."
                );
            }
        }
    }

    @FXML
    private void handleMarkNotVerified() {

        Candidate selectedCandidate =
                getSelectedCandidate();

        if (selectedCandidate == null) {
            return;
        }

        if (!selectedCandidate
                .isDocumentsVerified()) {

            showInformation(
                    "Not Verified",
                    "This candidate is already marked as not verified."
            );

            return;
        }

        boolean updated =
                candidateDAO.markDocumentsNotVerified(
                        selectedCandidate.getId()
                );

        if (updated) {

            loadCandidates();

            showInformation(
                    "Status Updated",
                    "Candidate documents marked as not verified."
            );

        } else {

            showError(
                    "Update Failed",
                    "Verification status could not be updated."
            );
        }
    }

    @FXML
    private void handleRefresh() {
        loadCandidates();
    }

    @FXML
    private void handleClose() {

        Stage stage =
                (Stage) candidateTable
                        .getScene()
                        .getWindow();

        stage.close();
    }

    private Candidate getSelectedCandidate() {

        Candidate selectedCandidate =
                candidateTable
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedCandidate == null) {

            showWarning(
                    "No Candidate Selected",
                    "Please select a candidate from the table first."
            );
        }

        return selectedCandidate;
    }

    private void showWarning(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(Alert.AlertType.WARNING);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private void showInformation(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private void showError(
            String title,
            String message
    ) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}