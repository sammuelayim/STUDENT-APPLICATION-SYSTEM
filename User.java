package com.example.studentapplicationsystem;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private Integer registrationId;
    private String address;
    private String DOB;
    private String program;
    private Timestamp dateOfSubmission;
    private String phoneNumber;
    private String email;
    private String name;
    private int loginId;

    public User() {
    }

    public User(String address, String DOB, String program, Timestamp dateOfSubmission, String phoneNumber, String email, String name, int loginId) {
        this.address = address;
        this.DOB = DOB;
        this.program = program;
        this.dateOfSubmission = dateOfSubmission;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.loginId = loginId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Timestamp getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Timestamp dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }
}
