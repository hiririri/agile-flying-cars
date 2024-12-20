package org.dauphine.agile;

public sealed interface MobilityMode permits DriveMode, FlyMode {

    void move(int speed, int altitude);

    static boolean isAltitudeValid(int altitude) {
        return altitude >= 0;
    }

    static boolean isSpeedValid(int speed) {
        return speed < 0;
    }
}
