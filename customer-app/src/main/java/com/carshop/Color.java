package com.carshop;

public class Color {
    private int id;
    private String name;

    public Color(int id, String name) {
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