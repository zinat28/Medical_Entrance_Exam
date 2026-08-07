package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.AttendanceRecord;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_ApproveLateEntryController {

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private TextField arrivalTimeTextField;

    @FXML
    private ComboBox<String> lateReasonComboBox;

    @FXML
    private DatePicker entryDatePicker;

    @FXML
    private CheckBox invigilatorApprovalCheckBox;

    @FXML
    private TextArea remarksTextArea;

    @FXML
    private Button approveButton;

    @FXML
    private TableView<AttendanceRecord> lateEntryTableView;

    @FXML
    private TableColumn<AttendanceRecord, String> recordIdColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> checkTimeColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> statusColumn;

    @FXML
    private TableColumn<AttendanceRecord, Boolean> isLateEntryColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> arrivalTimeColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        lateReasonComboBox.setItems(FXCollections.observableArrayList("Traffic Delay", "Transport Issue", "Medical Reason"));
        recordIdColumn.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        checkTimeColumn.setCellValueFactory(new PropertyValueFactory<>("checkTime"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        isLateEntryColumn.setCellValueFactory(new PropertyValueFactory<>("isLateEntry"));
        arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        lateEntryTableView.setItems(FXCollections.observableArrayList(Invigilator.attendanceRecords));
    }

    @FXML
    public void handleApproveLateEntry(ActionEvent event) {
        String roll = rollNumberTextField.getText();
        String arrival = arrivalTimeTextField.getText();
        String reason = lateReasonComboBox.getValue();
        LocalDate date = entryDatePicker.getValue();

        if (roll == null || roll.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Roll Number");
            alert.setContentText("Please enter candidate roll number.");
            alert.showAndWait();
            return;
        }

        if (arrival == null || arrival.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Arrival Time");
            alert.setContentText("Please enter actual arrival time.");
            alert.showAndWait();
            return;
        }

        if (reason == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Late Reason");
            alert.setContentText("Please select late entry reason.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select entry date.");
            alert.showAndWait();
            return;
        }

        Invigilator.approveLateEntry(roll, arrival);
        lateEntryTableView.setItems(FXCollections.observableArrayList(Invigilator.attendanceRecords));
    }
}
