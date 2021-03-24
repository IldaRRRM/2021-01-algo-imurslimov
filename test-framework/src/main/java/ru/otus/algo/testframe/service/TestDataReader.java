package ru.otus.algo.testframe.service;

import ru.otus.algo.testframe.model.TestData;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestDataReader {

    /**
     * Получить тестовые данные из директории
     *
     * @param pathToTestFolder относительный путь до директории
     * @return мапа, где ключ - номер теста. А value - объект, содержащий в себе вводные данные и ожидаемый результат
     */
    public Map<Integer, TestData> readAllTestData(String pathToTestFolder) throws IOException {
        Map<Integer, TestData> allTestData = new HashMap<>();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(Path.of(pathToTestFolder))) {
            Iterator<Path> iterator = paths.iterator();
            int testNumber = 0;
            while (iterator.hasNext()) {
                Path inputNext = iterator.next();
                String fileName = inputNext.getFileName().toString();
                if (fileName.endsWith(".in")) {

                    final List<String> inputData = collectData(inputNext);

                    Path expectedDataNext = iterator.next();
                    String expectedFileName = expectedDataNext.getFileName().toString();

                    if (expectedFileName.endsWith(".out")) {
                        final List<String> expectedDate = collectData(expectedDataNext);
                        allTestData.put(testNumber, new TestData(inputData, expectedDate));
                    }
                    testNumber++;
                }
            }
        }
        return allTestData;

    }

    private List<String> collectData(Path path) throws IOException {
        List<String> inputData = new ArrayList<>();
        try (Stream<String> inputDataStream = Files.lines(path)) {
            inputDataStream.forEach(inputData::add);
            return inputData;
        }
    }

}
