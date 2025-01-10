package org.dauphine.agile;

import static org.dauphine.agile.Mode.FLY;

public class FlyingVehicle {

    private final ModeManager modeManager;

    public FlyingVehicle(int maxAltitude, double maxSpeed, double maxFuel) {
        var speedManager = new SpeedManager(maxSpeed);
        var fuelManager = new FuelManager(maxFuel);
        var altitudeManager = new AltitudeManager(maxAltitude);

        var driveStrategy = new DriveModeStrategy.Builder()
                .fuelManager(fuelManager)
                .speedManager(speedManager)
                .build();

        var flyStrategy = new FlyModeStrategy.Builder()
                .fuelManager(fuelManager)
                .speedManager(speedManager)
                .altitudeManager(altitudeManager)
                .build();

        modeManager = new ModeManager(Mode.DRIVE, driveStrategy, flyStrategy);
    }

    public void switchMode() {
        modeManager.switchMode();
    }

    public double accelerate(double amount) {
        return modeManager.getCurrentStrategy().accelerate(amount);
    }

    public double decelerate(double amount) {
        return modeManager.getCurrentStrategy().decelerate(amount);
    }

    public double climb(double amount) {
        var strategy = modeManager.getCurrentStrategy();
        if (FLY == getCurrentMode()) {
            return ((FlyModeStrategy) strategy).climb(amount);
        }
        throw new UnsupportedOperationException("Climb is not supported in current mode.");
    }

    public double descend(double amount) {
        var strategy = modeManager.getCurrentStrategy();
        if (FLY == getCurrentMode()) {
            return ((FlyModeStrategy) strategy).descend(amount);
        }
        throw new UnsupportedOperationException("Descend is not supported in current mode.");
    }

    public Mode getCurrentMode() {
        return modeManager.getCurrentMode();
    }

    public ModeStrategy getCurrentStrategy() {
        return modeManager.getCurrentStrategy();
    }

    public double getCurrentSpeed() {
        return switch (getCurrentMode()) {
            case DRIVE -> ((DriveModeStrategy) modeManager.getCurrentStrategy()).getCurrentSpeed();
            case FLY -> ((FlyModeStrategy) modeManager.getCurrentStrategy()).getCurrentSpeed();
        };
    }

    public double getCurrentAltitude() {
        if (FLY == getCurrentMode()) {
            return ((FlyModeStrategy) modeManager.getCurrentStrategy()).getCurrentAltitude();
        }
        throw new UnsupportedOperationException("Altitude is not supported in current mode.");
    }

}