package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.Application;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_ManageApplicantRecordController {

    @FXML
    private TextField applicantIdTextField;

    @FXML
    private TextField applicantNameTextField;

    @FXML
    private ComboBox<String> verificationStatusComboBox;

    @FXML
    private DatePicker submissionDatePicker;

    @FXML
    private CheckBox verifiedDocCheckBox;

    @FXML
    private Button saveButton;

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
        verificationStatusComboBox.setItems(FXCollections.observableArrayList("Verified", "Pending", "Flagged"));
        applicationIdColumn.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
        applicantIdColumn.setCellValueFactory(new PropertyValueFactory<>("applicantId"));
        applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        submissionDateColumn.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));
        verificationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("verificationStatus"));
        approvalStatusColumn.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
        applicationTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.applicationList));
    }

    @FXML
    public void handleSaveApplicantRecord(ActionEvent event) {
        String appId = applicantIdTextField.getText();
        String name = applicantNameTextField.getText();
        String status = verificationStatusComboBox.getValue();
        LocalDate date = submissionDatePicker.getValue();

        if (appId == null || appId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Applicant ID");
            alert.setContentText("Please enter applicant ID.");
            alert.showAndWait();
            return;
        }

        if (name == null || name.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Applicant Name");
            alert.setContentText("Please enter applicant name.");
            alert.showAndWait();
            return;
        }

        if (status == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Verification Status");
            alert.setContentText("Please select verification status.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select submission date.");
            alert.showAndWait();
            return;
        }

        ExamAdministrator.manageApplicantRecord(appId, name);
        applicationTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.applicationList));
    }
}
