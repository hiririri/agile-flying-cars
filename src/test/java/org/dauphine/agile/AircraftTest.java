package org.dauphine.agile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AircraftTest {

    private Pilot pilot;
    private Aircraft aircraft;

    @BeforeEach
    public void setUp() {
        pilot = new Pilot("Maverick");
        aircraft = new Aircraft("F-GZDK", 150, pilot);
    }

    @Test
    public void testAddFuel() {
        aircraft.refuel(50);
        assertEquals(200, aircraft.getRemainingFuel());
    }

    @Test
    public void testThrowExceptionWhenAddingNegativeFuel() {
        assertThrows(IllegalArgumentException.class, () -> aircraft.refuel(-50));
    }

    @Test
    public void testGetPilotName() {
        assertEquals("Maverick", aircraft.getPilot().getName());
    }

    @Test
    public void testBidirectionalAssociation() {
        Aircraft newAircraft = new Aircraft("B-12345", 100, null);
        newAircraft.setPilot(pilot);
        assertEquals(2, pilot.getAircrafts().size());
        assertEquals(pilot, newAircraft.getPilot());
    }

    @Test
    public void testStateConsistencyAfterRefuel() {
        int initialFuel = aircraft.getRemainingFuel();
        aircraft.refuel(30);
        assertEquals(initialFuel + 30, aircraft.getRemainingFuel());
    }

}