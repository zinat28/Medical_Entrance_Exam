package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.CapacityStatus;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamCenterCoordinator_GetCenterDetailsController {

    @FXML
    private TextField centerIdTextField;

    @FXML
    private ComboBox<String> queryTypeComboBox;

    @FXML
    private DatePicker asOfDatePicker;

    @FXML
    private CheckBox includeCandidatesCheckBox;

    @FXML
    private Button queryButton;

    @FXML
    private TableView<CapacityStatus> capacityStatusTableView;

    @FXML
    private TableColumn<CapacityStatus, String> statusIdColumn;

    @FXML
    private TableColumn<CapacityStatus, String> centerIdColumn;

    @FXML
    private TableColumn<CapacityStatus, Integer> totalCapacityColumn;

    @FXML
    private TableColumn<CapacityStatus, Integer> allocatedSeatsColumn;

    @FXML
    private TableColumn<CapacityStatus, Integer> availableSeatsColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        queryTypeComboBox.setItems(FXCollections.observableArrayList("Full Audit", "Capacity Check", "Roster Sync"));
        statusIdColumn.setCellValueFactory(new PropertyValueFactory<>("statusId"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        totalCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("totalCapacity"));
        allocatedSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("allocatedSeats"));
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));
        capacityStatusTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.capacityStatusList));
    }

    @FXML
    public void handleGetCenterDetails(ActionEvent event) {
        String centerId = centerIdTextField.getText();
        String type = queryTypeComboBox.getValue();
        LocalDate date = asOfDatePicker.getValue();

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter center ID.");
            alert.showAndWait();
            return;
        }

        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Query Type");
            alert.setContentText("Please select query type.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select as-of date.");
            alert.showAndWait();
            return;
        }

        ExamCenterCoordinator.getCenterAndCandidateDetails(centerId);
        capacityStatusTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.capacityStatusList));
    }
}
