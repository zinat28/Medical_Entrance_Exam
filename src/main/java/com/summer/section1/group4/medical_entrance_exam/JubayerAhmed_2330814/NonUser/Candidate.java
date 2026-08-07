package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String candidateId;
    private String rollNumber;
    private String admitCardId;
    private String name;
    private String photo;
    private String assignedHallId;
    private String assignedSeatNumber;
    private String feeStatus;

    public Candidate() {
    }

    public Candidate(String candidateId, String rollNumber, String admitCardId, String name, String photo, String assignedHallId, String assignedSeatNumber, String feeStatus) {
        this.candidateId = candidateId;
        this.rollNumber = rollNumber;
        this.admitCardId = admitCardId;
        this.name = name;
        this.photo = photo;
        this.assignedHallId = assignedHallId;
        this.assignedSeatNumber = assignedSeatNumber;
        this.feeStatus = feeStatus;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getAdmitCardId() {
        return admitCardId;
    }

    public void setAdmitCardId(String admitCardId) {
        this.admitCardId = admitCardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAssignedHallId() {
        return assignedHallId;
    }

    public void setAssignedHallId(String assignedHallId) {
        this.assignedHallId = assignedHallId;
    }

    public String getAssignedSeatNumber() {
        return assignedSeatNumber;
    }

    public void setAssignedSeatNumber(String assignedSeatNumber) {
        this.assignedSeatNumber = assignedSeatNumber;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", admitCardId='" + admitCardId + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", assignedHallId='" + assignedHallId + '\'' +
                ", assignedSeatNumber='" + assignedSeatNumber + '\'' +
                ", feeStatus='" + feeStatus + '\'' +
                '}';
    }
}
