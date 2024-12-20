package org.dauphine.agile;

public record FlyMobilityStrategy(SpeedManager speedManager,
                                  AltitudeManager altitudeManager,
                                  FuelManager fuelManager) implements MobilityStrategy {

    @Override
    public double accelerate(double amount) {
        if (fuelManager.consumeFuel(amount * 0.2)) {
            return speedManager.accelerate(amount);
        }
        return speedManager.getCurrentSpeed();
    }

    @Override
    public double decelerate(double amount) {
        return speedManager.decelerate(amount);
    }

    public double climb(double amount) {
        if (fuelManager.consumeFuel(amount * 0.5)) {
            return altitudeManager.climb(amount);
        }
        throw new IllegalStateException("Cannot climb without enough fuel");
    }

    public double descend(double amount) {
        return altitudeManager.descend(amount);
    }

}
