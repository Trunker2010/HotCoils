package com.example.hotcoils;

import java.util.ArrayList;

public class Coil {
    private String name;
    private double resistance;
    private int price;
    private int imageResourceId;
    private String material;

    public Coil(String name, double resistance, int price, int imageResourceId) {
        this.name = name;
        this.resistance = resistance;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public static ArrayList<Coil> coils = new ArrayList<Coil>();



    public String getName() {
        return name;
    }



    public double getResistance() {
        return resistance;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getMaterial() {
        return material;
    }

    public String toString() {
        return this.name;
    }

    public Coil(String name, double resistance, int price, int imageResourceId, String material) {
        this.name = name;
        this.resistance = resistance;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.material = material;
    }



}
