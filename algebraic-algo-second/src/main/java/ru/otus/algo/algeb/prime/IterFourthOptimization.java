package ru.otus.algo.algeb.prime;

public class IterFourthOptimization extends PrimeNumFinder {

    @Override
    boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
