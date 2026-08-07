package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.AnswerSheet;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_IssueExtraSheetController {

    @FXML
    private TextField rollNumberTextField;

    @FXML
    private TextField sheetSerialTextField;

    @FXML
    private ComboBox<String> sheetTypeComboBox;

    @FXML
    private DatePicker issueDatePicker;

    @FXML
    private CheckBox supervisorSignedCheckBox;

    @FXML
    private Button issueButton;

    @FXML
    private TableView<AnswerSheet> extraSheetTableView;

    @FXML
    private TableColumn<AnswerSheet, String> barcodeColumn;

    @FXML
    private TableColumn<AnswerSheet, String> serialNumberColumn;

    @FXML
    private TableColumn<AnswerSheet, Boolean> isExtraSheetColumn;

    @FXML
    private TableColumn<AnswerSheet, String> collectionStatusColumn;

    @FXML
    public void initialize() {
        Invigilator.loadAllLists();
        sheetTypeComboBox.setItems(FXCollections.observableArrayList("Standard Extra Sheet", "Graph Paper", "Formula Sheet"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        isExtraSheetColumn.setCellValueFactory(new PropertyValueFactory<>("isExtraSheet"));
        collectionStatusColumn.setCellValueFactory(new PropertyValueFactory<>("collectionStatus"));
        extraSheetTableView.setItems(FXCollections.observableArrayList(Invigilator.answerSheets));
    }

    @FXML
    public void handleIssueExtraSheet(ActionEvent event) {
        String roll = rollNumberTextField.getText();
        String serial = sheetSerialTextField.getText();
        String type = sheetTypeComboBox.getValue();
        LocalDate date = issueDatePicker.getValue();

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
            alert.setHeaderText("Missing Sheet Serial");
            alert.setContentText("Please enter sheet serial number.");
            alert.showAndWait();
            return;
        }

        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Sheet Type");
            alert.setContentText("Please select sheet type.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select issuance date.");
            alert.showAndWait();
            return;
        }

        Invigilator.issueExtraAnswerSheet(roll, serial);
        extraSheetTableView.setItems(FXCollections.observableArrayList(Invigilator.answerSheets));
    }
}
