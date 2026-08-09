package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.ExamResult;
import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_PublishExamResultsController {

    @FXML
    private TextField resultFilePathTextField;

    @FXML
    private TextField totalProcessedTextField;

    @FXML
    private ComboBox<String> sessionComboBox;

    @FXML
    private DatePicker publishDatePicker;

    @FXML
    private CheckBox notifyCandidatesCheckBox;

    @FXML
    private Button publishButton;

    @FXML
    private TableView<ExamResult> examResultTableView;

    @FXML
    private TableColumn<ExamResult, String> resultIdColumn;

    @FXML
    private TableColumn<ExamResult, String> resultFilePathColumn;

    @FXML
    private TableColumn<ExamResult, String> uploadTimestampColumn;

    @FXML
    private TableColumn<ExamResult, Integer> totalProcessedColumn;

    @FXML
    private TableColumn<ExamResult, Boolean> isPublishedColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        sessionComboBox.setItems(FXCollections.observableArrayList("2026-Session-1", "2026-Session-2", "Special Batch"));
        resultIdColumn.setCellValueFactory(new PropertyValueFactory<>("resultId"));
        resultFilePathColumn.setCellValueFactory(new PropertyValueFactory<>("resultFilePath"));
        uploadTimestampColumn.setCellValueFactory(new PropertyValueFactory<>("uploadTimestamp"));
        totalProcessedColumn.setCellValueFactory(new PropertyValueFactory<>("totalProcessed"));
        isPublishedColumn.setCellValueFactory(new PropertyValueFactory<>("isPublished"));
        examResultTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examResultList));
    }

    @FXML
    public void handlePublishExamResults(ActionEvent event) {
        String path = resultFilePathTextField.getText();
        String countStr = totalProcessedTextField.getText();
        String session = sessionComboBox.getValue();
        LocalDate date = publishDatePicker.getValue();

        if (path == null || path.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing File Path");
            alert.setContentText("Please enter result file path.");
            alert.showAndWait();
            return;
        }

        if (countStr == null || countStr.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Processed Count");
            alert.setContentText("Please enter total processed count.");
            alert.showAndWait();
            return;
        }

        if (session == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Session");
            alert.setContentText("Please select exam session.");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Date");
            alert.setContentText("Please select publish date.");
            alert.showAndWait();
            return;
        }

        int processed = 1200;
        try {
            processed = Integer.parseInt(countStr.trim());
        } catch (NumberFormatException e) {
            processed = 1200;
        }

        ExamAdministrator.publishExamResults(path, processed);
        examResultTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examResultList));
    }
}
