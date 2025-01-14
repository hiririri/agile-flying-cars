package org.dauphine.agile;

import java.util.HashSet;
import java.util.Set;

public class Pilot {

    private final String name;

    private final Set<FlyingVehicle> assignedVehicles;

    public Pilot(String name) {
        this.name = name;
        this.assignedVehicles = new HashSet<>();
    }

    public void assignVehicle(FlyingVehicle vehicle) {
        if (assignedVehicles.add(vehicle)) {
            vehicle.addPilot(this);
        }
    }

    public void removeVehicle(FlyingVehicle vehicle) {
        if (assignedVehicles.remove(vehicle)) {
            vehicle.removePilot(this);
        }
    }

    public String getName() {
        return name;
    }
}
