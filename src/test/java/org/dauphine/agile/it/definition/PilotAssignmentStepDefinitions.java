package org.dauphine.agile.it.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dauphine.agile.Aircraft;
import org.dauphine.agile.Pilot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PilotAssignmentStepDefinitions {

    private Pilot pilot;
    private Aircraft aircraft;
    private Aircraft anotherAircraft;

    @Given("an aircraft with registration {string}")
    public void an_aircraft_with_registration(String registration) {
        aircraft = new Aircraft(registration, 0, null);
    }

    @Given("a pilot named {string}")
    public void aPilotNamed(String pilotName) {
        pilot = new Pilot(pilotName);
    }

    @When("I assign the pilot to the aircraft")
    public void iAssignThePilotToTheAircraft() {
        aircraft.setPilot(pilot);
    }

    @When("I remove the pilot from the aircraft")
    public void iRemoveThePilotFromTheAircraft() {
        aircraft.setPilot(null);
    }

    @When("I assign the pilot to both aircrafts")
    public void iAssignThePilotToBothAircrafts() {
        aircraft.setPilot(pilot);
        anotherAircraft.setPilot(pilot);
    }

    @Then("the aircraft should have the pilot {string}")
    public void theAircraftShouldHaveThePilot(String pilotName) {
        assertEquals(pilotName, aircraft.getPilot().getName());
    }

    @Then("the aircraft should not have a pilot")
    public void theAircraftShouldNotHaveAPilot() {
        assertNull(aircraft.getPilot());
    }

    @Then("the pilot should have {int} aircrafts")
    public void thePilotShouldHaveAircrafts(int numberOfAircrafts) {
        assertEquals(numberOfAircrafts, pilot.getAircrafts().size());
    }

    @Then("the pilot should have {int} aircraft")
    public void thePilotShouldHaveAircraft(int numberOfAircraft) {
        assertEquals(numberOfAircraft, pilot.getAircrafts().size());
    }

    @Given("the aircraft has a pilot {string}")
    public void theAircraftHasAPilot(String pilotName) {
        pilot = new Pilot(pilotName);
        aircraft = new Aircraft("F-GZDK", 150, pilot);
    }

    @Then("the pilot should not have the aircraft")
    public void thePilotShouldNotHaveTheAircraft() {
        assertEquals(0, pilot.getAircrafts().size());
    }

    @Given("another aircraft with registration {string}")
    public void anotherAircraftWithRegistrationAndRemainingFuelOf(String registration) {
        anotherAircraft = new Aircraft(registration, 0, null);
    }
}
