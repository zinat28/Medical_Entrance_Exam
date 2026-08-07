package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DirectorDashboardController {

    private static final String RESOURCE_BASE =
            "/com/summer/section1/group4/"
                    + "medical_entrance_exam/tanvir/";

    @FXML
    private void handleViewCandidates(
            ActionEvent event
    ) {

        openWindow(
                "candidate_dashboard.fxml",
                "All Candidates",
                false
        );
    }

    @FXML
    private void handleApproveCandidates(
            ActionEvent event
    ) {

        openWindow(
                "approve_candidates.fxml",
                "Candidate Approval",
                true
        );
    }

    @FXML
    private void handleGenerateReport(
            ActionEvent event
    ) {

        openWindow(
                "report_dashboard.fxml",
                "Candidate Report",
                true
        );
    }

    @FXML
    private void handleLogout(
            ActionEvent event
    ) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/Login.fxml"));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openWindow(
            String fxmlFile,
            String title,
            boolean modal
    ) {

        try {

            URL resource =
                    getClass().getResource(
                            RESOURCE_BASE + fxmlFile
                    );

            if (resource == null) {

                showError(
                        "FXML Error",
                        fxmlFile + " was not found."
                );

                return;
            }

            FXMLLoader loader =
                    new FXMLLoader(resource);

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setTitle(title);
            stage.setScene(new Scene(root));

            if (modal) {
                stage.initModality(
                        Modality.APPLICATION_MODAL
                );
            }

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

            showError(
                    "Window Error",
                    "Could not open " + title + "."
            );
        }
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