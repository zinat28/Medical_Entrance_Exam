package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PreviewQuestionPaperController {
    @FXML
    private TextArea FilteredQuestionPaperTA;
    @FXML
    private Label QuestionPreviewStatusLabel;
    @FXML
    private ComboBox<String> FilterSetForPreviewQuestionComBox;

    // Populate the set filter dropdown as soon as the view loads.
    @FXML
    public void initialize() {
        FilterSetForPreviewQuestionComBox.setItems(
                FXCollections.observableArrayList(QuestionData.questionSets.keySet()));
    }

    // Goal 6, first half: Load Filtered Set Preview
    @FXML
    public void loadExamPreviewOA(ActionEvent actionEvent) {
        String selectedSet = FilterSetForPreviewQuestionComBox.getValue();

        // event-6 (VL): a set must be selected.
        if (selectedSet == null || selectedSet.isEmpty()) {
            QuestionPreviewStatusLabel.setText("ERROR: Please select a question set to preview.");
            return;
        }

        String compiledPaper = compilePaperText(selectedSet);

        if (compiledPaper == null) {
            // event-8 (VR): no questions were found for the chosen set.
            FilteredQuestionPaperTA.setText("NO DATA FOUND");
            QuestionPreviewStatusLabel.setText("ERROR: No questions found for set '" + selectedSet + "'.");
            return;
        }

        // event-9 (OP)
        FilteredQuestionPaperTA.setText(compiledPaper);
        QuestionPreviewStatusLabel.setText("STATUS: Preview loaded for set '" + selectedSet + "'.");
    }

    // Goal 6, second half: Download Question Paper
    @FXML
    public void DownloadQuestionOA(ActionEvent actionEvent) {
        String selectedSet = FilterSetForPreviewQuestionComBox.getValue();

        // event-11 (VL): re-validate the selection and recompile the paper text.
        if (selectedSet == null || selectedSet.isEmpty()) {
            QuestionPreviewStatusLabel.setText("DOWNLOAD ERROR: No question set selected.");
            return;
        }

        String compiledPaper = compilePaperText(selectedSet);
        if (compiledPaper == null) {
            QuestionPreviewStatusLabel.setText("DOWNLOAD ERROR: No questions to save for this set.");
            return;
        }

        // event-12 (DP): write the compiled paper to local disk storage.
        String filename = "Question_Paper_" + selectedSet + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(compiledPaper);
            // event-13 (OP)
            QuestionPreviewStatusLabel.setText("SUCCESS: Saved separately to " + filename + "!");
        } catch (IOException e) {
            QuestionPreviewStatusLabel.setText("CRITICAL IO FAILURE: Could not write " + filename + ".");
        }
    }

    /**
     * Builds the official exam paper text for the given set. Returns null
     * if the set has no questions recorded yet.
     */
    private String compilePaperText(String setCode) {
        List<QuestionData.MCQQuestion> questions = QuestionData.questionBank.get(setCode);
        if (questions == null || questions.isEmpty()) {
            return null;
        }

        StringBuilder paper = new StringBuilder();
        paper.append("OFFICIAL MEDICAL ENTRANCE EXAMINATION QUESTION PAPER: ").append(setCode).append("\n");
        paper.append("================================================\n");

        int serial = 1;
        for (QuestionData.MCQQuestion q : questions) {
            paper.append(serial).append(". ").append(q.questionText).append("\n");
            paper.append("   A) ").append(q.optionA).append("\n");
            paper.append("   B) ").append(q.optionB).append("\n");
            paper.append("   C) ").append(q.optionC).append("\n");
            paper.append("   D) ").append(q.optionD).append("\n\n");
            serial++;
        }

        // event-8 (VR): serial counter must exceed 1, i.e. at least one question was written.
        if (serial <= 1) {
            return null;
        }
        return paper.toString();
    }
}