package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(result);
        anyM();
        allM();
    }

    private static void anyM() {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result);
    }

    private static void allM() {
        List<String> strings = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
        boolean result = strings
                .stream()
                .allMatch(element -> element.startsWith("Три"));
        System.out.println(result);
    }
}