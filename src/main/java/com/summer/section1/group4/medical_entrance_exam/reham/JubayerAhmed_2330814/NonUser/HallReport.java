package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class HallReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hallId;
    private String remarks;
    private String generatedDate;

    public HallReport() {
    }

    public HallReport(String hallId, String remarks, String generatedDate) {
        this.hallId = hallId;
        this.remarks = remarks;
        this.generatedDate = generatedDate;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(String generatedDate) {
        this.generatedDate = generatedDate;
    }

    @Override
    public String toString() {
        return "HallReport{" +
                "hallId='" + hallId + '\'' +
                ", remarks='" + remarks + '\'' +
                ", generatedDate='" + generatedDate + '\'' +
                '}';
    }
}
