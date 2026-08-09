package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class JubayerAhmedMenuController {

    @FXML
    private Button hallClosingReportButton;
    @FXML
    private Button reportIncidentButton;
    @FXML
    private Button approveLateEntryButton;
    @FXML
    private Button distributeQuestionButton;
    @FXML
    private Button revenueReportButton;
    @FXML
    private Button reVerifyCandidateButton;
    @FXML
    private Button verifyAttendanceButton;
    @FXML
    private Button resolveDisputeButton;
    @FXML
    private Button dailyReconciliationButton;
    @FXML
    private Button adjustScholarshipButton;
    @FXML
    private Button issueExtraSheetButton;
    @FXML
    private Button verifyPaymentButton;
    @FXML
    private Button financialAuditButton;
    @FXML
    private Button processRefundButton;
    @FXML
    private Button disburseShareButton;
    @FXML
    private Button collectAnswerSheetButton;

    private void openNewWindow(String fxmlName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/JubayerAhmed_2330814/" + fxmlName));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleOpenVerifyAttendance(ActionEvent event) {
        openNewWindow("Invigilator_VerifyAttendance.fxml", "Verify Attendance");
    }

    @FXML
    public void handleOpenDistributeQuestion(ActionEvent event) {
        openNewWindow("Invigilator_DistributeQuestion.fxml", "Distribute Question");
    }

    @FXML
    public void handleOpenReportIncident(ActionEvent event) {
        openNewWindow("Invigilator_ReportIncident.fxml", "Report Incident");
    }

    @FXML
    public void handleOpenCollectAnswerSheet(ActionEvent event) {
        openNewWindow("Invigilator_CollectAnswerSheet.fxml", "Collect Answer Sheet");
    }

    @FXML
    public void handleOpenReVerifyCandidate(ActionEvent event) {
        openNewWindow("Invigilator_ReVerifyCandidate.fxml", "Re-Verify Candidate");
    }

    @FXML
    public void handleOpenApproveLateEntry(ActionEvent event) {
        openNewWindow("Invigilator_ApproveLateEntry.fxml", "Approve Late Entry");
    }

    @FXML
    public void handleOpenIssueExtraSheet(ActionEvent event) {
        openNewWindow("Invigilator_IssueExtraSheet.fxml", "Issue Extra Sheet");
    }

    @FXML
    public void handleOpenHallClosingReport(ActionEvent event) {
        openNewWindow("Invigilator_HallClosingReport.fxml", "Hall Closing Report");
    }

    @FXML
    public void handleOpenVerifyPayment(ActionEvent event) {
        openNewWindow("FinanceOfficer_VerifyPayment.fxml", "Verify Payment");
    }

    @FXML
    public void handleOpenProcessRefund(ActionEvent event) {
        openNewWindow("FinanceOfficer_ProcessRefund.fxml", "Process Refund");
    }

    @FXML
    public void handleOpenRevenueReport(ActionEvent event) {
        openNewWindow("FinanceOfficer_RevenueReport.fxml", "Revenue Report");
    }

    @FXML
    public void handleOpenDisburseShare(ActionEvent event) {
        openNewWindow("FinanceOfficer_DisburseShare.fxml", "Disburse Share");
    }

    @FXML
    public void handleOpenResolveDispute(ActionEvent event) {
        openNewWindow("FinanceOfficer_ResolveDispute.fxml", "Resolve Dispute");
    }

    @FXML
    public void handleOpenDailyReconciliation(ActionEvent event) {
        openNewWindow("FinanceOfficer_DailyReconciliation.fxml", "Daily Reconciliation");
    }

    @FXML
    public void handleOpenAdjustScholarship(ActionEvent event) {
        openNewWindow("FinanceOfficer_AdjustScholarship.fxml", "Adjust Scholarship");
    }

    @FXML
    public void handleOpenFinancialAudit(ActionEvent event) {
        openNewWindow("FinanceOfficer_FinancialAudit.fxml", "Financial Audit");
    }

    @FXML
    public void handleLogoutButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/summer/section1/group4/medical_entrance_exam/Login.fxml"));
            Parent root = loader.load();
            Stage stage =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Log in");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
