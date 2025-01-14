package org.dauphine.agile;

public class SpeedManager {

    private double currentSpeed = 0;
    private final double maxSpeed;

    public SpeedManager(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double accelerate(double amount) {
        currentSpeed = Math.min(currentSpeed + amount, maxSpeed);
        return currentSpeed;
    }

    public double decelerate(double amount) {
        currentSpeed = Math.max(currentSpeed - amount, 0);
        return currentSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

}
