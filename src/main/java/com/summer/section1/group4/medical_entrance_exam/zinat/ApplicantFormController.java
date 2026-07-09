package com.summer.section1.group4.medical_entrance_exam.zinat;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ApplicantFormController {
    @javafx.fxml.FXML
    private Label FormStatusLabel;
    @javafx.fxml.FXML
    private TextField FullNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> HscBoardComB;
    @javafx.fxml.FXML
    private DatePicker DobTF;
    @javafx.fxml.FXML
    private ComboBox<String> SscBoardComB;
    @javafx.fxml.FXML
    private TextField SscGpaTF;
    @javafx.fxml.FXML
    private TextField HscGpaTF;

    @javafx.fxml.FXML
    public void SubmitApplicationOA(ActionEvent actionEvent) {
    }
}
