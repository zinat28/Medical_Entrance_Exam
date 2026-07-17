package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class DocumentUploadController {
    @javafx.fxml.FXML
    private ComboBox<String> HscDocumentComB;
    @javafx.fxml.FXML
    private ComboBox<String> SscDocumentComB;
    @javafx.fxml.FXML
    private ComboBox<String> VerificationDocumentComB;
    @FXML
    private Label DocumentUploadStatusLabel;

    @FXML
    public void initialize(){
        VerificationDocumentComB.getItems().addAll("NID","BirthCertificate", "Passport");
        SscDocumentComB.getItems().addAll("Transcript", "Certificate");
        HscDocumentComB.getItems().addAll("Transcript", "Certificate");

    }

    @javafx.fxml.FXML
    public void VerificationDocumentOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void HscDocumentOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SscDocumentOA(ActionEvent actionEvent) {
    }

    @Deprecated
    public void SubmitApplicationOA(ActionEvent actionEvent) {
    }

    @FXML
    public void SubmitDocumentsOA(ActionEvent actionEvent) {
    }
}
