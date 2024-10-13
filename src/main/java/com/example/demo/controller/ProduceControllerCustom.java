package com.example.demo.controller;

public class ProduceControllerCustom {

    private String name;
    private String price;
    private String quantity;
    private String imageURL;

    // Default constructor
    public ProduceControllerCustom() {}

    // Parameterized constructor (optional)
    public ProduceControllerCustom(String name, String price, String quantity, String imageURL) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageURL = imageURL;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
