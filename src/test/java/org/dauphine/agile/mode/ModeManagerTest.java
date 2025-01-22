package org.dauphine.agile.mode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ModeManagerTest {

    private ModeManager modeManager;

    @BeforeEach
    void setUp() {
        modeManager = new ModeManager(100, 100, 100);
    }

    @Test
    void getCurrentStrategy() {
        assertEquals(DriveModeStrategy.class, modeManager.getCurrentStrategy().getClass());
    }

    @Test
    void switchModeToFly() {
        modeManager.switchMode();
        assertEquals(Mode.FLY, modeManager.getCurrentMode());
    }

    @Test
    void switchModeToDrive() {
        modeManager.switchMode();
        modeManager.switchMode();
        assertEquals(Mode.DRIVE, modeManager.getCurrentMode());
    }

}