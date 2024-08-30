package com.carshop;

public class SelectedCar {
    private int car_type_id;
    private int item_id;
    private String model;
    private String make;
    private String color;
    private String engine;
    private String transmission;
    private String modelDescription;
    private Double price;

    public SelectedCar(int car_type_id, int item_id, String model, String make, String color, String engine, String transmission, Double price, String modelDescription) {
        this.car_type_id = car_type_id;
        this.item_id = item_id;
        this.model = model;
        this.make = make;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.price = price;
        this.modelDescription = modelDescription;
    }

    public SelectedCar () {}

    public int getId() {
        return car_type_id;
    }

    public int getItemID() {
        return item_id;
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

    public String getDescription() {
        return modelDescription;
    }

    public Double getPrice () {
        return price;
    }

}
