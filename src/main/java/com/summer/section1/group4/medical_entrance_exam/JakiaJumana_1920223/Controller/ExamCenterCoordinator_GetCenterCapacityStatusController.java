package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.CapacityStatus;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExamCenterCoordinator_GetCenterCapacityStatusController {

    @FXML
    private TextField centerIdTextField;

    @FXML
    private TextField totalCapacityTextField;

    @FXML
    private TextField allocatedSeatsTextField;

    @FXML
    private ComboBox<String> filterStatusComboBox;

    @FXML
    private CheckBox autoRefreshCheckBox;

    @FXML
    private Button checkButton;

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
        filterStatusComboBox.setItems(FXCollections.observableArrayList("All", "Full Capacity", "Available Seats"));
        statusIdColumn.setCellValueFactory(new PropertyValueFactory<>("statusId"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        totalCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("totalCapacity"));
        allocatedSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("allocatedSeats"));
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));
        capacityStatusTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.capacityStatusList));
    }

    @FXML
    public void handleGetCenterCapacityStatus(ActionEvent event) {
        String centerId = centerIdTextField.getText();
        String totalStr = totalCapacityTextField.getText();
        String allocStr = allocatedSeatsTextField.getText();
        String filter = filterStatusComboBox.getValue();

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter center ID.");
            alert.showAndWait();
            return;
        }

        if (totalStr == null || totalStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Total Capacity");
            alert.setContentText("Please enter total capacity.");
            alert.showAndWait();
            return;
        }

        if (allocStr == null || allocStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Allocated Seats");
            alert.setContentText("Please enter allocated seats count.");
            alert.showAndWait();
            return;
        }

        if (filter == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Filter Status");
            alert.setContentText("Please select filter status.");
            alert.showAndWait();
            return;
        }

        int total = 500;
        int alloc = 350;
        try {
            total = Integer.parseInt(totalStr.trim());
            alloc = Integer.parseInt(allocStr.trim());
        } catch (NumberFormatException e) {
            total = 500;
            alloc = 350;
        }

        ExamCenterCoordinator.getCenterCapacityStatus(centerId, total, alloc);
        capacityStatusTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.capacityStatusList));
    }
}
