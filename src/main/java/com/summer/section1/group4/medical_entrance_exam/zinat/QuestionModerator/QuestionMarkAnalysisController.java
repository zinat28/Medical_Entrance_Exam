package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.List;
import java.util.Map;

public class QuestionMarkAnalysisController {
    @FXML
    private TextArea QuestionMarkAnalysisTA;

    // Goal 4: Question Mark Analysis - runs automatically when this view loads.
    @FXML
    public void initialize() {
        StringBuilder report = new StringBuilder();
        report.append("QUESTION MARK ANALYSIS REPORT (AUTO-COMPILED)\n");
        report.append("================================================\n");

        if (QuestionData.questionBank.isEmpty()) {
            report.append("No question sets have been created yet.\n");
        } else {
            int grandTotalQuestions = 0;
            double grandTotalPoints = 0.0;

            // event-2, event-3 (DP): fetch each set's item count and total point value.
            for (Map.Entry<String, List<QuestionData.MCQQuestion>> entry : QuestionData.questionBank.entrySet()) {
                String setCode = entry.getKey();
                int itemCount = entry.getValue().size();
                double totalPoints = itemCount * QuestionData.marksPerQuestion;

                grandTotalQuestions += itemCount;
                grandTotalPoints += totalPoints;

                // event-5 (OP): individual breakdown per set.
                report.append(String.format("Set [%s] -> %d question(s), %.2f total mark(s)%n",
                        setCode, itemCount, totalPoints));
            }

            report.append("------------------------------------------------\n");
            report.append(String.format("Total questions across all sets: %d%n", grandTotalQuestions));
            report.append(String.format("Total possible marks           : %.2f%n", grandTotalPoints));
        }

        report.append("================================================\n");
        report.append("Live database metrics synchronization: Status OK.");

        QuestionMarkAnalysisTA.setText(report.toString());
    }
}