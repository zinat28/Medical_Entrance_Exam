package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.ExamRoom;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExamCenterCoordinator_AssignExamRoomsController {

    @FXML
    private TextField centerIdTextField;

    @FXML
    private TextField roomNumberTextField;

    @FXML
    private TextField capacityTextField;

    @FXML
    private ComboBox<String> roomTypeComboBox;

    @FXML
    private CheckBox isAvailableCheckBox;

    @FXML
    private Button assignButton;

    @FXML
    private TableView<ExamRoom> examRoomTableView;

    @FXML
    private TableColumn<ExamRoom, String> roomIdColumn;

    @FXML
    private TableColumn<ExamRoom, String> centerIdColumn;

    @FXML
    private TableColumn<ExamRoom, String> roomNumberColumn;

    @FXML
    private TableColumn<ExamRoom, Integer> capacityColumn;

    @FXML
    private TableColumn<ExamRoom, Boolean> isAvailableColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        roomTypeComboBox.setItems(FXCollections.observableArrayList("Standard Lecture Hall", "Computer Lab", "Auditorium"));
        roomIdColumn.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
        examRoomTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.examRoomList));
    }

    @FXML
    public void handleAssignExamRooms(ActionEvent event) {
        String centerId = centerIdTextField.getText();
        String roomNumber = roomNumberTextField.getText();
        String capStr = capacityTextField.getText();
        String type = roomTypeComboBox.getValue();

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter center ID.");
            alert.showAndWait();
            return;
        }

        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Room Number");
            alert.setContentText("Please enter room number.");
            alert.showAndWait();
            return;
        }

        if (capStr == null || capStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Room Capacity");
            alert.setContentText("Please enter room capacity.");
            alert.showAndWait();
            return;
        }

        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Room Type");
            alert.setContentText("Please select room type.");
            alert.showAndWait();
            return;
        }

        int capacity = 50;
        try {
            capacity = Integer.parseInt(capStr.trim());
        } catch (NumberFormatException e) {
            capacity = 50;
        }

        ExamCenterCoordinator.assignExamRooms(centerId, roomNumber, capacity);
        examRoomTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.examRoomList));
    }
}
