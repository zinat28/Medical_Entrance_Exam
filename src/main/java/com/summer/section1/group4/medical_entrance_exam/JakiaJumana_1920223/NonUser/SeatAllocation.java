package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class SeatAllocation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String allocationId;
    private String candidateId;
    private String roomId;
    private String seatNumber;

    public SeatAllocation() {
    }

    public SeatAllocation(String allocationId, String candidateId, String roomId, String seatNumber) {
        this.allocationId = allocationId;
        this.candidateId = candidateId;
        this.roomId = roomId;
        this.seatNumber = seatNumber;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "SeatAllocation{" +
                "allocationId='" + allocationId + '\'' +
                ", candidateId='" + candidateId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
