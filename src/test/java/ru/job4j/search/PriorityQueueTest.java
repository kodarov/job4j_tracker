package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityEquals() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("low");
    }

    @Test
    public void whenHigherPriorityThenUrgent1() {
        var queue = new PriorityQueue();
        queue.put(new Task("low1", 5));
        queue.put(new Task("low2", 5));
        queue.put(new Task("middle1", 3));
        queue.put(new Task("low3", 5));
        queue.put(new Task("urgent1", 1));
        queue.put(new Task("middle2", 3));
        queue.put(new Task("urgent2", 1));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent1");
    }

    @Test
    public void whenHigherPriorityThenFirst() {
        var queue = new PriorityQueue();
        queue.put(new Task("urgent", 10));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }
}