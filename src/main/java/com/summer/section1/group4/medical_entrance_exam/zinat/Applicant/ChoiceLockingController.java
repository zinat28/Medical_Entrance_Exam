package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChoiceLockingController {
    @FXML
    private ComboBox<String> cmbChoice1;
    @FXML
    private ComboBox<String> cmbChoice2;
    @FXML
    private ComboBox<String> cmbChoice3;
    @FXML
    private ComboBox<String> cmbChoice4;
    @FXML
    private ComboBox<String> cmbChoice5;
    @FXML
    private Label ChoiceLockStatusLabel;

    @FXML
    public void initialize() {
        ApplicationSession session = ApplicationSession.getInstance();


        if (!session.isResultDeclared() || !session.isPassed()) {
            ChoiceLockStatusLabel.setText("Status: Choice Locking is only available after a PASS result (Goal 6).");
            cmbChoice1.setDisable(true);
            cmbChoice2.setDisable(true);
            cmbChoice3.setDisable(true);
            cmbChoice4.setDisable(true);
            cmbChoice5.setDisable(true);
            return;
        }


        List<String> colleges = Arrays.asList(ApplicationSession.MEDICAL_COLLEGES);
        cmbChoice1.getItems().addAll(colleges);
        cmbChoice2.getItems().addAll(colleges);
        cmbChoice3.getItems().addAll(colleges);
        cmbChoice4.getItems().addAll(colleges);
        cmbChoice5.getItems().addAll(colleges);

        ChoiceLockStatusLabel.setText("Status: Ready. Please configure choices.");
    }

    @FXML
    public void LockChoiceListOA(ActionEvent actionEvent) {
        ApplicationSession session = ApplicationSession.getInstance();

        if (!session.isResultDeclared() || !session.isPassed()) {
            ChoiceLockStatusLabel.setText("Status: Choice Locking is only available after a PASS result (Goal 6).");
            return;
        }

        List<ComboBox<String>> boxes = Arrays.asList(cmbChoice1, cmbChoice2, cmbChoice3, cmbChoice4, cmbChoice5);


        for (ComboBox<String> box : boxes) {
            if (box.getValue() == null) {
                ChoiceLockStatusLabel.setText("VALIDATION ERROR: Please select all 5 choice preferences.");
                return;
            }
        }


        Set<String> uniqueCheck = new HashSet<>();
        for (ComboBox<String> box : boxes) {
            uniqueCheck.add(box.getValue());
        }
        if (uniqueCheck.size() != boxes.size()) {
            ChoiceLockStatusLabel.setText("VALIDATION ERROR: Duplicate institutions are not allowed across choices.");
            return;
        }


        List<String> orderedChoices = Arrays.asList(
                cmbChoice1.getValue(), cmbChoice2.getValue(), cmbChoice3.getValue(),
                cmbChoice4.getValue(), cmbChoice5.getValue());
        session.lockChoices(orderedChoices);

        ChoiceLockStatusLabel.setText("Status: Choices locked successfully. Proceed to Goal 8: College Allocation.");
    }
}