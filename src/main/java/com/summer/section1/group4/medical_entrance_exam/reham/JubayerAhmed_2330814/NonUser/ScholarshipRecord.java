package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class ScholarshipRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scholarshipId;
    private boolean isApproved;
    private double originalFeeAmount;
    private double adjustedFeeAmount;

    public ScholarshipRecord() {
    }

    public ScholarshipRecord(String scholarshipId, boolean isApproved, double originalFeeAmount, double adjustedFeeAmount) {
        this.scholarshipId = scholarshipId;
        this.isApproved = isApproved;
        this.originalFeeAmount = originalFeeAmount;
        this.adjustedFeeAmount = adjustedFeeAmount;
    }

    public String getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(String scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean approved) {
        isApproved = approved;
    }

    public double getOriginalFeeAmount() {
        return originalFeeAmount;
    }

    public void setOriginalFeeAmount(double originalFeeAmount) {
        this.originalFeeAmount = originalFeeAmount;
    }

    public double getAdjustedFeeAmount() {
        return adjustedFeeAmount;
    }

    public void setAdjustedFeeAmount(double adjustedFeeAmount) {
        this.adjustedFeeAmount = adjustedFeeAmount;
    }

    @Override
    public String toString() {
        return "ScholarshipRecord{" +
                "scholarshipId='" + scholarshipId + '\'' +
                ", isApproved=" + isApproved +
                ", originalFeeAmount=" + originalFeeAmount +
                ", adjustedFeeAmount=" + adjustedFeeAmount +
                '}';
    }
}
