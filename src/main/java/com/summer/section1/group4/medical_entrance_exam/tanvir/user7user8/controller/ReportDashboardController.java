package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReportDashboardController {

    @FXML
    private Label totalCandidatesLabel;

    @FXML
    private Label verifiedCandidatesLabel;

    @FXML
    private Label approvedCandidatesLabel;

    @FXML
    private Label pendingCandidatesLabel;

    private final CandidateDAO candidateDAO =
            new CandidateDAO();

    @FXML
    public void initialize() {

        loadReport();
    }

    private void loadReport() {

        try {

            int total =
                    candidateDAO
                            .getTotalCandidates();

            int verified =
                    candidateDAO
                            .getVerifiedCandidatesCount();

            int approved =
                    candidateDAO
                            .getApprovedCandidatesCount();

            int pending =
                    candidateDAO
                            .getPendingCandidatesCount();

            totalCandidatesLabel.setText(
                    String.valueOf(total)
            );

            verifiedCandidatesLabel.setText(
                    String.valueOf(verified)
            );

            approvedCandidatesLabel.setText(
                    String.valueOf(approved)
            );

            pendingCandidatesLabel.setText(
                    String.valueOf(pending)
            );

        } catch (Exception e) {

            e.printStackTrace();

            showError(
                    "Report Error",
                    "Could not load candidate report."
            );
        }
    }

    @FXML
    private void handleRefresh() {

        loadReport();
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