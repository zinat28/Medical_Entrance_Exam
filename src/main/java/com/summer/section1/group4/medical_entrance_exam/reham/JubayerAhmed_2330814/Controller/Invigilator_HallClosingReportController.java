package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.HallReport;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_HallClosingReportController {

    @FXML
    private TextField hallIdTextField;

    @FXML
    private ComboBox<String> closingStatusComboBox;

    @FXML
    private DatePicker closingDatePicker;

    @FXML
    private CheckBox sealVerifiedCheckBox;

    @FXML
    private TextArea remarksTextArea;

    @FXML
    private Button generateButton;

    @FXML
    private TableView<HallReport> hallReportTableView;

    @FXML
    private TableColumn<HallReport, String> hallIdColumn;

    @FXML
    private TableColumn<HallReport, String> remarksColumn;

    @FXML
    private TableColumn<HallReport, String> generatedDateColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        closingStatusComboBox.setItems(FXCollections.observableArrayList("Normal Close", "Disputed Close", "Emergency Close"));
        hallIdColumn.setCellValueFactory(new PropertyValueFactory<>("hallId"));
        remarksColumn.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        generatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        hallReportTableView.setItems(FXCollections.observableArrayList(Invigilator.hallReports));
    }

    @FXML
    public void handleGenerateHallClosingReport(ActionEvent event) {
        String hallId = hallIdTextField.getText();
        String status = closingStatusComboBox.getValue();
        LocalDate date = closingDatePicker.getValue();
        String remarks = remarksTextArea.getText();

        if (hallId == null || hallId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Hall ID");
            alert.setContentText("Please enter exam hall ID.");
            alert.showAndWait();
            return;
        }

        if (status == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Closing Status");
            alert.setContentText("Please select closing status.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select closing date.");
            alert.showAndWait();
            return;
        }

        if (remarks == null || remarks.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Remarks");
            alert.setContentText("Please enter closing remarks.");
            alert.showAndWait();
            return;
        }

        Invigilator.generateHallClosingReport(hallId, remarks);
        hallReportTableView.setItems(FXCollections.observableArrayList(Invigilator.hallReports));
    }
}
