package com.carshop;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class OwnedCarCardController {
    @FXML
    private Label name;

    @FXML
    private ImageView carImage;

    private OwnedCar ownedCar;
    private MainController mainController;

    public void setCar(OwnedCar ownedCar) {
        this.ownedCar = ownedCar;
        updateCardView();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void updateCardView() {
        name.setText(ownedCar.getMake() + " " + ownedCar.getModel());
        carImage.setImage(ownedCar.getImg());

        // You can set an image here if you have one
        // carImage.setImage(new Image("path/to/image.jpg"));
    }

    @FXML
    private void handleCardClick() {
        mainController.showOwnedCarDetails(ownedCar);
    }
}