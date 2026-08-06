package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model;

public class Candidate {

    private int id;
    private String name;
    private String roll;
    private double gpa;
    private String status;
    private boolean documentsVerified;

    public Candidate() {
    }

    // Used while adding a new candidate
    public Candidate(
            String name,
            String roll,
            double gpa,
            String status
    ) {
        this(0, name, roll, gpa, status, false);
    }

    // Keeps your previous code compatible
    public Candidate(
            int id,
            String name,
            String roll,
            double gpa,
            String status
    ) {
        this(id, name, roll, gpa, status, false);
    }

    // Complete constructor
    public Candidate(
            int id,
            String name,
            String roll,
            double gpa,
            String status,
            boolean documentsVerified
    ) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.gpa = gpa;
        this.status = status;
        this.documentsVerified = documentsVerified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDocumentsVerified() {
        return documentsVerified;
    }

    public boolean getDocumentsVerified() {
        return documentsVerified;
    }

    public void setDocumentsVerified(boolean documentsVerified) {
        this.documentsVerified = documentsVerified;
    }

    public String getVerificationStatus() {
        return documentsVerified ? "Verified" : "Not Verified";
    }
}