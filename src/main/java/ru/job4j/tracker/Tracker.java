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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            return true;
        }
        return false;
    }
}