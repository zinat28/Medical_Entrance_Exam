package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class CapacityStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    private String statusId;
    private String centerId;
    private int totalCapacity;
    private int allocatedSeats;
    private int availableSeats;

    public CapacityStatus() {
    }

    public CapacityStatus(String statusId, String centerId, int totalCapacity, int allocatedSeats, int availableSeats) {
        this.statusId = statusId;
        this.centerId = centerId;
        this.totalCapacity = totalCapacity;
        this.allocatedSeats = allocatedSeats;
        this.availableSeats = availableSeats;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAllocatedSeats() {
        return allocatedSeats;
    }

    public void setAllocatedSeats(int allocatedSeats) {
        this.allocatedSeats = allocatedSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "CapacityStatus{" +
                "statusId='" + statusId + '\'' +
                ", centerId='" + centerId + '\'' +
                ", totalCapacity=" + totalCapacity +
                ", allocatedSeats=" + allocatedSeats +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
