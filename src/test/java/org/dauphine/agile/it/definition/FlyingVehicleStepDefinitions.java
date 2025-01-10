package org.dauphine.agile.it.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.dauphine.agile.FlyingVehicle;
import org.dauphine.agile.Mode;

import static org.junit.jupiter.api.Assertions.*;

public class FlyingVehicleStepDefinitions {

    private FlyingVehicle flyingVehicle;
    private double result;

    // Step Definitions for Feature 1: Switching Modes

    @Given("a flying vehicle is in \"DRIVE\" mode")
    public void a_flying_vehicle_is_in_drive_mode() {
        flyingVehicle = new FlyingVehicle(10000, 200, 1500, "FGH-123");
        assertEquals(Mode.DRIVE, flyingVehicle.getCurrentMode());
    }

    @Given("a flying vehicle is in \"FLY\" mode")
    public void a_flying_vehicle_is_in_fly_mode() {
        flyingVehicle = new FlyingVehicle(10000, 200, 1500, "FGH-123");
        flyingVehicle.switchMode();
        assertEquals(Mode.FLY, flyingVehicle.getCurrentMode());
    }

    @When("the pilot switches the mode")
    public void the_pilot_switches_the_mode() {
        flyingVehicle.switchMode();
    }

    @Then("the flying vehicle should be in \"DRIVE\" mode")
    public void the_flying_vehicle_should_be_in_drive_mode() {
        assertEquals(Mode.DRIVE, flyingVehicle.getCurrentMode());
    }

    @Then("the flying vehicle should be in \"FLY\" mode")
    public void the_flying_vehicle_should_be_in_fly_mode() {
        assertEquals(Mode.FLY, flyingVehicle.getCurrentMode());
    }

    // Step Definitions for Feature 2: Acceleration and Climbing

    @Given("a flying vehicle is in \"DRIVE\" mode with a current speed of {double}")
    public void a_flying_vehicle_is_in_drive_mode_with_speed(double initialSpeed) {
        flyingVehicle = new FlyingVehicle(10000, 200, 1500, "FGH-123");
        flyingVehicle.accelerate(initialSpeed);
        assertEquals(Mode.DRIVE, flyingVehicle.getCurrentMode());
    }

    @When("the pilot accelerates by {double}")
    public void the_pilot_accelerates_by(double accelerationAmount) {
        result = flyingVehicle.accelerate(accelerationAmount);
    }

    @Then("the current speed should be {double}")
    public void the_current_speed_should_be(double expectedSpeed) {
        assertEquals(expectedSpeed, result, 0.01);
    }

    @Given("a flying vehicle is in \"FLY\" mode with a current altitude of {double}")
    public void a_flying_vehicle_is_in_fly_mode_with_altitude(double initialAltitude) {
        flyingVehicle = new FlyingVehicle(10000, 200, 1500, "FGH-123");
        flyingVehicle.switchMode();
        flyingVehicle.climb(initialAltitude);
        assertEquals(Mode.FLY, flyingVehicle.getCurrentMode());
    }

    @When("the pilot climbs by {double}")
    public void the_pilot_climbs_by(double climbAmount) {
        result = flyingVehicle.climb(climbAmount);
    }

    @Then("the current altitude should be {double}")
    public void the_current_altitude_should_be(double expectedAltitude) {
        assertEquals(expectedAltitude, result, 0.01);
    }
}
