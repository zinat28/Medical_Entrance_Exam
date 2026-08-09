package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.ExamSessionReport;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamCenterCoordinator_SubmitExamSessionReportController {

    @FXML
    private TextField centerIdTextField;

    @FXML
    private TextField submissionTimeTextField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker submissionDatePicker;

    @FXML
    private TextArea sessionRemarksTextArea;

    @FXML
    private CheckBox signedByCoordinatorCheckBox;

    @FXML
    private Button submitButton;

    @FXML
    private TableView<ExamSessionReport> examSessionReportTableView;

    @FXML
    private TableColumn<ExamSessionReport, String> reportIdColumn;

    @FXML
    private TableColumn<ExamSessionReport, String> generatedDateColumn;

    @FXML
    private TableColumn<ExamSessionReport, String> centerIdColumn;

    @FXML
    private TableColumn<ExamSessionReport, String> sessionRemarksColumn;

    @FXML
    private TableColumn<ExamSessionReport, String> submissionTimeColumn;

    @FXML
    private TableColumn<ExamSessionReport, String> statusColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        statusComboBox.setItems(FXCollections.observableArrayList("Completed", "In Progress", "Incident Reported"));
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        sessionRemarksColumn.setCellValueFactory(new PropertyValueFactory<>("sessionRemarks"));
        submissionTimeColumn.setCellValueFactory(new PropertyValueFactory<>("submissionTime"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        examSessionReportTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.examSessionReportList));
    }

    @FXML
    public void handleSubmitExamSessionReport(ActionEvent event) {
        String centerId = centerIdTextField.getText();
        String time = submissionTimeTextField.getText();
        String status = statusComboBox.getValue();
        LocalDate date = submissionDatePicker.getValue();
        String remarks = sessionRemarksTextArea.getText();

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter center ID.");
            alert.showAndWait();
            return;
        }

        if (time == null || time.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Submission Time");
            alert.setContentText("Please enter submission time.");
            alert.showAndWait();
            return;
        }

        if (status == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Session Status");
            alert.setContentText("Please select session status.");
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

        if (remarks == null || remarks.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Session Remarks");
            alert.setContentText("Please enter session remarks.");
            alert.showAndWait();
            return;
        }

        ExamCenterCoordinator.submitExamSessionReport(centerId, remarks);
        examSessionReportTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.examSessionReportList));
    }
}
