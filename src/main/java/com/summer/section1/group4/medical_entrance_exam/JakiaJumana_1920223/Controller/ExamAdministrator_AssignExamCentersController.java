package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.ExamCenter;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExamAdministrator_AssignExamCentersController {

    @FXML
    private TextField centerNameTextField;

    @FXML
    private TextField capacityTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private ComboBox<String> regionComboBox;

    @FXML
    private CheckBox activeCenterCheckBox;

    @FXML
    private Button assignButton;

    @FXML
    private TableView<ExamCenter> examCenterTableView;

    @FXML
    private TableColumn<ExamCenter, String> centerIdColumn;

    @FXML
    private TableColumn<ExamCenter, String> centerNameColumn;

    @FXML
    private TableColumn<ExamCenter, Integer> totalCapacityColumn;

    @FXML
    private TableColumn<ExamCenter, Integer> availableSeatsColumn;

    @FXML
    private TableColumn<ExamCenter, String> locationColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        regionComboBox.setItems(FXCollections.observableArrayList("Dhaka Division", "Chittagong Division", "Rajshahi Division", "Sylhet Division"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        centerNameColumn.setCellValueFactory(new PropertyValueFactory<>("centerName"));
        totalCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("totalCapacity"));
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        examCenterTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examCenterList));
    }

    @FXML
    public void handleAssignExamCenters(ActionEvent event) {
        String name = centerNameTextField.getText();
        String capStr = capacityTextField.getText();
        String loc = locationTextField.getText();
        String region = regionComboBox.getValue();

        if (name == null || name.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center Name");
            alert.setContentText("Please enter center name.");
            alert.showAndWait();
            return;
        }

        if (capStr == null || capStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Capacity");
            alert.setContentText("Please enter total capacity.");
            alert.showAndWait();
            return;
        }

        if (loc == null || loc.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Location");
            alert.setContentText("Please enter center location.");
            alert.showAndWait();
            return;
        }

        if (region == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Region");
            alert.setContentText("Please select region.");
            alert.showAndWait();
            return;
        }

        int capacity = 500;
        try {
            capacity = Integer.parseInt(capStr.trim());
        } catch (NumberFormatException e) {
            capacity = 500;
        }

        ExamAdministrator.assignExamCenters(name, capacity, loc);
        examCenterTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examCenterList));
    }
}
