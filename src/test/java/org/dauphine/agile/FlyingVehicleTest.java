package org.dauphine.agile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlyingVehicleTest {

    public static final int MAX_SPEED = 300;
    public static final int INITIAL_FUEL = 100;
    public static final int MAX_ALTITUDE = 10000;

    private FlyingVehicle flyingVehicle;

    @BeforeEach
    void setUp() {
        flyingVehicle = new FlyingVehicle(MAX_ALTITUDE, MAX_SPEED, INITIAL_FUEL);
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
        assertEquals("FLY", flyingVehicle.getCurrentMode());
        flyingVehicle.switchMode();
        assertEquals("DRIVE", flyingVehicle.getCurrentMode());
    }

}