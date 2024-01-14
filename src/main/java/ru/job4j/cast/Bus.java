package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.format(getClass().getSimpleName() + " едет по дороге" + System.lineSeparator());
    }

    @Override
    public void pitStop() {
        System.out.format(getClass().getSimpleName() + " приезжает на дорожную остановку" + System.lineSeparator());
    }
}
