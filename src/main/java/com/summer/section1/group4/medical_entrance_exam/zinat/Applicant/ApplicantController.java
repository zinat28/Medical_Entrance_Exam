package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

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
    private Button SecurePaymentBTN;
    @FXML
    private Button DocumentUploadsBTN;
    @FXML
    private Button ApplicationFormFillUpBTN;
    @FXML
    private Button CheckResultBTN;
    @FXML
    private Button AdmitCardDownloadBTN;
    @FXML
    private Button MedicalCollegeAllocationBTN;
    @FXML
    private Button ViewCentreBTN;
    @FXML
    private Button ChoiceLockingBTN;


    @FXML
    public void handleMenuSelection(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        String fxmlFile = "";

        // Determine which target view window needs to load inside the pane container box
        switch (buttonId) {
            case "ApplicationFormFillUpBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/ApplicantForm.fxml";
                break;
            case "DocumentUploadsBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/DocumentsUpload.fxml";
                break;
            case "SecurePaymentBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/Payment.fxml";
                break;
            case "AdmitCardDownloadBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/AdmitCardDownload.fxml";
                break;
            case "ViewCentreBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/ExamCenter.fxml";
                break;
            case "CheckResultBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/Result.fxml";
                break;
            case "ChoiceLockingBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/ChoiceLocking.fxml";
                break;
            case "MedicalCollegeAllocationBTN":
                fxmlFile = "/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/AllocatedCollege.fxml";
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
    public void ExitOA(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/Login.fxml"));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void MainMenuOA(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/zinat/Applicant/Applicant.fxml"));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
