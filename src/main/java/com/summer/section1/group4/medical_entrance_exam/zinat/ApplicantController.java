package com.summer.section1.group4.medical_entrance_exam.zinat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ApplicantController {
    @FXML private AnchorPane paneContentContainer;


    @FXML
    public void handleMenuSelection(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        String fxmlFile = "";

        // Determine which target view window needs to load inside the pane container box
        switch (buttonId) {
            case "ApplicationFormFillUpBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/ApplicantForm.fxml";
                break;
            case "DocumentUploadsBTN":
                fxmlFile = "app_goal2.fxml";
                break;
            case "SecurePaymentBTN":
                fxmlFile = "app_goal3.fxml";
                break;
            case "AdmitCardDownloadBTN":
                fxmlFile = "app_goal4.fxml";
                break;
            case "ViewCentreBTN":
                fxmlFile = "app_goal5.fxml";
                break;
            case "CheckResultBTN":
                fxmlFile = "app_goal6.fxml";
                break;
            case "ChoiceLockingBTN":
                fxmlFile = "app_goal7.fxml";
                break;
            case "MedicalCollegeAllocationBTN":
                fxmlFile = "app_goal8.fxml";
                break;
        }

        try {
            // Dynamically load the layout file
            Node newContentPane = FXMLLoader.load(getClass().getResource(fxmlFile));

            // Clear out old view elements and display the new goal view window form
            paneContentContainer.getChildren().clear();
            paneContentContainer.getChildren().add(newContentPane);

            // Lock positioning layout constraints perfectly anchors
            AnchorPane.setTopAnchor(newContentPane, 0.0);
            AnchorPane.setBottomAnchor(newContentPane, 0.0);
            AnchorPane.setLeftAnchor(newContentPane, 0.0);
            AnchorPane.setRightAnchor(newContentPane, 0.0);

        } catch (IOException e) {
            System.out.println("Could not switch forms. Ensure target layout resource file exists: " + fxmlFile);
            e.printStackTrace();
        }

    }

    @FXML
    public void MainMenuOA(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/zinat/Login.fxml"));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
