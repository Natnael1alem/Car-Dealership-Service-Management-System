package com.carshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    // @FXML
    // private TableView<Car> carTableView;
    // @FXML
    // private TableColumn<Car, String> modelColumn;
    // @FXML
    // private TableColumn<Car, String> colorColumn;
    // @FXML
    // private TableColumn<Car, String> engineColumn;
    // @FXML
    // private TableColumn<Car, String> transmissionColumn;

    // @FXML
    // private TableView<Accessory> accessoryTableView;
    // @FXML
    // private TableColumn<Accessory, String> accessoryNameColumn;
    // @FXML
    // private TableColumn<Accessory, String> accessoryDescriptionColumn;
    // @FXML
    // private TableColumn<Accessory, Double> accessoryPriceColumn;

    @FXML
    private FlowPane carContainer;

    // @FXML
    // private TilePane carContainer;

    private ObservableList<Car> carList = FXCollections.observableArrayList();
    private ObservableList<Accessory> accessoryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // initializeCarTable();
        // initializeAccessoryTable();
        loadCarsFromDatabase();
        loadAccessoriesFromDatabase();
    }

    private void initializeCarTable() {
        // modelColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
        // colorColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));
        // engineColumn.setCellValueFactory(new PropertyValueFactory<>("Engine"));
        // transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("Transmission"));
        // carTableView.setItems(carList);
        carContainer.getChildren().clear();
        for (Car car : carList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("car-card.fxml"));
                Parent carCard = loader.load();
                CarController controller = loader.getController();
                controller.setCar(car);
                controller.setMainController(this);
                carContainer.getChildren().add(carCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeAccessoryTable() {
        // accessoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        // accessoryDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        // accessoryPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        // accessoryTableView.setItems(accessoryList);
    }

    private void loadCarsFromDatabase() {
        carList.clear();
        carList.addAll(DatabaseManager.getAllCars());
        initializeCarTable();
    }

    private void loadAccessoriesFromDatabase() {
        accessoryList.clear();
        accessoryList.addAll(DatabaseManager.getAllAccessories());
    }

    @FXML
    private void handleAddCarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-car-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 350);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add New Car");
        stage.setScene(scene);

        AddCarFormController controller = fxmlLoader.getController();
        controller.setMainController(this);
        
        stage.showAndWait();
    }

    @FXML
    private void handleAddAccessoryButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-accessory-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 350);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add New Accessory");
        stage.setScene(scene);

        AddAccessoryFormController controller = fxmlLoader.getController();
        controller.setMainController(this);

        stage.showAndWait();
    }

    public void addCar(int modelID, int colorID, int engineID, int transmissionID) {
        DatabaseManager.addCar(modelID, colorID, engineID, transmissionID);
        loadCarsFromDatabase();
    }

    public void addAccessory(int accessoryID) {
        DatabaseManager.addAccessory(accessoryID);
        loadAccessoriesFromDatabase();
    }
}