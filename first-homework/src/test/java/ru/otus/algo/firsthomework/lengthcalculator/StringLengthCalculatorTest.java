package ru.otus.algo.firsthomework.lengthcalculator;

import org.junit.jupiter.api.Test;
import ru.otus.algo.testframe.service.impl.TestExecutorImpl;

import java.io.IOException;

class StringLengthCalculatorTest {

    private final TestExecutorImpl testExecutor = new TestExecutorImpl();

    @Test
    public void testStringLength() throws IOException {
        testExecutor.execute("src/test/resources/0.String", new StringLengthCalculator());
    }
}