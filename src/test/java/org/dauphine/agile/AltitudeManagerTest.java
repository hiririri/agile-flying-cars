package org.dauphine.agile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AltitudeManagerTest {

    @Test
    void climbWithinMaxAltitude() {
        AltitudeManager altitudeManager = new AltitudeManager(1000);
        assertEquals(500, altitudeManager.climb(500));
    }

    @Test
    void climbToMaxAltitude() {
        AltitudeManager altitudeManager = new AltitudeManager(1000);
        assertEquals(1000, altitudeManager.climb(1500));
    }

    @Test
    void descendWithinMinAltitude() {
        AltitudeManager altitudeManager = new AltitudeManager(1000);
        altitudeManager.climb(500);
        assertEquals(300, altitudeManager.descend(200));
    }

    @Test
    void descendToMinAltitude() {
        AltitudeManager altitudeManager = new AltitudeManager(1000);
        altitudeManager.climb(500);
        assertEquals(0, altitudeManager.descend(600));
    }

    @Test
    void getCurrentAltitudeAfterClimb() {
        AltitudeManager altitudeManager = new AltitudeManager(1000);
        altitudeManager.climb(400);
        assertEquals(400, altitudeManager.getCurrentAltitude());
    }

    @Test
    void getCurrentAltitudeAfterDescend() {
        AltitudeManager altitudeManager = new AltitudeManager(1000);
        altitudeManager.climb(400);
        altitudeManager.descend(200);
        assertEquals(200, altitudeManager.getCurrentAltitude());
    }
}