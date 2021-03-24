package ru.otus.algo.testframe.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;
import ru.otus.algo.testframe.model.TestData;
import ru.otus.algo.testframe.service.TestDataReader;
import ru.otus.algo.testframe.service.TestExecutable;
import ru.otus.algo.testframe.service.TestExecutor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class TestExecutorImpl implements TestExecutor {

	private final TestDataReader testDataReader = new TestDataReader();

	@Override
	public void execute(String path, TestExecutable<?> testExecutable) throws IOException {
		final Map<Integer, TestData> testDataMap = testDataReader.readAllTestData(path);
		testDataMap
				.keySet()
				.forEach(key -> getTestResult(key, testExecutable, testDataMap));
		log.info("Все тесты выполнились успешно");
	}


	private void getTestResult(Integer key, TestExecutable<?> testExecutable, Map<Integer, TestData> testDataMap) {
		final long start = System.currentTimeMillis();
		final Object result = testExecutable
				.execute(testDataMap.get(key).getInputData());
		final long endTime = System.currentTimeMillis() - start;
		final List<String> expectedResult = testDataMap.get(key).getExpectedResult();
		boolean testResult;
		if (result instanceof List) {
			List<String> resultList = (List<String>) result;
			for (int i = 0; i < resultList.size(); i++) {
				testResult = new EqualsBuilder().append(resultList.get(i), expectedResult.get(i)).isEquals();
				checkAssertException(key, resultList.get(i), expectedResult.get(i), testResult);
				logTestResult(key, resultList.get(i), endTime, expectedResult.get(i));
			}
		} else {
			testResult = new EqualsBuilder().append(result.toString(), expectedResult.get(0)).isEquals();
			checkAssertException(key, result, expectedResult, testResult);
			logTestResult(key, result, endTime, expectedResult);
		}

	}

	private void logTestResult(Integer key, Object result, long endTime, Object expectedResult) {
		log.info("Фактический результат теста №{}: {}. Время нахождения факт. рез-та : {} мс {}" +
						"Ожидаемый результат : {} "
				, key, result, endTime, System.lineSeparator(), expectedResult);
	}

	private void checkAssertException(Integer key, Object result, Object expectedResult, boolean testResult) {
		if (!testResult) {
			throw new AssertionError(String.format("Ошибка в тесте № %d" + System.lineSeparator() +
							"ожидаемый результат = %s" +
							System.lineSeparator() +
							"актуальный результат = %s",
					key, expectedResult.toString(), result.toString()
			));
		}
	}

}
