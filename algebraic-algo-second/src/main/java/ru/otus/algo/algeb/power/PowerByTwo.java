package ru.otus.algo.algeb.power;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.List;

public class PowerByTwo implements TestExecutable<Double> {

    public Double powerUpByTwo(Double initial, long power) {
        if (power == 0) {
            return 1.0;
        }
        long currentPower = 2;
        Double result = initial;

        while (currentPower <= power) {
            result *= result;
            if (currentPower == power) {
                return result;
            }
            currentPower <<= 1;
        }

        currentPower >>= 1;
        for (int i = 0; i < power - currentPower; i++) {
            result *= initial;
        }
        return result;
    }

    @Override
    public Double execute(List<String> input) {
        return powerUpByTwo(Double.parseDouble(input.get(0)), Long.parseLong(input.get(1)));
    }

    private double getTemp(double temp, int i, double initial) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return initial;
        } else {
            return temp;
        }
    }
}
