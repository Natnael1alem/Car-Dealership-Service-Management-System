package com.carshop;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuCarCardController {
    @FXML
    private Label name;

    @FXML
    private ImageView carImage;

    private MenuCar menuCar;
    private MainController mainController;

    public void setCar(MenuCar menuCar) {
        this.menuCar = menuCar;
        updateCardView();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void updateCardView() {
        name.setText(menuCar.getMake() + " " + menuCar.getModel());
        carImage.setImage(menuCar.getImg());

        // You can set an image here if you have one
        // carImage.setImage(new Image("path/to/image.jpg"));
    }

    @FXML
    private void handleCardClick() {
        mainController.showMenuCarDetails(menuCar);
    }
}