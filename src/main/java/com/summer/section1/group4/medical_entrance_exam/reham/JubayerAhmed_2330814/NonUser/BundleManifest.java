package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class BundleManifest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String manifestId;
    private String hallId;
    private int totalSheetsCollected;
    private String sealStatus;
    private String invigilatorSignature;

    public BundleManifest() {
    }

    public BundleManifest(String manifestId, String hallId, int totalSheetsCollected, String sealStatus, String invigilatorSignature) {
        this.manifestId = manifestId;
        this.hallId = hallId;
        this.totalSheetsCollected = totalSheetsCollected;
        this.sealStatus = sealStatus;
        this.invigilatorSignature = invigilatorSignature;
    }

    public String getManifestId() {
        return manifestId;
    }

    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public int getTotalSheetsCollected() {
        return totalSheetsCollected;
    }

    public void setTotalSheetsCollected(int totalSheetsCollected) {
        this.totalSheetsCollected = totalSheetsCollected;
    }

    public String getSealStatus() {
        return sealStatus;
    }

    public void setSealStatus(String sealStatus) {
        this.sealStatus = sealStatus;
    }

    public String getInvigilatorSignature() {
        return invigilatorSignature;
    }

    public void setInvigilatorSignature(String invigilatorSignature) {
        this.invigilatorSignature = invigilatorSignature;
    }

    @Override
    public String toString() {
        return "BundleManifest{" +
                "manifestId='" + manifestId + '\'' +
                ", hallId='" + hallId + '\'' +
                ", totalSheetsCollected=" + totalSheetsCollected +
                ", sealStatus='" + sealStatus + '\'' +
                ", invigilatorSignature='" + invigilatorSignature + '\'' +
                '}';
    }
}
