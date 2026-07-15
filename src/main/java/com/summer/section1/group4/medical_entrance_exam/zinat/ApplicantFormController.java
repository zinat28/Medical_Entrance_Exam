package com.summer.section1.group4.medical_entrance_exam.zinat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApplicantFormController {
    @javafx.fxml.FXML
    private TextField FullNameTF;
    @javafx.fxml.FXML
    private DatePicker DobTF;
    @javafx.fxml.FXML
    private ComboBox<String> SscBoardComB;
    @javafx.fxml.FXML
    private ComboBox<String> HscBoardComB;
    @javafx.fxml.FXML
    private TextField SscGpaTF;
    @javafx.fxml.FXML
    private TextField HscGpaTF;
    @javafx.fxml.FXML
    private Label FormStatusLabel;


    @FXML
    public void initialize(){
        String[] boards = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barishal", "Khulna", "Jessore", "Dinajpur", "Cumilla", "Mymensingh", "Technical", "Madrasah"};
        SscBoardComB.getItems().addAll(boards);
        HscBoardComB.getItems().addAll(boards);
    }

    @javafx.fxml.FXML
    public void SubmitApplicationOA(ActionEvent actionEvent) {
        if (FullNameTF.getText().trim().isEmpty() || SscGpaTF.getText().trim().isEmpty() || HscGpaTF.getText().trim().isEmpty()) {
            FormStatusLabel.setText("VALIDATION ERROR: Please fill out all text boxes!");
            return;
        }
        if (DobTF.getValue() == null || SscBoardComB.getValue() == null || HscBoardComB.getValue() == null) {
            FormStatusLabel.setText("VALIDATION ERROR: Missing date selection or board parameters!");
            return;
        }
        if ((Double.parseDouble(SscGpaTF.getText())>5.00) || (Double.parseDouble(HscGpaTF.getText())>5.00)){
            FormStatusLabel.setText("VALIDATION ERROR: GPA can not be greater than 5.00");
            return;
        }

        Applicant a = new Applicant(
                FullNameTF.getText(),
                SscBoardComB.getValue(),
                HscBoardComB.getValue(),
                Double.parseDouble(SscGpaTF.getText()),
                Double.parseDouble(HscGpaTF.getText()),
                DobTF.getValue());

        FormStatusLabel.setText("SUCCESS: Saved! Move to Goal 2: Document Uploads next.");


    }
}
