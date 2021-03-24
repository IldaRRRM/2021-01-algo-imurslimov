package ru.otus.algo.testframe.service;

import java.util.List;

public interface TestExecutable<E> {

    E execute(List<String> input);

}
