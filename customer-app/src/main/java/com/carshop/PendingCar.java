package com.carshop;

public class PendingCar {
    private int car_type_id;
    private int ownership_id;
    private String model;
    private String make;
    private String color;
    private String engine;
    private String transmission;
    private String Description;
    private Double price;

    public PendingCar(int car_type_id, int ownership_id, String model, String make, String color, String engine, String transmission, Double price) {
        this.car_type_id = car_type_id;
        this.ownership_id = ownership_id;
        this.model = model;
        this.make = make;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.price = price;
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

    public String getDescription() {
        return Description;
    }

    public Double getPrice () {
        return price;
    }
}
