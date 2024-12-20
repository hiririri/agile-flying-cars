package org.dauphine.agile;

public class Aircraft {
    private String registration;
    private int remainingFuel;
    private Pilot pilot;

    public Aircraft(String registration, int remainingFuel, Pilot pilot) {
        this.registration = registration;
        this.remainingFuel = remainingFuel;
        setPilot(pilot);
    }

    public void setPilot(Pilot pilot) {
        if (this.pilot != null) {
            this.pilot.removeAircraft(this);
        }
        this.pilot = pilot;
        if (pilot != null) {
            pilot.addAircraft(this);
        }
    }

    public Pilot getPilot() {
        return pilot;
    }

    public String getRegistration() {
        return registration;
    }

    public int getRemainingFuel() {
        return remainingFuel;
    }

    private boolean isFuelAmountValid(int fuel) {
        return fuel >= 0;
    }

    public void refuel(int fuel) {
        if (isFuelAmountValid(fuel)) {
            this.remainingFuel += fuel;
            return;
        }

        throw new IllegalArgumentException("Fuel amount must be positive");
    }

}
