package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller;

import com.example.group4medicalexamsimulation.JakiaJumana_1920223.NonUser.ExamNotice;
import com.example.group4medicalexamsimulation.JakiaJumana_1920223.User.ExamAdministrator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExamAdministrator_PublishExamNoticeController {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<String> targetAudienceComboBox;

    @FXML
    private DatePicker publishDatePicker;

    @FXML
    private CheckBox publishImmediatelyCheckBox;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private Button publishButton;

    @FXML
    private TableView<ExamNotice> noticeTableView;

    @FXML
    private TableColumn<ExamNotice, String> noticeIdColumn;

    @FXML
    private TableColumn<ExamNotice, String> titleColumn;

    @FXML
    private TableColumn<ExamNotice, String> detailsColumn;

    @FXML
    private TableColumn<ExamNotice, String> publishDateColumn;

    @FXML
    private TableColumn<ExamNotice, Boolean> isPublishedColumn;

    @FXML
    public void initialize() {
        ExamAdministrator.loadAllLists();
        targetAudienceComboBox.setItems(FXCollections.observableArrayList("All Candidates", "Invigilators", "Center Coordinators"));
        noticeIdColumn.setCellValueFactory(new PropertyValueFactory<>("noticeId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        publishDateColumn.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
        isPublishedColumn.setCellValueFactory(new PropertyValueFactory<>("isPublished"));
        noticeTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examNoticeList));
    }

    @FXML
    public void handlePublishNotice(ActionEvent event) {
        String title = titleTextField.getText();
        String audience = targetAudienceComboBox.getValue();
        LocalDate date = publishDatePicker.getValue();
        String details = detailsTextArea.getText();

        if (title == null || title.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Title");
            alert.setContentText("Please enter notice title.");
            alert.showAndWait();
            return;
        }

        if (audience == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Target Audience");
            alert.setContentText("Please select target audience.");
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

        if (details == null || details.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Missing Details");
            alert.setContentText("Please enter notice details.");
            alert.showAndWait();
            return;
        }

        ExamAdministrator.publishExamNotice(title, details);
        noticeTableView.setItems(FXCollections.observableArrayList(ExamAdministrator.examNoticeList));
    }
}
