package com.carshop;

public class Car {
    private int id;
    private String model;
    private String color;
    private String engine;
    private String transmission;

    public Car(String model, String color, String engine, String transmission) {
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
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
}
