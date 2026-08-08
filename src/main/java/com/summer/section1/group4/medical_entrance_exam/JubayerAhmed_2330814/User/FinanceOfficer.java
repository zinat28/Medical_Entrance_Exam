package com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.User;

import com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser.*;
import java.io.*;
import java.util.ArrayList;

public class FinanceOfficer extends com.example.group4medicalexamsimulation.JubayerAhmed_2330814.User.SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String officerId;
    private String department;
    private String authorizationLevel;

    public static ArrayList<PaymentTransaction> paymentTransactions = new ArrayList<>();
    public static ArrayList<RefundRequest> refundRequests = new ArrayList<>();
    public static ArrayList<RevenueReport> revenueReports = new ArrayList<>();
    public static ArrayList<InstituteDisbursement> instituteDisbursements = new ArrayList<>();
    public static ArrayList<PaymentDispute> paymentDisputes = new ArrayList<>();
    public static ArrayList<DailyReconciliation> dailyReconciliations = new ArrayList<>();
    public static ArrayList<ScholarshipRecord> scholarshipRecords = new ArrayList<>();
    public static ArrayList<FinancialAuditReport> financialAuditReports = new ArrayList<>();

    public FinanceOfficer() {
    }

    public FinanceOfficer(String userId, String name, String email, String officerId, String department, String authorizationLevel) {
        super(userId, name, email);
        this.officerId = officerId;
        this.department = department;
        this.authorizationLevel = authorizationLevel;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(String authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    public static String verifyApplicationPayment(String transactionId) {
        PaymentTransaction tx = new PaymentTransaction(transactionId, 1500.0, "2026-08-05", "BANK-REF-100", true, "Verified");
        paymentTransactions.add(tx);
        saveListToFile("paymentTransactions.bin", paymentTransactions);
        return "Transaction " + transactionId + " successfully verified.";
    }

    public static String processRefund(String candidateId, String refundReason) {
        RefundRequest request = new RefundRequest("REF-" + System.currentTimeMillis() % 10000, 1500.0, refundReason, true, "ACC-998877");
        refundRequests.add(request);
        saveListToFile("refundRequests.bin", refundRequests);
        return "Refund of $1500.0 processed for Candidate " + candidateId;
    }

    public static RevenueReport generateRevenueReport(String startDate, String endDate, String instituteId) {
        RevenueReport report = new RevenueReport("REV-" + System.currentTimeMillis() % 10000, "2026-08-05", startDate + " to " + endDate, 50000.0, 5000.0, 1500.0);
        revenueReports.add(report);
        saveListToFile("revenueReports.bin", revenueReports);
        return report;
    }

    public static String disburseInstituteShare(String instituteId, String period) {
        InstituteDisbursement disbursement = new InstituteDisbursement("DISB-" + System.currentTimeMillis() % 10000, instituteId, period, 120, 80.0, 40000.0, "Completed");
        instituteDisbursements.add(disbursement);
        saveListToFile("instituteDisbursements.bin", instituteDisbursements);
        return "Disbursed $40000.0 to Institute " + instituteId + " for period " + period;
    }

    public static String resolvePaymentDispute(String transactionId, String disputeDetails) {
        PaymentDispute dispute = new PaymentDispute("DISP-" + System.currentTimeMillis() % 10000, disputeDetails, true, "Resolved - Refund Approved");
        paymentDisputes.add(dispute);
        saveListToFile("paymentDisputes.bin", paymentDisputes);
        return "Dispute resolved for Transaction " + transactionId;
    }

    public static ReconciliationSummary performDailyReconciliation(String reconciliationDate) {
        DailyReconciliation rec = new DailyReconciliation("REC-" + System.currentTimeMillis() % 10000, reconciliationDate, 100000.0, 100000.0, 0, "Matched");
        dailyReconciliations.add(rec);
        saveListToFile("dailyReconciliations.bin", dailyReconciliations);
        return new ReconciliationSummary(reconciliationDate, 100000.0, 100000.0, 0, "Matched");
    }

    public static String adjustScholarshipFee(String candidateId, String scholarshipDetails) {
        ScholarshipRecord record = new ScholarshipRecord("SCH-" + System.currentTimeMillis() % 10000, true, 1500.0, 500.0);
        scholarshipRecords.add(record);
        saveListToFile("scholarshipRecords.bin", scholarshipRecords);
        return "Scholarship fee adjusted for Candidate " + candidateId + " (" + scholarshipDetails + ")";
    }

    public static FinancialAuditReport generateFinancialAuditReport(String auditPeriod) {
        FinancialAuditReport report = new FinancialAuditReport("AUD-" + System.currentTimeMillis() % 10000, "2026-08-05", auditPeriod, 350, 150000.0, true);
        financialAuditReports.add(report);
        saveListToFile("financialAuditReports.bin", financialAuditReports);
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
        saveListToFile("paymentTransactions.bin", paymentTransactions);
        saveListToFile("refundRequests.bin", refundRequests);
        saveListToFile("revenueReports.bin", revenueReports);
        saveListToFile("instituteDisbursements.bin", instituteDisbursements);
        saveListToFile("paymentDisputes.bin", paymentDisputes);
        saveListToFile("dailyReconciliations.bin", dailyReconciliations);
        saveListToFile("scholarshipRecords.bin", scholarshipRecords);
        saveListToFile("financialAuditReports.bin", financialAuditReports);
    }

    public static void loadAllLists() {
        paymentTransactions = loadListFromFile("paymentTransactions.bin");
        if (paymentTransactions.isEmpty()) {
            paymentTransactions.add(new PaymentTransaction("TX-9001", 1500.0, "2026-08-01", "BANK-REF-9001", true, "Verified"));
            paymentTransactions.add(new PaymentTransaction("TX-9002", 1500.0, "2026-08-02", "BANK-REF-9002", true, "Verified"));
            paymentTransactions.add(new PaymentTransaction("TX-9003", 2000.0, "2026-08-03", "BANK-REF-9003", false, "Pending"));
            saveListToFile("paymentTransactions.bin", paymentTransactions);
        }

        refundRequests = loadListFromFile("refundRequests.bin");
        if (refundRequests.isEmpty()) {
            refundRequests.add(new RefundRequest("REF-3001", 1500.0, "Double payment charged", true, "ACC-112233"));
            refundRequests.add(new RefundRequest("REF-3002", 1500.0, "Application cancelled before deadline", true, "ACC-445566"));
            saveListToFile("refundRequests.bin", refundRequests);
        }

        revenueReports = loadListFromFile("revenueReports.bin");
        if (revenueReports.isEmpty()) {
            revenueReports.add(new RevenueReport("REV-7001", "2026-08-05", "2026-07-01 to 2026-07-31", 150000.0, 15000.0, 3000.0));
            revenueReports.add(new RevenueReport("REV-7002", "2026-08-05", "2026-08-01 to 2026-08-05", 50000.0, 5000.0, 1500.0));
            saveListToFile("revenueReports.bin", revenueReports);
        }

        instituteDisbursements = loadListFromFile("instituteDisbursements.bin");
        if (instituteDisbursements.isEmpty()) {
            instituteDisbursements.add(new InstituteDisbursement("DISB-4001", "INST-01", "2026-Q1", 120, 80.0, 96000.0, "Completed"));
            instituteDisbursements.add(new InstituteDisbursement("DISB-4002", "INST-02", "2026-Q1", 80, 80.0, 64000.0, "Completed"));
            saveListToFile("instituteDisbursements.bin", instituteDisbursements);
        }

        paymentDisputes = loadListFromFile("paymentDisputes.bin");
        if (paymentDisputes.isEmpty()) {
            paymentDisputes.add(new PaymentDispute("DISP-5001", "Bank debited twice but 1 failed", true, "Resolved - Refund Approved"));
            paymentDisputes.add(new PaymentDispute("DISP-5002", "Incorrect fee amount charged", true, "Under Investigation"));
            saveListToFile("paymentDisputes.bin", paymentDisputes);
        }

        dailyReconciliations = loadListFromFile("dailyReconciliations.bin");
        if (dailyReconciliations.isEmpty()) {
            dailyReconciliations.add(new DailyReconciliation("REC-6001", "2026-08-04", 100000.0, 100000.0, 0, "Matched"));
            dailyReconciliations.add(new DailyReconciliation("REC-6002", "2026-08-05", 120000.0, 120000.0, 0, "Matched"));
            saveListToFile("dailyReconciliations.bin", dailyReconciliations);
        }

        scholarshipRecords = loadListFromFile("scholarshipRecords.bin");
        if (scholarshipRecords.isEmpty()) {
            scholarshipRecords.add(new ScholarshipRecord("SCH-1001", true, 1500.0, 500.0));
            scholarshipRecords.add(new ScholarshipRecord("SCH-1002", true, 1500.0, 0.0));
            saveListToFile("scholarshipRecords.bin", scholarshipRecords);
        }

        financialAuditReports = loadListFromFile("financialAuditReports.bin");
        if (financialAuditReports.isEmpty()) {
            financialAuditReports.add(new FinancialAuditReport("AUD-8001", "2026-08-05", "2026-Q1", 350, 160000.0, true));
            financialAuditReports.add(new FinancialAuditReport("AUD-8002", "2026-08-05", "2026-Q2", 420, 210000.0, true));
            saveListToFile("financialAuditReports.bin", financialAuditReports);
        }
    }

    @Override
    public String toString() {
        return "FinanceOfficer{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", officerId='" + officerId + '\'' +
                ", department='" + department + '\'' +
                ", authorizationLevel='" + authorizationLevel + '\'' +
                '}';
    }
}
