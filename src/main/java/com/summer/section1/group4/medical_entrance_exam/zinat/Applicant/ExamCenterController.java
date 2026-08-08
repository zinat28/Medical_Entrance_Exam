package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ExamCenterController {
    @FXML
    private Label CenterAllocationLabel;
    @FXML
    private TextArea ExamCenterDetailsTA;

    // Mock "center mapping index" master data — District -> Venue -> Room pool.
    private static final String[][] CENTER_MAP = {
            {"Dhaka", "Dhaka Medical College Exam Hall"},
            {"Chattogram", "Chattogram Medical College Exam Hall"},
            {"Rajshahi", "Rajshahi Medical College Exam Hall"},
            {"Sylhet", "Sylhet MAG Osmani Medical College Exam Hall"},
            {"Khulna", "Khulna Medical College Exam Hall"},
            {"Rangpur", "Rangpur Medical College Exam Hall"}
    };

    @FXML
    public void initialize() {
        // The screen should already show center data as soon as it loads (event-1..event-5).
        loadCenterAllocation();
    }

    @FXML
    public void ReVerifyCenterAllocationOA(ActionEvent actionEvent) {
        loadCenterAllocation();
    }

    private void loadCenterAllocation() {
        ApplicationSession session = ApplicationSession.getInstance();

        if (session.getRollNumber() == null) {
            ExamCenterDetailsTA.setText("");
            CenterAllocationLabel.setText("STATUS: No roll number on file. Complete Goal 4 (Admit Card) first.");
            return;
        }

        String roll = session.getRollNumber();

        int index = Math.abs(roll.hashCode()) % CENTER_MAP.length;
        String district = CENTER_MAP[index][0];
        String venue = CENTER_MAP[index][1];
        int seatNumber = 100 + (Math.abs(roll.hashCode()) % 400);


        StringBuilder slip = new StringBuilder();
        slip.append("===== OFFICIAL MEDICAL ENTRANCE EXAMINATION ENTRY SLIP =====\n");
        slip.append("Roll Number      : ").append(roll).append("\n");
        slip.append("District         : ").append(district).append("\n");
        slip.append("Venue Institute  : ").append(venue).append("\n");
        slip.append("Seat Number      : ").append(seatNumber).append("\n");
        slip.append("==============================================================\n");
        ExamCenterDetailsTA.setText(slip.toString());


        CenterAllocationLabel.setText("Status: Center credentials compiled and loaded cleanly.");
    }
}