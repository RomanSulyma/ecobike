package com.ecobike.entities;

import java.util.Scanner;

/**
 * Parent class for all bikes
 */

public abstract class Bike {

    Scanner scanner = new Scanner(System.in);

    private String brand;

    private int weight;

    private boolean lights;

    private String color;

    private int price;

    public Bike() {
    }

    public Bike(String brand, int weight, boolean lights, String color, int price) {
        this.brand = brand;
        this.weight = weight;
        this.lights = lights;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isLights() {
        return lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bike)) return false;

        Bike bike = (Bike) o;

        if (weight != bike.weight) return false;
        if (lights != bike.lights) return false;
        if (price != bike.price) return false;
        if (!brand.equals(bike.brand)) return false;
        return color.equals(bike.color);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + weight;
        result = 31 * result + (lights ? 1 : 0);
        result = 31 * result + color.hashCode();
        result = 31 * result + price;
        return result;
    }

    public void createBikeInstance(){
        System.out.println("Enter brand");
            setBrand(scanner.nextLine());
        System.out.println("Enter weight");
            setWeight(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter availability of lights at front and back (TRUE/FALSE)");
            setLights(Boolean.parseBoolean(scanner.nextLine()));
        System.out.println("Enter color");
            setColor(scanner.nextLine());
        System.out.println("Enter price");
            setPrice(Integer.parseInt(scanner.nextLine()));
    }

    public abstract String prepareToWrite();
}
