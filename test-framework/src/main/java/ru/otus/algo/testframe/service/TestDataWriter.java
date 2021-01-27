package ru.otus.algo.testframe.service;

import ru.otus.algo.testframe.model.TestData;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestDataWriter {

	/**
	 * Получить тестовые данные из директории
	 *
	 * @param pathToTestFolder относительный путь до директории
	 * @return мапа, где ключ - номер теста. А value - объект, содержащий в себе вводные данные и ожидаемый результат
	 */
	public Map<Integer, TestData> writeAllTestData(String pathToTestFolder) throws IOException {
		Map<Integer, TestData> allTestData = new HashMap<>();
		DirectoryStream<Path> paths = Files.newDirectoryStream(Path.of(pathToTestFolder));
		Iterator<Path> iterator = paths.iterator();
		int testNumber = 0;
		while (iterator.hasNext()) {
			Path inputNext = iterator.next();
			String fileName = inputNext.getFileName().toString();
			if (fileName.endsWith(String.valueOf(testNumber).concat(".in"))) {
				String inputData = Files.lines(inputNext).findFirst().orElse("");
				Path expectedDataNext = iterator.next();
				String expectedFileName = expectedDataNext.getFileName().toString();
				if (expectedFileName.endsWith(String.valueOf(testNumber).concat(".out"))) {
					String expectedResult = Files.lines(expectedDataNext).findFirst().orElse("");
					allTestData.put(testNumber, new TestData(inputData, expectedResult));
					testNumber++;
				}
			}
		}
		paths.close();
		return allTestData;
	}
}
