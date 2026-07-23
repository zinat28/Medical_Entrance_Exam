package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TimeLogController {
    @FXML
    private TextArea TimeLogTA;

    // Goal 8: Set Creation History & Time Log - runs automatically on load.
    @FXML
    public void initialize() {
        // event-3 (VR): halt with a friendly message if no logs exist yet.
        if (QuestionData.setCreationHistoryLogs.isEmpty()) {
            TimeLogTA.setText("No transaction logs recorded yet. "
                    + "Please create a set code in Goal 1 to generate an active stamp.");
            return;
        }

        // event-5, event-6 (DP/OP): compile every log entry into the registry view.
        StringBuilder registry = new StringBuilder();
        registry.append("HISTORICAL TIME LOG REGISTRY\n");
        registry.append("================================================\n");

        for (String logEntry : QuestionData.setCreationHistoryLogs) {
            registry.append(logEntry).append("\n");
        }

        registry.append("================= END OF HISTORY LOG =================");

        TimeLogTA.setText(registry.toString());
    }
}