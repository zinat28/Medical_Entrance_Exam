package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class RefundRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String refundId;
    private double amount;
    private String refundReason;
    private boolean isEligible;
    private String bankAccountDetails;

    public RefundRequest() {
    }

    public RefundRequest(String refundId, double amount, String refundReason, boolean isEligible, String bankAccountDetails) {
        this.refundId = refundId;
        this.amount = amount;
        this.refundReason = refundReason;
        this.isEligible = isEligible;
        this.bankAccountDetails = bankAccountDetails;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public boolean isIsEligible() {
        return isEligible;
    }

    public void setIsEligible(boolean eligible) {
        isEligible = eligible;
    }

    public String getBankAccountDetails() {
        return bankAccountDetails;
    }

    public void setBankAccountDetails(String bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }

    @Override
    public String toString() {
        return "RefundRequest{" +
                "refundId='" + refundId + '\'' +
                ", amount=" + amount +
                ", refundReason='" + refundReason + '\'' +
                ", isEligible=" + isEligible +
                ", bankAccountDetails='" + bankAccountDetails + '\'' +
                '}';
    }
}
