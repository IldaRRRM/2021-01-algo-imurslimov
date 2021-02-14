package ru.otus.algo.firsthomework.lengthcalculator;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.Arrays;
import java.util.List;

public class StringLengthCalculator implements TestExecutable<Integer> {

    @Override
    public Integer execute(Object... object) {
        final List<Object> objects = Arrays.asList(object);
        if (objects.size() == 1) {
            return objects.get(0).toString().length();
        }
        throw new UnsupportedOperationException();
    }
}
