package org.dauphine.agile;

import java.util.HashSet;
import java.util.Set;

import static org.dauphine.agile.Mode.FLY;

public class FlyingVehicle {

    private final String registration;

    private final ModeManager modeManager;

    public Set<Pilot> assignedPilots;

    public FlyingVehicle(int maxAltitude, double maxSpeed, double maxFuel, String registration) {
        this.registration = registration;
        modeManager = new ModeManager(maxAltitude, maxSpeed, maxFuel);
        assignedPilots = new HashSet<>();
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
        return modeManager.getCurrentStrategy().getCurrentSpeed();
    }

    public double getCurrentAltitude() {
        if (FLY == getCurrentMode()) {
            return ((FlyModeStrategy) modeManager.getCurrentStrategy()).getCurrentAltitude();
        }
        throw new UnsupportedOperationException("Altitude is not supported in current mode.");
    }

    public String getRegistration() {
        return registration;
    }

    public void addPilot(Pilot pilot) {
        if (assignedPilots.add(pilot)) {
            pilot.assignVehicle(this);
        }
    }

    public void removePilot(Pilot pilot) {
        if (assignedPilots.remove(pilot)) {
            pilot.removeVehicle(this);
        }
    }

}