package ru.otus.algo.chess;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.algo.chess.figure.Bishop;
import ru.otus.algo.chess.figure.King;
import ru.otus.algo.chess.figure.Knight;
import ru.otus.algo.chess.figure.Queen;
import ru.otus.algo.chess.figure.Rook;
import ru.otus.algo.testframe.service.TestExecutable;
import ru.otus.algo.testframe.service.impl.TestExecutorImpl;

import java.io.IOException;
import java.util.stream.Stream;

public class BitsChessFigureTest {

    private static final String SRC_TEST_RESOURCES = "src/test/resources";
    TestExecutorImpl testExecutor = new TestExecutorImpl();

    @ParameterizedTest
    @MethodSource("providePathAndBitsFigures")
    public void whenReadTestDataFromPathExecuteTestsAndValidateActualAndExpectResults(String path, TestExecutable<?> testExecutable) throws IOException {
        testExecutor.execute(path, testExecutable);
    }

    private static Stream<Arguments> providePathAndBitsFigures() {
        return Stream.of(
                Arguments.of(SRC_TEST_RESOURCES.concat("/king"), new King()),
                Arguments.of(SRC_TEST_RESOURCES.concat("/knight"), new Knight()),
                Arguments.of(SRC_TEST_RESOURCES.concat("/bishop"), new Bishop()),
                Arguments.of(SRC_TEST_RESOURCES.concat("/rook"), new Rook()),
                Arguments.of(SRC_TEST_RESOURCES.concat("/queen"), new Queen())

        );
    }

}