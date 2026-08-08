package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.ExamSchedule;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_CreateExamScheduleController {

    @FXML
    private DatePicker scheduleDatePicker;

    @FXML
    private TextField startTimeTextField;

    @FXML
    private TextField durationTextField;

    @FXML
    private ComboBox<String> examTypeComboBox;

    @FXML
    private CheckBox saveDraftCheckBox;

    @FXML
    private Button createButton;

    @FXML
    private TableView<ExamSchedule> scheduleTableView;

    @FXML
    private TableColumn<ExamSchedule, String> scheduleIdColumn;

    @FXML
    private TableColumn<ExamSchedule, String> examDateColumn;

    @FXML
    private TableColumn<ExamSchedule, String> startTimeColumn;

    @FXML
    private TableColumn<ExamSchedule, Integer> durationMinutesColumn;

    @FXML
    private TableColumn<ExamSchedule, Boolean> isSavedColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        examTypeComboBox.setItems(FXCollections.observableArrayList("Medical Licensing", "Residency Exam", "Specialty Board"));
        scheduleIdColumn.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        examDateColumn.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        durationMinutesColumn.setCellValueFactory(new PropertyValueFactory<>("durationMinutes"));
        isSavedColumn.setCellValueFactory(new PropertyValueFactory<>("isSaved"));
        scheduleTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examScheduleList));
    }

    @FXML
    public void handleCreateExamSchedule(ActionEvent event) {
        LocalDate date = scheduleDatePicker.getValue();
        String startTime = startTimeTextField.getText();
        String durationStr = durationTextField.getText();
        String examType = examTypeComboBox.getValue();

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Exam Date");
            alert.setContentText("Please select exam date.");
            alert.showAndWait();
            return;
        }

        if (startTime == null || startTime.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Start Time");
            alert.setContentText("Please enter start time.");
            alert.showAndWait();
            return;
        }

        if (durationStr == null || durationStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Duration");
            alert.setContentText("Please enter duration in minutes.");
            alert.showAndWait();
            return;
        }

        if (examType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Exam Type");
            alert.setContentText("Please select exam type.");
            alert.showAndWait();
            return;
        }

        int duration = 180;
        try {
            duration = Integer.parseInt(durationStr.trim());
        } catch (NumberFormatException e) {
            duration = 180;
        }

        ExamAdministrator.createExamSchedule(date.toString(), startTime, duration);
        scheduleTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examScheduleList));
    }
}
