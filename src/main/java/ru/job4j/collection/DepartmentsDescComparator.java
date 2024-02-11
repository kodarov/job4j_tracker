package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        if (leftArray[0].compareTo(rightArray[0]) != 0) {
            return rightArray[0].compareTo(leftArray[0]);
        }
        return left.compareTo(right);
    }
}