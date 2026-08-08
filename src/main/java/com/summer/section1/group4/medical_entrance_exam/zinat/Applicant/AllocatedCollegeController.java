package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AllocatedCollegeController {
    @FXML
    private TextArea AllocatedCollegeTA;
    @FXML
    private Label AlloctedCollegeStatusLabel;
    @FXML
    private TextField CollegeAllocationRollTF;

    @FXML
    public void initialize() {
        AlloctedCollegeStatusLabel.setText(
                "-- DGME ALLOTMENT MATRIX STANDBY --\n"
                        + "Status: Awaiting registration authorization token signature query lookup...");
        CollegeAllocationRollTF.setOnAction(event -> FetchAllotmentOrderOA());
    }

    @FXML
    public void FetchAllotmentOrderOA() {
        String roll = CollegeAllocationRollTF.getText() == null ? "" : CollegeAllocationRollTF.getText().trim();

        if (!roll.matches("M-\\d{6}")) {
            AlloctedCollegeStatusLabel.setText("Status: Invalid roll number format. Expected e.g. M-675193.");
            return;
        }

        ApplicationSession session = ApplicationSession.getInstance();

        if (session.getRollNumber() == null || !roll.equals(session.getRollNumber())) {
            AlloctedCollegeStatusLabel.setText("Status: Request deferred. No active registration found for this roll number.");
            return;
        }

        if (!session.isChoicesLocked()) {
            AllocatedCollegeTA.setText("===== DGME PROCESSING HOLD: NO LOCKED CHOICES DETECTED =====");
            AlloctedCollegeStatusLabel.setText("Status: Request deferred. Lock target preferences list first.");
            return;
        }

        if (!session.isAllocationDone()) {
            session.runAllocationEngine();
        }

        StringBuilder order = new StringBuilder();
        order.append("===== OFFICIAL INSTITUTIONAL ALLOTMENT ORDER =====\n");
        order.append("Roll Number      : ").append(session.getRollNumber()).append("\n");
        order.append("Candidate Name   : ").append(session.getApplicant().getApplicantName()).append("\n");
        order.append("Merit Rank       : ").append(session.getMeritRank()).append("\n");
        order.append("Allotted College : ").append(session.getAllocatedCollege()).append("\n");
        order.append("====================================================");
        AllocatedCollegeTA.setText(order.toString());

        AlloctedCollegeStatusLabel.setText("SUCCESS: Final selection allotment documentation compiled cleanly!");
    }
}