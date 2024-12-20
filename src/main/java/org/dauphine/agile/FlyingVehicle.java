package org.dauphine.agile;

import java.util.Map;

public class FlyingVehicle {

    private MobilityStrategy mobilityStrategy;

    private String currentMode = "DRIVE";

    private final Map<String, MobilityStrategy> modeStrategyMap;

    private final SpeedManager speedManager;
    private final AltitudeManager altitudeManager;
    private final FuelManager fuelManager;

    public FlyingVehicle(int maxAltitude, double maxSpeed, double maxFuel) {
        this.speedManager = new SpeedManager(maxSpeed);
        this.altitudeManager = new AltitudeManager(maxAltitude);
        this.fuelManager = new FuelManager(maxFuel);

        modeStrategyMap = Map.of("DRIVE", new DriveMobilityStrategy(speedManager, fuelManager),
                                 "FLY", new FlyMobilityStrategy(speedManager, altitudeManager, fuelManager));

        mobilityStrategy = modeStrategyMap.get(currentMode);
    }

    public void switchMode() {
        switch (currentMode) {
            case "DRIVE" -> {
                currentMode = "FLY";
                mobilityStrategy = modeStrategyMap.get(currentMode);
            }
            case "FLY" -> {
                currentMode = "DRIVE";
                mobilityStrategy = modeStrategyMap.get(currentMode);
            }
        }
    }

    public void accelerate(double amount) {
        mobilityStrategy.accelerate(amount);
    }

    public void decelerate(double amount) {
        mobilityStrategy.decelerate(amount);
    }

    public double climb(double amount) {
        if ("FLY".equals(currentMode)) {
            return ((FlyMobilityStrategy) mobilityStrategy).climb(amount);
        }
        throw new IllegalStateException("Cannot climb in DRIVE mode");
    }

    public double descend(double amount) {
        if ("FLY".equals(currentMode)) {
            return ((FlyMobilityStrategy) mobilityStrategy).descend(amount);
        }
        throw new IllegalStateException("Cannot descend in DRIVE mode");
    }

    public double getCurrentSpeed() {
        return speedManager.getCurrentSpeed();
    }

    public double getCurrentAltitude() {
        return altitudeManager.getCurrentAltitude();
    }

    public double getCurrentFuel() {
        return fuelManager.getCurrentFuel();
    }

    public String getCurrentMode() {
        return currentMode;
    }

}
