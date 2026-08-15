package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser;

import java.io.Serializable;

public class ExamSchedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scheduleId;
    private String examDate;
    private String startTime;
    private int durationMinutes;
    private boolean isSaved;

    public ExamSchedule() {
    }

    public ExamSchedule(String scheduleId, String examDate, String startTime, int durationMinutes, boolean isSaved) {
        this.scheduleId = scheduleId;
        this.examDate = examDate;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.isSaved = isSaved;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean saved) {
        isSaved = saved;
    }

    @Override
    public String toString() {
        return "ExamSchedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", examDate='" + examDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", isSaved=" + isSaved +
                '}';
    }
  //public void checkExamTime(){
        //int exDate= examDate.get.Year
   // }
}
