package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("\\.");
        String[] rightSplit = right.split("\\.");
        int leftNumber = Integer.parseInt(leftSplit[0]);
        int rightNumber = Integer.parseInt(rightSplit[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}