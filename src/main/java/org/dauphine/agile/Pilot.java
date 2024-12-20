package org.dauphine.agile;

import java.util.HashSet;
import java.util.Set;

public class Pilot {
    private String name;
    private Set<Aircraft> aircrafts = new HashSet<>();

    public Pilot(String name) {
        this.name = name;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircrafts.add(aircraft);
    }

    public void removeAircraft(Aircraft aircraft) {
        this.aircrafts.remove(aircraft);
    }

    public Set<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public String getName() {
        return this.name;
    }
}
