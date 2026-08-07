package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.Candidate;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_ReVerifyCandidateController {

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private ComboBox<String> reasonComboBox;

    @FXML
    private DatePicker reVerifyDatePicker;

    @FXML
    private CheckBox biometricMatchCheckBox;

    @FXML
    private Button reVerifyButton;

    @FXML
    private TableView<Candidate> candidateTableView;

    @FXML
    private TableColumn<Candidate, String> candidateIdColumn;

    @FXML
    private TableColumn<Candidate, String> rollNumberColumn;

    @FXML
    private TableColumn<Candidate, String> nameColumn;

    @FXML
    private TableColumn<Candidate, String> assignedHallIdColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        reasonComboBox.setItems(FXCollections.observableArrayList("Discrepancy", "Random Check", "Supervisor Request"));
        candidateIdColumn.setCellValueFactory(new PropertyValueFactory<>("candidateId"));
        rollNumberColumn.setCellValueFactory(new PropertyValueFactory<>("rollNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        assignedHallIdColumn.setCellValueFactory(new PropertyValueFactory<>("assignedHallId"));
        candidateTableView.setItems(FXCollections.observableArrayList(Invigilator.candidateList));
    }

    @FXML
    public void handleReVerifyCandidate(ActionEvent event) {
        String roll = rollNumberTextField.getText();
        String reason = reasonComboBox.getValue();
        LocalDate date = reVerifyDatePicker.getValue();

        if (roll == null || roll.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Roll Number");
            alert.setContentText("Please enter candidate roll number.");
            alert.showAndWait();
            return;
        }

        if (reason == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Reason");
            alert.setContentText("Please select re-verification reason.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select re-verification date.");
            alert.showAndWait();
            return;
        }

        Invigilator.reVerifyCandidateIdentity(roll);
        candidateTableView.setItems(FXCollections.observableArrayList(Invigilator.candidateList));
    }
}
