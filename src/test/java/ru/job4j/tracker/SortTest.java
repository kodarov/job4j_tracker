package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.utils.ItemAscByName;
import ru.job4j.tracker.utils.ItemDescByName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {
    @Test
    void whenSortItemsAscByNameThenSuccessful() {
        List<Item> result = Arrays.asList(
                new Item(3, "Gggg"),
                new Item(1, "Aaaa"),
                new Item(2, "Bbbb")
        );
        result.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Aaaa"),
                new Item(2, "Bbbb"),
                new Item(3, "Gggg")
        );
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenSortItemsDescByNameThenSuccessful() {
        List<Item> result = Arrays.asList(
                new Item(3, "Gggg"),
                new Item(1, "Aaaa"),
                new Item(2, "Bbbb")
        );
        result.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "Gggg"),
                new Item(2, "Bbbb"),
                new Item(1, "Aaaa")
        );
        assertThat(result).isEqualTo(expected);
    }
}
