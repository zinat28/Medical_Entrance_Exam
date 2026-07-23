package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateQuestionSetController {
    @javafx.fxml.FXML
    private TextField SetCodeTF;
    @javafx.fxml.FXML
    private TextArea SetDetailsTA;
    @javafx.fxml.FXML
    private Label SetStatusLabel;
    @javafx.fxml.FXML
    private TextField SetExamTitleTF;

    // Goal 1: Initialize New Question Set Profile
    @javafx.fxml.FXML
    public void CreateSet_Verify(ActionEvent actionEvent) {
        String setCode = SetCodeTF.getText() == null ? "" : SetCodeTF.getText().trim();
        String examTitle = SetExamTitleTF.getText() == null ? "" : SetExamTitleTF.getText().trim();

        // event-6 (VL): neither field may be empty, and the code must be a simple
        // alphanumeric token (basic naming structure constraint).
        if (setCode.isEmpty() || examTitle.isEmpty()) {
            SetStatusLabel.setText("ERROR: Set Code and Examination Title cannot be empty.");
            return;
        }
        if (!setCode.matches("[A-Za-z0-9_-]+")) {
            SetStatusLabel.setText("ERROR: Set Code may only contain letters, numbers, '-' or '_'.");
            return;
        }

        // event-7 (VR): the Set Code ID must be unique.
        if (QuestionData.questionSets.containsKey(setCode)) {
            SetStatusLabel.setText("ERROR: Set Code '" + setCode + "' already exists. Choose a different code.");
            return;
        }

        // event-8 (DP): create the new set profile and log the creation.
        QuestionData.addSet(setCode, examTitle);

        // Confirmation summary readout (OP)
        SetDetailsTA.setText(
                "Set Code       : " + setCode + "\n" +
                        "Exam Title     : " + examTitle + "\n" +
                        "Questions added: 0\n" +
                        "Status         : Ready to accept MCQ items in Goal 2."
        );
        SetStatusLabel.setText("SUCCESS: Set '" + setCode + "' created and verified!");

        // Clear the inputs so the moderator can create another set right away.
        SetCodeTF.clear();
        SetExamTitleTF.clear();
    }
}