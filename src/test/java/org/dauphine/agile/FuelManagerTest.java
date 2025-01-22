package org.dauphine.agile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FuelManagerTest {

    @Test
    void consumeFuelWithinCurrentFuel() {
        FuelManager fuelManager = new FuelManager(100);
        assertTrue(fuelManager.consumeFuel(50));
        assertEquals(50, fuelManager.getCurrentFuel());
    }

    @Test
    void consumeFuelExceedingCurrentFuel() {
        FuelManager fuelManager = new FuelManager(100);
        assertFalse(fuelManager.consumeFuel(150));
        assertEquals(100, fuelManager.getCurrentFuel());
    }

    @Test
    void refuelWithinMaxFuel() {
        FuelManager fuelManager = new FuelManager(100);
        fuelManager.consumeFuel(50);
        fuelManager.refuel(30);
        assertEquals(80, fuelManager.getCurrentFuel());
    }

    @Test
    void refuelExceedingMaxFuel() {
        FuelManager fuelManager = new FuelManager(100);
        fuelManager.consumeFuel(50);
        fuelManager.refuel(60);
        assertEquals(100, fuelManager.getCurrentFuel());
    }

    @Test
    void getCurrentFuelAfterConsumption() {
        FuelManager fuelManager = new FuelManager(100);
        fuelManager.consumeFuel(40);
        assertEquals(60, fuelManager.getCurrentFuel());
    }

    @Test
    void getCurrentFuelAfterRefueling() {
        FuelManager fuelManager = new FuelManager(100);
        fuelManager.consumeFuel(40);
        fuelManager.refuel(20);
        assertEquals(80, fuelManager.getCurrentFuel());
    }
}