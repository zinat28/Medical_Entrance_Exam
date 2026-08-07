package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class IncidentReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String incidentId;
    private String timestamp;
    private String description;
    private String photo;
    private String status;

    public IncidentReport() {
    }

    public IncidentReport(String incidentId, String timestamp, String description, String photo, String status) {
        this.incidentId = incidentId;
        this.timestamp = timestamp;
        this.description = description;
        this.photo = photo;
        this.status = status;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IncidentReport{" +
                "incidentId='" + incidentId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
