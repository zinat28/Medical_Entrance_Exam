package com.summer.section1.group4.medical_entrance_exam;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    public static final List<Login> loginArrayList= new ArrayList<>();

    static {
        loginArrayList.add(new Login("zinat", "12345", "Applicant"));
        loginArrayList.add(new Login("zinat", "12345", "Question Moderator"));
        loginArrayList.add(new Login("tanvir", "12345", "Medical Officer"));
        loginArrayList.add(new Login("tanvir", "12345", "Director"));
        loginArrayList.add(new Login("jakia", "12345", "Administrator"));
        loginArrayList.add(new Login("jakia", "12345", "Center Coordinator"));
        loginArrayList.add(new Login("jubayer", "12345", "Finance Officer"));
        loginArrayList.add(new Login("jubayer", "12345", "Invigilator"));
    }

    public static List<Login> getLoginArrayList(){
        return loginArrayList;

    }
}
