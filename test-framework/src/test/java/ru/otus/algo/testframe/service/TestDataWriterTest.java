package ru.otus.algo.testframe.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.algo.testframe.model.TestData;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TestDataWriterTest {

	private static final TestDataWriter testDataWriter = new TestDataWriter();

	@ParameterizedTest
	@MethodSource("providePathAndExpectedSize")
	void whenWriteAllTestDataFromDirAndCheckThatSizeIsCorrect(String input, int expectedSize) throws IOException {
		Map<Integer, TestData> allTestData = testDataWriter.writeAllTestData(input);
		assertThat(allTestData.keySet().size()).isEqualTo(expectedSize);
	}

	private static Stream<Arguments> providePathAndExpectedSize() {
		return Stream.of(
				Arguments.of("src/main/resources/0.String", 5),
				Arguments.of("src/main/resources/1.Tickets", 10)
		);
	}
}