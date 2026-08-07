package com.example.group4medicalexamsimulation.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class DailyReconciliation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reconciliationId;
    private String date;
    private double gatewayCollectedTotal;
    private double bankSettlementTotal;
    private int mismatchCount;
    private String status;

    public DailyReconciliation() {
    }

    public DailyReconciliation(String reconciliationId, String date, double gatewayCollectedTotal, double bankSettlementTotal, int mismatchCount, String status) {
        this.reconciliationId = reconciliationId;
        this.date = date;
        this.gatewayCollectedTotal = gatewayCollectedTotal;
        this.bankSettlementTotal = bankSettlementTotal;
        this.mismatchCount = mismatchCount;
        this.status = status;
    }

    public String getReconciliationId() {
        return reconciliationId;
    }

    public void setReconciliationId(String reconciliationId) {
        this.reconciliationId = reconciliationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getGatewayCollectedTotal() {
        return gatewayCollectedTotal;
    }

    public void setGatewayCollectedTotal(double gatewayCollectedTotal) {
        this.gatewayCollectedTotal = gatewayCollectedTotal;
    }

    public double getBankSettlementTotal() {
        return bankSettlementTotal;
    }

    public void setBankSettlementTotal(double bankSettlementTotal) {
        this.bankSettlementTotal = bankSettlementTotal;
    }

    public int getMismatchCount() {
        return mismatchCount;
    }

    public void setMismatchCount(int mismatchCount) {
        this.mismatchCount = mismatchCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DailyReconciliation{" +
                "reconciliationId='" + reconciliationId + '\'' +
                ", date='" + date + '\'' +
                ", gatewayCollectedTotal=" + gatewayCollectedTotal +
                ", bankSettlementTotal=" + bankSettlementTotal +
                ", mismatchCount=" + mismatchCount +
                ", status='" + status + '\'' +
                '}';
    }
}
