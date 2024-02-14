package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, -3, 0, 44, 21, 10, 6, 100, 1, -33);
        List<Integer> positive = numbers.stream().filter(e -> e > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}