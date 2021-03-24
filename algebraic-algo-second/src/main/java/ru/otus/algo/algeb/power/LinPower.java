package ru.otus.algo.algeb.power;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.List;

public class LinPower implements TestExecutable<Double> {

    public double linPower(double initial, long power) {

        double result = initial;

        if (power == 0) {
            return 1;
        }

        for (int i = 1; i < power; i++) {
            result *= initial;
        }

        return result;
    }

    @Override
    public Double execute(List<String> input) {
        return linPower(Double.parseDouble(input.get(0)), Long.parseLong(input.get(1)));
    }
}
