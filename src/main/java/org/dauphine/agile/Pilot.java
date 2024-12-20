package org.dauphine.agile;

import java.util.HashSet;
import java.util.Set;

public class Pilot {
    private final String name;
    private Set<FlyingVehicle> flyingVehicles;

    public Pilot(String name) {
        this.name = name;
        this.flyingVehicles = new HashSet<>();
    }

    public void addFlyingVehicle(FlyingVehicle flyingVehicle) {
        if (flyingVehicles.contains(flyingVehicle)) {
            throw new IllegalArgumentException("Pilot already has this flying vehicle");
        }

        this.flyingVehicles.add(flyingVehicle);
    }

    public void removeFlyingVehicle(FlyingVehicle flyingVehicle) {
        this.flyingVehicles.remove(flyingVehicle);
    }

    public String getName() {
        return this.name;
    }
}
