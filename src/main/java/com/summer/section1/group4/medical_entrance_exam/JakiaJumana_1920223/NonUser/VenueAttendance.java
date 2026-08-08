package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class VenueAttendance implements Serializable {
    private static final long serialVersionUID = 1L;

    private String attendanceId;
    private String venueId;
    private String centerId;
    private int totalCandidates;
    private int verifiedPresentCount;
    private boolean isFullAttendanceMarked;

    public VenueAttendance() {
    }

    public VenueAttendance(String attendanceId, String venueId, String centerId, int totalCandidates, int verifiedPresentCount, boolean isFullAttendanceMarked) {
        this.attendanceId = attendanceId;
        this.venueId = venueId;
        this.centerId = centerId;
        this.totalCandidates = totalCandidates;
        this.verifiedPresentCount = verifiedPresentCount;
        this.isFullAttendanceMarked = isFullAttendanceMarked;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public int getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(int totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public int getVerifiedPresentCount() {
        return verifiedPresentCount;
    }

    public void setVerifiedPresentCount(int verifiedPresentCount) {
        this.verifiedPresentCount = verifiedPresentCount;
    }

    public boolean isIsFullAttendanceMarked() {
        return isFullAttendanceMarked;
    }

    public void setIsFullAttendanceMarked(boolean fullAttendanceMarked) {
        isFullAttendanceMarked = fullAttendanceMarked;
    }

    @Override
    public String toString() {
        return "VenueAttendance{" +
                "attendanceId='" + attendanceId + '\'' +
                ", venueId='" + venueId + '\'' +
                ", centerId='" + centerId + '\'' +
                ", totalCandidates=" + totalCandidates +
                ", verifiedPresentCount=" + verifiedPresentCount +
                ", isFullAttendanceMarked=" + isFullAttendanceMarked +
                '}';
    }
}
