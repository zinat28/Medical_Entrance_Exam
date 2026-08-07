package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.AttendanceRecord;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_VerifyAttendanceController {

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private TextField admitCardIdTextField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker checkDatePicker;

    @FXML
    private CheckBox verifiedCheckBox;

    @FXML
    private Button verifyButton;

    @FXML
    private TableView<AttendanceRecord> attendanceTableView;

    @FXML
    private TableColumn<AttendanceRecord, String> recordIdColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> checkTimeColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> statusColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> arrivalTimeColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        statusComboBox.setItems(FXCollections.observableArrayList("Verified", "Flagged", "Absent"));
        recordIdColumn.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        checkTimeColumn.setCellValueFactory(new PropertyValueFactory<>("checkTime"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        attendanceTableView.setItems(FXCollections.observableArrayList(Invigilator.attendanceRecords));
    }

    @FXML
    public void handleVerifyAttendance(ActionEvent event) {
        String roll = rollNumberTextField.getText();
        String admitCard = admitCardIdTextField.getText();
        String status = statusComboBox.getValue();
        LocalDate date = checkDatePicker.getValue();

        if (roll == null || roll.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Roll Number");
            alert.setContentText("Please enter candidate roll number.");
            alert.showAndWait();
            return;
        }

        if (admitCard == null || admitCard.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Admit Card ID");
            alert.setContentText("Please enter admit card ID.");
            alert.showAndWait();
            return;
        }

        if (status == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Status");
            alert.setContentText("Please select verification status.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select verification date.");
            alert.showAndWait();
            return;
        }

        Invigilator.verifyAttendanceAndSeating(roll, admitCard);
        attendanceTableView.setItems(FXCollections.observableArrayList(Invigilator.attendanceRecords));
    }
}
