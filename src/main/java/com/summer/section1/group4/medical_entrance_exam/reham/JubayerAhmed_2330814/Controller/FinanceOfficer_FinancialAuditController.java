package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.FinancialAuditReport;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_FinancialAuditController {

    @FXML
    private ComboBox<String> auditPeriodComboBox;

    @FXML
    private DatePicker auditDatePicker;

    @FXML
    private TextField verifiedPaymentsTextField;

    @FXML
    private CheckBox completenessFlagCheckBox;

    @FXML
    private Button generateButton;

    @FXML
    private TableView<FinancialAuditReport> auditReportTableView;

    @FXML
    private TableColumn<FinancialAuditReport, String> reportIdColumn;

    @FXML
    private TableColumn<FinancialAuditReport, String> generatedDateColumn;

    @FXML
    private TableColumn<FinancialAuditReport, String> auditPeriodColumn;

    @FXML
    private TableColumn<FinancialAuditReport, Integer> totalVerifiedPaymentsColumn;

    @FXML
    private TableColumn<FinancialAuditReport, Double> totalDisbursementsColumn;

    @FXML
    private TableColumn<FinancialAuditReport, Boolean> completenessFlagColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        auditPeriodComboBox.setItems(FXCollections.observableArrayList("2025-Annual", "2026-H1", "2026-Q1"));
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        auditPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("auditPeriod"));
        totalVerifiedPaymentsColumn.setCellValueFactory(new PropertyValueFactory<>("totalVerifiedPayments"));
        totalDisbursementsColumn.setCellValueFactory(new PropertyValueFactory<>("totalDisbursements"));
        completenessFlagColumn.setCellValueFactory(new PropertyValueFactory<>("completenessFlag"));
        auditReportTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.financialAuditReports));
    }

    @FXML
    public void handleGenerateFinancialAuditReport(ActionEvent event) {
        String period = auditPeriodComboBox.getValue();
        LocalDate date = auditDatePicker.getValue();
        String countStr = verifiedPaymentsTextField.getText();

        if (period == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Audit Period");
            alert.setContentText("Please select audit period.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Audit Date");
            alert.setContentText("Please select audit date.");
            alert.showAndWait();
            return;
        }

        if (countStr == null || countStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Verified Payments Total");
            alert.setContentText("Please enter verified payments total.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.generateFinancialAuditReport(period);
        auditReportTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.financialAuditReports));
    }
}
