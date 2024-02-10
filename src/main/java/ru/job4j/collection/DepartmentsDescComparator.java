package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        List<String> leftList = new ArrayList<>(Arrays.asList(left.split("/")));
        List<String> rightList = new ArrayList<>(Arrays.asList(right.split("/")));
        for (int i = 0; i < Math.min(rightList.size(), leftList.size()); i++) {
            if (!leftList.get(0).equals(rightList.get(0))) {
                return rightList.get(0).compareTo(leftList.get(0));
            }
            if (leftList.get(i).equals(rightList.get(i))) {
                continue;
            }
            return leftList.get(i).compareTo(rightList.get(i));
        }
        return Integer.compare(left.length(), right.length());
    }
}