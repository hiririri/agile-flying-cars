package org.dauphine.agile;

public record DriveMobilityStrategy(SpeedManager speedManager, FuelManager fuelManager) implements MobilityStrategy {

    @Override
    public double accelerate(double amount) {
        if (fuelManager.consumeFuel(amount * 0.1)) {
            return speedManager.accelerate(amount);
        }
        return speedManager.getCurrentSpeed();
    }

    @Override
    public double decelerate(double amount) {
        return speedManager.decelerate(amount);
    }

}
