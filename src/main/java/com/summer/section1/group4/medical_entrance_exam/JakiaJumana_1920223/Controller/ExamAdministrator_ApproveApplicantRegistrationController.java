package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.Application;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_ApproveApplicantRegistrationController {

    @FXML
    private TextField applicationIdTextField;
    @FXML
    private TextField applicantIdTextField;
    @FXML
    private ComboBox<String> approvalDecisionComboBox;
    @FXML
    private DatePicker approvalDatePicker;
    @FXML
    private CheckBox notifyApplicantCheckBox;
    @FXML
    private Button approveButton;
    @FXML
    private TableView<Application> applicationTableView;
    @FXML
    private TableColumn<Application, String> applicationIdColumn;
    @FXML
    private TableColumn<Application, String> applicantIdColumn;
    @FXML
    private TableColumn<Application, String> applicantNameColumn;
    @FXML
    private TableColumn<Application, String> submissionDateColumn;
    @FXML
    private TableColumn<Application, String> verificationStatusColumn;
    @FXML
    private TableColumn<Application, String> approvalStatusColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        approvalDecisionComboBox.setItems(FXCollections.observableArrayList("Approved", "Rejected", "Conditional Approval"));
        applicationIdColumn.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
        applicantIdColumn.setCellValueFactory(new PropertyValueFactory<>("applicantId"));
        applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        submissionDateColumn.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));
        verificationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("verificationStatus"));
        approvalStatusColumn.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
        applicationTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.applicationList));
    }

    @FXML
    public void handleApproveApplicantRegistration(ActionEvent event) {
        String appId = applicationIdTextField.getText();
        String applicantId = applicantIdTextField.getText();
        String decision = approvalDecisionComboBox.getValue();
        LocalDate date = approvalDatePicker.getValue();

        if (appId == null || appId.trim().isEmpty()) {//checking is empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Application ID");
            alert.setContentText("Please enter application ID.");
            alert.showAndWait();
            return;
        }

        if (applicantId == null || applicantId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Applicant ID");
            alert.setContentText("Please enter applicant ID.");
            alert.showAndWait();
            return;
        }

        if (decision == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Decision");
            alert.setContentText("Please select approval decision.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select approval date.");
            alert.showAndWait();
            return;
        }// fx collection is used for obsevable arraylist

        ExamAdministrator.approveApplicantRegistration(appId);//done in model class, here just calling
        applicationTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.applicationList));
    }///observable arraylist will help table for auto update
}
