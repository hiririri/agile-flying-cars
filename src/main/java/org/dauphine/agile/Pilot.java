package org.dauphine.agile;

import java.util.Set;

public class Pilot {

    private String name;

    private Set<FlyingVehicle> assignedVehicles;

    public Pilot(String name, Set<FlyingVehicle> assignedVehicles) {
        this.name = name;
        this.assignedVehicles = assignedVehicles;
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

}
