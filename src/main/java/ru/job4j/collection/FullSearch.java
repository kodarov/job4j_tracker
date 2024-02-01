package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    Set<String> numbers = new HashSet<>();

    public Set<String> extractNumber(List<Task> tasks) {
        for (Task task : tasks) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}
