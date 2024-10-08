package com.carshop;

public class User {
    String FName;
    String LName;
    String password;
    String email;
    String username;

    public User (String username, String FName, String LName, String email, String password) {
        this.FName = FName;
        this.LName = LName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void setID() {
        
    }

    public String getFName (){
        return this.FName;
    }

    public String getLName() {
        return this.LName;
    }

    public String getUsername (){
        return this.username;
    }

    public String getUserPass () { 
        return this.password;
    }
}
