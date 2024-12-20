package org.dauphine.agile;

public class FlyingVehicle {

    private final String registration;

    private int remainingFuel;

    private int altitude;

    private int speed;

    private Pilot pilot;

    private MobilityMode mobilityMode;

    public FlyingVehicle(String registration, int initialFuel) {
        this.registration = registration;
        this.remainingFuel = initialFuel;
        this.mobilityMode = new DriveMode(this);
    }

    public void switchMobilityMode() {
        switch (mobilityMode) {
            case DriveMode driveMode -> {
                if (speed < 200) throw new IllegalStateException("Cannot switch to fly mode, speed is too low");

                mobilityMode = new FlyMode(this);
            }
            case FlyMode flyMode -> {
                if (altitude != 0) throw new IllegalStateException("Cannot switch to drive mode while flying");

                mobilityMode = new DriveMode(this);
            }
        }
    }

    public void move(int speed, int altitude) {
        mobilityMode.move(speed, altitude);
    }

    private boolean isFuelAmountValid(int fuel) {
        return fuel >= 0;
    }

    public void refuel(int fuel) {
        if (isFuelAmountValid(fuel)) {
            this.remainingFuel += fuel;
            return;
        }

        throw new IllegalArgumentException("Fuel amount must be positive");
    }

    public String getRegistration() {
        return registration;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRemainingFuel() {
        return remainingFuel;
    }

    public MobilityMode getMobilityMode() {
        return mobilityMode;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMobilityMode(MobilityMode mobilityMode) {
        this.mobilityMode = mobilityMode;
    }
}
