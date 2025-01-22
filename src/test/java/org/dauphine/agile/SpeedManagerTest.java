package org.dauphine.agile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeedManagerTest {

    @Test
    void accelerateWithinMaxSpeed() {
        SpeedManager speedManager = new SpeedManager(100);
        assertEquals(50, speedManager.accelerate(50));
    }

    @Test
    void accelerateToMaxSpeed() {
        SpeedManager speedManager = new SpeedManager(100);
        assertEquals(100, speedManager.accelerate(150));
    }

    @Test
    void decelerateWithinMinSpeed() {
        SpeedManager speedManager = new SpeedManager(100);
        speedManager.accelerate(50);
        assertEquals(30, speedManager.decelerate(20));
    }

    @Test
    void decelerateToMinSpeed() {
        SpeedManager speedManager = new SpeedManager(100);
        speedManager.accelerate(50);
        assertEquals(0, speedManager.decelerate(60));
    }

    @Test
    void getCurrentSpeedAfterAcceleration() {
        SpeedManager speedManager = new SpeedManager(100);
        speedManager.accelerate(50);
        assertEquals(50, speedManager.getCurrentSpeed());
    }

    @Test
    void getCurrentSpeedAfterDeceleration() {
        SpeedManager speedManager = new SpeedManager(100);
        speedManager.accelerate(50);
        speedManager.decelerate(20);
        assertEquals(30, speedManager.getCurrentSpeed());
    }
}