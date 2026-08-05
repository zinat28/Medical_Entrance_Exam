package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;


import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.UserDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;



public class LoginController {


    @FXML
    private TextField usernameField;


    @FXML
    private PasswordField passwordField;


    @FXML
    private Label messageLabel;



    @FXML
    public void login(){


        String username = usernameField.getText();

        String password = passwordField.getText();



        UserDAO userDAO = new UserDAO();


        User user = userDAO.login(username, password);



        if(user == null){

            messageLabel.setText("Invalid Username or Password");

            return;

        }



        String role = user.getRole();



        if(role.equalsIgnoreCase("medical officer")){


            openDashboard("medical_officer_dashboard.fxml");


        }


        else if(role.equalsIgnoreCase("director")){


            openDashboard("director_dashboard.fxml");


        }


        else {


            messageLabel.setText("Role not available");

        }


    }





    private void openDashboard(String fileName){


        try{


            FXMLLoader loader = new FXMLLoader(

                    getClass().getResource(
                            "/com/summer/section1/group4/medical_entrance_exam/tanvir/"
                                    + fileName)

            );


            Parent root = loader.load();



            Stage stage =
                    (Stage) usernameField.getScene().getWindow();



            stage.setScene(new Scene(root));


            stage.show();



        }
        catch(Exception e){

            e.printStackTrace();

            messageLabel.setText(
                    "Dashboard loading error");

        }


    }


}