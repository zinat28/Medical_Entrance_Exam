package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.InstituteDisbursement;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_DisburseShareController {

    @FXML
    private TextField instituteIdTextField;

    @FXML
    private ComboBox<String> periodComboBox;

    @FXML
    private TextField disbursementAmountTextField;

    @FXML
    private DatePicker transferDatePicker;

    @FXML
    private CheckBox boardApprovalCheckBox;

    @FXML
    private Button disburseButton;

    @FXML
    private TableView<InstituteDisbursement> disbursementTableView;

    @FXML
    private TableColumn<InstituteDisbursement, String> disbursementIdColumn;

    @FXML
    private TableColumn<InstituteDisbursement, String> instituteIdColumn;

    @FXML
    private TableColumn<InstituteDisbursement, String> periodColumn;

    @FXML
    private TableColumn<InstituteDisbursement, Integer> lockedCandidateCountColumn;

    @FXML
    private TableColumn<InstituteDisbursement, Double> agreementPercentageColumn;

    @FXML
    private TableColumn<InstituteDisbursement, Double> calculatedShareAmountColumn;

    @FXML
    private TableColumn<InstituteDisbursement, String> bankTransferStatusColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        periodComboBox.setItems(FXCollections.observableArrayList("2026-Q1", "2026-Q2", "2026-Q3", "2026-Q4"));
        disbursementIdColumn.setCellValueFactory(new PropertyValueFactory<>("disbursementId"));
        instituteIdColumn.setCellValueFactory(new PropertyValueFactory<>("instituteId"));
        periodColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
        lockedCandidateCountColumn.setCellValueFactory(new PropertyValueFactory<>("lockedCandidateCount"));
        agreementPercentageColumn.setCellValueFactory(new PropertyValueFactory<>("agreementPercentage"));
        calculatedShareAmountColumn.setCellValueFactory(new PropertyValueFactory<>("calculatedShareAmount"));
        bankTransferStatusColumn.setCellValueFactory(new PropertyValueFactory<>("bankTransferStatus"));
        disbursementTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.instituteDisbursements));
    }

    @FXML
    public void handleDisburseShare(ActionEvent event) {
        String instId = instituteIdTextField.getText();
        String period = periodComboBox.getValue();
        String amtStr = disbursementAmountTextField.getText();
        LocalDate date = transferDatePicker.getValue();

        if (instId == null || instId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Institute ID");
            alert.setContentText("Please enter institute ID.");
            alert.showAndWait();
            return;
        }

        if (period == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Period");
            alert.setContentText("Please select disbursement period.");
            alert.showAndWait();
            return;
        }

        if (amtStr == null || amtStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Transfer Amount");
            alert.setContentText("Please enter transfer amount.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Transfer Date");
            alert.setContentText("Please select transfer date.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.disburseInstituteShare(instId, period);
        disbursementTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.instituteDisbursements));
    }
}
