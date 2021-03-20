package ru.otus.algo.basestruct.queue;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

class ItemListTest {

    @Test
    void whenAddItemToListThenHeShouldBeAdded() {
        ItemList<Integer> integers = new ItemList<>();
        integers.add(1);
        integers.add(2);

        final Iterator<Integer> iterator = integers.iterator();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
    }

    @Test
    void whenPullFirstElementShouldBeReturnedFirstElement() {
        ItemList<Integer> integers = new ItemList<>();
        integers.add(67);
        integers.add(89);

        assertThat(integers.pull()).isEqualTo(67);
        assertThat(integers.getRoot().getValue()).isEqualTo(89);
    }
}