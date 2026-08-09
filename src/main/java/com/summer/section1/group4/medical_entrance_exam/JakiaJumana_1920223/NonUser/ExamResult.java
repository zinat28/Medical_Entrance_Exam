package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class ExamResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String resultId;
    private String resultFilePath;
    private String uploadTimestamp;
    private int totalProcessed;
    private boolean isPublished;

    public ExamResult() {
    }

    public ExamResult(String resultId, String resultFilePath, String uploadTimestamp, int totalProcessed, boolean isPublished) {
        this.resultId = resultId;
        this.resultFilePath = resultFilePath;
        this.uploadTimestamp = uploadTimestamp;
        this.totalProcessed = totalProcessed;
        this.isPublished = isPublished;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getResultFilePath() {
        return resultFilePath;
    }

    public void setResultFilePath(String resultFilePath) {
        this.resultFilePath = resultFilePath;
    }

    public String getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(String uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public int getTotalProcessed() {
        return totalProcessed;
    }

    public void setTotalProcessed(int totalProcessed) {
        this.totalProcessed = totalProcessed;
    }

    public boolean isIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean published) {
        isPublished = published;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "resultId='" + resultId + '\'' +
                ", resultFilePath='" + resultFilePath + '\'' +
                ", uploadTimestamp='" + uploadTimestamp + '\'' +
                ", totalProcessed=" + totalProcessed +
                ", isPublished=" + isPublished +
                '}';
    }
}
