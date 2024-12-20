package org.dauphine.agile;

import java.util.HashSet;
import java.util.Set;

public class Car {
    private String brand;
    private int price;
    private String modele;
    private int speed;
    private Set<Driver> drivers;

    public Car(String brand, String modele, int price) {
        // initialisation des variables d'instance
        this.price = price;
        this.modele = modele;
        this.brand = brand;
        this.drivers = new HashSet<>();
        this.speed = 0;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModele() {
        return this.modele;
    }

    public int getPrice() {
        return this.price;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Driver> getDrivers() {
        return this.drivers;
    }

    public int reducePrice(int y) {
        return this.price -= y;
    }

    public void accelerate(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must be positive");
        }
        this.speed += speed;
    }

    public void stop() {
        this.speed = 0;
    }

    public void assignDriver(Driver driver) {
        this.drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        this.drivers.remove(driver);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
}
