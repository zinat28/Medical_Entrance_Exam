package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditCandidateController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField rollField;

    @FXML
    private TextField gpaField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Label messageLabel;

    private final CandidateDAO candidateDAO = new CandidateDAO();

    private Candidate selectedCandidate;

    @FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "Pending",
                "Verified",
                "Approved",
                "Rejected"
        );
    }

    public void setCandidate(Candidate candidate) {

        this.selectedCandidate = candidate;

        nameField.setText(candidate.getName());
        rollField.setText(candidate.getRoll());
        gpaField.setText(String.valueOf(candidate.getGpa()));
        statusComboBox.setValue(candidate.getStatus());
    }

    @FXML
    private void handleSave() {

        if (selectedCandidate == null) {
            showError("No candidate selected.");
            return;
        }

        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();
        String gpaText = gpaField.getText().trim();
        String status = statusComboBox.getValue();

        if (name.isEmpty()) {
            showError("Name is required.");
            return;
        }

        if (roll.isEmpty()) {
            showError("Roll is required.");
            return;
        }

        if (gpaText.isEmpty()) {
            showError("GPA is required.");
            return;
        }

        if (status == null || status.isBlank()) {
            showError("Status is required.");
            return;
        }

        double gpa;

        try {
            gpa = Double.parseDouble(gpaText);
        } catch (NumberFormatException e) {
            showError("GPA must be a valid number.");
            return;
        }

        if (gpa < 0 || gpa > 5) {
            showError("GPA must be between 0 and 5.");
            return;
        }

        selectedCandidate.setName(name);
        selectedCandidate.setRoll(roll);
        selectedCandidate.setGpa(gpa);
        selectedCandidate.setStatus(status);

        boolean updated =
                candidateDAO.updateCandidate(selectedCandidate);

        if (updated) {

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Candidate updated successfully.");

            Stage stage =
                    (Stage) nameField.getScene().getWindow();

            stage.close();

        } else {
            showError(
                    "Candidate update failed. Roll may already exist."
            );
        }
    }

    @FXML
    private void handleCancel() {

        Stage stage =
                (Stage) nameField.getScene().getWindow();

        stage.close();
    }

    private void showError(String message) {

        messageLabel.setStyle("-fx-text-fill: red;");
        messageLabel.setText(message);
    }
}