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

public class UserAuthController {
    private ObservableList<User> userList = FXCollections.observableArrayList();

    private void loadUsersFromDatabase() {
        userList.clear();
        userList.addAll(DatabaseManager.getAllUsers());
    }

    @FXML
    public void initialize() {
        loadUsersFromDatabase();
        System.out.println(userList);
    }

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label l_message;

    @FXML
    private TextField newUsernameField;
    @FXML
    private TextField newFNameField;
    @FXML
    private TextField newLNameField;
    @FXML
    private TextField newEmailField;
    @FXML
    private TextField newPassField;
    @FXML
    private TextField confirmNewPassField;
    @FXML
    private Label s_message;

    @FXML
    public void handleLogin() throws IOException{
        String userField = usernameField.getText();
        String passField = passwordField.getText();

        System.out.println("entered: " + userField + " " + passField);

        for (User user : userList) {
            if (userField.equals(user.getUsername())) {
                System.out.println("retrieved: " + user.getUsername() + " " + user.getUserPass());
                if (passField.equals(user.getUserPass())){
                    System.out.println("Successfully Authenticated");
                    App.setCurrentUser(user);
                    App.showMainView();
                    return;
                }
            }
        }
        
        l_message.setText("Incorrect user id or password");
        System.out.println("Incorrect user id or password");        
    }

    @FXML
    public void handleSignup() throws IOException{
        String usernameField = newUsernameField.getText();
        String fNameField = newFNameField.getText();
        String lNameField = newLNameField.getText();
        String emailField = newEmailField.getText();
        String passField = newPassField.getText();
        String confirmPassField = confirmNewPassField.getText();

        System.out.println("entered: " + usernameField + " " + fNameField + " " + lNameField + " " + passField + " " + confirmPassField);

        DatabaseManager.addUser(usernameField, fNameField, lNameField, emailField, passField);
        
        // s_message.setText("Form not complete or filled incorrectly");
        // System.out.println("Form not complete or filled incorrectly");     
    }

    @FXML
    public void handleGoSignup() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("sign-up.fxml"));
        Parent root = fxmlLoader.load();
        App.setDetail("Sign-up", root);
    }

    @FXML
    public void handleGoLogin() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("log-in.fxml"));
        Parent root = fxmlLoader.load();
        App.setDetail("Log-in", root);
    }
   
}
