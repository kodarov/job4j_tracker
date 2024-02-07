package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        List<Character> leftList = new ArrayList<>(size);
        List<Character> rightList = new ArrayList<>(size);
        for (int i = 0; i < left.length(); i++) {
            leftList.add(left.charAt(i));
        }
        for (int i = 0; i < right.length(); i++) {
            rightList.add(right.charAt(i));
        }
        for (int i = 0; i < size; i++) {

            if (Character.compare(leftList.get(i), rightList.get(i)) < 0) {
                return -1;
            }
            if (Character.compare(leftList.get(i), rightList.get(i)) > 0) {
                return 1;
            }
        }
        if (Integer.compare(leftList.size(), rightList.size()) < 0) {
            return -1;
        }
        return 0;
    }
}