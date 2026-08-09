package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.AbsentReport;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamCenterCoordinator_ReportAbsentCandidatesController {

    @FXML
    private TextField centerIdTextField;

    @FXML
    private TextField totalAbsentTextField;

    @FXML
    private ComboBox<String> reasonComboBox;

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private CheckBox notifyAdminCheckBox;

    @FXML
    private Button reportButton;

    @FXML
    private TableView<AbsentReport> absentReportTableView;

    @FXML
    private TableColumn<AbsentReport, String> reportIdColumn;

    @FXML
    private TableColumn<AbsentReport, String> generatedDateColumn;

    @FXML
    private TableColumn<AbsentReport, String> centerIdColumn;

    @FXML
    private TableColumn<AbsentReport, Integer> totalAbsentCountColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        reasonComboBox.setItems(FXCollections.observableArrayList("No Show", "Medical Exemption", "Late Arrival Disqualification"));
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        totalAbsentCountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAbsentCount"));
        absentReportTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.absentReportList));
    }

    @FXML
    public void handleReportAbsentCandidates(ActionEvent event) {
        String centerId = centerIdTextField.getText();
        String absentStr = totalAbsentTextField.getText();
        String reason = reasonComboBox.getValue();
        LocalDate date = reportDatePicker.getValue();

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter center ID.");
            alert.showAndWait();
            return;
        }

        if (absentStr == null || absentStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Absent Count");
            alert.setContentText("Please enter total absent count.");
            alert.showAndWait();
            return;
        }

        if (reason == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Primary Reason");
            alert.setContentText("Please select primary reason.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select report date.");
            alert.showAndWait();
            return;
        }

        int absent = 5;
        try {
            absent = Integer.parseInt(absentStr.trim());
        } catch (NumberFormatException e) {
            absent = 5;
        }

        ExamCenterCoordinator.reportAbsentCandidates(centerId, absent);
        absentReportTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.absentReportList));
    }
}
