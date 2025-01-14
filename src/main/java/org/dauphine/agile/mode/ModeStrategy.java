package org.dauphine.agile.mode;

public interface ModeStrategy {

    double accelerate(double amount);

    double decelerate(double amount);

    double getCurrentSpeed();

    double getCurrentFuel();

}
