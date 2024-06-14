package net.javaguides.LEAVEMANAGEMENTSYSTEM.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String contactNumber;
    private String emailAddress;

    public User() {
    }

    public User(String username, String password, String contactNumber, String emailAddress) {
        this.username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}


