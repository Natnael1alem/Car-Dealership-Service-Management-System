package com.carshop;

public class MenuCar {
    private String model;
    private int modelID;
    private String make;
    private String color;
    private String modelDescription;

    public MenuCar(String model, int modelID, String make, String modelDescription) {
        this.model = model;
        this.make = make;
        // this.color = color;
        this.modelID = modelID;
        this.modelDescription = modelDescription;
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
}
