package ru.otus.algo.testframe.service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import ru.otus.algo.testframe.model.TestData;

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
                if (fileName.endsWith(String.valueOf(testNumber).concat(".in"))) {
                    try (Stream<String> inputDataStream = Files.lines(inputNext)) {
                        String inputData = inputDataStream.findFirst().orElse("");
                        Path expectedDataNext = iterator.next();
                        String expectedFileName = expectedDataNext.getFileName().toString();
                        if (expectedFileName.endsWith(String.valueOf(testNumber).concat(".out"))) {
                            try (Stream<String> expectedDataStream = Files.lines(expectedDataNext)) {
                                String expectedResult = expectedDataStream.findFirst().orElse("");
                                allTestData.put(testNumber, new TestData(inputData, expectedResult));
                                testNumber++;
                            }
                        }
                    }
                }
            }
        }
        return allTestData;
    }

}
