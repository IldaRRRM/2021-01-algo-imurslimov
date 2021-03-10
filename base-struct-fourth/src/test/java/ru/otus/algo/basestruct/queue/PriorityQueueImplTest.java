package ru.otus.algo.basestruct.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriorityQueueImplTest {

    @Test
    public void whenAddItemWithHighestAndLowestPriorityThenTheyShouldBeAddToItemLists() {
        final PriorityQueueImpl<Integer> integerPriorityQueue = new PriorityQueueImpl<>(10);

        integerPriorityQueue.enqueue(10, 7);
        integerPriorityQueue.enqueue(2, 2);
        integerPriorityQueue.enqueue(2, 2);
        integerPriorityQueue.enqueue(1, 9);
        integerPriorityQueue.enqueue(1, 8);
        integerPriorityQueue.enqueue(1, 7);

        assertThat(integerPriorityQueue.dequeue()).isEqualTo(9);
        assertThat(integerPriorityQueue.dequeue()).isEqualTo(8);
        assertThat(integerPriorityQueue.dequeue()).isEqualTo(7);
        assertThat(integerPriorityQueue.dequeue()).isEqualTo(2);
        assertThat(integerPriorityQueue.dequeue()).isEqualTo(2);
        assertThat(integerPriorityQueue.dequeue()).isEqualTo(7);
    }
}