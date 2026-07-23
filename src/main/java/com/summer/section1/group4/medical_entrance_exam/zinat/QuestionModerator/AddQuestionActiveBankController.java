package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddQuestionActiveBankController {
    @FXML
    private Label SaveMCQStatusLabel;
    @FXML
    private TextField QuestionOptionATF;
    @FXML
    private TextField QuestionDetailsTF;
    @FXML
    private TextField QuestionOptionBTF;
    @FXML
    private TextField QuestionOptionCTF;
    @FXML
    private TextField QuestionOptionDTF;
    @FXML
    private ComboBox<String> SetChooserCombBox;

    // Runs automatically as soon as this view is loaded (event-2, event-3)
    @FXML
    public void initialize() {
        SetChooserCombBox.setItems(FXCollections.observableArrayList(QuestionData.questionSets.keySet()));

        if (QuestionData.questionSets.isEmpty()) {
            SaveMCQStatusLabel.setText("WARNING: No custom sets generated in Goal 1 yet!");
        } else {
            SaveMCQStatusLabel.setText("STATUS: Awaiting for question input");
        }
    }

    // Goal 2: Append MCQ Item to Active Bank
    @FXML
    public void SaveMCQOA(ActionEvent actionEvent) {
        String selectedSet = SetChooserCombBox.getValue();
        String question = QuestionDetailsTF.getText() == null ? "" : QuestionDetailsTF.getText().trim();
        String optionA = QuestionOptionATF.getText() == null ? "" : QuestionOptionATF.getText().trim();
        String optionB = QuestionOptionBTF.getText() == null ? "" : QuestionOptionBTF.getText().trim();
        String optionC = QuestionOptionCTF.getText() == null ? "" : QuestionOptionCTF.getText().trim();
        String optionD = QuestionOptionDTF.getText() == null ? "" : QuestionOptionDTF.getText().trim();

        // event-7 (VL): a set must be selected and no field left empty.
        if (selectedSet == null || selectedSet.isEmpty()) {
            SaveMCQStatusLabel.setText("ERROR: Please select a question paper set category first.");
            return;
        }
        if (question.isEmpty() || optionA.isEmpty() || optionB.isEmpty()
                || optionC.isEmpty() || optionD.isEmpty()) {
            SaveMCQStatusLabel.setText("ERROR: Question body and all four options are required.");
            return;
        }

        // event-8 (DP): commit the new MCQ item into the active bank for the chosen set.
        QuestionData.MCQQuestion mcq = new QuestionData.MCQQuestion(question, optionA, optionB, optionC, optionD);
        QuestionData.questionBank.get(selectedSet).add(mcq);

        SaveMCQStatusLabel.setText(
                "SUCCESS: Question recorded under '" + selectedSet + "'! Head to Goal 6 to filter or download.");

        // Clear the fields so the moderator can enter the next question.
        QuestionDetailsTF.clear();
        QuestionOptionATF.clear();
        QuestionOptionBTF.clear();
        QuestionOptionCTF.clear();
        QuestionOptionDTF.clear();
    }
}