package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;


public class MedicalOfficerDashboardController {


    @FXML
    private void handleViewCandidates(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/summer/section1/group4/medical_entrance_exam/tanvir/candidate_dashboard.fxml")
            );


            Parent root = loader.load();


            Stage stage = new Stage();

            stage.setTitle("Candidate List");
            stage.setScene(new Scene(root));

            stage.show();


        } catch(Exception e){

            e.printStackTrace();

        }

    }



    @FXML
    private void handleVerifyDocuments(ActionEvent event){

        System.out.println("Document verification page coming soon");

    }




    @FXML
    private void handleLogout(ActionEvent event){

        try {


            // Close current dashboard window

            Stage currentStage =
                    (Stage)((Node)event.getSource())
                            .getScene()
                            .getWindow();


            currentStage.close();



            // Open login page

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/summer/section1/group4/medical_entrance_exam/tanvir/login.fxml")
            );


            Parent root = loader.load();


            Stage loginStage = new Stage();

            loginStage.setTitle("Combined Medical Entrance Exam Portal");

            loginStage.setScene(new Scene(root));

            loginStage.show();



        } catch(Exception e){

            e.printStackTrace();

        }

    }


}