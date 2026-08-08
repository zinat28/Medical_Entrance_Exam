package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.PaymentTransaction;
import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_VerifyPaymentController {

    @FXML
    private TextField transactionIdTextField;

    @FXML
    private ComboBox<String> paymentGatewayComboBox;

    @FXML
    private DatePicker paymentDatePicker;

    @FXML
    private CheckBox bankConfirmedCheckBox;

    @FXML
    private Button verifyButton;

    @FXML
    private TableView<PaymentTransaction> transactionTableView;

    @FXML
    private TableColumn<PaymentTransaction, String> transactionIdColumn;

    @FXML
    private TableColumn<PaymentTransaction, Double> amountColumn;

    @FXML
    private TableColumn<PaymentTransaction, String> paymentDateColumn;

    @FXML
    private TableColumn<PaymentTransaction, String> bankReferenceColumn;

    @FXML
    private TableColumn<PaymentTransaction, Boolean> isReconciledColumn;

    @FXML
    private TableColumn<PaymentTransaction, String> statusColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        paymentGatewayComboBox.setItems(FXCollections.observableArrayList("bKash", "Nagad", "Rocket", "Bank Transfer"));
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        bankReferenceColumn.setCellValueFactory(new PropertyValueFactory<>("bankReference"));
        isReconciledColumn.setCellValueFactory(new PropertyValueFactory<>("isReconciled"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        transactionTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.paymentTransactions));
    }

    @FXML
    public void handleVerifyPayment(ActionEvent event) {
        String txId = transactionIdTextField.getText();
        String gateway = paymentGatewayComboBox.getValue();
        LocalDate date = paymentDatePicker.getValue();

        if (txId == null || txId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Transaction ID");
            alert.setContentText("Please enter transaction ID.");
            alert.showAndWait();
            return;
        }

        if (gateway == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Gateway");
            alert.setContentText("Please select payment gateway.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select payment date.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.verifyApplicationPayment(txId);
        transactionTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.paymentTransactions));
    }
}
