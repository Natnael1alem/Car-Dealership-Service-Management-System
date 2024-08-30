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
    public void handleLogin() throws IOException{
        String content = userIDField.getText();
        
        try {
            int enteredUserID = Integer.parseInt(content);
            for (User user : userList) {
                if (enteredUserID == user.getUserID()) {
                    App.setCurrentUser(user);
                    App.showMainView();
                    return;
                }
            }  
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } 
        System.out.println("No user ID was found");        
    }
   
}
