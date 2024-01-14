package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.format(getClass().getSimpleName() + " едет по рельсам" + System.lineSeparator());
    }

    @Override
    public void pitStop() {
        System.out.format(getClass().getSimpleName() + " приезжает на станцию" + System.lineSeparator());
    }
}
