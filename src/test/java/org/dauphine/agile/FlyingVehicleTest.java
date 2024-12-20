package org.dauphine.agile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyingVehicleTest {

    public static final String REGISTRATION = "F-GHJK";
    public static final int INITIAL_FUEL = 100;

    private FlyingVehicle flyingVehicle;

    @BeforeEach
    void setUp() {
        flyingVehicle = new FlyingVehicle(REGISTRATION, INITIAL_FUEL);
    }


    @Test
    void shouldSwitchToFlyMode() {
        flyingVehicle.setSpeed(200);
        flyingVehicle.switchMobilityMode();
        assertInstanceOf(FlyMode.class, flyingVehicle.getMobilityMode());
    }

    @Test
    void shouldNotSwitchToFlyMode() {
        flyingVehicle.setSpeed(199);
        assertThrows(IllegalStateException.class, flyingVehicle::switchMobilityMode);
    }

    @Test
    void shouldSwitchToDriveMode() {
        flyingVehicle.setMobilityMode(new FlyMode(flyingVehicle));
        flyingVehicle.setAltitude(0);
        flyingVehicle.switchMobilityMode();
        assertInstanceOf(DriveMode.class, flyingVehicle.getMobilityMode());
    }

    @Test
    void shouldNotSwitchToDriveMode() {
        flyingVehicle.setMobilityMode(new FlyMode(flyingVehicle));
        flyingVehicle.setAltitude(1);
        assertThrows(IllegalStateException.class, flyingVehicle::switchMobilityMode);
    }

}