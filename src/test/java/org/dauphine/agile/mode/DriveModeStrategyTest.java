package org.dauphine.agile.mode;

import org.dauphine.agile.FuelManager;
import org.dauphine.agile.SpeedManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DriveModeStrategyTest {

    @Mock
    private SpeedManager speedManager;

    @Mock
    private FuelManager fuelManager;

    @InjectMocks
    private DriveModeStrategy driveMode;

    @Test
    void accelerateWithSufficientFuel() {
        when(fuelManager.consumeFuel(50 * DriveModeStrategy.FUEL_CONSUMPTION)).thenReturn(true);
        when(speedManager.accelerate(50)).thenReturn(50.0);
        assertEquals(50, driveMode.accelerate(50));
    }

    @Test
    void accelerateWithInsufficientFuel() {
        when(fuelManager.consumeFuel(50 * DriveModeStrategy.FUEL_CONSUMPTION)).thenReturn(false);
        assertEquals(0, driveMode.accelerate(50));
    }

    @Test
    void decelerateWithinSpeedLimit() {
        driveMode.accelerate(50);
        when(speedManager.decelerate(20)).thenReturn(30.0);
        assertEquals(30, driveMode.decelerate(20));
    }

    @Test
    void decelerateToZeroSpeed() {
        driveMode.accelerate(50);
        when(speedManager.decelerate(60)).thenReturn(0.0);
        assertEquals(0, driveMode.decelerate(60));
    }

    @Test
    void getCurrentSpeedAfterAcceleration() {
        when(speedManager.getCurrentSpeed()).thenReturn(80.0);
        assertEquals(80, driveMode.getCurrentSpeed());
    }

    @Test
    void getCurrentFuelAfterAcceleration() {
        driveMode.accelerate(50);
        when(fuelManager.getCurrentFuel()).thenReturn(95.0);
        assertEquals(95, driveMode.getCurrentFuel());
    }

}