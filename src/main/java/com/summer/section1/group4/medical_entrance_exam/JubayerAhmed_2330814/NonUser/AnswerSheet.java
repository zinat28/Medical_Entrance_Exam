package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser;

import java.io.Serializable;

public class AnswerSheet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String barcode;
    private String serialNumber;
    private boolean isExtraSheet;
    private String collectionStatus;

    public AnswerSheet() {
    }

    public AnswerSheet(String barcode, String serialNumber, boolean isExtraSheet, String collectionStatus) {
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.isExtraSheet = isExtraSheet;
        this.collectionStatus = collectionStatus;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isIsExtraSheet() {
        return isExtraSheet;
    }

    public void setIsExtraSheet(boolean extraSheet) {
        isExtraSheet = extraSheet;
    }

    public String getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(String collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    @Override
    public String toString() {
        return "AnswerSheet{" +
                "barcode='" + barcode + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", isExtraSheet=" + isExtraSheet +
                ", collectionStatus='" + collectionStatus + '\'' +
                '}';
    }
}
