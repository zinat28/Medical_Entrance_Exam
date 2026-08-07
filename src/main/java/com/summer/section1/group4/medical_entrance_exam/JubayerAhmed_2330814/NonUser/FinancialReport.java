package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class FinancialReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reportId;
    private String generatedDate;
    private double totalRevenue;

    public FinancialReport() {
    }

    public FinancialReport(String reportId, String generatedDate, double totalRevenue) {
        this.reportId = reportId;
        this.generatedDate = generatedDate;
        this.totalRevenue = totalRevenue;
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

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "reportId='" + reportId + '\'' +
                ", generatedDate='" + generatedDate + '\'' +
                ", totalRevenue=" + totalRevenue +
                '}';
    }
}
