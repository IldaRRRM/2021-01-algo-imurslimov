package ru.otus.algo.firsthomework.tickets;

import org.junit.jupiter.api.Test;
import ru.otus.algo.testframe.service.impl.TestExecutorImpl;

import java.io.IOException;

public class HappyTicketsTest {

    private final TestExecutorImpl testExecutor = new TestExecutorImpl();

    @Test
    public void testStringLength() throws IOException {
        testExecutor.execute("src/test/resources/1.Tickets", new HappyTickets());
    }
}