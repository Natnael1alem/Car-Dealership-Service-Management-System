package com.carshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddCarFormController {
    @FXML
    private ComboBox<String> modelComboBox;

    private ArrayList<Model> modelList = new ArrayList<Model>();
    private Map<String, Integer> modelMap;

    @FXML
    private ComboBox<String> colorComboBox;

    private ArrayList<Color> colorList = new ArrayList<Color>();
    private Map<String, Integer> colorMap;

    @FXML
    private ComboBox<String> engineComboBox;

    private ArrayList<Engine> engineList = new ArrayList<Engine>();
    private Map<String, Integer> engineMap;

    @FXML
    private ComboBox<String> transmissionComboBox;

    private ArrayList<Transmission> transmissionList = new ArrayList<Transmission>();
    private Map<String, Integer> transmissionMap;

    private MainController mainController;


    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    @FXML
    public void initialize() {
        loadModelsFromDatabase();
        initializeModelsCombo();
        loadColorsFromDatabase();
        initializeColorsCombo();
        loadEnginesFromDatabase();
        initializeEnginesCombo();
        loadTransmissionsFromDatabase();
        initializeTransmissionsCombo();
    }

    private void loadModelsFromDatabase() {
        modelList.clear();
        modelList.addAll(DatabaseManager.getAllModels());
    }

    private void initializeModelsCombo() {
        modelMap = new HashMap<>();

        for (Model model : modelList) {
            modelMap.put(model.getName(), model.getId());
        }
        
        modelComboBox.setItems(FXCollections.observableArrayList(modelMap.keySet()));
    }

    private void loadColorsFromDatabase() {
        colorList.clear();
        colorList.addAll(DatabaseManager.getAllColors());
    }

    private void initializeColorsCombo() {
        colorMap = new HashMap<>();

        for (Color color : colorList) {
            colorMap.put(color.getName(), color.getId());
        }
        
        colorComboBox.setItems(FXCollections.observableArrayList(colorMap.keySet()));
    }

    private void loadEnginesFromDatabase() {
        engineList.clear();
        engineList.addAll(DatabaseManager.getAllEngines());
    }

    private void initializeEnginesCombo() {
        engineMap = new HashMap<>();

        for (Engine engine : engineList) {
            engineMap.put(engine.getName(), engine.getId());
        }
        
        engineComboBox.setItems(FXCollections.observableArrayList(engineMap.keySet()));
    }

    private void loadTransmissionsFromDatabase() {
        transmissionList.clear();
        transmissionList.addAll(DatabaseManager.getAllTransmissions());
    }

    private void initializeTransmissionsCombo() {
        transmissionMap = new HashMap<>();

        for (Transmission transmission : transmissionList) {
            transmissionMap.put(transmission.getName(), transmission.getId());
        }
        
        transmissionComboBox.setItems(FXCollections.observableArrayList(transmissionMap.keySet()));
    }




    @FXML
    private void handleNewModelButton()  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-model.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Model");
        stage.setScene(scene);

        NewModelController controller = fxmlLoader.getController();
        controller.setMainController(this);
        
        stage.showAndWait();
    }

    @FXML
    private void handleNewColorButton()  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-color.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Color");
        stage.setScene(scene);

        NewColorController controller = fxmlLoader.getController();
        controller.setMainController(this);
        
        stage.showAndWait();
    }

    @FXML
    private void handleNewEngineButton()  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-engine.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Engine");
        stage.setScene(scene);

        NewEngineController controller = fxmlLoader.getController();
        controller.setMainController(this);
        
        stage.showAndWait();
    }

    @FXML
    private void handleNewTransmissionButton()  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new-transmission.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Transmission");
        stage.setScene(scene);

        NewTransmissionController controller = fxmlLoader.getController();
        controller.setMainController(this);
        
        stage.showAndWait();
    }






    public void newModel(String name) {
        DatabaseManager.addNewModel(name);
        loadModelsFromDatabase();
        initializeModelsCombo();
    }

    public void newColor(String name) {
        DatabaseManager.addNewColor(name);
        loadColorsFromDatabase();
        initializeColorsCombo();
    }

    public void newEngine(String name) {
        DatabaseManager.addNewEngine(name);
        loadEnginesFromDatabase();
        initializeEnginesCombo();
    }

    public void newTransmission(String name) {
        DatabaseManager.addNewTransmission(name);
        loadTransmissionsFromDatabase();
        initializeTransmissionsCombo();
    }






    @FXML
    private void handleSaveButton() {
        String selectedModel = modelComboBox.getSelectionModel().getSelectedItem();
        Integer modelID = modelMap.get(selectedModel);

        String selectedColor = colorComboBox.getSelectionModel().getSelectedItem();
        Integer colorID = colorMap.get(selectedColor);

        String selectedEngine = engineComboBox.getSelectionModel().getSelectedItem();
        Integer engineID = engineMap.get(selectedEngine);

        String selectedTransmission = transmissionComboBox.getSelectionModel().getSelectedItem();
        Integer transmissionID = transmissionMap.get(selectedTransmission);

        
        mainController.addCar(modelID, colorID, engineID, transmissionID);

        closeStage();
    }

    @FXML
    private void handleCancelButton() {
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) modelComboBox.getScene().getWindow();
        stage.close();
    }
}