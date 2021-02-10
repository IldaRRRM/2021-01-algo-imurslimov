package ru.otus.algo.firsthomework.tickets;

import ru.otus.algo.testframe.service.TestExecutable;

import java.util.Arrays;
import java.util.List;

public class HappyTickets implements TestExecutable<Long> {

    public long getHappyTicketsCount(int n) {
        int resultN = 2 * n;
        int possibleNumbersSum = n * 9;
        return getSum(resultN, possibleNumbersSum);
    }

    /*
     * Формула для подсчёта количества счастливых билетов
     *          9
     * Nn(k) = 	∑ Nn–1(k – l);
     *        l = 0
     */

    private long getSum(int n, int k) {
        long sum = 0;
        if (n > 1) {
            for (int l = 0; l < 10; l++) {
                sum += getSum(n - 1, k - l);
            }
        } else {
            if (k >= 0 && k <= 9) {
                sum += 1;
            }
        }
        return sum;
    }

    @Override
    public Long execute(Object... object) {
        final List<Object> objects = Arrays.asList(object);
        if (objects.size() == 1) {
            final int inputTicketNumber = Integer.parseInt(objects.get(0).toString());
            return getHappyTicketsCount(inputTicketNumber);
        }
        throw new UnsupportedOperationException();
    }
}
