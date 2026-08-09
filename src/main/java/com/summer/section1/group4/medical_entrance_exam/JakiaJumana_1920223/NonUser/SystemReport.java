package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public abstract class SystemReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reportId;
    private String generatedDate;

    public SystemReport() {
    }

    public SystemReport(String reportId, String generatedDate) {
        this.reportId = reportId;
        this.generatedDate = generatedDate;
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

    @Override
    public String toString() {
        return "SystemReport{" +
                "reportId='" + reportId + '\'' +
                ", generatedDate='" + generatedDate + '\'' +
                '}';
    }
}
