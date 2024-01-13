package ru.job4j.polymorphism;

public interface Transport {
    void go();

    void acceptPassengers(int passengers);

    double refuel(int gallon);
}
