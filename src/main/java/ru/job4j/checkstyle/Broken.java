package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    private String name;
    private String surname;
    private static final String NEW_VALUE = "";

    public Broken() {
    }

    public void echo() {
    }

    public void mediaPrint(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void calc(int a, int b, int c, int d, int e, int f, int g) {

    }
}