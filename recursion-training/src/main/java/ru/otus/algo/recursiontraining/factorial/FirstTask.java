package ru.otus.algo.recursiontraining.factorial;

public class FirstTask {

    public int printFromOneToN(int n) {
        if (n == 1) {
            System.out.println(1);
            return 1;
        }
        System.out.println(n);
        return printFromOneToN(n - 1);
    }
}
