package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class JakiaJumanaDashboardController {

    @FXML
    private AnchorPane mainContentPane;

    private void loadViewIntoRightPane(String fxmlName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/JakiaJumana_1920223/" + fxmlName));
            Parent view = loader.load();
            mainContentPane.getChildren().clear();
            mainContentPane.getChildren().add(view);
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleOpenCreateSchedule(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_CreateExamSchedule.fxml");
    }

    @FXML
    public void handleOpenPublishNotice(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_PublishExamNotice.fxml");
    }

    @FXML
    public void handleOpenManageApplicant(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_ManageApplicantRecord.fxml");
    }

    @FXML
    public void handleOpenApproveRegistration(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_ApproveApplicantRegistration.fxml");
    }

    @FXML
    public void handleOpenAssignCenters(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_AssignExamCenters.fxml");
    }

    @FXML
    public void handleOpenGenerateAdmitCards(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_GenerateAdmitCards.fxml");
    }

    @FXML
    public void handleOpenPublishResults(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_PublishExamResults.fxml");
    }

    @FXML
    public void handleOpenGenerateFinalReport(ActionEvent event) {
        loadViewIntoRightPane("ExamAdministrator_GenerateFinalReport.fxml");
    }

    @FXML
    public void handleOpenGetCenterDetails(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_GetCenterDetails.fxml");
    }

    @FXML
    public void handleOpenAssignRooms(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_AssignExamRooms.fxml");
    }

    @FXML
    public void handleOpenManageSeatAllocation(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_ManageSeatAllocation.fxml");
    }

    @FXML
    public void handleOpenVerifyVenueAttendance(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_VerifyVenueAttendance.fxml");
    }

    @FXML
    public void handleOpenReportAbsentCandidates(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_ReportAbsentCandidates.fxml");
    }

    @FXML
    public void handleOpenSubmitSessionReport(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_SubmitExamSessionReport.fxml");
    }

    @FXML
    public void handleOpenGetCapacityStatus(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_GetCenterCapacityStatus.fxml");
    }

    @FXML
    public void handleOpenDownloadDocument(ActionEvent event) {
        loadViewIntoRightPane("ExamCenterCoordinator_DownloadCenterDocument.fxml");
    }

    @FXML
    public void Exit01(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/Login.fxml"));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}