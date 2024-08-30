package com.carshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DatabaseManager.initializeDatabase();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("text.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Car Company Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

