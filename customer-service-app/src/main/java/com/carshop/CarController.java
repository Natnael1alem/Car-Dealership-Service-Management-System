package com.carshop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CarController {
    @FXML
    private Label model;
    @FXML
    private Label color;
    @FXML
    private Label engine;
    @FXML
    private Label transmission;
    @FXML
    private ImageView carImage;
    @FXML
    private Label typeLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private Label descriptionLabel;

    private Car car;
    private Stage stage;
    private MainController mainController;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCar(Car car) {
        this.car = car;
        updateCardView();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void updateCardView() {
        model.setText(car.getModel());
        color.setText(car.getColor());
        engine.setText(car.getEngine());
        transmission.setText(car.getTransmission());

        // You can set an image here if you have one
        // carImage.setImage(new Image("path/to/image.jpg"));
    }

    @FXML
    private void handleCardClick() {
        // mainController.showCarDetails(car);
    }

    public void showDetails() {
        // makeModelLabel.setText(car.getMake() + " " + car.getModel());
        // yearLabel.setText(String.valueOf(car.getYear()));
        // priceLabel.setText("$" + car.getPrice());
        // typeLabel.setText(car.getType());
        // colorLabel.setText(car.getColor());
        // descriptionLabel.setText(car.getDescription());
    }

    @FXML
    public void handleBack() throws IOException {
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        // Parent root = loader.load();

        // MainController controller = loader.getController();
        // controller.setStage(stage);

        // Main.setRoot(root);
        // stage.setTitle("Car Catalog");
    }
}