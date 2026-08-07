package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class PaymentDispute implements Serializable {
    private static final long serialVersionUID = 1L;

    private String disputeId;
    private String details;
    private boolean isEligible;
    private String resolutionOutcome;

    public PaymentDispute() {
    }

    public PaymentDispute(String disputeId, String details, boolean isEligible, String resolutionOutcome) {
        this.disputeId = disputeId;
        this.details = details;
        this.isEligible = isEligible;
        this.resolutionOutcome = resolutionOutcome;
    }

    public String getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(String disputeId) {
        this.disputeId = disputeId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isIsEligible() {
        return isEligible;
    }

    public void setIsEligible(boolean eligible) {
        isEligible = eligible;
    }

    public String getResolutionOutcome() {
        return resolutionOutcome;
    }

    public void setResolutionOutcome(String resolutionOutcome) {
        this.resolutionOutcome = resolutionOutcome;
    }

    @Override
    public String toString() {
        return "PaymentDispute{" +
                "disputeId='" + disputeId + '\'' +
                ", details='" + details + '\'' +
                ", isEligible=" + isEligible +
                ", resolutionOutcome='" + resolutionOutcome + '\'' +
                '}';
    }
}
