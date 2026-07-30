package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model;

public class User {

    private int id;
    private String username;
    private String password;
    private String role;


    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getRole() {
        return role;
    }
}
