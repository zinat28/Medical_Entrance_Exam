package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Optional;

public class ApproveCandidatesController {

    @FXML
    private TableView<Candidate> candidateTable;

    @FXML
    private TableColumn<Candidate, Integer> idColumn;

    @FXML
    private TableColumn<Candidate, String> nameColumn;

    @FXML
    private TableColumn<Candidate, String> rollColumn;

    @FXML
    private TableColumn<Candidate, Double> gpaColumn;

    @FXML
    private TableColumn<Candidate, String> documentsColumn;

    @FXML
    private TableColumn<Candidate, String> statusColumn;

    @FXML
    private TableColumn<Candidate, String> approvalColumn;

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

        gpaColumn.setCellValueFactory(
                new PropertyValueFactory<>("gpa")
        );

        documentsColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "verificationStatus"
                )
        );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        approvalColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "approvalStatus"
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
    private void handleApproveCandidate() {

        Candidate selectedCandidate =
                getSelectedCandidate();

        if (selectedCandidate == null) {
            return;
        }

        if (!selectedCandidate
                .isDocumentsVerified()) {

            showWarning(
                    "Documents Not Verified",
                    "The Medical Officer must verify "
                            + "this candidate's documents first."
            );

            return;
        }

        if (selectedCandidate
                .isDirectorApproved()) {

            showInformation(
                    "Already Approved",
                    "This candidate is already approved."
            );

            return;
        }

        Alert confirmation =
                new Alert(Alert.AlertType.CONFIRMATION);

        confirmation.setTitle(
                "Approve Candidate"
        );

        confirmation.setHeaderText(
                "Confirm final candidate approval"
        );

        confirmation.setContentText(
                "Candidate: "
                        + selectedCandidate.getName()
                        + "\nRoll: "
                        + selectedCandidate.getRoll()
                        + "\nGPA: "
                        + selectedCandidate.getGpa()
                        + "\nDocuments: Verified"
                        + "\n\nApprove this candidate?"
        );

        Optional<ButtonType> result =
                confirmation.showAndWait();

        if (result.isPresent()
                && result.get() == ButtonType.OK) {

            boolean approved =
                    candidateDAO.approveCandidate(
                            selectedCandidate.getId()
                    );

            if (approved) {

                loadCandidates();

                showInformation(
                        "Approval Successful",
                        "Candidate approved successfully."
                );

            } else {

                showError(
                        "Approval Failed",
                        "Candidate could not be approved."
                );
            }
        }
    }

    @FXML
    private void handleRemoveApproval() {

        Candidate selectedCandidate =
                getSelectedCandidate();

        if (selectedCandidate == null) {
            return;
        }

        if (!selectedCandidate
                .isDirectorApproved()) {

            showInformation(
                    "Not Approved",
                    "This candidate is not currently approved."
            );

            return;
        }

        Alert confirmation =
                new Alert(Alert.AlertType.CONFIRMATION);

        confirmation.setTitle(
                "Remove Approval"
        );

        confirmation.setHeaderText(
                "Confirm approval removal"
        );

        confirmation.setContentText(
                "Candidate: "
                        + selectedCandidate.getName()
                        + "\nRoll: "
                        + selectedCandidate.getRoll()
                        + "\n\nRemove Director approval?"
        );

        Optional<ButtonType> result =
                confirmation.showAndWait();

        if (result.isPresent()
                && result.get() == ButtonType.OK) {

            boolean removed =
                    candidateDAO.removeCandidateApproval(
                            selectedCandidate.getId()
                    );

            if (removed) {

                loadCandidates();

                showInformation(
                        "Approval Removed",
                        "Candidate approval removed successfully."
                );

            } else {

                showError(
                        "Update Failed",
                        "Candidate approval could not be removed."
                );
            }
        }
    }

    @FXML
    private void handleRefresh() {
        loadCandidates();
    }

    @FXML
    private void handleClose(
            ActionEvent event
    ) {

        Stage stage =
                (Stage) ((Node) event.getSource())
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
                    "Please select a candidate "
                            + "from the table first."
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