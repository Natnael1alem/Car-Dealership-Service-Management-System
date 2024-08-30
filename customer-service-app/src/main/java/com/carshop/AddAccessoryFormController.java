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

public class AddAccessoryFormController {
    @FXML
    private ComboBox<String> accessoryComboBox;

    private ArrayList<AccessoryType> accessorytypeList = new ArrayList<AccessoryType>();
    private Map<String, Integer> accessoryMap;

    private MainController mainController;

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    @FXML
    public void initialize() {
        loadAccessoriesFromDatabase();
        initializeAccessoriesCombo();
    }

    private void loadAccessoriesFromDatabase() {
        accessorytypeList.clear();
        accessorytypeList.addAll(DatabaseManager.getAllAccessoriesType());
    }

    private void initializeAccessoriesCombo() {
        accessoryMap = new HashMap<>();

        for (AccessoryType accessory : accessorytypeList) {
            accessoryMap.put(accessory.getName(), accessory.getId());
        }
        
        accessoryComboBox.setItems(FXCollections.observableArrayList(accessoryMap.keySet()));
    }
    

    @FXML
    private void handleNewButton()  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-accessory.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Accessory");
        stage.setScene(scene);

        NewAccessoryController controller = fxmlLoader.getController();
        controller.setMainController(this);
        
        stage.showAndWait();
    }

    public void newAccessory(String name, String description) {
        DatabaseManager.addNewAccessory(name, description);
        loadAccessoriesFromDatabase();
        initializeAccessoriesCombo();
    }


    @FXML
    private void handleSaveButton() {
        String selectedAccessory = accessoryComboBox.getSelectionModel().getSelectedItem();
        Integer modelID = accessoryMap.get(selectedAccessory);

        mainController.addAccessory(modelID);

        closeStage();
    }

    @FXML
    private void handleCancelButton() {
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) accessoryComboBox.getScene().getWindow();
        stage.close();
    }
}