package org.dauphine.agile;

public final class FlyMode implements MobilityMode {

    private final FlyingVehicle flyingVehicle;

    public FlyMode(FlyingVehicle flyingVehicle) {
        this.flyingVehicle = flyingVehicle;
    }

    @Override
    public void move(int speed, int altitude) {
        if (!MobilityMode.isAltitudeValid(altitude)) {
            throw new IllegalArgumentException("Altitude must be positive");
        }
        if (MobilityMode.isSpeedValid(speed)) {
            throw new IllegalArgumentException("Speed must be positive");
        }

        flyingVehicle.setSpeed(speed);
        flyingVehicle.setAltitude(altitude);
    }

}
