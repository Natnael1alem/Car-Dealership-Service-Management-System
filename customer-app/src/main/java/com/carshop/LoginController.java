package com.carshop;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private ObservableList<User> userList = FXCollections.observableArrayList();

    private void loadUsersFromDatabase() {
        userList.clear();
        userList.addAll(DatabaseManager.getAllUsers());
    }

    @FXML
    public void initialize() {
        loadUsersFromDatabase();
    }

    @FXML
    private Label title;

    @FXML
    private TextField userIDField;

    @FXML
    private TextField passwordField;

    @FXML
    public void handleLogin() throws IOException{
        String userField = userIDField.getText();
        String passField = passwordField.getText();

        System.out.println(userField + " " + passField);
        
        try {
            int enteredUserID = Integer.parseInt(userField);
            for (User user : userList) {
                System.out.println(user.getUserID() + " " + user.getUserPass());
                if (enteredUserID == user.getUserID()) {
                    if (passField.equals(user.getUserPass())){
                        System.out.println("Successfully Authenticated");
                        App.setCurrentUser(user);
                        App.showMainView();
                        return;
                    }
                }
            }  
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } 
        System.out.println("Incorrect user id or password");        
    }
   
}
