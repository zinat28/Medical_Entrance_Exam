package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PaymentController {
    @javafx.fxml.FXML
    private ComboBox<String> PaymentMethodComB;
    @javafx.fxml.FXML
    private Label PaymentProofStatusLabel;

    @FXML
    public void initialize(){
        PaymentMethodComB.getItems().addAll("Bank","Mobile Banking");
    }



    @javafx.fxml.FXML
    public void AttachPaymentProofOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitPaymentProofA(ActionEvent actionEvent) {
    }
}
