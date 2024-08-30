package com.carshop;

public class Accessory {
    private int id;
    private String name;
    private String description;
    private double price;

    public Accessory(String name, String description) {
        this.name = name;
        this.description = description;
        this.price = 50;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}