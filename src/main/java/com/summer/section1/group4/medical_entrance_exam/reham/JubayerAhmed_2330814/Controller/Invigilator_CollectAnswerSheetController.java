package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.Controller;

import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser.AnswerSheet;
import com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.Invigilator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Invigilator_CollectAnswerSheetController {

    @FXML
    private TextField sheetBarcodeTextField;

    @FXML
    private TextField manifestIdTextField;

    @FXML
    private ComboBox<String> collectionStatusComboBox;

    @FXML
    private DatePicker collectionDatePicker;

    @FXML
    private CheckBox verifiedBarcodeCheckBox;

    @FXML
    private Button collectButton;

    @FXML
    private TableView<AnswerSheet> answerSheetTableView;

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
        collectionStatusComboBox.setItems(FXCollections.observableArrayList("Collected", "Pending", "Damaged"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        isExtraSheetColumn.setCellValueFactory(new PropertyValueFactory<>("isExtraSheet"));
        collectionStatusColumn.setCellValueFactory(new PropertyValueFactory<>("collectionStatus"));
        answerSheetTableView.setItems(FXCollections.observableArrayList(Invigilator.answerSheets));
    }

    @FXML
    public void handleCollectAnswerSheet(ActionEvent event) {
        String barcode = sheetBarcodeTextField.getText();
        String manifest = manifestIdTextField.getText();
        String status = collectionStatusComboBox.getValue();
        LocalDate date = collectionDatePicker.getValue();

        if (barcode == null || barcode.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Barcode");
            alert.setContentText("Please enter sheet barcode.");
            alert.showAndWait();
            return;
        }

        if (manifest == null || manifest.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Manifest ID");
            alert.setContentText("Please enter manifest ID.");
            alert.showAndWait();
            return;
        }

        if (status == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Collection Status");
            alert.setContentText("Please select collection status.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select collection date.");
            alert.showAndWait();
            return;
        }

        Invigilator.collectAnswerSheet(barcode, manifest);
        answerSheetTableView.setItems(FXCollections.observableArrayList(Invigilator.answerSheets));
    }
}
