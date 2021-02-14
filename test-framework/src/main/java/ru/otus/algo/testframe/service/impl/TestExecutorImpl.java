package ru.otus.algo.testframe.service.impl;

import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;
import ru.otus.algo.testframe.model.TestData;
import ru.otus.algo.testframe.service.TestDataReader;
import ru.otus.algo.testframe.service.TestExecutable;
import ru.otus.algo.testframe.service.TestExecutor;

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
        final Object expectedResult = testDataMap.get(key).getExpectedResult();
        final boolean testResult = new EqualsBuilder().append(result.toString(), expectedResult.toString()).isEquals();
        log.info("Фактический результат теста №{}: {}. Время нахождения факт. рез-та : {} мс {}" +
                "Ожидаемый результат : {} "
            , key, result, endTime, System.lineSeparator(), expectedResult);

        if (!testResult) {
            throw new AssertionError(String.format("Ошибка в тесте № %d" + System.lineSeparator() +
                            "ожидаемый результат = %s" +
                            System.lineSeparator() +
                            "актуальный результат = %s",
                    key, expectedResult.toString(), result.toString()));
        }
    }
}
