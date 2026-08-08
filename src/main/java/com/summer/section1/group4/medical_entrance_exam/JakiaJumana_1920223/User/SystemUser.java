package com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User;

import java.io.Serializable;

public abstract class SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String name;
    private String email;

    public SystemUser() {
    }

    public SystemUser(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
