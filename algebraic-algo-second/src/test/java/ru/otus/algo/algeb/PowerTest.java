package ru.otus.algo.algeb;

import org.junit.jupiter.api.Test;
import ru.otus.algo.algeb.power.LinPower;
import ru.otus.algo.algeb.power.PowerByDecomposition;
import ru.otus.algo.algeb.power.PowerByTwo;
import ru.otus.algo.testframe.service.impl.TestExecutorImpl;

import java.io.IOException;

class PowerTest {

    private final TestExecutorImpl testExecutor = new TestExecutorImpl();

    @Test
    public void test() throws IOException {
        testExecutor.execute("src/test/resources/3.Power", new LinPower());
    }

    @Test
    public void powerUpByTwo() throws IOException {
        final PowerByTwo powerByTwo = new PowerByTwo();
        powerByTwo.powerUpByTwo(2.0, 10);
        testExecutor.execute("src/test/resources/3.Power", new PowerByTwo());
    }

    @Test
    public void powerByDecomposition() throws IOException {
        testExecutor.execute("src/test/resources/3.Power", new PowerByDecomposition());
    }


}