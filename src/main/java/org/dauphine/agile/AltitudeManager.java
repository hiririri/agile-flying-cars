package org.dauphine.agile;

public class AltitudeManager {

    private double currentAltitude = 0;
    private double maxAltitude;

    public AltitudeManager(double maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public double climb(double amount) {
        currentAltitude += amount;
        if (currentAltitude > maxAltitude) {
            currentAltitude = maxAltitude;
        }
        return currentAltitude;
    }

    public double descend(double amount) {
        currentAltitude -= amount;
        if (currentAltitude < 0) {
            currentAltitude = 0;
        }
        return currentAltitude;
    }

    public double getCurrentAltitude() {
        return currentAltitude;
    }

}
