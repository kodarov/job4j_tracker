package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int index = 0;
        Item[] allItems = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                allItems[index] = items[i];
                index++;
            }
        }
        allItems = Arrays.copyOf(allItems, index);
        return allItems;
    }

    public Item[] findByName(String key) {
        int index = 0;
        Item[] findItems = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                findItems[index] = items[i];
                index++;
            }
        }
        findItems = Arrays.copyOf(findItems, index);
        return findItems;
    }
}