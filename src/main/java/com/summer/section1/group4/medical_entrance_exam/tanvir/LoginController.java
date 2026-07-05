package com.summer.section1.group4.medical_entrance_exam.tanvir;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private Label messageLabel;

    @FXML
    public void showMessage() {
        messageLabel.setText("Welcome Tanvir");
    }
}
