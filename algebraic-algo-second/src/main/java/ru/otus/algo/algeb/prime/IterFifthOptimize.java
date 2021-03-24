package ru.otus.algo.algeb.prime;

public class IterFifthOptimize extends PrimeNumFinder {

    @Override
    boolean isPrime(int number) {
        if (number == 2) {
            return true;
        } else if ((number & 1) == 0) {
            return false;
        }
        int sqr = (int) Math.sqrt(number);
        for (int i = 3; i <= sqr; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
