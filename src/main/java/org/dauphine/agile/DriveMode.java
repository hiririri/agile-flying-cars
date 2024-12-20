package org.dauphine.agile;

public final class DriveMode implements MobilityMode {
    private final FlyingVehicle flyingVehicle;

    public DriveMode(FlyingVehicle flyingVehicle) {
        this.flyingVehicle = flyingVehicle;
    }

    @Override
    public void move(int speed, int altitude) {
        if (MobilityMode.isSpeedValid(speed)) {
            throw new IllegalArgumentException("Speed must be positive");
        }

        flyingVehicle.setSpeed(speed);
    }

}
