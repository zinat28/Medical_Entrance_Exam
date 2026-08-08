package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class CenterDocument implements Serializable {
    private static final long serialVersionUID = 1L;

    private String documentId;
    private String centerId;
    private String title;
    private String fileFormat;
    private String downloadUrl;

    public CenterDocument() {
    }

    public CenterDocument(String documentId, String centerId, String title, String fileFormat, String downloadUrl) {
        this.documentId = documentId;
        this.centerId = centerId;
        this.title = title;
        this.fileFormat = fileFormat;
        this.downloadUrl = downloadUrl;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "CenterDocument{" +
                "documentId='" + documentId + '\'' +
                ", centerId='" + centerId + '\'' +
                ", title='" + title + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
