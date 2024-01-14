package ru.job4j.cast;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.format(getClass().getSimpleName() + " летит!" + System.lineSeparator());
    }

    @Override
    public void pitStop() {
        System.out.format(getClass().getSimpleName() + " прилетает в аэродром" + System.lineSeparator());
    }
}
