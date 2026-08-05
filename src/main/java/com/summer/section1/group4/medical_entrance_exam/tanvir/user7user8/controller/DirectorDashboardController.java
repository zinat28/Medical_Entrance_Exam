package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DirectorDashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome Director");
    }

    @FXML
    private void handleLogout() {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource(
                            "/com/summer/section1/group4/medical_entrance_exam/tanvir/login.fxml"
                    )
            );

            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Combined Medical Entrance Exam Portal");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}