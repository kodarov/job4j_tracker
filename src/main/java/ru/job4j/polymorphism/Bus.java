package ru.job4j.polymorphism;

public class Bus implements Transport {
    private int passengers;

    public int getPassengers() {
        return passengers;
    }

    @Override
    public void go() {
        System.out.format("Едем едем");
    }

    @Override
    public void acceptPassengers(int passengers) {
        this.passengers += passengers;
    }

    @Override
    public double refuel(int gallon) {
        return 60.52 * gallon;
    }
}
