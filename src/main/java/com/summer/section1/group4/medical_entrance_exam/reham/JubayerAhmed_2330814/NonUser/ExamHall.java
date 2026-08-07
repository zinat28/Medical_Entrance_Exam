package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class ExamHall implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hallId;
    private String centerName;
    private int capacity;
    private String invigilatorAssigned;
    private String status;

    public ExamHall() {
    }

    public ExamHall(String hallId, String centerName, int capacity, String invigilatorAssigned, String status) {
        this.hallId = hallId;
        this.centerName = centerName;
        this.capacity = capacity;
        this.invigilatorAssigned = invigilatorAssigned;
        this.status = status;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getInvigilatorAssigned() {
        return invigilatorAssigned;
    }

    public void setInvigilatorAssigned(String invigilatorAssigned) {
        this.invigilatorAssigned = invigilatorAssigned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamHall{" +
                "hallId='" + hallId + '\'' +
                ", centerName='" + centerName + '\'' +
                ", capacity=" + capacity +
                ", invigilatorAssigned='" + invigilatorAssigned + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
