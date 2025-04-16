package com.carshop;
import java.sql.Blob;
import java.sql.SQLException;
import java.io.InputStream;

import javafx.scene.image.Image;

public class MenuCar {
    private String model;
    private int modelID;
    private String make;
    private String color;
    private String modelDescription;
    private Image img;
    private InputStream is;

    

    public MenuCar(String model, int modelID, String make, String modelDescription, Blob blob) {
        this.model = model;
        this.make = make;
        // this.color = color;
        this.modelID = modelID;
        this.modelDescription = modelDescription;

        try {
            if (blob != null) {
                this.is = blob.getBinaryStream();
                this.img = new Image(this.is);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // or show an alert to the user
        }
    }

    public String getModel() {
        return model;
    }

    public String getMake(){
        return make;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return modelDescription;
    }

    public int getModelID() {
        return modelID;
    }

    public Image getImg() {
        return img;
    }
}
