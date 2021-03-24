package ru.otus.algo.algeb.prime;

public class IterNoOptimize extends PrimeNumFinder {

    public boolean isPrime(int number) {
        int q = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                q++;
            }
        }
        return q == 2;
    }
}
