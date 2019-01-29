package com.ryan.model;

public class User {

    private String emailAddress;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private boolean isFemale;

    public User() {
    }

    public User(String emailAddress, String password, String fullName, String dateOfBirth, boolean isFemale) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.isFemale = isFemale;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setGender(boolean female) {
        isFemale = female;
    }
}
