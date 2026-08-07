package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class AttendanceRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recordId;
    private String checkTime;
    private String status;
    private boolean isLateEntry;
    private String arrivalTime;

    public AttendanceRecord() {
    }

    public AttendanceRecord(String recordId, String checkTime, String status, boolean isLateEntry, String arrivalTime) {
        this.recordId = recordId;
        this.checkTime = checkTime;
        this.status = status;
        this.isLateEntry = isLateEntry;
        this.arrivalTime = arrivalTime;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsLateEntry() {
        return isLateEntry;
    }

    public void setIsLateEntry(boolean lateEntry) {
        isLateEntry = lateEntry;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "recordId='" + recordId + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", status='" + status + '\'' +
                ", isLateEntry=" + isLateEntry +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
