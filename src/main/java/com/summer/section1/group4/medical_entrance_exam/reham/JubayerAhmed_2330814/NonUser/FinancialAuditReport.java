package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class FinancialAuditReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reportId;
    private String generatedDate;
    private String auditPeriod;
    private int totalVerifiedPayments;
    private double totalDisbursements;
    private boolean completenessFlag;

    public FinancialAuditReport() {
    }

    public FinancialAuditReport(String reportId, String generatedDate, String auditPeriod, int totalVerifiedPayments, double totalDisbursements, boolean completenessFlag) {
        this.reportId = reportId;
        this.generatedDate = generatedDate;
        this.auditPeriod = auditPeriod;
        this.totalVerifiedPayments = totalVerifiedPayments;
        this.totalDisbursements = totalDisbursements;
        this.completenessFlag = completenessFlag;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(String generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getAuditPeriod() {
        return auditPeriod;
    }

    public void setAuditPeriod(String auditPeriod) {
        this.auditPeriod = auditPeriod;
    }

    public int getTotalVerifiedPayments() {
        return totalVerifiedPayments;
    }

    public void setTotalVerifiedPayments(int totalVerifiedPayments) {
        this.totalVerifiedPayments = totalVerifiedPayments;
    }

    public double getTotalDisbursements() {
        return totalDisbursements;
    }

    public void setTotalDisbursements(double totalDisbursements) {
        this.totalDisbursements = totalDisbursements;
    }

    public boolean isCompletenessFlag() {
        return completenessFlag;
    }

    public void setCompletenessFlag(boolean completenessFlag) {
        this.completenessFlag = completenessFlag;
    }

    @Override
    public String toString() {
        return "FinancialAuditReport{" +
                "reportId='" + reportId + '\'' +
                ", generatedDate='" + generatedDate + '\'' +
                ", auditPeriod='" + auditPeriod + '\'' +
                ", totalVerifiedPayments=" + totalVerifiedPayments +
                ", totalDisbursements=" + totalDisbursements +
                ", completenessFlag=" + completenessFlag +
                '}';
    }
}
