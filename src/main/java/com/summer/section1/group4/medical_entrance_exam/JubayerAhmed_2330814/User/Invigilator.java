package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.User;

import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.*;
import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.AnswerSheet;
import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.Candidate;
import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.QuestionBooklet;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Invigilator extends com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String invigilatorId;
    private String assignedHallId;
    private String contactNumber;

    public static ArrayList<Candidate> candidateList = new ArrayList<>();
    public static ArrayList<AttendanceRecord> attendanceRecords = new ArrayList<>();
    public static Collection<QuestionBooklet> questionBooklets = new ArrayList<>();
    public static ArrayList<IncidentReport> incidentReports = new ArrayList<>();
    public static Collection<AnswerSheet> answerSheets = new ArrayList<>();
    public static ArrayList<HallReport> hallReports = new ArrayList<>();

    public Invigilator() {
    }

    public Invigilator(String userId, String name, String email, String invigilatorId, String assignedHallId, String contactNumber) {
        super(userId, name, email);
        this.invigilatorId = invigilatorId;
        this.assignedHallId = assignedHallId;
        this.contactNumber = contactNumber;
    }

    public String getInvigilatorId() {
        return invigilatorId;
    }

    public void setInvigilatorId(String invigilatorId) {
        this.invigilatorId = invigilatorId;
    }

    public String getAssignedHallId() {
        return assignedHallId;
    }

    public void setAssignedHallId(String assignedHallId) {
        this.assignedHallId = assignedHallId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public static String verifyAttendanceAndSeating(String rollNumber, String admitCardId) {
        AttendanceRecord record = new AttendanceRecord("ATT-" + System.currentTimeMillis() % 10000, "10:00 AM", "Verified", false, "09:45 AM");
        attendanceRecords.add(record);
        saveListToFile("attendanceRecords.bin", attendanceRecords);
        return "Attendance Verified for Roll: " + rollNumber + " (Admit Card: " + admitCardId + ")";
    }

    public static String distributeQuestionBooklet(String rollNumber, String serialNumber) {
        QuestionBooklet booklet = new QuestionBooklet(serialNumber, "SET-A", true);
        questionBooklets.add(booklet);
        saveListToFile("questionBooklets.bin", questionBooklets);
        return "Booklet " + serialNumber + " distributed to Roll " + rollNumber;
    }

    public static String reportIncident(String rollNumber, String incidentTime, String description, String photo) {
        IncidentReport report = new IncidentReport("INC-" + System.currentTimeMillis() % 10000, incidentTime, description, photo, "Logged");
        incidentReports.add(report);
        saveListToFile("incidentReports.bin", incidentReports);
        return "Incident logged for Candidate " + rollNumber;
    }

    public static String collectAnswerSheet(String sheetBarcode, String manifestId) {
        AnswerSheet sheet = new AnswerSheet(sheetBarcode, "SN-" + sheetBarcode, false, "Collected");
        answerSheets.add(sheet);
        saveListToFile("answerSheets.bin", answerSheets);
        return "Sheet " + sheetBarcode + " collected into Manifest " + manifestId;
    }

    public static String reVerifyCandidateIdentity(String rollNumber) {
        return "Identity Re-verified for Roll: " + rollNumber + " - Matched";
    }

    public static String approveLateEntry(String rollNumber, String arrivalTime) {
        AttendanceRecord record = new AttendanceRecord("ATT-LATE-" + System.currentTimeMillis() % 10000, arrivalTime, "Late Approved", true, arrivalTime);
        attendanceRecords.add(record);
        saveListToFile("attendanceRecords.bin", attendanceRecords);
        return "Late entry approved for Roll: " + rollNumber + " at " + arrivalTime;
    }

    public static String issueExtraAnswerSheet(String rollNumber, String sheetSerialNumber) {
        AnswerSheet sheet = new AnswerSheet("BAR-" + sheetSerialNumber, sheetSerialNumber, true, "Issued");
        answerSheets.add(sheet);
        saveListToFile("answerSheets.bin", answerSheets);
        return "Extra answer sheet " + sheetSerialNumber + " issued to Roll " + rollNumber;
    }

    public static HallReport generateHallClosingReport(String hallId, String remarks) {
        HallReport report = new HallReport(hallId, remarks, "2026-08-05");
        hallReports.add(report);
        saveListToFile("hallReports.bin", hallReports);
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
        saveListToFile("candidateList.bin", candidateList);
        saveListToFile("attendanceRecords.bin", attendanceRecords);
        saveListToFile("questionBooklets.bin", questionBooklets);
        saveListToFile("incidentReports.bin", incidentReports);
        saveListToFile("answerSheets.bin", answerSheets);
        saveListToFile("hallReports.bin", hallReports);
    }

    public static void loadAllLists() {
        candidateList = loadListFromFile("candidateList.bin");
        if (candidateList.isEmpty()) {
            candidateList.add(new Candidate("CAND-101", "1001", "ADM-1001", "Rahim Uddin", "photo1.jpg", "HALL-A", "A-12", "Paid"));
            candidateList.add(new Candidate("CAND-102", "1002", "ADM-1002", "Karim Hossain", "photo2.jpg", "HALL-A", "A-13", "Paid"));
            candidateList.add(new Candidate("CAND-103", "1003", "ADM-1003", "Nusrat Jahan", "photo3.jpg", "HALL-B", "B-05", "Paid"));
            saveListToFile("candidateList.bin", candidateList);
        }

        attendanceRecords = loadListFromFile("attendanceRecords.bin");
        if (attendanceRecords.isEmpty()) {
            attendanceRecords.add(new AttendanceRecord("ATT-101", "09:30 AM", "Verified", false, "09:15 AM"));
            attendanceRecords.add(new AttendanceRecord("ATT-102", "09:40 AM", "Verified", false, "09:20 AM"));
            attendanceRecords.add(new AttendanceRecord("ATT-103", "10:15 AM", "Late Approved", true, "10:10 AM"));
            saveListToFile("attendanceRecords.bin", attendanceRecords);
        }

        questionBooklets = loadListFromFile("questionBooklets.bin");
        if (questionBooklets.isEmpty()) {
            questionBooklets.add(new QuestionBooklet("SN-5001", "SET-A", true));
            questionBooklets.add(new QuestionBooklet("SN-5002", "SET-B", true));
            questionBooklets.add(new QuestionBooklet("SN-5003", "SET-C", false));
            saveListToFile("questionBooklets.bin", questionBooklets);
        }

        incidentReports = loadListFromFile("incidentReports.bin");
        if (incidentReports.isEmpty()) {
            incidentReports.add(new IncidentReport("INC-201", "10:30 AM", "Unauthorized paper found", "photo_inc1.jpg", "Logged"));
            incidentReports.add(new IncidentReport("INC-202", "11:00 AM", "Calculator malfunction", "photo_inc2.jpg", "Resolved"));
            saveListToFile("incidentReports.bin", incidentReports);
        }

        answerSheets = loadListFromFile("answerSheets.bin");
        if (answerSheets.isEmpty()) {
            answerSheets.add(new AnswerSheet("BAR-8001", "SN-8001", false, "Collected"));
            answerSheets.add(new AnswerSheet("BAR-8002", "SN-8002", false, "Collected"));
            answerSheets.add(new AnswerSheet("BAR-8003", "SN-EX01", true, "Issued"));
            saveListToFile("answerSheets.bin", answerSheets);
        }

        hallReports = loadListFromFile("hallReports.bin");
        if (hallReports.isEmpty()) {
            hallReports.add(new HallReport("HALL-A", "All exam sessions completed normally.", "2026-08-05"));
            hallReports.add(new HallReport("HALL-B", "One minor incident logged and reported.", "2026-08-05"));
            saveListToFile("hallReports.bin", hallReports);
        }
    }

    @Override
    public String toString() {
        return "Invigilator{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", invigilatorId='" + invigilatorId + '\'' +
                ", assignedHallId='" + assignedHallId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
