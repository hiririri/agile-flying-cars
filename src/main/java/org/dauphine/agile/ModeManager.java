package org.dauphine.agile;

import java.util.Map;

import static org.dauphine.agile.Mode.DRIVE;
import static org.dauphine.agile.Mode.FLY;

public class ModeManager {

    private Mode currentMode;

    private final Map<Mode, ModeStrategy> modeStrategyMap;

    public ModeManager(Mode initialMode, ModeStrategy driveStrategy, ModeStrategy flyStrategy) {
        this.modeStrategyMap = Map.of(DRIVE, driveStrategy, FLY, flyStrategy);
        this.currentMode = initialMode;
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