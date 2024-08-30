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

public class PendingCarDetailController {
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

    private PendingCar pendingCar;
    private MainController mainController;

    public void setCar(PendingCar pendingCar) {
        this.pendingCar = pendingCar;
        showDetails();
    }

    public PendingCar getSelectedCar(){
        return pendingCar;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    public void showDetails() {
        title.setText(pendingCar.getMake() + " " + pendingCar.getModel());
        model.setText(pendingCar.getModel());
        color.setText(pendingCar.getColor());
        engine.setText(pendingCar.getEngine());
        transmission.setText(pendingCar.getTransmission());
        price.setText(Double.toString(pendingCar.getPrice()));
    }

    @FXML
    private void handlePay() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("make-payment-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 350);

        MakePaymentController controller = fxmlLoader.getController();
        controller.setCar(this.pendingCar);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Confirm Payment");
        stage.setScene(scene);        
        stage.showAndWait();
    }

    @FXML
    public void handleBack() {
        mainController.showMainView();
    }
}