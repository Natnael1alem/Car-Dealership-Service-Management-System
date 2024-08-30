package com.carshop;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PendingCarCardController {
    @FXML
    private Label name;

    @FXML
    private ImageView carImage;

    private PendingCar pendingCar;
    private MainController mainController;

    public void setCar(PendingCar pendingCar) {
        this.pendingCar = pendingCar;
        updateCardView();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void updateCardView() {
        name.setText(pendingCar.getMake() + " " + pendingCar.getModel());

        // You can set an image here if you have one
        // carImage.setImage(new Image("path/to/image.jpg"));
    }

    @FXML
    private void handleCardClick() {
        mainController.showPendingCarDetails(pendingCar);
    }
}