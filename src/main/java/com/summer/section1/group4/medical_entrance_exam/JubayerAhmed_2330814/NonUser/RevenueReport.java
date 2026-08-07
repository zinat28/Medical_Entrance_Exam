package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class RevenueReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reportId;
    private String generatedDate;
    private String dateRange;
    private double totalCollected;
    private double totalPending;
    private double totalRefunded;

    public RevenueReport() {
    }

    public RevenueReport(String reportId, String generatedDate, String dateRange, double totalCollected, double totalPending, double totalRefunded) {
        this.reportId = reportId;
        this.generatedDate = generatedDate;
        this.dateRange = dateRange;
        this.totalCollected = totalCollected;
        this.totalPending = totalPending;
        this.totalRefunded = totalRefunded;
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

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public void setTotalCollected(double totalCollected) {
        this.totalCollected = totalCollected;
    }

    public double getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(double totalPending) {
        this.totalPending = totalPending;
    }

    public double getTotalRefunded() {
        return totalRefunded;
    }

    public void setTotalRefunded(double totalRefunded) {
        this.totalRefunded = totalRefunded;
    }

    @Override
    public String toString() {
        return "RevenueReport{" +
                "reportId='" + reportId + '\'' +
                ", generatedDate='" + generatedDate + '\'' +
                ", dateRange='" + dateRange + '\'' +
                ", totalCollected=" + totalCollected +
                ", totalPending=" + totalPending +
                ", totalRefunded=" + totalRefunded +
                '}';
    }
}
