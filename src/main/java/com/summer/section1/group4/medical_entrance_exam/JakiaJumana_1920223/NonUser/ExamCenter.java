package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class ExamCenter implements Serializable {
    private static final long serialVersionUID = 1L;

    private String centerId;
    private String centerName;
    private int totalCapacity;
    private int availableSeats;
    private String location;

    public ExamCenter() {
    }

    public ExamCenter(String centerId, String centerName, int totalCapacity, int availableSeats, String location) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.totalCapacity = totalCapacity;
        this.availableSeats = availableSeats;
        this.location = location;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ExamCenter{" +
                "centerId='" + centerId + '\'' +
                ", centerName='" + centerName + '\'' +
                ", totalCapacity=" + totalCapacity +
                ", availableSeats=" + availableSeats +
                ", location='" + location + '\'' +
                '}';
    }
}
