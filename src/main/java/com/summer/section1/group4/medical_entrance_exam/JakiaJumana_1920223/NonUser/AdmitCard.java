package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class AdmitCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private String admitCardId;
    private String applicantId;
    private String rollNumber;
    private String assignedCenterId;
    private String issueDate;

    public AdmitCard() {
    }

    public AdmitCard(String admitCardId, String applicantId, String rollNumber, String assignedCenterId, String issueDate) {
        this.admitCardId = admitCardId;
        this.applicantId = applicantId;
        this.rollNumber = rollNumber;
        this.assignedCenterId = assignedCenterId;
        this.issueDate = issueDate;
    }

    public String getAdmitCardId() {
        return admitCardId;
    }

    public void setAdmitCardId(String admitCardId) {
        this.admitCardId = admitCardId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getAssignedCenterId() {
        return assignedCenterId;
    }

    public void setAssignedCenterId(String assignedCenterId) {
        this.assignedCenterId = assignedCenterId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "AdmitCard{" +
                "admitCardId='" + admitCardId + '\'' +
                ", applicantId='" + applicantId + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", assignedCenterId='" + assignedCenterId + '\'' +
                ", issueDate='" + issueDate + '\'' +
                '}';
    }
}
