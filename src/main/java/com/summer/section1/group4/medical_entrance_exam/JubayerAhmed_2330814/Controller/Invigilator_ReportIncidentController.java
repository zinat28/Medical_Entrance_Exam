package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.IncidentReport;
import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_ReportIncidentController {

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private TextField photoPathTextField;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private DatePicker incidentDatePicker;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private CheckBox urgentCheckBox;

    @FXML
    private Button reportButton;

    @FXML
    private TableView<IncidentReport> incidentTableView;

    @FXML
    private TableColumn<IncidentReport, String> incidentIdColumn;

    @FXML
    private TableColumn<IncidentReport, String> timestampColumn;

    @FXML
    private TableColumn<IncidentReport, String> descriptionColumn;

    @FXML
    private TableColumn<IncidentReport, String> statusColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        categoryComboBox.setItems(FXCollections.observableArrayList("Misconduct", "Technical Issue", "Medical Emergency"));
        incidentIdColumn.setCellValueFactory(new PropertyValueFactory<>("incidentId"));
        timestampColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        incidentTableView.setItems(FXCollections.observableArrayList(Invigilator.incidentReports));
    }

    @FXML
    public void handleReportIncident(ActionEvent event) {
        String roll = rollNumberTextField.getText();
        String photo = photoPathTextField.getText();
        String category = categoryComboBox.getValue();
        LocalDate date = incidentDatePicker.getValue();
        String desc = descriptionTextArea.getText();

        if (roll == null || roll.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Roll Number");
            alert.setContentText("Please enter candidate roll number.");
            alert.showAndWait();
            return;
        }

        if (photo == null || photo.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Evidence Reference");
            alert.setContentText("Please enter evidence reference.");
            alert.showAndWait();
            return;
        }

        if (category == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Category");
            alert.setContentText("Please select incident category.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select incident date.");
            alert.showAndWait();
            return;
        }

        if (desc == null || desc.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Description");
            alert.setContentText("Please enter incident description.");
            alert.showAndWait();
            return;
        }

        Invigilator.reportIncident(roll, "10:30 AM", desc, photo);
        incidentTableView.setItems(FXCollections.observableArrayList(Invigilator.incidentReports));
    }
}
