package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

public class CandidateDAOTest {

    public static void main(String[] args) {


        Candidate candidate = new Candidate(
                0,
                "Rahim Ahmed",
                "rahim@gmail.com",
                "01700000000",
                "Pending"
        );


        CandidateDAO dao = new CandidateDAO();


        dao.addCandidate(candidate);


        System.out.println("Candidate test completed");

    }
}