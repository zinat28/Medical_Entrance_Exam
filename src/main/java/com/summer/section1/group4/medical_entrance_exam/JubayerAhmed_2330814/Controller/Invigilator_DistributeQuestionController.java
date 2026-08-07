package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.QuestionBooklet;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_DistributeQuestionController {

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private TextField bookletSerialTextField;

    @FXML
    private ComboBox<String> examSetComboBox;

    @FXML
    private DatePicker distributionDatePicker;

    @FXML
    private CheckBox receiptAckCheckBox;

    @FXML
    private Button distributeButton;

    @FXML
    private TableView<QuestionBooklet> bookletTableView;

    @FXML
    private TableColumn<QuestionBooklet, String> serialNumberColumn;

    @FXML
    private TableColumn<QuestionBooklet, String> examSetCodeColumn;

    @FXML
    private TableColumn<QuestionBooklet, Boolean> isDistributedColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        examSetComboBox.setItems(FXCollections.observableArrayList("Set A", "Set B", "Set C", "Set D"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        examSetCodeColumn.setCellValueFactory(new PropertyValueFactory<>("examSetCode"));
        isDistributedColumn.setCellValueFactory(new PropertyValueFactory<>("isDistributed"));
        bookletTableView.setItems(FXCollections.observableArrayList(Invigilator.questionBooklets));
    }

    @FXML
    public void handleDistributeQuestion(ActionEvent event) {
        String roll = rollNumberTextField.getText();
        String serial = bookletSerialTextField.getText();
        String examSet = examSetComboBox.getValue();
        LocalDate date = distributionDatePicker.getValue();

        if (roll == null || roll.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Roll Number");
            alert.setContentText("Please enter candidate roll number.");
            alert.showAndWait();
            return;
        }

        if (serial == null || serial.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Booklet Serial");
            alert.setContentText("Please enter booklet serial number.");
            alert.showAndWait();
            return;
        }

        if (examSet == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Exam Set");
            alert.setContentText("Please select exam set code.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select distribution date.");
            alert.showAndWait();
            return;
        }

        Invigilator.distributeQuestionBooklet(roll, serial);
        bookletTableView.setItems(FXCollections.observableArrayList(Invigilator.questionBooklets));
    }
}
