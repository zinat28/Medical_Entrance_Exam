package com.summer.section1.group4.medical_entrance_exam.zinat;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private Label messegeLabel;

    public void initialize(){
        userTypeComboBox.getItems().addAll("Administrator", "Center Coordinator", "Applicant", "Question Moderator", "Invigilator", "Finance Officer", "Medical Officer", "Director" );

    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        for(Login x: LoginManager.getLoginArrayList()) {
            if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Applicant")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant.fxml");

            }
        }

        messegeLabel.setText("Login Failed");



    }
}
