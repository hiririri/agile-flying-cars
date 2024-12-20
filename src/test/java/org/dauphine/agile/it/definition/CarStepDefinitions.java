package org.dauphine.agile.it.definition;

import org.dauphine.agile.Car;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class CarStepDefinitions {
    private Car car;
    private Exception exception;

    @Given("une voiture ayant comme vitesse courante {int}")
    public void initCar(int vitesseCourante) {
        car = new Car("Toyota", "Corolla", 10000);
        car.setSpeed(vitesseCourante);
    }

    @When("j'accélère la voiture d'une vitesse de {int}")
    public void accelerateCar(int acceleration) {
        try {
            car.accelerate(acceleration);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Then("la vitesse de la voiture est {int}")
    public void checkSpeed(int vitesseFinale) {
        assertEquals(vitesseFinale,car.getSpeed());
    }

    @Then("une exception est levée")
    public void checkSpeedConstant() {
        assertEquals("Speed must be positive",this.exception.getMessage());
    }

    @When("je stoppe la voiture")
    public void stopCar() {
        car.stop();
    }

    @Then("la vitesse de la voiture est nulle")
    public void checkSpeedZero() {
        assertEquals(0,car.getSpeed());
    }
}
