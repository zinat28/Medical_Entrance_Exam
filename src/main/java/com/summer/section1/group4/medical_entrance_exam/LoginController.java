package com.summer.section1.group4.medical_entrance_exam;

import com.summer.section1.group4.medical_entrance_exam.zinat.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/Applicant.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Question Moderator")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/zinat/QuestionModerator/QuestionModerator.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Medical Officer")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/tanvir/medical_officer_dashboard.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Director")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/tanvir/director_dashboard.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Financial Officer")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/reham/JubayerAhmed_2330814/JubayerAhmedMenu.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Invigilator")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/JubayerAhmed_2330814/JubayerAhmedMenu.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Finance Officer")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/JubayerAhmed_2330814/JubayerAhmedMenu.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Center Coordinator")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/JakiaJumana_1920223/JakiaJumanaDashboard.fxml");
            }
            else if ((usernameTextField.getText().equals(x.getUsername())) && passwordTextField.getText().equals(x.getPassword()) && userTypeComboBox.getValue().equals("Administrator")) {
                messegeLabel.setText("Login Successful");
                SceneSwitcher.switchTo("/com/summer/section1/group4/medical_entrance_exam/JakiaJumana_1920223/JakiaJumanaDashboard.fxml");
            }
        }

        messegeLabel.setText("Login Failed");



    }
}
