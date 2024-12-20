package org.dauphine.agile;

public class Driver {
    private String name;
    private int age;
    private Car car;

    public Driver(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
        if (car != null) {
            car.assignDriver(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setCar(Car car) {
        if (this.car != null) {
            this.car.removeDriver(this);
        }
        this.car = car;
        car.assignDriver(this);
    }

    public void accelerate(int speed) {
        if (this.car != null) {
            this.car.accelerate(speed);
        } else {
            throw new IllegalStateException("Driver has no car");
        }
    }

    public void stop() {
        if (this.car != null) {
            this.car.stop();
        } else {
            throw new IllegalStateException("Driver has no car");
        }
    }

}
