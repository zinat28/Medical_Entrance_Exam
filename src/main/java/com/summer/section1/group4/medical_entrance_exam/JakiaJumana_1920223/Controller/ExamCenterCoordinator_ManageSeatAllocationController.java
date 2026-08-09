package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.SeatAllocation;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExamCenterCoordinator_ManageSeatAllocationController {

    @FXML
    private TextField candidateIdTextField;

    @FXML
    private TextField roomIdTextField;

    @FXML
    private TextField seatNumberTextField;

    @FXML
    private ComboBox<String> allocationStrategyComboBox;

    @FXML
    private CheckBox lockSeatCheckBox;

    @FXML
    private Button allocateButton;

    @FXML
    private TableView<SeatAllocation> seatAllocationTableView;

    @FXML
    private TableColumn<SeatAllocation, String> allocationIdColumn;

    @FXML
    private TableColumn<SeatAllocation, String> candidateIdColumn;

    @FXML
    private TableColumn<SeatAllocation, String> roomIdColumn;

    @FXML
    private TableColumn<SeatAllocation, String> seatNumberColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        allocationStrategyComboBox.setItems(FXCollections.observableArrayList("Sequential Roll", "Randomized", "Special Accessibility Needs"));
        allocationIdColumn.setCellValueFactory(new PropertyValueFactory<>("allocationId"));
        candidateIdColumn.setCellValueFactory(new PropertyValueFactory<>("candidateId"));
        roomIdColumn.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        seatAllocationTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.seatAllocationList));
    }

    @FXML
    public void handleManageSeatAllocation(ActionEvent event) {
        String candId = candidateIdTextField.getText();
        String roomId = roomIdTextField.getText();
        String seatNum = seatNumberTextField.getText();
        String strategy = allocationStrategyComboBox.getValue();

        if (candId == null || candId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Candidate ID");
            alert.setContentText("Please enter candidate ID.");
            alert.showAndWait();
            return;
        }

        if (roomId == null || roomId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Room ID");
            alert.setContentText("Please enter room ID.");
            alert.showAndWait();
            return;
        }

        if (seatNum == null || seatNum.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Seat Number");
            alert.setContentText("Please enter seat number.");
            alert.showAndWait();
            return;
        }

        if (strategy == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Strategy");
            alert.setContentText("Please select allocation strategy.");
            alert.showAndWait();
            return;
        }

        ExamCenterCoordinator.manageSeatAllocation(candId, roomId, seatNum);
        seatAllocationTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.seatAllocationList));
    }
}
