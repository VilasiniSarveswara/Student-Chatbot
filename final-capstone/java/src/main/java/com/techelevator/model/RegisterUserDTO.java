package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class RegisterUserDTO {


    private String username;

    private String password;

    private String confirmPassword;

    private String role;
    private String firstName;
    private String lastName;
    private String emailId;
    private long contactNumber;
    private boolean isStudent;


    public RegisterUserDTO(String firstName, String lastName, String emailId, long contactNumber, boolean isStudent){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.isStudent = isStudent;

    }

//    public RegisterUserDTO(String username, String password, String confirmPassword, String role, String firstName, String lastName, String emailId, long contactNumber, boolean isStudent) {
//        this.username = username;
//        this.password = password;
//        this.confirmPassword = confirmPassword;
//        this.role = role;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.emailId = emailId;
//        this.contactNumber = contactNumber;
//        this.isStudent = isStudent;
//    }

    public RegisterUserDTO(){};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    /*    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/
}
