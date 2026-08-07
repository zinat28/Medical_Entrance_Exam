package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.PaymentDispute;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_ResolveDisputeController {

    @FXML
    private TextField transactionIdTextField;

    @FXML
    private ComboBox<String> resolutionTypeComboBox;

    @FXML
    private DatePicker resolutionDatePicker;

    @FXML
    private CheckBox notifyCandidateCheckBox;

    @FXML
    private TextArea disputeDetailsTextArea;

    @FXML
    private Button resolveButton;

    @FXML
    private TableView<PaymentDispute> disputeTableView;

    @FXML
    private TableColumn<PaymentDispute, String> disputeIdColumn;

    @FXML
    private TableColumn<PaymentDispute, String> detailsColumn;

    @FXML
    private TableColumn<PaymentDispute, String> eligibilityStatusColumn;

    @FXML
    private TableColumn<PaymentDispute, String> resolutionOutcomeColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        resolutionTypeComboBox.setItems(FXCollections.observableArrayList("Refund Approved", "Dispute Rejected", "Manual Adjustment"));
        disputeIdColumn.setCellValueFactory(new PropertyValueFactory<>("disputeId"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        eligibilityStatusColumn.setCellValueFactory(new PropertyValueFactory<>("eligibilityStatus"));
        resolutionOutcomeColumn.setCellValueFactory(new PropertyValueFactory<>("resolutionOutcome"));
        disputeTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.paymentDisputes));
    }

    @FXML
    public void handleResolveDispute(ActionEvent event) {
        String txId = transactionIdTextField.getText();
        String resolutionAction = resolutionTypeComboBox.getValue();
        LocalDate date = resolutionDatePicker.getValue();
        String details = disputeDetailsTextArea.getText();

        if (txId == null || txId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Transaction ID");
            alert.setContentText("Please enter transaction ID.");
            alert.showAndWait();
            return;
        }

        if (resolutionAction == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Resolution Action");
            alert.setContentText("Please select resolution action.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Resolution Date");
            alert.setContentText("Please select resolution date.");
            alert.showAndWait();
            return;
        }

        if (details == null || details.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Dispute Details");
            alert.setContentText("Please enter dispute details.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.resolvePaymentDispute(txId, details);
        disputeTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.paymentDisputes));
    }
}
