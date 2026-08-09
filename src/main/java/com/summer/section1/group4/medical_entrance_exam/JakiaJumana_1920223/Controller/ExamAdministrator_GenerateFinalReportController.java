package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.FinalReport;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_GenerateFinalReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker generatedDatePicker;

    @FXML
    private TextArea reportDataTextArea;

    @FXML
    private CheckBox includeAnalyticsCheckBox;

    @FXML
    private Button generateButton;

    @FXML
    private TableView<FinalReport> finalReportTableView;

    @FXML
    private TableColumn<FinalReport, String> reportIdColumn;

    @FXML
    private TableColumn<FinalReport, String> generatedDateColumn;

    @FXML
    private TableColumn<FinalReport, String> reportTypeColumn;

    @FXML
    private TableColumn<FinalReport, String> reportDataColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        reportTypeComboBox.setItems(FXCollections.observableArrayList("Annual Summary", "Pass/Fail Distribution", "Center Audit"));
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        reportTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        reportDataColumn.setCellValueFactory(new PropertyValueFactory<>("reportData"));
        finalReportTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.finalReportList));
    }

    @FXML
    public void handleGenerateFinalReport(ActionEvent event) {
        String type = reportTypeComboBox.getValue();
        LocalDate date = generatedDatePicker.getValue();
        String data = reportDataTextArea.getText();

        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Report Type");
            alert.setContentText("Please select report type.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select generated date.");
            alert.showAndWait();
            return;
        }

        if (data == null || data.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Summary");
            alert.setContentText("Please enter report summary data.");
            alert.showAndWait();
            return;
        }

        ExamAdministrator.generateFinalReport(type, data);
        finalReportTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.finalReportList));
    }
}
