package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class ExamSessionReport extends SystemReport implements Serializable {
    private static final long serialVersionUID = 1L;//verssion number for serialization
//object of this class ar allowed to be converted into a form that can be saved to file
    private String centerId;
    private String sessionRemarks;
    private String submissionTime;
    private String status;

    public ExamSessionReport() {
    }

    public ExamSessionReport(String reportId, String generatedDate, String centerId, String sessionRemarks, String submissionTime, String status) {
        super(reportId, generatedDate);
        this.centerId = centerId;
        this.sessionRemarks = sessionRemarks;
        this.submissionTime = submissionTime;
        this.status = status;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getSessionRemarks() {
        return sessionRemarks;
    }

    public void setSessionRemarks(String sessionRemarks) {
        this.sessionRemarks = sessionRemarks;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamSessionReport{" +
                "reportId='" + getReportId() + '\'' +
                ", generatedDate='" + getGeneratedDate() + '\'' +
                ", centerId='" + centerId + '\'' +
                ", sessionRemarks='" + sessionRemarks + '\'' +
                ", submissionTime='" + submissionTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
