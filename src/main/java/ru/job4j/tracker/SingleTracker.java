package ru.job4j.tracker;

import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.entity.Tracker;

public final class SingleTracker {

    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static Tracker getTracker() {
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}