package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class AbsentReport extends SystemReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String centerId;
    private int totalAbsentCount;

    public AbsentReport() {
    }

    public AbsentReport(String reportId, String generatedDate, String centerId, int totalAbsentCount) {
        super(reportId, generatedDate);
        this.centerId = centerId;
        this.totalAbsentCount = totalAbsentCount;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public int getTotalAbsentCount() {
        return totalAbsentCount;
    }

    public void setTotalAbsentCount(int totalAbsentCount) {
        this.totalAbsentCount = totalAbsentCount;
    }

    @Override
    public String toString() {
        return "AbsentReport{" +
                "reportId='" + getReportId() + '\'' +
                ", generatedDate='" + getGeneratedDate() + '\'' +
                ", centerId='" + centerId + '\'' +
                ", totalAbsentCount=" + totalAbsentCount +
                '}';
    }
}
