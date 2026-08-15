package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User;

import com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser.*;

import java.io.*;
import java.util.ArrayList;

public class ExamCenterCoordinator extends SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String coordinatorId;
    private String assignedCenterId;
    private String contactNumber;

    public static ArrayList<ExamRoom> examRoomList = new ArrayList<>();
    public static ArrayList<SeatAllocation> seatAllocationList = new ArrayList<>();
    public static ArrayList<VenueAttendance> venueAttendanceList = new ArrayList<>();
    public static ArrayList<AbsentReport> absentReportList = new ArrayList<>();
    public static ArrayList<ExamSessionReport> examSessionReportList = new ArrayList<>();
    public static ArrayList<CapacityStatus> capacityStatusList = new ArrayList<>();
    public static ArrayList<CenterDocument> centerDocumentList = new ArrayList<>();

    public ExamCenterCoordinator() {
    }

    public ExamCenterCoordinator(String userId, String name, String email, String coordinatorId, String assignedCenterId, String contactNumber) {
        super(userId, name, email);
        this.coordinatorId = coordinatorId;
        this.assignedCenterId = assignedCenterId;
        this.contactNumber = contactNumber;
    }

    public String getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(String coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public String getAssignedCenterId() {
        return assignedCenterId;
    }

    public void setAssignedCenterId(String assignedCenterId) {
        this.assignedCenterId = assignedCenterId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public static ExamCenter getCenterAndCandidateDetails(String centerId) {
        CapacityStatus status = new CapacityStatus("CAP-" + System.currentTimeMillis() % 10000, centerId, 500, 350, 150);
        capacityStatusList.add(status);
        saveListToFile("capacityStatusList.bin", capacityStatusList);
        return new ExamCenter(centerId, "Center " + centerId, 500, 150, "Main Campus");
    }

    public static ExamRoom assignExamRooms(String centerId, String roomNumber, int capacity) {
        ExamRoom room = new ExamRoom("ROOM-" + System.currentTimeMillis() % 10000, centerId, roomNumber, capacity, true);
        examRoomList.add(room);
        saveListToFile("examRoomList.bin", examRoomList);
        return room;
    }

    public static SeatAllocation manageSeatAllocation(String candidateId, String roomId, String seatNumber) {
        SeatAllocation alloc = new SeatAllocation("ALLOC-" + System.currentTimeMillis() % 10000, candidateId, roomId, seatNumber);
        seatAllocationList.add(alloc);
        saveListToFile("seatAllocationList.bin", seatAllocationList);
        return alloc;
    }

    public static VenueAttendance verifyVenueAttendance(String venueId, String centerId, int totalCandidates, int presentCount) {
        VenueAttendance att = new VenueAttendance("ATT-" + System.currentTimeMillis() % 10000, venueId, centerId, totalCandidates, presentCount, true);
        venueAttendanceList.add(att);
        saveListToFile("venueAttendanceList.bin", venueAttendanceList);
        return att;
    }

    public static AbsentReport reportAbsentCandidates(String centerId, int totalAbsentCount) {
        AbsentReport report = new AbsentReport("ABS-" + System.currentTimeMillis() % 10000, "2026-08-06", centerId, totalAbsentCount);
        absentReportList.add(report);
        saveListToFile("absentReportList.bin", absentReportList);
        return report;
    }

    public static ExamSessionReport submitExamSessionReport(String centerId, String sessionRemarks) {
        ExamSessionReport report = new ExamSessionReport("SESS-" + System.currentTimeMillis() % 10000, "2026-08-06", centerId, sessionRemarks, "12:00 PM", "Submitted");
        examSessionReportList.add(report);
        saveListToFile("examSessionReportList.bin", examSessionReportList);
        return report;
    }

    public static CapacityStatus getCenterCapacityStatus(String centerId, int totalCapacity, int allocatedSeats) {
        CapacityStatus status = new CapacityStatus("CAP-" + System.currentTimeMillis() % 10000, centerId, totalCapacity, allocatedSeats, totalCapacity - allocatedSeats);
        capacityStatusList.add(status);
        saveListToFile("capacityStatusList.bin", capacityStatusList);
        return status;
    }

    public static CenterDocument downloadCenterDocument(String centerId, String title, String fileFormat) {
        CenterDocument doc = new CenterDocument("DOC-" + System.currentTimeMillis() % 10000, centerId, title, fileFormat, "https://docs.exam.org/" + title + "." + fileFormat.toLowerCase());
        centerDocumentList.add(doc);
        saveListToFile("centerDocumentList.bin", centerDocumentList);
        return doc;
    }

    public static void saveListToFile(String filename, Object list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> loadListFromFile(String filename) {//decorator, have to do it for file
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
        saveListToFile("examRoomList.bin", examRoomList);
        saveListToFile("seatAllocationList.bin", seatAllocationList);
        saveListToFile("venueAttendanceList.bin", venueAttendanceList);
        saveListToFile("absentReportList.bin", absentReportList);
        saveListToFile("examSessionReportList.bin", examSessionReportList);
        saveListToFile("capacityStatusList.bin", capacityStatusList);
        saveListToFile("centerDocumentList.bin", centerDocumentList);
    }

    public static void loadAllLists() {
        examRoomList = loadListFromFile("examRoomList.bin");
        if (examRoomList.isEmpty()) {
            examRoomList.add(new ExamRoom("ROOM-101", "CTR-01", "R-101", 50, true));
            examRoomList.add(new ExamRoom("ROOM-102", "CTR-01", "R-102", 50, true));
            examRoomList.add(new ExamRoom("ROOM-201", "CTR-02", "R-201", 60, true));
            saveListToFile("examRoomList.bin", examRoomList);
        }

        seatAllocationList = loadListFromFile("seatAllocationList.bin");
        if (seatAllocationList.isEmpty()) {
            seatAllocationList.add(new SeatAllocation("ALLOC-801", "CAND-501", "ROOM-101", "S-01"));
            seatAllocationList.add(new SeatAllocation("ALLOC-802", "CAND-502", "ROOM-101", "S-02"));
            saveListToFile("seatAllocationList.bin", seatAllocationList);
        }

        venueAttendanceList = loadListFromFile("venueAttendanceList.bin");
        if (venueAttendanceList.isEmpty()) {
            venueAttendanceList.add(new VenueAttendance("ATT-401", "VENUE-A", "CTR-01", 200, 196, true));
            venueAttendanceList.add(new VenueAttendance("ATT-402", "VENUE-B", "CTR-02", 150, 148, true));
            saveListToFile("venueAttendanceList.bin", venueAttendanceList);
        }

        absentReportList = loadListFromFile("absentReportList.bin");
        if (absentReportList.isEmpty()) {
            absentReportList.add(new AbsentReport("ABS-201", "2026-08-05", "CTR-01", 4));
            absentReportList.add(new AbsentReport("ABS-202", "2026-08-05", "CTR-02", 2));
            saveListToFile("absentReportList.bin", absentReportList);
        }

        examSessionReportList = loadListFromFile("examSessionReportList.bin");
        if (examSessionReportList.isEmpty()) {
            examSessionReportList.add(new ExamSessionReport("SESS-501", "2026-08-05", "CTR-01", "Morning session conducted without issues.", "12:30 PM", "Completed"));
            examSessionReportList.add(new ExamSessionReport("SESS-502", "2026-08-05", "CTR-02", "Afternoon session completed on schedule.", "05:00 PM", "Completed"));
            saveListToFile("examSessionReportList.bin", examSessionReportList);
        }

        capacityStatusList = loadListFromFile("capacityStatusList.bin");
        if (capacityStatusList.isEmpty()) {
            capacityStatusList.add(new CapacityStatus("CAP-101", "CTR-01", 600, 450, 150));
            capacityStatusList.add(new CapacityStatus("CAP-102", "CTR-02", 400, 300, 100));
            saveListToFile("capacityStatusList.bin", capacityStatusList);
        }

        centerDocumentList = loadListFromFile("centerDocumentList.bin");
        if (centerDocumentList.isEmpty()) {
            centerDocumentList.add(new CenterDocument("DOC-301", "CTR-01", "Center Guidelines 2026", "PDF", "https://docs.exam.org/CTR-01_guidelines.pdf"));
            centerDocumentList.add(new CenterDocument("DOC-302", "CTR-02", "Seating Plan Layout", "PDF", "https://docs.exam.org/CTR-02_seating.pdf"));
            saveListToFile("centerDocumentList.bin", centerDocumentList);
        }
    }

    @Override
    public String toString() {
        return "ExamCenterCoordinator{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", coordinatorId='" + coordinatorId + '\'' +
                ", assignedCenterId='" + assignedCenterId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
