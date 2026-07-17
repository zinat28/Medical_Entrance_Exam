package com.summer.section1.group4.medical_entrance_exam.zinat;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    public static final List<Login> loginArrayList= new ArrayList<>();

    static {
        loginArrayList.add(new Login("zinat", "12345", "Applicant"));
        loginArrayList.add(new Login("z", "1", "Question Moderator"));
    }

    public static List<Login> getLoginArrayList(){
        return loginArrayList;

    }
}
