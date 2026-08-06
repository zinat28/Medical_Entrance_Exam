package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class CandidateDashboardController {

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
    private TableColumn<Candidate, String> statusColumn;

    private final CandidateDAO candidateDAO = new CandidateDAO();

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

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        loadCandidates();

        // Double-click a candidate row to edit.
        candidateTable.setOnMouseClicked(event -> {

            Candidate selectedCandidate =
                    candidateTable
                            .getSelectionModel()
                            .getSelectedItem();

            if (event.getClickCount() == 2
                    && selectedCandidate != null) {

                handleEditCandidate();
            }
        });
    }

    private void loadCandidates() {

        candidateTable.setItems(
                FXCollections.observableArrayList(
                        candidateDAO.getAllCandidates()
                )
        );
    }

    @FXML
    private void refreshCandidates() {
        loadCandidates();
    }

    @FXML
    private void handleAddCandidate() {

        try {

            URL resource = getClass().getResource(
                    "/com/summer/section1/group4/medical_entrance_exam/tanvir/add_candidate.fxml"
            );

            if (resource == null) {
                showError(
                        "FXML Error",
                        "add_candidate.fxml was not found."
                );
                return;
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();

            Stage addStage = new Stage();

            addStage.setTitle("Add Candidate");
            addStage.setScene(new Scene(root));
            addStage.initModality(Modality.APPLICATION_MODAL);

            addStage.showAndWait();

            loadCandidates();

        } catch (IOException e) {

            e.printStackTrace();

            showError(
                    "Add Candidate Error",
                    "Could not open the Add Candidate window."
            );
        }
    }

    @FXML
    private void handleEditCandidate() {

        Candidate selectedCandidate =
                candidateTable
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedCandidate == null) {

            showWarning(
                    "No Candidate Selected",
                    "Please select a candidate from the table first."
            );

            return;
        }

        try {

            URL resource = getClass().getResource(
                    "/com/summer/section1/group4/medical_entrance_exam/tanvir/edit_candidate.fxml"
            );

            if (resource == null) {
                showError(
                        "FXML Error",
                        "edit_candidate.fxml was not found."
                );
                return;
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();

            EditCandidateController editController =
                    loader.getController();

            editController.setCandidate(selectedCandidate);

            Stage editStage = new Stage();

            editStage.setTitle("Edit Candidate");
            editStage.setScene(new Scene(root));
            editStage.initModality(Modality.APPLICATION_MODAL);

            editStage.showAndWait();

            loadCandidates();

        } catch (IOException e) {

            e.printStackTrace();

            showError(
                    "Edit Candidate Error",
                    "Could not open the Edit Candidate window."
            );
        }
    }

    @FXML
    private void handleDeleteCandidate() {

        Candidate selectedCandidate =
                candidateTable
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedCandidate == null) {

            showWarning(
                    "No Candidate Selected",
                    "Please select a candidate from the table first."
            );

            return;
        }

        Alert confirmationAlert =
                new Alert(Alert.AlertType.CONFIRMATION);

        confirmationAlert.setTitle("Delete Candidate");
        confirmationAlert.setHeaderText(
                "Are you sure you want to delete this candidate?"
        );

        confirmationAlert.setContentText(
                "Name: " + selectedCandidate.getName()
                        + "\nRoll: " + selectedCandidate.getRoll()
                        + "\nGPA: " + selectedCandidate.getGpa()
                        + "\nStatus: " + selectedCandidate.getStatus()
                        + "\n\nThis action cannot be undone."
        );

        Optional<ButtonType> result =
                confirmationAlert.showAndWait();

        if (result.isPresent()
                && result.get() == ButtonType.OK) {

            boolean deleted =
                    candidateDAO.deleteCandidate(
                            selectedCandidate.getId()
                    );

            if (deleted) {

                loadCandidates();

                showInformation(
                        "Delete Successful",
                        "Candidate deleted successfully."
                );

            } else {

                showError(
                        "Delete Failed",
                        "Candidate could not be deleted."
                );
            }
        }
    }

    private void showWarning(
            String title,
            String message
    ) {

        Alert alert = new Alert(
                Alert.AlertType.WARNING
        );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private void showInformation(
            String title,
            String message
    ) {

        Alert alert = new Alert(
                Alert.AlertType.INFORMATION
        );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private void showError(
            String title,
            String message
    ) {

        Alert alert = new Alert(
                Alert.AlertType.ERROR
        );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}