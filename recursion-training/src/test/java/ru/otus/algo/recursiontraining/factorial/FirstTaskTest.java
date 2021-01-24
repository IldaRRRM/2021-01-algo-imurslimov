package ru.otus.algo.recursiontraining.factorial;

import org.junit.jupiter.api.Test;

class FirstTaskTest {

    private final FirstTask firstTask = new FirstTask();

    @Test
    void printFromOneToN() {
        firstTask.printFromOneToN(1024);
    }
}