package ru.otus.algo.algeb.power;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.List;

public class PowerByDecomposition implements TestExecutable<Double> {

    public Double powerByDecomposition(Double initial, long power) {
        double result = 1;
        while (power > 0) {
            if ((power & 1) != 0) {
                result *= initial;
            }
            initial *= initial;
            power >>= 1;
        }
        return result;
    }

    @Override
    public Double execute(List<String> input) {
        return powerByDecomposition(Double.parseDouble(input.get(0)), Long.parseLong(input.get(1)));
    }
}
