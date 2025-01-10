package org.dauphine.agile;

import java.util.Map;

import static org.dauphine.agile.Mode.DRIVE;
import static org.dauphine.agile.Mode.FLY;

public class ModeManager {

    private Mode currentMode;

    private final Map<Mode, ModeStrategy> modeStrategyMap;

    public ModeManager(int maxAltitude, double maxSpeed, double maxFuel) {
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

        this.modeStrategyMap = Map.of(DRIVE, driveStrategy, FLY, flyStrategy);
        this.currentMode = DRIVE;
    }

    public void switchMode() {
        currentMode = (currentMode == DRIVE) ? FLY : DRIVE;
    }

    public ModeStrategy getCurrentStrategy() {
        return modeStrategyMap.get(currentMode);
    }

    public Mode getCurrentMode() {
        return currentMode;
    }

}