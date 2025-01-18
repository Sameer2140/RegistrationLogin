package org.example.registerlogin.Request;

public class LoginRequest {
    private String emailid;
    private String password;

//    constructors


    public LoginRequest(String emailid, String password) {
        this.emailid = emailid;
        this.password = password;
    }

    //  Default constructor
    public LoginRequest() {
    }

    //    getters and setters

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
