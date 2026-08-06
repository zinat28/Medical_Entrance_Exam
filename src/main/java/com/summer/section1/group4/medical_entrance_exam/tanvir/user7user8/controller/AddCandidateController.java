package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCandidateController {

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

    @FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "Pending",
                "Verified",
                "Approved",
                "Rejected"
        );

        statusComboBox.setValue("Pending");
    }

    @FXML
    private void handleAdd() {

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
            showError("Please select a status.");
            return;
        }

        double gpa;

        try {
            gpa = Double.parseDouble(gpaText);
        } catch (NumberFormatException e) {
            showError("GPA must be a valid number.");
            return;
        }

        if (gpa < 0.00 || gpa > 5.00) {
            showError("GPA must be between 0.00 and 5.00.");
            return;
        }

        Candidate candidate = new Candidate(
                name,
                roll,
                gpa,
                status
        );

        boolean saved = candidateDAO.addCandidate(candidate);

        if (saved) {
            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Candidate saved successfully.");

            clearFields();
        } else {
            showError(
                    "Candidate could not be saved. The roll may already exist."
            );
        }
    }

    @FXML
    private void handleClear() {
        clearFields();
        messageLabel.setText("");
    }

    private void clearFields() {

        nameField.clear();
        rollField.clear();
        gpaField.clear();
        statusComboBox.setValue("Pending");

        nameField.requestFocus();
    }

    private void showError(String message) {

        messageLabel.setStyle("-fx-text-fill: red;");
        messageLabel.setText(message);
    }
}