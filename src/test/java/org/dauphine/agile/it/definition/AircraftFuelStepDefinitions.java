package org.dauphine.agile.it.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dauphine.agile.Aircraft;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AircraftFuelStepDefinitions {

    private Aircraft aircraft;

    @Given("an aircraft with registration {string} and remaining fuel of {int}")
    public void an_aircraft_with_registration_and_remaining_fuel(String registration, int initialFuel) {
        aircraft = new Aircraft(registration, initialFuel, null);
    }

    @When("I add {int} units of fuel")
    public void i_add_units_of_fuel(int fuelToAdd) {
        aircraft.refuel(fuelToAdd);
    }

    @Then("the remaining fuel should be {int}")
    public void the_remaining_fuel_should_be(int expectedFuel) {
        assertEquals(expectedFuel, aircraft.getRemainingFuel(),
                "The remaining fuel does not match the expected value.");
    }

}
