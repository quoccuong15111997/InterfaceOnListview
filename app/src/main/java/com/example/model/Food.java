package com.example.model;

public class Food {
    private String name;
    private int price;
    private int image;

    public Food(String name, int price, int image) {
        this.name = name;
        this.price = price;
        this.image=image;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
