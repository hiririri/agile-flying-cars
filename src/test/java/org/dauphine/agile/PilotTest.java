package org.dauphine.agile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    private Pilot pilot;
    private FlyingVehicle vehicle;

    @BeforeEach
    void setUp() {
        pilot = new Pilot("Maverick");
        vehicle = new FlyingVehicle(10000, 200, 1500, "FGH-123");
    }

    @Test
    void testAssignVehicle() {
        pilot.assignVehicle(vehicle);
        assertTrue(vehicle.getAssignedPilots().contains(pilot));
    }

    @Test
    void testRemoveVehicle() {
        pilot.assignVehicle(vehicle);
        pilot.removeVehicle(vehicle);
        assertFalse(vehicle.getAssignedPilots().contains(pilot));
    }

    @Test
    void testGetName() {
        assertEquals("Maverick", pilot.getName());
    }
}