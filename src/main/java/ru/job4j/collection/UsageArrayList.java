package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class UsageArrayList {
    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();
        namesList.add("Petr");
        namesList.add("Ivan");
        namesList.add("Stepan");
        for (String name : namesList) {
            System.out.format(name + System.lineSeparator());
        }
    }
}
