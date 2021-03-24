package ru.otus.algo.algeb.fibo;

import ru.otus.algo.testframe.service.TestExecutable;

import java.math.BigInteger;
import java.util.List;

public class LinFib implements TestExecutable<BigInteger> {

    public BigInteger linFib(int n) {
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ZERO;

        if (n == 1) {
            return f1;
        }

        for (int i = 2; i <= n; i++) {
            f2 = f1.add(f0);
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    @Override
    public BigInteger execute(List<String> input) {
        return linFib(Integer.parseInt(input.get(0)));
    }
}
