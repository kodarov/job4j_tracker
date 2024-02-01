package ru.job4j.tracker;

import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.entity.Tracker;

import java.util.Collection;

public final class SingleTracker {
    private Tracker tracker = new Tracker();

    private static SingleTracker singleTracker;

    private SingleTracker() {
    }

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Collection<Item> findAll() {
        return tracker.findAll();
    }

    public Collection<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}