package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.AdmitCard;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_GenerateAdmitCardsController {

    @FXML
    private TextField applicantIdTextField;

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private TextField assignedCenterIdTextField;

    @FXML
    private DatePicker issueDatePicker;

    @FXML
    private CheckBox batchGenerationCheckBox;

    @FXML
    private Button generateButton;

    @FXML
    private TableView<AdmitCard> admitCardTableView;

    @FXML
    private TableColumn<AdmitCard, String> admitCardIdColumn;

    @FXML
    private TableColumn<AdmitCard, String> applicantIdColumn;

    @FXML
    private TableColumn<AdmitCard, String> rollNumberColumn;

    @FXML
    private TableColumn<AdmitCard, String> assignedCenterIdColumn;

    @FXML
    private TableColumn<AdmitCard, String> issueDateColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        admitCardIdColumn.setCellValueFactory(new PropertyValueFactory<>("admitCardId"));
        applicantIdColumn.setCellValueFactory(new PropertyValueFactory<>("applicantId"));
        rollNumberColumn.setCellValueFactory(new PropertyValueFactory<>("rollNumber"));
        assignedCenterIdColumn.setCellValueFactory(new PropertyValueFactory<>("assignedCenterId"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        admitCardTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.admitCardList));
    }

    @FXML
    public void handleGenerateAdmitCards(ActionEvent event) {
        String appId = applicantIdTextField.getText();
        String roll = rollNumberTextField.getText();
        String centerId = assignedCenterIdTextField.getText();
        LocalDate date = issueDatePicker.getValue();

        if (appId == null || appId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Applicant ID");
            alert.setContentText("Please enter applicant ID.");
            alert.showAndWait();
            return;
        }

        if (roll == null || roll.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Roll Number");
            alert.setContentText("Please enter roll number.");
            alert.showAndWait();
            return;
        }

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter assigned center ID.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select issue date.");
            alert.showAndWait();
            return;
        }

        ExamAdministrator.generateAdmitCards(appId, roll, centerId);
        admitCardTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.admitCardList));
    }
}
