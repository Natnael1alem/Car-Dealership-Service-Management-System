package com.carshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Scene mainScene;
    private static Stage mainStage;
    private static User currentUser;

    @Override
    public void start(Stage stage) throws IOException {
        DatabaseManager.initializeDatabase();
        this.mainStage = stage;
        mainScene = new Scene(new Pane(), 800, 600);
        mainStage.setScene(mainScene);

        showLoginView();
        
        mainStage.show();
    }



    static void setDetail(String title, Parent root) throws IOException {
        mainScene.setRoot(root);
        mainStage.setTitle(title);
    }

    static void showMainView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Parent root = fxmlLoader.load();
        App.setDetail("Car Company Management", root);
    }

    static void showLoginView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("log-in.fxml"));
        Parent root = fxmlLoader.load();
        App.setDetail("Log-in", root);
    }



    public static void main(String[] args) {
        launch();
    }



    static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}

