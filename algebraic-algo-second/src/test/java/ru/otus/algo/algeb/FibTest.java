package ru.otus.algo.algeb;

import org.junit.jupiter.api.Test;
import ru.otus.algo.algeb.fibo.GoldFib;
import ru.otus.algo.algeb.fibo.LinFib;
import ru.otus.algo.algeb.fibo.RecFibo;
import ru.otus.algo.testframe.service.impl.TestExecutorImpl;

import java.io.IOException;

public class FibTest {

    private final TestExecutorImpl testExecutor = new TestExecutorImpl();

    @Test
    public void whenFindFibByLinFibThenShouldLineOn() throws IOException {
        testExecutor.execute("src/test/resources/4.Fibo", new LinFib());
    }

    @Test
    public void whenFindFibByRecursionAlgoThenShouldGetExpoN() throws IOException {
        testExecutor.execute("src/test/resources/4.Fibo", new RecFibo());
    }

    @Test
    public void whenFindFibByGoldThenShouldGetPowAndSqrtN() throws IOException {
        testExecutor.execute("src/test/resources/4.Fibo", new GoldFib());
    }
}