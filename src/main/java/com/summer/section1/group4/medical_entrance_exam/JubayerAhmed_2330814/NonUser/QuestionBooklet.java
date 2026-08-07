package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;
import java.io.Serializable;

public class QuestionBooklet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String serialNumber;
    private String examSetCode;
    private boolean isDistributed;

    public QuestionBooklet() {
    }

    public QuestionBooklet(String serialNumber, String examSetCode, boolean isDistributed) {
        this.serialNumber = serialNumber;
        this.examSetCode = examSetCode;
        this.isDistributed = isDistributed;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getExamSetCode() {
        return examSetCode;
    }

    public void setExamSetCode(String examSetCode) {
        this.examSetCode = examSetCode;
    }

    public boolean isIsDistributed() {
        return isDistributed;
    }

    public void setIsDistributed(boolean distributed) {
        isDistributed = distributed;
    }

    @Override
    public String toString() {
        return "QuestionBooklet{" +
                "serialNumber='" + serialNumber + '\'' +
                ", examSetCode='" + examSetCode + '\'' +
                ", isDistributed=" + isDistributed +
                '}';
    }
}
