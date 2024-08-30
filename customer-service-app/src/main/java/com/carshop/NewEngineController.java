package com.carshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewEngineController {
    @FXML
    private TextField nameField;

    private AddCarFormController mainController;

    public void setMainController(AddCarFormController controller) {
        this.mainController = controller;
    }
    
    @FXML
    private void handleOkButton() {
        String name = nameField.getText();

        mainController.newEngine(name);

        closeStage();
    }

    @FXML
    private void handleCancelButton() {
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}