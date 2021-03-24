package ru.otus.algo.firsthomework.tickets;

import java.util.List;
import ru.otus.algo.testframe.service.TestExecutable;

public class HappyTickets implements TestExecutable<Long> {

    public long getHappyTicketsCount(int n) {
        int resultN = 2 * n;
        int possibleNumbersSum = n * 9;
        return getHappyTicketCount(resultN, possibleNumbersSum);
    }

    /*
     * Формула для подсчёта количества счастливых билетов
     *          9
     * Nn(k) = 	∑ Nn–1(k – l);
     *        l = 0
     */

    private long getHappyTicketCount(int digitN, int sumOfNumbers) {
        long happyTicketCount = 0;
        if (digitN > 1) {
            for (int possibleNumber = 0; possibleNumber < 10; possibleNumber++) {
                happyTicketCount += getHappyTicketCount(digitN - 1, sumOfNumbers - possibleNumber);
            }
        } else {
            if (sumOfNumbers >= 0 && sumOfNumbers <= 9) {
                happyTicketCount += 1;
            }
        }
        return happyTicketCount;
    }

    @Override
    public Long execute(List<String> input) {
        final int inputTicketNumber = Integer.parseInt(input.get(0));
        return getHappyTicketsCount(inputTicketNumber);
    }
}
