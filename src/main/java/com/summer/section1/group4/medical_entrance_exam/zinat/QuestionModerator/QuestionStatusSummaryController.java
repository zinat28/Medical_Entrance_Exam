package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.List;
import java.util.Map;

public class QuestionStatusSummaryController {

    @FXML
    private Label StatusSummaryStatusLabel;
    @FXML
    private TextArea QuestionStatusSummaryTA;

    // Goal 5: View Status Summary (refreshed on button click)
    @FXML
    public void QuestionStatusSummaryOA(ActionEvent actionEvent) {
        // event-4 (VR): verify at least one set exists.
        if (QuestionData.questionSets.isEmpty()) {
            QuestionStatusSummaryTA.setText("No question sets have been registered yet. Create one in Goal 1.");
            StatusSummaryStatusLabel.setText("STATUS: No data available.");
            return;
        }

        // event-5, event-6 (DP): iterate and tally question counts per set.
        StringBuilder summary = new StringBuilder();
        summary.append("QUESTION SET STATUS SUMMARY\n");
        summary.append("================================================\n");

        int totalSets = QuestionData.questionSets.size();
        int totalQuestions = 0;

        for (Map.Entry<String, String> setEntry : QuestionData.questionSets.entrySet()) {
            String setCode = setEntry.getKey();
            String examTitle = setEntry.getValue();
            List<QuestionData.MCQQuestion> questions = QuestionData.questionBank.get(setCode);
            int count = (questions == null) ? 0 : questions.size();
            totalQuestions += count;

            summary.append(String.format("Set [%s] \"%s\" -> %d question(s)%n", setCode, examTitle, count));
        }

        summary.append("------------------------------------------------\n");
        summary.append(String.format("Total registered sets: %d%n", totalSets));
        summary.append(String.format("Total questions overall: %d", totalQuestions));

        // event-7 (OP)
        QuestionStatusSummaryTA.setText(summary.toString());
        StatusSummaryStatusLabel.setText("STATUS: Live system metrics data fetched successfully.");
    }
}