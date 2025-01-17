package org.dauphine.agile.mode;

import org.dauphine.agile.FuelManager;
import org.dauphine.agile.SpeedManager;

public class DriveModeStrategy implements ModeStrategy {

    private final SpeedManager speedManager;
    private final FuelManager fuelManager;

    public static final double FUEL_CONSUMPTION = 0.1;

    private DriveModeStrategy(SpeedManager speedManager, FuelManager fuelManager) {
        this.speedManager = speedManager;
        this.fuelManager = fuelManager;
    }

    @Override
    public double accelerate(double amount) {
        if (fuelManager.consumeFuel(amount * FUEL_CONSUMPTION)) {
            return speedManager.accelerate(amount);
        }
        return speedManager.getCurrentSpeed();
    }

    @Override
    public double decelerate(double amount) {
        return speedManager.decelerate(amount);
    }

    @Override
    public double getCurrentSpeed() {
        return speedManager.getCurrentSpeed();
    }

    @Override
    public double getCurrentFuel() {
        return fuelManager.getCurrentFuel();
    }

    public static class Builder {
        private SpeedManager speedManager;
        private FuelManager fuelManager;

        public Builder speedManager(SpeedManager speedManager) {
            this.speedManager = speedManager;
            return this;
        }

        public Builder fuelManager(FuelManager fuelManager) {
            this.fuelManager = fuelManager;
            return this;
        }

        public DriveModeStrategy build() {
            if (speedManager == null || fuelManager == null) {
                throw new IllegalStateException("SpeedManager and FuelManager must be set.");
            }
            return new DriveModeStrategy(speedManager, fuelManager);
        }
    }
}
