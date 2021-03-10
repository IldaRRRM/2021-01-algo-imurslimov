package ru.otus.algo.basestruct;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class FactorArrayTest {

    private final Integer[] testArray = new Integer[]{4, 5, 6, 7, 8};

    @Test
    void testTimeAdd() {
        final FactorArray<Integer> vectorArray = new FactorArray<>(Integer.class, testArray, 50);
        final int elements = 100_000;

        final long start = System.currentTimeMillis();

        for (int i = 0; i < elements; i++) {
            vectorArray.add(1);
        }

        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);

    }

    @Test
    void removeArray() {
        final FactorArray<Integer> vectorArray = new FactorArray<>(Integer.class, testArray, 50);
        final int elements = 100_000;

        for (int i = 0; i < elements; i++) {
            vectorArray.add(1);
        }

        final long start = System.currentTimeMillis();

        for (int i = 0; i < elements; i++) {
            vectorArray.remove(5);
        }

        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);
    }

}