package ru.otus.algo.algeb.fibo;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.List;

public class RecFibo implements TestExecutable<Long> {

    public long fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    @Override
    public Long execute(List<String> input) {
        return fib(Integer.parseInt(input.get(0)));
    }
}
