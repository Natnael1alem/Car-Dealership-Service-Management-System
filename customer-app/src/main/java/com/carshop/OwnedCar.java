package com.carshop;

import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Blob;
import javafx.scene.image.Image;

public class OwnedCar {
    private int car_type_id;
    private int ownership_id;
    private String model;
    private String make;
    private String color;
    private String engine;
    private String transmission;
    private String modelDescription;
    private String specDescription;
    private Image img;
    private InputStream is;
    
    // private Double price;

    public OwnedCar(int car_type_id, int ownership_id, String model, String make, String color, String engine, String transmission, String modelDescription, Blob blob) {
        this.car_type_id = car_type_id;
        this.ownership_id = ownership_id;
        this.model = model;
        this.make = make;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
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

    public int getId() {
        return car_type_id;
    }

    public int getItemID() {
        return ownership_id;
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

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public String getSpecDescription() {
        return specDescription;
    }

    public Image getImg() {
        return img;
    }

    // public Double getPrice () {
    //     return price;
    // }
}
