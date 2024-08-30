package com.carshop;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BuyCarController {
    @FXML
    private Label title;
    @FXML
    private Label carName;
    @FXML
    private Label color;
    @FXML
    private Label engine;
    @FXML
    private Label transmission;
    @FXML
    private Label price;
    @FXML
    private Label userid;

    private SelectedCar selectedCar;
    User user = App.getCurrentUser();

    public void setCar(SelectedCar selectedCarar) {
        this.selectedCar = selectedCarar;
        showDetail();
    }

    public void showDetail() {
        carName.setText(selectedCar.getMake() + " " + selectedCar.getModel());
        color.setText(selectedCar.getColor());
        engine.setText(selectedCar.getEngine());
        transmission.setText(selectedCar.getTransmission());
        price.setText(Double.toString(selectedCar.getPrice()));
        userid.setText(Integer.toString(user.getUserID()));
    }

    @FXML
    private void handleConfirm() {
        DatabaseManager.buyCar(user, this.selectedCar);

        closeStage();
    }

    @FXML
    private void handleCancelButton() {
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) title.getScene().getWindow();
        stage.close();
    }
}