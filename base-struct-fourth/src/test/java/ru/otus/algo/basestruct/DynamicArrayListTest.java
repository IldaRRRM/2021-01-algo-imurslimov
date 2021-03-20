package ru.otus.algo.basestruct;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class DynamicArrayListTest {

    private final Integer[] testArray = new Integer[]{4, 5, 6, 7, 8};

    @Test
    void testTimeAdd() {
        final ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(testArray));
        final int elements = 100_000;

        final long start = System.currentTimeMillis();

        for (int i = 0; i < elements; i++) {
            integers.add(1);
        }

        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);

    }

    @Test
    void removeArray() {
        final ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(testArray));
        final int elements = 100_000;

        for (int i = 0; i < elements; i++) {
            integers.add(1);
        }

        final long start = System.currentTimeMillis();

        for (int i = 0; i < elements; i++) {
            integers.remove(integers.size() - 1);
        }

        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);

    }
}
