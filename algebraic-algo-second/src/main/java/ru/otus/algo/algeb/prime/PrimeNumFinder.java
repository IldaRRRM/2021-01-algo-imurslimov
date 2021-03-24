package ru.otus.algo.algeb.prime;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.List;

public abstract class PrimeNumFinder implements TestExecutable<Integer> {

    public int getPrimeNumbers(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    abstract boolean isPrime(int number);

    @Override
    public Integer execute(List<String> input) {
        return getPrimeNumbers(Integer.parseInt(input.get(0)));
    }
}
