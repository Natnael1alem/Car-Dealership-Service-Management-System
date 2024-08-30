package com.carshop;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuCarDetailController {
    @FXML
    private Label title;
    @FXML
    private FlowPane ColorFlow;
    @FXML
    private FlowPane EngineFlow;
    @FXML
    private FlowPane TransmissionFlow;

    @FXML
    private Label resultLabel;
    // @FXML 
    // private Label price;
    // @FXML 
    // private Label quantity;

    @FXML
    private ImageView carImage;

    @FXML
    private TableView<FilterCar> carTable;
    @FXML
    private TableColumn<FilterCar, String> colorColumn;
    @FXML
    private TableColumn<FilterCar, String> engineColumn;
    @FXML
    private TableColumn<FilterCar, String> transColumn;
    @FXML
    private TableColumn<FilterCar, Integer> qtyColumn;

    ArrayList<CheckBox> colorList = new ArrayList<>();
    ArrayList<CheckBox> engineList = new ArrayList<>();
    ArrayList<CheckBox> transmissionList = new ArrayList<>();

    private ObservableList<FilterCar> filCarList = FXCollections.observableArrayList();

    private MenuCar menuCar;                                //just to know the model and make of the car, just based on info on the car menu card
    private SelectedCar selectedCar;                        //the car of choice
    private MainController mainController;
    

    public void setCar(MenuCar menuCar) {
        this.menuCar = menuCar;
        showDetails();
    }

    public MenuCar getSelectedCar(){
        return menuCar;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    public void showDetails() {
        title.setText(menuCar.getMake() + " " + menuCar.getModel());
        
        for(int i = 1; i <= 10; i++) {
            CheckBox check = new CheckBox("col" + i);
            check.setUserData(i);
            check.setSelected(true);
            colorList.add(check);
        }    
        ColorFlow.getChildren().addAll(colorList);

        for(int i = 1; i <= 4; i++) {
            CheckBox check = new CheckBox("eng" + i);
            check.setUserData(i);
            check.setSelected(true);
            engineList.add(check);
        }  
        EngineFlow.getChildren().addAll(engineList);
          
        for(int i = 1; i <= 3; i++) {
            CheckBox check = new CheckBox("trans" + i);
            check.setUserData(i);
            check.setSelected(true);
            transmissionList.add(check);
        } 
        TransmissionFlow.getChildren().addAll(transmissionList);

        //give user options and let them Filter and finally choose a car(assign choiceCar) 
    }

    @FXML
    private void handleBuy() throws IOException {
        //Set the selected Car
        FilterCar _selCar = carTable.getSelectionModel().getSelectedItem();
        
        if (_selCar != null) {
            selectedCar = DatabaseManager.getSelectedCar(_selCar.getId());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buy-car-form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 450, 350);
            
            BuyCarController controller = fxmlLoader.getController();
            controller.setCar(this.selectedCar);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Confirm Purchase");
            stage.setScene(scene);        
            stage.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Car Selected");
            alert.setContentText("Please select a car from the table before trying to buy.");
            alert.showAndWait();
            return;
        }

    }

    @FXML
    public void handleBack() {
        mainController.showMainView();
    }

    @FXML
    public void handleApply() {
        ArrayList<Integer> selCols = new ArrayList<>();
        ArrayList<Integer> selEngs = new ArrayList<>();
        ArrayList<Integer> selTrans = new ArrayList<>();

        for (CheckBox check : colorList) {
            if (check.isSelected()) {
                selCols.add((Integer) check.getUserData());
            }
        }
        
        for (CheckBox check : engineList) {
            if (check.isSelected()) {
                selEngs.add((Integer) check.getUserData());
            }
        }
        
        for (CheckBox check : transmissionList) {
            if (check.isSelected()) {
                selTrans.add((Integer) check.getUserData());
            }
        }

        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        engineColumn.setCellValueFactory(new PropertyValueFactory<>("engine"));
        transColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));

        filCarList.clear();
        filCarList.addAll(DatabaseManager.getFilteredCars(menuCar.getModelID(), selCols, selEngs, selTrans));
        carTable.setItems(filCarList);

        // resultLabel.setText(selCols + ", " + selEngs + ", " + selTrans);
    }
}