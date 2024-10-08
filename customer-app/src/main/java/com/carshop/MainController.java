package com.carshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private FlowPane carContainer;
    @FXML
    private FlowPane carOwnedContainer;
    @FXML
    private FlowPane carPendingContainer;
    @FXML
    private Label username;

    private ObservableList<MenuCar> menuCarList = FXCollections.observableArrayList();
    private ObservableList<OwnedCar> ownedCarList = FXCollections.observableArrayList();
    private ObservableList<PendingCar> pendingCarList = FXCollections.observableArrayList();
    // private ObservableList<Accessory> accessoryList = FXCollections.observableArrayList();
    

    @FXML
    public void initialize() {
        username.setText(App.getCurrentUser().getFName());
        loadMenuCarsFromDatabase();
        loadOwnedCarsFromDatabase();
        loadPendingCarsFromDatabase();
        //loadAccessoriesFromDatabase();
    }


    
    private void loadMenuCarsFromDatabase() {
        menuCarList.clear();
        menuCarList.addAll(DatabaseManager.getMenuCars());
        initializeMenuCarCards();
    }

    private void loadOwnedCarsFromDatabase() {
        ownedCarList.clear();
        ownedCarList.addAll(DatabaseManager.getOwnedCars(App.getCurrentUser()));
        initializeOwnedCarCards();
    }

    private void loadPendingCarsFromDatabase() {
        pendingCarList.clear();
        pendingCarList.addAll(DatabaseManager.getPendingCars(App.getCurrentUser()));
        initializeCarPendingCards();
    }



    private void initializeMenuCarCards() {
        carContainer.getChildren().clear();
        for (MenuCar car : menuCarList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-car-card.fxml"));
                Parent carCard = loader.load();
                MenuCarCardController controller = loader.getController();
                controller.setCar(car);
                controller.setMainController(this);
                carContainer.getChildren().add(carCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeOwnedCarCards() {
        carOwnedContainer.getChildren().clear();
        for (OwnedCar car : ownedCarList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("owned-car-card.fxml"));
                Parent carCard = loader.load();
                OwnedCarCardController controller = loader.getController();
                controller.setCar(car);
                controller.setMainController(this);
                carOwnedContainer.getChildren().add(carCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeCarPendingCards() {
        carPendingContainer.getChildren().clear();
        for (PendingCar car : pendingCarList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pending-car-card.fxml"));
                Parent carCard = loader.load();
                PendingCarCardController controller = loader.getController();
                controller.setCar(car);
                controller.setMainController(this);
                carPendingContainer.getChildren().add(carCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void showMenuCarDetails(MenuCar menuCar)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-car-detail.fxml"));
            Parent root = loader.load();
            MenuCarDetailController controller = loader.getController();
            controller.setCar(menuCar);
            controller.setMainController(this);

            App.setDetail(menuCar.getModel(), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOwnedCarDetails(OwnedCar ownedCar)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("owned-car-detail.fxml"));
            Parent root = loader.load();
            OwnedCarDetailController ownedController = loader.getController();
            ownedController.setCar(ownedCar);
            ownedController.setMainController(this);

            App.setDetail(ownedCar.getModel(), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPendingCarDetails(PendingCar ownedCar)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pending-car-detail.fxml"));
            Parent root = loader.load();
            PendingCarDetailController pendingController = loader.getController();
            pendingController.setCar(ownedCar);
            pendingController.setMainController(this);

            App.setDetail(ownedCar.getModel(), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void showMainView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            App.setDetail("Car Company Management", loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }

    /*//Add car and add accessory
    private void loadAccessoriesFromDatabase() {
        accessoryList.clear();
        accessoryList.addAll(DatabaseManager.getAllAccessories());
        initializeAccessoryCards();
    }
    
    private void initializeAccessoryCards() {

    }*/
    
}