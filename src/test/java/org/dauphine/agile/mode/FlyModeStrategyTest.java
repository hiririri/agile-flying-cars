package org.dauphine.agile.mode;

import org.dauphine.agile.AltitudeManager;
import org.dauphine.agile.FuelManager;
import org.dauphine.agile.SpeedManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlyModeStrategyTest {

    @Mock
    private SpeedManager speedManager;

    @Mock
    private FuelManager fuelManager;

    @Mock
    private AltitudeManager altitudeManager;

    @InjectMocks
    private FlyModeStrategy flyMode;

    @Test
    void accelerateWithSufficientFuel() {
        when(fuelManager.consumeFuel(50 * FlyModeStrategy.FUEL_CONSUMPTION)).thenReturn(true);
        when(speedManager.accelerate(50)).thenReturn(50.0);
        assertEquals(50, flyMode.accelerate(50));
    }

    @Test
    void accelerateWithInsufficientFuel() {
        when(fuelManager.consumeFuel(50 * FlyModeStrategy.FUEL_CONSUMPTION)).thenReturn(false);
        assertEquals(0, flyMode.accelerate(50));
    }

    @Test
    void decelerateWithinSpeedLimit() {
        flyMode.accelerate(50);
        when(speedManager.decelerate(20)).thenReturn(30.0);
        assertEquals(30, flyMode.decelerate(20));
    }

    @Test
    void decelerateToZeroSpeed() {
        flyMode.accelerate(50);
        when(speedManager.decelerate(60)).thenReturn(0.0);
        assertEquals(0, flyMode.decelerate(60));
    }

    @Test
    void climbWithSufficientFuel() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(true);
        when(altitudeManager.climb(50)).thenReturn(50.0);
        assertEquals(50, flyMode.climb(50));
    }

    @Test
    void climbWithInsufficientFuel() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(false);
        assertThrows(IllegalStateException.class, () -> flyMode.climb(50));
    }

    @Test
    void descendWithinAltitudeLimit() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(true);
        when(altitudeManager.climb(50)).thenReturn(50.0);
        when(altitudeManager.descend(20)).thenReturn(30.0);
        flyMode.climb(50);

        var res = flyMode.descend(20);
        assertEquals(30, res);
    }

    @Test
    void getCurrentSpeedAfterAcceleration() {
        when(speedManager.getCurrentSpeed()).thenReturn(80.0);
        assertEquals(80, flyMode.getCurrentSpeed());
    }

    @Test
    void getCurrentFuelAfterAcceleration() {
        flyMode.accelerate(50);
        when(fuelManager.getCurrentFuel()).thenReturn(95.0);
        assertEquals(95, flyMode.getCurrentFuel());
    }

    @Test
    void getCurrentAltitudeAfterClimb() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(true);
        when(altitudeManager.climb(50)).thenReturn(50.0);
        when(altitudeManager.getCurrentAltitude()).thenReturn(50.0);
        flyMode.climb(50);
        assertEquals(50, flyMode.getCurrentAltitude());
    }

    @Test
    void getCurrentAltitudeAfterDescend() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(true);
        when(altitudeManager.climb(50)).thenReturn(50.0);
        when(altitudeManager.descend(20)).thenReturn(30.0);
        when(altitudeManager.getCurrentAltitude()).thenReturn(30.0);
        flyMode.climb(50);
        flyMode.descend(20);
        assertEquals(30, flyMode.getCurrentAltitude());
    }

    @Test
    void getCurrentAltitudeAfterClimbAndDescend() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(true);
        when(altitudeManager.climb(50)).thenReturn(50.0);
        when(altitudeManager.descend(20)).thenReturn(30.0);
        when(altitudeManager.getCurrentAltitude()).thenReturn(30.0);
        flyMode.climb(50);
        flyMode.descend(20);
        assertEquals(30, flyMode.getCurrentAltitude());
    }

    @Test
    void getCurrentAltitudeAfterClimbAndDescendTwice() {
        when(fuelManager.consumeFuel(50 * 0.5)).thenReturn(true);
        when(altitudeManager.climb(50)).thenReturn(50.0);
        when(altitudeManager.descend(20)).thenReturn(30.0);
        when(altitudeManager.getCurrentAltitude()).thenReturn(30.0);
        flyMode.climb(50);
        flyMode.descend(20);
        flyMode.climb(50);
        flyMode.descend(20);
        assertEquals(30, flyMode.getCurrentAltitude());
    }

}