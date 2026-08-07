package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class PaymentTransaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private String transactionId;
    private double amount;
    private String paymentDate;
    private String bankReference;
    private boolean isReconciled;
    private String status;

    public PaymentTransaction() {
    }

    public PaymentTransaction(String transactionId, double amount, String paymentDate, String bankReference, boolean isReconciled, String status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.bankReference = bankReference;
        this.isReconciled = isReconciled;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBankReference() {
        return bankReference;
    }

    public void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    public boolean isIsReconciled() {
        return isReconciled;
    }

    public void setIsReconciled(boolean reconciled) {
        isReconciled = reconciled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", paymentDate='" + paymentDate + '\'' +
                ", bankReference='" + bankReference + '\'' +
                ", isReconciled=" + isReconciled +
                ", status='" + status + '\'' +
                '}';
    }
}
