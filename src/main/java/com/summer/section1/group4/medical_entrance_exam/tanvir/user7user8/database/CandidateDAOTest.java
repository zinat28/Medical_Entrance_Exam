package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

public class CandidateDAOTest {

    public static void main(String[] args) {

        Candidate candidate = new Candidate(
                0,
                "Rahim Ahmed",
                "MED-1001",
                5.00,
                "Pending"
        );

        CandidateDAO candidateDAO =
                new CandidateDAO();

        boolean saved =
                candidateDAO.addCandidate(candidate);

        if (saved) {
            System.out.println(
                    "Candidate test completed successfully."
            );
        } else {
            System.out.println(
                    "Candidate test failed."
            );
        }
    }
}