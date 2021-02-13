package ru.otus.algo.testframe.service;

import java.io.IOException;

public interface TestExecutor {

    void execute(String path, TestExecutable<?> testExecute) throws IOException;
}
