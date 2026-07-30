package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.UserDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;


    @FXML
    public void login() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        UserDAO userDAO = new UserDAO();

        User user = userDAO.login(username, password);


        if(user != null){

            messageLabel.setText("Login Successful");

            System.out.println("Welcome " + user.getUsername());

        }
        else{

            messageLabel.setText("Invalid username or password");

        }
    }
}