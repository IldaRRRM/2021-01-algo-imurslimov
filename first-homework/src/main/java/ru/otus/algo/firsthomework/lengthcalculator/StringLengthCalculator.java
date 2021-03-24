package ru.otus.algo.firsthomework.lengthcalculator;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.Arrays;
import java.util.List;

public class StringLengthCalculator implements TestExecutable<Integer> {

    @Override
    public Integer execute(List<String> input) {
        return input.get(0).toString().length();
    }
}
