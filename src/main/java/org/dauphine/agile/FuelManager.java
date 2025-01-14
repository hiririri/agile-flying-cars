package org.dauphine.agile;

public class FuelManager {

    private double currentFuel;
    private final double maxFuel;

    public FuelManager(double maxFuel) {
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;
    }

    public boolean consumeFuel(double amount) {
        if (currentFuel >= amount) {
            currentFuel -= amount;
            return true;
        }
        return false;
    }

    public void refuel(double amount) {
        currentFuel = Math.min(currentFuel + amount, maxFuel);
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

}
