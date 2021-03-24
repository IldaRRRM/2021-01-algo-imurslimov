package ru.otus.algo.algeb.fibo;

import ru.otus.algo.algeb.power.PowerByDecomposition;
import ru.otus.algo.testframe.service.TestExecutable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class GoldFib implements TestExecutable<BigInteger> {

    public static final double GOLD_FI = 1.618;
    private final PowerByDecomposition powerByDecomposition = new PowerByDecomposition();

    public BigInteger fib(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return BigInteger.ONE;
        }
        final double v = powerByDecomposition.powerByDecomposition(GOLD_FI, n) / Math.sqrt(5) + 0.5;
        return BigDecimal.valueOf(v).toBigInteger();
    }

    @Override
    public BigInteger execute(List<String> input) {
        return fib(Integer.parseInt(input.get(0)));
    }
}
