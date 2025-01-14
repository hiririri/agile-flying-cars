package org.dauphine.agile;

public class AltitudeManager {

    private double currentAltitude = 0;
    private final double maxAltitude;

    public AltitudeManager(double maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public double climb(double amount) {
        currentAltitude = Math.min(currentAltitude + amount, maxAltitude);
        return currentAltitude;
    }

    public double descend(double amount) {
        currentAltitude = Math.max(currentAltitude - amount, 0);
        return currentAltitude;
    }

    public double getCurrentAltitude() {
        return currentAltitude;
    }

}
