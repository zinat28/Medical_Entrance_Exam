package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class Application implements Serializable {
    private static final long serialVersionUID = 1L;

    private String applicationId;
    private String applicantId;
    private String applicantName;
    private String submissionDate;
    private String verificationStatus;
    private String approvalStatus;

    public Application() {
    }

    public Application(String applicationId, String applicantId, String applicantName, String submissionDate, String verificationStatus, String approvalStatus) {
        this.applicationId = applicationId;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.submissionDate = submissionDate;
        this.verificationStatus = verificationStatus;
        this.approvalStatus = approvalStatus;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId='" + applicationId + '\'' +
                ", applicantId='" + applicantId + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
