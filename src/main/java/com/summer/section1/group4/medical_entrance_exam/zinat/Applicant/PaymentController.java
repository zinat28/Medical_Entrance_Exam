package com.summer.section1.group4.medical_entrance_exam.zinat.Applicant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class PaymentController {
    @FXML
    private ComboBox<String> PaymentMethodComB;
    @FXML
    private Label PaymentProofStatusLabel;

    private String paymentProofFileName;

    @FXML
    public void initialize() {
        PaymentMethodComB.getItems().addAll("Bank", "Mobile Banking");
        PaymentProofStatusLabel.setText("Mandatory Exam Registration Fee: $"
                + String.format("%.2f", ApplicationSession.REGISTRATION_FEE)
                + " | STATUS: Awaiting Submission Proof.");
    }

    @FXML
    public void AttachPaymentProofOA(ActionEvent actionEvent) {
        if (PaymentMethodComB.getValue() == null) {
            PaymentProofStatusLabel.setText("STATUS: Please select a payment method first.");
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Payment Proof (screenshot / receipt)");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image / PDF files", "*.pdf", "*.jpg", "*.jpeg", "*.png"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File chosen = fileChooser.showOpenDialog(stage);
        if (chosen != null) {
            paymentProofFileName = chosen.getName();
            PaymentProofStatusLabel.setText("Payment proof attached: " + paymentProofFileName);
        }
    }

    @FXML
    public void SubmitPaymentProofA(ActionEvent actionEvent) {
        ApplicationSession session = ApplicationSession.getInstance();


        if (!session.isFormSubmitted()) {
            PaymentProofStatusLabel.setText("Payment Status: Unpaid — complete Goal 1 (Application Form) first.");
            return;
        }
        if (!session.isDocumentsUploaded()) {
            PaymentProofStatusLabel.setText("Payment Status: Unpaid — complete Goal 2 (Document Uploads) first.");
            return;
        }
        if (PaymentMethodComB.getValue() == null || paymentProofFileName == null) {
            PaymentProofStatusLabel.setText("Payment Status: Unpaid — select a payment method and attach proof.");
            return;
        }


        session.setPaymentProofFileName(paymentProofFileName);
        session.setPaymentCleared(true);


        PaymentProofStatusLabel.setText("PAYMENT RECEIVED: Registration process invoice cleared successfully.");
    }
}