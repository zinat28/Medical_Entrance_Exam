package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class InstituteDisbursement implements Serializable {
    private static final long serialVersionUID = 1L;

    private String disbursementId;
    private String instituteId;
    private String period;
    private int lockedCandidateCount;
    private double agreementPercentage;
    private double calculatedShareAmount;
    private String bankTransferStatus;

    public InstituteDisbursement() {
    }

    public InstituteDisbursement(String disbursementId, String instituteId, String period, int lockedCandidateCount, double agreementPercentage, double calculatedShareAmount, String bankTransferStatus) {
        this.disbursementId = disbursementId;
        this.instituteId = instituteId;
        this.period = period;
        this.lockedCandidateCount = lockedCandidateCount;
        this.agreementPercentage = agreementPercentage;
        this.calculatedShareAmount = calculatedShareAmount;
        this.bankTransferStatus = bankTransferStatus;
    }

    public String getDisbursementId() {
        return disbursementId;
    }

    public void setDisbursementId(String disbursementId) {
        this.disbursementId = disbursementId;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getLockedCandidateCount() {
        return lockedCandidateCount;
    }

    public void setLockedCandidateCount(int lockedCandidateCount) {
        this.lockedCandidateCount = lockedCandidateCount;
    }

    public double getAgreementPercentage() {
        return agreementPercentage;
    }

    public void setAgreementPercentage(double agreementPercentage) {
        this.agreementPercentage = agreementPercentage;
    }

    public double getCalculatedShareAmount() {
        return calculatedShareAmount;
    }

    public void setCalculatedShareAmount(double calculatedShareAmount) {
        this.calculatedShareAmount = calculatedShareAmount;
    }

    public String getBankTransferStatus() {
        return bankTransferStatus;
    }

    public void setBankTransferStatus(String bankTransferStatus) {
        this.bankTransferStatus = bankTransferStatus;
    }

    @Override
    public String toString() {
        return "InstituteDisbursement{" +
                "disbursementId='" + disbursementId + '\'' +
                ", instituteId='" + instituteId + '\'' +
                ", period='" + period + '\'' +
                ", lockedCandidateCount=" + lockedCandidateCount +
                ", agreementPercentage=" + agreementPercentage +
                ", calculatedShareAmount=" + calculatedShareAmount +
                ", bankTransferStatus='" + bankTransferStatus + '\'' +
                '}';
    }
}
