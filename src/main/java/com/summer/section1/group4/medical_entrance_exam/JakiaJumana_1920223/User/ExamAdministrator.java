package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.*;

import java.io.*;
import java.util.ArrayList;

public class ExamAdministrator extends SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adminId;
    private String department;
    private String role;

    public static ArrayList<ExamSchedule> examScheduleList = new ArrayList<>();
    public static ArrayList<ExamNotice> examNoticeList = new ArrayList<>();
    public static ArrayList<Application> applicationList = new ArrayList<>();
    public static ArrayList<ExamCenter> examCenterList = new ArrayList<>();
    public static ArrayList<AdmitCard> admitCardList = new ArrayList<>();
    public static ArrayList<ExamResult> examResultList = new ArrayList<>();
    public static ArrayList<FinalReport> finalReportList = new ArrayList<>();

    public ExamAdministrator() {
    }

    public ExamAdministrator(String userId, String name, String email, String adminId, String department, String role) {
        super(userId, name, email);
        this.adminId = adminId;
        this.department = department;
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static ExamSchedule createExamSchedule(String examDate, String startTime, int durationMinutes) {
        ExamSchedule schedule = new ExamSchedule("SCH-" + System.currentTimeMillis() % 10000, examDate, startTime, durationMinutes, true);
        examScheduleList.add(schedule);
        saveListToFile("examScheduleList.bin", examScheduleList);
        return schedule;
    }

    public static ExamNotice publishExamNotice(String title, String details) {
        ExamNotice notice = new ExamNotice("NOT-" + System.currentTimeMillis() % 10000, title, details, "2026-08-06", true);
        examNoticeList.add(notice);
        saveListToFile("examNoticeList.bin", examNoticeList);
        return notice;
    }

    public static Application manageApplicantRecord(String applicantId, String applicantName) {
        Application app = new Application("APP-" + System.currentTimeMillis() % 10000, applicantId, applicantName, "2026-08-06", "Verified", "Pending");
        applicationList.add(app);
        saveListToFile("applicationList.bin", applicationList);
        return app;
    }

    public static String approveApplicantRegistration(String applicationId) {
        for (Application app : applicationList) {
            if (app.getApplicationId().equals(applicationId)) {
                app.setApprovalStatus("Approved");
                saveListToFile("applicationList.bin", applicationList);
                return "Application " + applicationId + " Approved";
            }
        }
        Application app = new Application(applicationId, "APP-NEW", "Applicant", "2026-08-06", "Verified", "Approved");
        applicationList.add(app);
        saveListToFile("applicationList.bin", applicationList);
        return "Application " + applicationId + " Approved";
    }

    public static ExamCenter assignExamCenters(String centerName, int capacity, String location) {
        ExamCenter center = new ExamCenter("CTR-" + System.currentTimeMillis() % 10000, centerName, capacity, capacity, location);
        examCenterList.add(center);
        saveListToFile("examCenterList.bin", examCenterList);
        return center;
    }

    public static AdmitCard generateAdmitCards(String applicantId, String rollNumber, String centerId) {
        AdmitCard card = new AdmitCard("ADM-" + System.currentTimeMillis() % 10000, applicantId, rollNumber, centerId, "2026-08-06");
        admitCardList.add(card);
        saveListToFile("admitCardList.bin", admitCardList);
        return card;
    }

    public static ExamResult publishExamResults(String resultFilePath, int totalProcessed) {
        ExamResult res = new ExamResult("RES-" + System.currentTimeMillis() % 10000, resultFilePath, "2026-08-06 10:00", totalProcessed, true);
        examResultList.add(res);
        saveListToFile("examResultList.bin", examResultList);
        return res;
    }

    public static FinalReport generateFinalReport(String reportType, String reportData) {
        FinalReport report = new FinalReport("REP-" + System.currentTimeMillis() % 10000, "2026-08-06", reportType, reportData);
        finalReportList.add(report);
        saveListToFile("finalReportList.bin", finalReportList);
        return report;
    }

    public static void saveListToFile(String filename, Object list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> loadListFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<T>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveAllLists() {
        saveListToFile("examScheduleList.bin", examScheduleList);
        saveListToFile("examNoticeList.bin", examNoticeList);
        saveListToFile("applicationList.bin", applicationList);
        saveListToFile("examCenterList.bin", examCenterList);
        saveListToFile("admitCardList.bin", admitCardList);
        saveListToFile("examResultList.bin", examResultList);
        saveListToFile("finalReportList.bin", finalReportList);
    }

    public static void loadAllLists() {
        examScheduleList = loadListFromFile("examScheduleList.bin");
        if (examScheduleList.isEmpty()) {
            examScheduleList.add(new ExamSchedule("SCH-701", "2026-09-10", "10:00 AM", 180, true));
            examScheduleList.add(new ExamSchedule("SCH-702", "2026-09-15", "02:00 PM", 120, true));
            saveListToFile("examScheduleList.bin", examScheduleList);
        }

        examNoticeList = loadListFromFile("examNoticeList.bin");
        if (examNoticeList.isEmpty()) {
            examNoticeList.add(new ExamNotice("NOT-101", "Medical Exam Registration Open", "All candidates are requested to complete online registration.", "2026-08-01", true));
            examNoticeList.add(new ExamNotice("NOT-102", "Admit Card Download Schedule", "Admit cards can be downloaded from the candidate portal.", "2026-08-05", true));
            saveListToFile("examNoticeList.bin", examNoticeList);
        }

        applicationList = loadListFromFile("applicationList.bin");
        if (applicationList.isEmpty()) {
            applicationList.add(new Application("APP-301", "CAND-501", "Tasmia Islam", "2026-08-02", "Verified", "Approved"));
            applicationList.add(new Application("APP-302", "CAND-502", "Fahim Ahmed", "2026-08-03", "Verified", "Approved"));
            applicationList.add(new Application("APP-303", "CAND-503", "Saima Sultana", "2026-08-04", "Pending", "Pending"));
            saveListToFile("applicationList.bin", applicationList);
        }

        examCenterList = loadListFromFile("examCenterList.bin");
        if (examCenterList.isEmpty()) {
            examCenterList.add(new ExamCenter("CTR-01", "Dhaka Medical College", 600, 150, "Dhaka"));
            examCenterList.add(new ExamCenter("CTR-02", "Chittagong Medical College", 400, 100, "Chittagong"));
            saveListToFile("examCenterList.bin", examCenterList);
        }

        admitCardList = loadListFromFile("admitCardList.bin");
        if (admitCardList.isEmpty()) {
            admitCardList.add(new AdmitCard("ADM-901", "CAND-501", "ROLL-5001", "CTR-01", "2026-08-05"));
            admitCardList.add(new AdmitCard("ADM-902", "CAND-502", "ROLL-5002", "CTR-01", "2026-08-05"));
            saveListToFile("admitCardList.bin", admitCardList);
        }

        examResultList = loadListFromFile("examResultList.bin");
        if (examResultList.isEmpty()) {
            examResultList.add(new ExamResult("RES-101", "/results/2026_mbb_batch1.csv", "2026-08-05 16:00", 950, true));
            examResultList.add(new ExamResult("RES-102", "/results/2026_bds_batch1.csv", "2026-08-05 17:00", 450, true));
            saveListToFile("examResultList.bin", examResultList);
        }

        finalReportList = loadListFromFile("finalReportList.bin");
        if (finalReportList.isEmpty()) {
            finalReportList.add(new FinalReport("REP-601", "2026-08-05", "Annual Summary", "All examination centers operated smoothly with 98% attendance."));
            finalReportList.add(new FinalReport("REP-602", "2026-08-05", "Audit Report", "Complete financial and attendance audit cleared."));
            saveListToFile("finalReportList.bin", finalReportList);
        }
    }

    @Override
    public String toString() {
        return "ExamAdministrator{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", adminId='" + adminId + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
