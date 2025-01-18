package org.example.registerlogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//whenever the compiler look an Entity class it will create a table in the database

@Entity
public class User {
    //    variables


    @Id
    private String emailid;
    private String username;
    private String password;

//    constructor(parameterized)

    public User(String emailid, String username, String password) {
        this.emailid = emailid;
        this.username = username;
        this.password = password;
    }

//    default constructor

    public User() {
    }
//    getter and setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


//    To string method


    @Override
    public String toString() {
        return "User{" +
                "emailid='" + emailid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
