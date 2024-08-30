package com.carshop;

public class User {
    String userName;
    String password;
    String email;
    int user_id;

    public User (String userName, String email, int user_id) {
        this.userName = userName;
        this.email = email;
        this.user_id = user_id;
    }

    public void setID() {
        
    }

    public String getUserName (){
        return this.userName;
    }

    public int getUserID (){
        return this.user_id;
    }
}
