package org.dauphine.agile;

import org.dauphine.agile.mode.DriveModeStrategy;
import org.dauphine.agile.mode.FlyModeStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.dauphine.agile.mode.Mode.DRIVE;
import static org.dauphine.agile.mode.Mode.FLY;
import static org.junit.jupiter.api.Assertions.*;

class FlyingVehicleTest {

    public static final double MAX_SPEED = 300;
    public static final double INITIAL_FUEL = 100;
    public static final int MAX_ALTITUDE = 10000;

    private FlyingVehicle flyingVehicle;

    @BeforeEach
    void setUp() {
        flyingVehicle = new FlyingVehicle(MAX_ALTITUDE, MAX_SPEED, INITIAL_FUEL, "FGH-123");
    }

    @Test
    void testAccelerate() {
        flyingVehicle.accelerate(50);
        assertEquals(50, flyingVehicle.getCurrentSpeed());
    }

    @Test
    void testDecelerate() {
        flyingVehicle.accelerate(50);
        flyingVehicle.decelerate(20);
        assertEquals(30, flyingVehicle.getCurrentSpeed());
    }

    @Test
    void testClimb() {
        flyingVehicle.switchMode();
        flyingVehicle.climb(100);
        assertEquals(100, flyingVehicle.getCurrentAltitude());
    }

    @Test
    void testClimbWithoutEnoughFuel() {
        flyingVehicle.switchMode();
        assertThrows(IllegalStateException.class, () -> flyingVehicle.climb(1000));
    }

    @Test
    void testDescend() {
        flyingVehicle.switchMode();
        flyingVehicle.climb(100);
        flyingVehicle.descend(50);
        assertEquals(50, flyingVehicle.getCurrentAltitude());
    }

    @Test
    void testSwitchMode() {
        flyingVehicle.switchMode();
        assertEquals(FLY, flyingVehicle.getCurrentMode());
        assertInstanceOf(FlyModeStrategy.class, flyingVehicle.getCurrentStrategy());

        flyingVehicle.switchMode();
        assertEquals(DRIVE, flyingVehicle.getCurrentMode());
        assertInstanceOf(DriveModeStrategy.class, flyingVehicle.getCurrentStrategy());
    }

}