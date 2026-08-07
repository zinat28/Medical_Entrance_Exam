package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class ReconciliationSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reconciliationDate;
    private double totalCollected;
    private double totalSettled;
    private int discrepancyCount;
    private String status;

    public ReconciliationSummary() {
    }

    public ReconciliationSummary(String reconciliationDate, double totalCollected, double totalSettled, int discrepancyCount, String status) {
        this.reconciliationDate = reconciliationDate;
        this.totalCollected = totalCollected;
        this.totalSettled = totalSettled;
        this.discrepancyCount = discrepancyCount;
        this.status = status;
    }

    public String getReconciliationDate() {
        return reconciliationDate;
    }

    public void setReconciliationDate(String reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public void setTotalCollected(double totalCollected) {
        this.totalCollected = totalCollected;
    }

    public double getTotalSettled() {
        return totalSettled;
    }

    public void setTotalSettled(double totalSettled) {
        this.totalSettled = totalSettled;
    }

    public int getDiscrepancyCount() {
        return discrepancyCount;
    }

    public void setDiscrepancyCount(int discrepancyCount) {
        this.discrepancyCount = discrepancyCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReconciliationSummary{" +
                "reconciliationDate='" + reconciliationDate + '\'' +
                ", totalCollected=" + totalCollected +
                ", totalSettled=" + totalSettled +
                ", discrepancyCount=" + discrepancyCount +
                ", status='" + status + '\'' +
                '}';
    }
}
