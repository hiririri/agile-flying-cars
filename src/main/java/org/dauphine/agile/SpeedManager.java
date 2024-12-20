package org.dauphine.agile;

public class SpeedManager {

    private double currentSpeed = 0;
    private final double maxSpeed;

    public SpeedManager(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double accelerate(double amount) {
        currentSpeed += amount;
        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
        return currentSpeed;
    }

    public double decelerate(double amount) {
        currentSpeed -= amount;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
        return currentSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

}
