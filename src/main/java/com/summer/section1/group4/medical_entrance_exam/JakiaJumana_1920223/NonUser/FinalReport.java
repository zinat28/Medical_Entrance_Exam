package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class FinalReport extends SystemReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reportType;
    private String reportData;

    public FinalReport() {
    }

    public FinalReport(String reportId, String generatedDate, String reportType, String reportData) {
        super(reportId, generatedDate);
        this.reportType = reportType;
        this.reportData = reportData;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }

    @Override
    public String toString() {
        return "FinalReport{" +
                "reportId='" + getReportId() + '\'' +
                ", generatedDate='" + getGeneratedDate() + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportData='" + reportData + '\'' +
                '}';
    }
}
