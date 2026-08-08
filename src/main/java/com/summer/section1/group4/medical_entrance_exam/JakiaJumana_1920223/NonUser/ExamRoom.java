package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class ExamRoom implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roomId;
    private String centerId;
    private String roomNumber;
    private int capacity;
    private boolean isAvailable;

    public ExamRoom() {
    }

    public ExamRoom(String roomId, String centerId, String roomNumber, int capacity, boolean isAvailable) {
        this.roomId = roomId;
        this.centerId = centerId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "ExamRoom{" +
                "roomId='" + roomId + '\'' +
                ", centerId='" + centerId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", capacity=" + capacity +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
