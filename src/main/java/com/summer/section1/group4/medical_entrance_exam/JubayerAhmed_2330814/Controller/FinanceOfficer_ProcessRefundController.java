package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.RefundRequest;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_ProcessRefundController {

    @FXML
    private TextField candidateIdTextField;

    @FXML
    private TextField refundAmountTextField;

    @FXML
    private ComboBox<String> refundStatusComboBox;

    @FXML
    private DatePicker requestDatePicker;

    @FXML
    private TextArea reasonTextArea;

    @FXML
    private CheckBox eligibilityCheckBox;

    @FXML
    private Button processButton;

    @FXML
    private TableView<RefundRequest> refundTableView;

    @FXML
    private TableColumn<RefundRequest, String> refundIdColumn;

    @FXML
    private TableColumn<RefundRequest, Double> amountColumn;

    @FXML
    private TableColumn<RefundRequest, String> refundReasonColumn;

    @FXML
    private TableColumn<RefundRequest, String> eligibilityStatusColumn;

    @FXML
    private TableColumn<RefundRequest, String> bankAccountDetailsColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        refundStatusComboBox.setItems(FXCollections.observableArrayList("Approved", "Rejected", "Pending"));
        refundIdColumn.setCellValueFactory(new PropertyValueFactory<>("refundId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        refundReasonColumn.setCellValueFactory(new PropertyValueFactory<>("refundReason"));
        eligibilityStatusColumn.setCellValueFactory(new PropertyValueFactory<>("eligibilityStatus"));
        bankAccountDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("bankAccountDetails"));
        refundTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.refundRequests));
    }

    @FXML
    public void handleProcessRefund(ActionEvent event) {
        String candId = candidateIdTextField.getText();
        String amtStr = refundAmountTextField.getText();
        String status = refundStatusComboBox.getValue();
        LocalDate date = requestDatePicker.getValue();
        String reason = reasonTextArea.getText();

        if (candId == null || candId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Candidate ID");
            alert.setContentText("Please enter candidate ID.");
            alert.showAndWait();
            return;
        }

        if (amtStr == null || amtStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Refund Amount");
            alert.setContentText("Please enter refund amount.");
            alert.showAndWait();
            return;
        }

        if (status == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Refund Status");
            alert.setContentText("Please select refund status.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select request date.");
            alert.showAndWait();
            return;
        }

        if (reason == null || reason.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Reason");
            alert.setContentText("Please enter refund reason.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.processRefund(candId, reason);
        refundTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.refundRequests));
    }
}
