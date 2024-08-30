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

public class MakePaymentController {
    private PendingCar pendingCar;

    public void setCar(PendingCar pendingCar) {
        this.pendingCar = pendingCar;
    }

    @FXML
    private Label title;

    @FXML
    private void handleConfirm() {
        User user = App.getCurrentUser();

        DatabaseManager.payCar(user, this.pendingCar);
        
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