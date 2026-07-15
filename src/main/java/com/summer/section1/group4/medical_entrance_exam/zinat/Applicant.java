package com.summer.section1.group4.medical_entrance_exam.zinat;

import java.time.LocalDate;

public class Applicant {
    String applicantName, sscBoard, hscBoard;
    double sscGpa, hscGpa;
    LocalDate applicantDob;

    public Applicant(String applicantName, String sscBoard, String hscBoard, double sscGpa, double hscGpa, LocalDate applicantDob) {
        this.applicantName = applicantName;
        this.sscBoard = sscBoard;
        this.hscBoard = hscBoard;
        this.sscGpa = sscGpa;
        this.hscGpa = hscGpa;
        this.applicantDob = applicantDob;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getSscBoard() {
        return sscBoard;
    }

    public void setSscBoard(String sscBoard) {
        this.sscBoard = sscBoard;
    }

    public String getHscBoard() {
        return hscBoard;
    }

    public void setHscBoard(String hscBoard) {
        this.hscBoard = hscBoard;
    }

    public double getSscGpa() {
        return sscGpa;
    }

    public void setSscGpa(double sscGpa) {
        this.sscGpa = sscGpa;
    }

    public double getHscGpa() {
        return hscGpa;
    }

    public void setHscGpa(double hscGpa) {
        this.hscGpa = hscGpa;
    }

    public LocalDate getApplicantDob() {
        return applicantDob;
    }

    public void setApplicantDob(LocalDate applicantDob) {
        this.applicantDob = applicantDob;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantName='" + applicantName + '\'' +
                ", sscBoard='" + sscBoard + '\'' +
                ", hscBoard='" + hscBoard + '\'' +
                ", sscGpa=" + sscGpa +
                ", hscGpa=" + hscGpa +
                ", applicantDob=" + applicantDob +
                '}';
    }
}
