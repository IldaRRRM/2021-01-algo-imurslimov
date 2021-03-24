package ru.otus.algo.algeb.prime;

public class IterSixthOptimize extends PrimeNumFinder {

    private int[] primes;

    @Override
    public int getPrimeNumbers(int n) {
        int count = 0;
        this.primes = new int[n];

        if (n >= 2) {
            primes[count++] = 2;
        }

        for (int i = 3; i <= n; i += 2) {
            if (isPrime(i)) {
                this.primes[count++] = i;
            }
        }
        return count;
    }

    @Override
    boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);
        for (int i = 0; primes[i] <= sqrt; i++) {
            if (number % primes[i] == 0) {
                return false;
            }
        }
        return true;
    }

}
