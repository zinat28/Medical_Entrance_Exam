package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.ScholarshipRecord;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.FinanceOfficer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinanceOfficer_AdjustScholarshipController {

    @FXML
    private TextField candidateIdTextField;

    @FXML
    private ComboBox<String> scholarshipTypeComboBox;

    @FXML
    private TextField adjustedFeeTextField;

    @FXML
    private DatePicker adjustmentDatePicker;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private CheckBox approvalFlagCheckBox;

    @FXML
    private Button adjustButton;

    @FXML
    private TableView<ScholarshipRecord> scholarshipTableView;

    @FXML
    private TableColumn<ScholarshipRecord, String> scholarshipIdColumn;

    @FXML
    private TableColumn<ScholarshipRecord, String> approvalStatusColumn;

    @FXML
    private TableColumn<ScholarshipRecord, Double> originalFeeAmountColumn;

    @FXML
    private TableColumn<ScholarshipRecord, Double> adjustedFeeAmountColumn;

    @FXML
    public void initialize() {
        FinanceOfficer.loadAllLists();
        scholarshipTypeComboBox.setItems(FXCollections.observableArrayList("Merit Waiver", "Financial Aid", "Government Grant"));
        scholarshipIdColumn.setCellValueFactory(new PropertyValueFactory<>("scholarshipId"));
        approvalStatusColumn.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
        originalFeeAmountColumn.setCellValueFactory(new PropertyValueFactory<>("originalFeeAmount"));
        adjustedFeeAmountColumn.setCellValueFactory(new PropertyValueFactory<>("adjustedFeeAmount"));
        scholarshipTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.scholarshipRecords));
    }

    @FXML
    public void handleAdjustScholarshipFee(ActionEvent event) {
        String candId = candidateIdTextField.getText();
        String type = scholarshipTypeComboBox.getValue();
        String feeStr = adjustedFeeTextField.getText();
        LocalDate date = adjustmentDatePicker.getValue();
        String details = detailsTextArea.getText();

        if (candId == null || candId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Candidate ID");
            alert.setContentText("Please enter candidate ID.");
            alert.showAndWait();
            return;
        }

        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Scholarship Type");
            alert.setContentText("Please select scholarship type.");
            alert.showAndWait();
            return;
        }

        if (feeStr == null || feeStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Adjusted Fee");
            alert.setContentText("Please enter adjusted fee.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Adjustment Date");
            alert.setContentText("Please select adjustment date.");
            alert.showAndWait();
            return;
        }

        if (details == null || details.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Scholarship Details");
            alert.setContentText("Please enter scholarship details.");
            alert.showAndWait();
            return;
        }

        FinanceOfficer.adjustScholarshipFee(candId, details);
        scholarshipTableView.setItems(FXCollections.observableArrayList(FinanceOfficer.scholarshipRecords));
    }
}
