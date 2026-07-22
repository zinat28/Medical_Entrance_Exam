package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.io.FileWriter;
import java.io.IOException;

public class AdmitCardDownloadController {
    @FXML
    private TextField AdmitCardFullNameTF;
    @FXML
    private Label AdmitCardStatusLabel;
    @FXML
    private TextArea AdmitCardTA;

    @FXML
    public void DownloadAdmitsCardOA(ActionEvent actionEvent) {
        ApplicationSession session = ApplicationSession.getInstance();

        // --- VL: full name box must not be empty ---
        String enteredName = AdmitCardFullNameTF.getText() == null ? "" : AdmitCardFullNameTF.getText().trim();
        if (enteredName.isEmpty()) {
            AdmitCardStatusLabel.setText("STATUS: Please enter your full name.");
            return;
        }

        // --- VR: cross-verify Document Upload Status and Registration Fee State ---
        if (!session.isFormSubmitted()) {
            AdmitCardStatusLabel.setText("STATUS: No application record found. Complete Goal 1 first.");
            return;
        }
        if (!enteredName.equalsIgnoreCase(session.getApplicant().getApplicantName())) {
            AdmitCardStatusLabel.setText("STATUS: Name does not match the record on file.");
            return;
        }
        if (!session.isDocumentsUploaded()) {
            AdmitCardStatusLabel.setText("STATUS: Document Upload Status is not COMPLETED / VERIFIED.");
            return;
        }
        if (!session.isPaymentCleared()) {
            AdmitCardStatusLabel.setText("STATUS: Registration Fee State is not PAID / TRANSACTION SUCCESS.");
            return;
        }

        // --- DP: lazy-loaded random identifier engine -> retrieve (or reuse) the roll number ---
        String roll = session.getOrCreateRollNumber();
        Applicant applicant = session.getApplicant();

        // --- OP: compile the dynamic data summary block ---
        StringBuilder slip = new StringBuilder();
        slip.append("========= APPLICANT REGISTRATION RECORD SLIP =========\n");
        slip.append("Roll Number     : ").append(roll).append("\n");
        slip.append("Full Name       : ").append(applicant.getApplicantName()).append("\n");
        slip.append("Date of Birth   : ").append(applicant.getApplicantDob()).append("\n");
        slip.append("SSC Board / GPA : ").append(applicant.getSscBoard()).append(" / ").append(applicant.getSscGpa()).append("\n");
        slip.append("HSC Board / GPA : ").append(applicant.getHscBoard()).append(" / ").append(applicant.getHscGpa()).append("\n");
        slip.append("Payment Status  : PAID (Fee $").append(String.format("%.2f", ApplicationSession.REGISTRATION_FEE)).append(")\n");
        slip.append("Documents       : Identity, SSC & HSC transcripts VERIFIED\n");
        slip.append("========================================================\n");

        AdmitCardTA.setText(slip.toString());

        // --- OP: render confirmation line ---
        AdmitCardStatusLabel.setText("System Readiness: Slip file generated and awaiting extraction.");

        session.setAdmitCardGenerated(true);

        // --- UIE / file generation utility: compile the record to disk ---
        // Note: writing a true .pdf normally needs a library such as Apache PDFBox or iText,
        // which isn't bundled with this project by default. We export the same content as a
        // plain text "slip" file so the download step is fully functional without new dependencies.
        String fileName = "AdmitCard_" + roll + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(slip.toString());
            AdmitCardStatusLabel.setText("System Readiness: Slip file generated -> saved as " + fileName);
        } catch (IOException e) {
            AdmitCardStatusLabel.setText("STATUS: Slip generated on screen, but saving to disk failed.");
            e.printStackTrace();
        }
    }
}