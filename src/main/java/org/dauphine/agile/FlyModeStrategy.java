package org.dauphine.agile;

public class FlyModeStrategy implements ModeStrategy {

    private final SpeedManager speedManager;
    private final FuelManager fuelManager;
    private final AltitudeManager altitudeManager;

    private FlyModeStrategy(SpeedManager speedManager, FuelManager fuelManager, AltitudeManager altitudeManager) {
        this.speedManager = speedManager;
        this.fuelManager = fuelManager;
        this.altitudeManager = altitudeManager;
    }

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
        throw new IllegalStateException("Not enough fuel to climb.");
    }

    public double descend(double amount) {
        return altitudeManager.descend(amount);
    }

    public double getCurrentSpeed() {
        return speedManager.getCurrentSpeed();
    }

    public double getCurrentAltitude() {
        return altitudeManager.getCurrentAltitude();
    }

    public static class Builder {
        private SpeedManager speedManager;
        private FuelManager fuelManager;
        private AltitudeManager altitudeManager;

        public Builder speedManager(SpeedManager speedManager) {
            this.speedManager = speedManager;
            return this;
        }

        public Builder fuelManager(FuelManager fuelManager) {
            this.fuelManager = fuelManager;
            return this;
        }

        public Builder altitudeManager(AltitudeManager altitudeManager) {
            this.altitudeManager = altitudeManager;
            return this;
        }

        public FlyModeStrategy build() {
            if (speedManager == null || fuelManager == null || altitudeManager == null) {
                throw new IllegalStateException("SpeedManager, FuelManager, and AltitudeManager must be set.");
            }
            return new FlyModeStrategy(speedManager, fuelManager, altitudeManager);
        }
    }

}
