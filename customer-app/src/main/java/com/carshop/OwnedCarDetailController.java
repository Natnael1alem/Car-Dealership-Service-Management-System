package com.carshop;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OwnedCarDetailController {
    @FXML
    private Label title;
    @FXML
    private Label model;
    @FXML
    private Label color;
    @FXML
    private Label engine;
    @FXML
    private Label transmission;
    @FXML 
    private Label price;
    @FXML
    private ImageView carImage;

    private OwnedCar ownedCar;
    private MainController mainController;

    public void setCar(OwnedCar ownedCar) {
        this.ownedCar = ownedCar;
        showDetails();
    }

    public OwnedCar getSelectedCar(){
        return ownedCar;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    public void showDetails() {
        title.setText(ownedCar.getMake() + " " + ownedCar.getModel());
        model.setText(ownedCar.getModel());
        color.setText(ownedCar.getColor());
        engine.setText(ownedCar.getEngine());
        transmission.setText(ownedCar.getTransmission());
        // price.setText(Double.toString(ownedCar.getPrice()));
    }

    @FXML
    private void handleServices() throws IOException {
        // Get some service
        System.out.println("You are accessing your sevices");
    }

    @FXML
    public void handleBack() {
        mainController.showMainView();
    }
}