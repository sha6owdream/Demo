package com.example.materialtest;

public class Fruit {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }
}
