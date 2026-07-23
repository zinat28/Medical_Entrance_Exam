package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MarkDistributionController {
    @FXML
    private TextField DeductedMarkTF;
    @FXML
    private TextField AwardedMarkTF;
    @FXML
    private Label GradingConfigureStatusLabel;

    // Goal 7: Set Marks (Awarded or Deducted)
    @FXML
    public void ApplyGradingConfigureOA(ActionEvent actionEvent) {
        String awardedInput = AwardedMarkTF.getText() == null ? "" : AwardedMarkTF.getText().trim();
        String deductedInput = DeductedMarkTF.getText() == null ? "" : DeductedMarkTF.getText().trim();

        double awardedValue;
        double deductedValue;

        // event-6 (VL): both inputs must be valid decimal numbers.
        try {
            awardedValue = Double.parseDouble(awardedInput);
            deductedValue = Double.parseDouble(deductedInput);
        } catch (NumberFormatException e) {
            GradingConfigureStatusLabel.setText("ERROR: Both mark values must be valid numbers.");
            return;
        }

        // event-7 (VR): the deducted/penalty value must be negative or zero.
        if (deductedValue > 0.0) {
            GradingConfigureStatusLabel.setText("VERIFICATION FAIL: Penalty parameters must be negative numbers!");
            return;
        }

        // event-8 (DP): update the central configuration used globally (e.g. Goal 4 analysis).
        QuestionData.marksPerQuestion = awardedValue;
        QuestionData.negativeMarksPerQuestion = deductedValue;

        // event-9 (OP)
        GradingConfigureStatusLabel.setText(
                "SUCCESS: Central configuration updated! Correct: +" + awardedValue + " | Penalty: " + deductedValue);
    }
}