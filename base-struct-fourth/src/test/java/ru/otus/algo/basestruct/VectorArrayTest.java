package ru.otus.algo.basestruct;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class VectorArrayTest {

    private final Integer[] testArray = new Integer[]{4, 5, 6, 7, 8};

    @Test
    void testTimeWhenWeInsertAtTheBeginningOfAnArray() {
        final VectorArray<Integer> vectorArray = new VectorArray<>(Integer.class, testArray);
        final int elements = 10_000;
        for (int i = 0; i < elements; i++) {
            vectorArray.add(1);
        }
        final long start = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            vectorArray.remove(vectorArray.size - 1);
        }
        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);

    }

    @Test
    void testTimeAdd() {
        final VectorArray<Integer> vectorArray = new VectorArray<>(Integer.class, testArray);
        final int elements = 10_000;

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