package ru.otus.algo.algeb.prime;

import org.junit.jupiter.api.Test;
import ru.otus.algo.testframe.service.TestExecutor;
import ru.otus.algo.testframe.service.impl.TestExecutorImpl;

import java.io.IOException;

class PrimeNumberTest {
    TestExecutor testExecutor = new TestExecutorImpl();

    @Test
    public void nonOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterNoOptimize());
    }

    @Test
    public void firstOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterFirstOptimize());
    }

    @Test
    public void secondOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterSecondOptimize());
    }

    @Test
    public void thirdOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterThirdOptimize());
    }

    @Test
    public void fourthOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterFourthOptimization());
    }

    @Test
    public void fifthOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterFifthOptimize());
    }

    @Test
    public void sixthOptimize() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new IterSixthOptimize());
    }

    @Test
    public void eratosfen() throws IOException {
        testExecutor.execute("src/test/resources/5.Primes", new Eratosfen());
    }

}