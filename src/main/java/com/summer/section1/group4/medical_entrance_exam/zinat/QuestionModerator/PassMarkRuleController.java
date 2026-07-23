package com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PassMarkRuleController {
    @FXML
    private TextField PassingMarkTF;
    @FXML
    private Label PassMarkSetStatusLabel;

    // Goal 3: Adjust System Pass Mark Threshold Rules
    @FXML
    public void PassMarkRuleParameterToSettingsOA(ActionEvent actionEvent) {
        String input = PassingMarkTF.getText() == null ? "" : PassingMarkTF.getText().trim();

        // event-5 (VL): must be a valid number, not blank, within 0-100.
        if (input.isEmpty()) {
            PassMarkSetStatusLabel.setText("ERROR: Passing percentage cannot be blank.");
            return;
        }

        double newPassMark;
        try {
            newPassMark = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            PassMarkSetStatusLabel.setText("ERROR: Passing percentage must be a valid number.");
            return;
        }

        if (newPassMark < 0.0 || newPassMark > 100.0) {
            PassMarkSetStatusLabel.setText("ERROR: Passing percentage must be between 0 and 100.");
            return;
        }

        // event-6 (DP): save the new baseline percentage rule.
        QuestionData.passMarkPercentage = newPassMark;

        // event-7 (OP)
        PassMarkSetStatusLabel.setText("RULE CONFIRMED (OP): Cut-off system value updated to " + newPassMark + "%.");
    }
}