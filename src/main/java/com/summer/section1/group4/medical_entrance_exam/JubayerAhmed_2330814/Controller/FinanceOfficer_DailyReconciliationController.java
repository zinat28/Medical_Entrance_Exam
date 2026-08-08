package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.DailyReconciliation;
import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_DailyReconciliationController {

    @FXML
    private DatePicker reconciliationDatePicker;

    @FXML
    private ComboBox<String> modeComboBox;

    @FXML
    private TextField gatewayTotalTextField;

    @FXML
    private TextField bankTotalTextField;

    @FXML
    private CheckBox auditMismatchCheckBox;

    @FXML
    private Button reconcileButton;

    @FXML
    private TableView<DailyReconciliation> reconciliationTableView;

    @FXML
    private TableColumn<DailyReconciliation, String> reconciliationIdColumn;

    @FXML
    private TableColumn<DailyReconciliation, String> dateColumn;

    @FXML
    private TableColumn<DailyReconciliation, Double> gatewayCollectedTotalColumn;

    @FXML
    private TableColumn<DailyReconciliation, Double> bankSettlementTotalColumn;

    @FXML
    private TableColumn<DailyReconciliation, Integer> mismatchCountColumn;

    @FXML
    private TableColumn<DailyReconciliation, String> statusColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        modeComboBox.setItems(FXCollections.observableArrayList("Automatic", "Manual Audit", "Strict Batch"));
        reconciliationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reconciliationId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        gatewayCollectedTotalColumn.setCellValueFactory(new PropertyValueFactory<>("gatewayCollectedTotal"));
        bankSettlementTotalColumn.setCellValueFactory(new PropertyValueFactory<>("bankSettlementTotal"));
        mismatchCountColumn.setCellValueFactory(new PropertyValueFactory<>("mismatchCount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        reconciliationTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.dailyReconciliations));
    }

    @FXML
    public void handlePerformDailyReconciliation(ActionEvent event) {
        LocalDate date = reconciliationDatePicker.getValue();
        String mode = modeComboBox.getValue();
        String gwTotal = gatewayTotalTextField.getText();
        String bankTotal = bankTotalTextField.getText();

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select reconciliation date.");
            alert.showAndWait();
            return;
        }

        if (mode == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Mode");
            alert.setContentText("Please select reconciliation mode.");
            alert.showAndWait();
            return;
        }

        if (gwTotal == null || gwTotal.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Gateway Total");
            alert.setContentText("Please enter gateway total.");
            alert.showAndWait();
            return;
        }

        if (bankTotal == null || bankTotal.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Bank Total");
            alert.setContentText("Please enter bank total.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.performDailyReconciliation(date.toString());
        reconciliationTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.dailyReconciliations));
    }
}
