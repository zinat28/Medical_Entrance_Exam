package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.RevenueReport;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_RevenueReportController {

    @FXML
    private TextField instituteIdTextField;

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private CheckBox includePendingCheckBox;

    @FXML
    private Button generateButton;

    @FXML
    private TableView<RevenueReport> revenueReportTableView;

    @FXML
    private TableColumn<RevenueReport, String> reportIdColumn;

    @FXML
    private TableColumn<RevenueReport, String> generatedDateColumn;

    @FXML
    private TableColumn<RevenueReport, String> dateRangeColumn;

    @FXML
    private TableColumn<RevenueReport, Double> totalCollectedColumn;

    @FXML
    private TableColumn<RevenueReport, Double> totalPendingColumn;

    @FXML
    private TableColumn<RevenueReport, Double> totalRefundedColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        reportTypeComboBox.setItems(FXCollections.observableArrayList("Monthly", "Quarterly", "Annual"));
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        dateRangeColumn.setCellValueFactory(new PropertyValueFactory<>("dateRange"));
        totalCollectedColumn.setCellValueFactory(new PropertyValueFactory<>("totalCollected"));
        totalPendingColumn.setCellValueFactory(new PropertyValueFactory<>("totalPending"));
        totalRefundedColumn.setCellValueFactory(new PropertyValueFactory<>("totalRefunded"));
        revenueReportTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.revenueReports));
    }

    @FXML
    public void handleGenerateRevenueReport(ActionEvent event) {
        String instId = instituteIdTextField.getText();
        String type = reportTypeComboBox.getValue();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (instId == null || instId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Institute ID");
            alert.setContentText("Please enter institute ID.");
            alert.showAndWait();
            return;
        }

        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Report Type");
            alert.setContentText("Please select report type.");
            alert.showAndWait();
            return;
        }

        if (startDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Start Date");
            alert.setContentText("Please select start date.");
            alert.showAndWait();
            return;
        }

        if (endDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing End Date");
            alert.setContentText("Please select end date.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.generateRevenueReport(startDate.toString(), endDate.toString(), instId);
        revenueReportTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.revenueReports));
    }
}
