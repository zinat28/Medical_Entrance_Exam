package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class ExamNotice implements Serializable {
    private static final long serialVersionUID = 1L;

    private String noticeId;
    private String title;
    private String details;
    private String publishDate;
    private boolean isPublished;

    public ExamNotice() {
    }

    public ExamNotice(String noticeId, String title, String details, String publishDate, boolean isPublished) {
        this.noticeId = noticeId;
        this.title = title;
        this.details = details;
        this.publishDate = publishDate;
        this.isPublished = isPublished;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean published) {
        isPublished = published;
    }

    @Override
    public String toString() {
        return "ExamNotice{" +
                "noticeId='" + noticeId + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", isPublished=" + isPublished +
                '}';
    }
}
