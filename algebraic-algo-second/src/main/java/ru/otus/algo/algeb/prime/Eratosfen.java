package ru.otus.algo.algeb.prime;

public class Eratosfen extends PrimeNumFinder {

    @Override
    public int getPrimeNumbers(int n) {
        boolean[] divs = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!(divs[i])) {
                count++;
                for (long j = (long) i * i; j <= n; j += i) {
                    divs[Math.toIntExact(j)] = true;
                }
            }
        }
        return count;
    }

    @Override
    boolean isPrime(int number) {
        throw new UnsupportedOperationException();
    }
}
