package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ApproveCandidatesController {

    @FXML
    private Button closeButton;

    @FXML
    private void handleClose() {

        Stage stage =
                (Stage) closeButton
                        .getScene()
                        .getWindow();

        stage.close();
    }
}