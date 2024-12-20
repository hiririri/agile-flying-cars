package org.dauphine.agile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    protected Car car;
    protected Driver driver;

    public CarTest() {
    }

    @BeforeEach
    public void setUp() {
        this.car = new Car("BMW", "X1", 60000);
        this.driver = new Driver("Juelle", 22, car);
    }

    @Test
    public void testReducePrice() {
        assertEquals(55000, this.car.reducePrice(5000));
    }

    @Test
    public void testAssignDriver() {
        assertTrue(car.getDrivers().contains(driver));
    }
}





