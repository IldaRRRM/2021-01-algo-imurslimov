package ru.otus.algo.basestruct;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SingleArrayTest {

    private final Integer[] testArray = new Integer[]{4, 5, 6, 7, 8};
    private final Integer[] emptyArray = new Integer[14];

    @Test
    void whenAddItemToMiddleOfArrayThenItemShouldBeAdded() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        integerSingleArray.add(34, 11);
        final Object[] array = integerSingleArray.getArray();
        final Integer result = (Integer) array[11];
        assertThat(result).isEqualTo(34);
    }

    @Test
    void whenAddAElementToArrayThenElementShouldIncludeToArray() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        integerSingleArray.add(31, 4);
        final Object[] array = integerSingleArray.getArray();
        final Integer result = (Integer) array[4];
        assertThat(result).isEqualTo(31);
    }

    @Test
    void whenAddItemToArrayWithoutIndexAndHeShouldAddToLastIndexOfArray() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        integerSingleArray.add(128);
        final Integer result = integerSingleArray.getItem(5);
        assertThat(result).isEqualTo(128);
    }

    @Test
    void whenToDeleteElementAndHeExistsAndMethodDeleteItemFromArrayAndReturnDeletedElement() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        final Integer remove = integerSingleArray.remove(1);

        assertThat(remove).isEqualTo(5);
        assertThat(integerSingleArray.getItem(1)).isEqualTo(6);

    }

    @Test
    void whenArrayIsNotEmptyShouldReturnTrue() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        assertThat(integerSingleArray.isEmpty()).isTrue();
    }

    @Test
    void whenArrayIsEmptyShouldReturnFalse() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, emptyArray);
        assertThat(integerSingleArray.isEmpty()).isFalse();
    }

    @Test
    void testTimeWhenWeInsertAtTheBeginningOfAnArray() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        final long start = System.currentTimeMillis();
        final int elements = 10_000;
        for (int i = 0; i < elements; i++) {
            integerSingleArray.add(56, 0);
        }
        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);

        for (int i = 0; i < integerSingleArray.getArray().length; i++) {
            System.out.println(integerSingleArray.getArray()[i]);

        }

    }

    @Test
    void testTimeWhenWeDeleteFromBeginningOfArray() {
        final SingleArray<Integer> integerSingleArray = new SingleArray<>(Integer.class, testArray);
        final int elements = 10_000;
        for (int i = 0; i < elements; i++) {
            integerSingleArray.add(56, 0);
        }
        final long start = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            integerSingleArray.remove(integerSingleArray.size - 1);
        }
        log.info("Add Time for {} elements {}", elements, System.currentTimeMillis() - start);
    }
}