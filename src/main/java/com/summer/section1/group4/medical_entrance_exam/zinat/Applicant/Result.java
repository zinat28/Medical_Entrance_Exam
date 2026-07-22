package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Result {
    @FXML
    private Label ResultCheckLabel;
    @FXML
    private TextField ResultRollTF;
    @FXML
    private TextArea ResultTA;

    @FXML
    public void CheckResultOA(ActionEvent actionEvent) {
        String enteredRoll = ResultRollTF.getText() == null ? "" : ResultRollTF.getText().trim();

        // --- VL: validate roll number format, e.g. "M-675193" (M- followed by 6 digits) ---
        if (!enteredRoll.matches("M-\\d{6}")) {
            showMismatch("Status: Query completed. 0 records fetched.");
            ResultCheckLabel.setText("VALIDATION ERROR: Roll number must be formatted like M-123456.");
            return;
        }

        ApplicationSession session = ApplicationSession.getInstance();

        // --- VR: run a database query verification check against existing application data ---
        if (session.getRollNumber() == null || !enteredRoll.equals(session.getRollNumber())) {
            showMismatch("Status: Query completed. 0 records fetched.");
            return;
        }

        // --- DP: fetch exam records, marks matrix, calculate merit rank ---
        if (!session.isResultDeclared()) {
            session.declareResult();
        }

        Applicant applicant = session.getApplicant();

        // --- OP: render the marksheet ---
        if (session.isPassed()) {
            StringBuilder sheet = new StringBuilder();
            sheet.append("===== OFFICIAL MEDICAL ENTRANCE EXAMINATION MARKSHEET =====\n");
            sheet.append("Roll Number    : ").append(session.getRollNumber()).append("\n");
            sheet.append("Candidate Name : ").append(applicant.getApplicantName()).append("\n");
            sheet.append("Secured Marks  : ").append(session.getSecuredMarks())
                    .append(" / ").append(ApplicationSession.TOTAL_MARKS).append("\n");
            sheet.append("Merit Rank     : ").append(session.getMeritRank()).append("\n");
            sheet.append("Result         : PASS\n");
            sheet.append("=============================================================\n");
            sheet.append("\nCONGRATULATIONS! You may now proceed to Goal 7: Choice Locking.");
            ResultTA.setText(sheet.toString());
            ResultCheckLabel.setStyle("-fx-text-fill: #068053;");
            ResultCheckLabel.setText("Status: CONGRATULATIONS! Result found and verified.");
        } else {
            showMismatch("Status: Result declared. Minimum passing marks (" + ApplicationSession.PASSING_MARKS
                    + "/" + ApplicationSession.TOTAL_MARKS + ") not met.");
        }
    }

    private void showMismatch(String statusLine) {
        ResultTA.setText("===== ERROR: SYSTEM RECORD MISMATCH =====\n"
                + "The roll number entered could not be matched against a passing record.\n"
                + "Troubleshooting: double-check the roll number on your Admit Card slip\n"
                + "and make sure Goal 4 (Admit Card Download) has already been completed.\n"
                + "===========================================");
        ResultCheckLabel.setStyle("-fx-text-fill: #cc0000;");
        ResultCheckLabel.setText(statusLine);
    }
}