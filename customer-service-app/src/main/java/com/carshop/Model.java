package com.carshop;

public class Model {
    private int id;
    private String name;

    public Model(int id, String name) {
        this.name = name;
        this.id = id;
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
}