package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.CenterDocument;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamCenterCoordinator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamCenterCoordinator_DownloadCenterDocumentController {

    @FXML
    private TextField centerIdTextField;

    @FXML
    private TextField documentTitleTextField;

    @FXML
    private ComboBox<String> fileFormatComboBox;

    @FXML
    private DatePicker downloadDatePicker;

    @FXML
    private CheckBox verifyHashCheckBox;

    @FXML
    private Button downloadButton;

    @FXML
    private TableView<CenterDocument> centerDocumentTableView;

    @FXML
    private TableColumn<CenterDocument, String> documentIdColumn;

    @FXML
    private TableColumn<CenterDocument, String> centerIdColumn;

    @FXML
    private TableColumn<CenterDocument, String> titleColumn;

    @FXML
    private TableColumn<CenterDocument, String> fileFormatColumn;

    @FXML
    private TableColumn<CenterDocument, String> downloadUrlColumn;

    @FXML
    public void initialize() {
        ExamCenterCoordinator.loadAllLists();
        fileFormatComboBox.setItems(FXCollections.observableArrayList("PDF", "DOCX", "XLSX", "ZIP"));
        documentIdColumn.setCellValueFactory(new PropertyValueFactory<>("documentId"));
        centerIdColumn.setCellValueFactory(new PropertyValueFactory<>("centerId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        fileFormatColumn.setCellValueFactory(new PropertyValueFactory<>("fileFormat"));
        downloadUrlColumn.setCellValueFactory(new PropertyValueFactory<>("downloadUrl"));
        centerDocumentTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.centerDocumentList));
    }

    @FXML
    public void handleDownloadCenterDocument(ActionEvent event) {
        String centerId = centerIdTextField.getText();
        String title = documentTitleTextField.getText();
        String format = fileFormatComboBox.getValue();
        LocalDate date = downloadDatePicker.getValue();

        if (centerId == null || centerId.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Center ID");
            alert.setContentText("Please enter center ID.");
            alert.showAndWait();
            return;
        }

        if (title == null || title.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Document Title");
            alert.setContentText("Please enter document title.");
            alert.showAndWait();
            return;
        }

        if (format == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing File Format");
            alert.setContentText("Please select file format.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select download date.");
            alert.showAndWait();
            return;
        }

        ExamCenterCoordinator.downloadCenterDocument(centerId, title, format);
        centerDocumentTableView.setItems(FXCollections.observableArrayList(ExamCenterCoordinator.centerDocumentList));
    }
}
