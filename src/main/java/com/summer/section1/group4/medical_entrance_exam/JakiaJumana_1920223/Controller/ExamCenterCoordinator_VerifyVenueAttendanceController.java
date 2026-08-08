package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.VenueAttendance;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExamCenterCoordinator_VerifyVenueAttendanceController {

    @FXML
    private TextField venueIdTextField;

    @FXML
    private TextField centerIdTextField;

    @FXML
    private TextField totalCandidatesTextField;

    @FXML
    private TextField verifiedPresentTextField;

    @FXML
    private CheckBox fullAttendanceCheckBox;

    @FXML
    private Button verifyButton;

    @FXML
    private TableView<VenueAttendance> venueAttendanceTableView;

    @FXML
    private TableColumn<VenueAttendance, String> attendanceIdColumn;

    @FXML
    private TableColumn<VenueAttendance, String> venueIdColumn;

    @FXML
    private TableColumn<VenueAttendance, String> centerIdColumn;

    @FXML
    private TableColumn<VenueAttendance, Integer> totalCandidatesColumn;

    @FXML
    private TableColumn<VenueAttendance, Integer> verifiedPresentCountColumn;

    @FXML
    private TableColumn<VenueAttendance, Boolean> isFullAttendanceMarkedColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        attendanceIdColumn.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
        venueIdColumn.setCellValueFactory(new PropertyValueFactory<>("venueId"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        totalCandidatesColumn.setCellValueFactory(new PropertyValueFactory<>("totalCandidates"));
        verifiedPresentCountColumn.setCellValueFactory(new PropertyValueFactory<>("verifiedPresentCount"));
        isFullAttendanceMarkedColumn.setCellValueFactory(new PropertyValueFactory<>("isFullAttendanceMarked"));
        venueAttendanceTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.venueAttendanceList));
    }

    @FXML
    public void handleVerifyVenueAttendance(ActionEvent event) {
        String venueId = venueIdTextField.getText();
        String centerId = centerIdTextField.getText();
        String totalStr = totalCandidatesTextField.getText();
        String presentStr = verifiedPresentTextField.getText();

        if (venueId == null || venueId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Venue ID");
            alert.setContentText("Please enter venue ID.");
            alert.showAndWait();
            return;
        }

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
            alert.setHeaderText("Missing Total Candidates");
            alert.setContentText("Please enter total candidates count.");
            alert.showAndWait();
            return;
        }

        if (presentStr == null || presentStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Verified Present");
            alert.setContentText("Please enter verified present count.");
            alert.showAndWait();
            return;
        }

        int total = 200;
        int present = 195;
        try {
            total = Integer.parseInt(totalStr.trim());
            present = Integer.parseInt(presentStr.trim());
        } catch (NumberFormatException e) {
            total = 200;
            present = 195;
        }

        ExamCenterCoordinator.verifyVenueAttendance(venueId, centerId, total, present);
        venueAttendanceTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.venueAttendanceList));
    }
}
