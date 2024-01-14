package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle aircraft = new Aircraft();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = {aircraft, train, bus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.pitStop();
        }
    }
}
