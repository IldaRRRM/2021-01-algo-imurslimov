package ru.otus.algo.chess.figure;

import ru.otus.algo.chess.service.ChessBigIntegerHandler;
import ru.otus.algo.testframe.service.TestExecutable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FigureBits implements TestExecutable<List<String>>, ChessBigIntegerHandler {

    protected final BigInteger excludeAcolumn = new BigInteger("18374403900871474942");
    protected final BigInteger excludeHcolumn = new BigInteger("9187201950435737471");
    protected final BigInteger excludeBcolumn = new BigInteger("18302063728033398269");
    protected final BigInteger excludeGcolumn = new BigInteger("13816973012072644543");

    public abstract BigInteger getPossibleMovesBits(Number startPosition);

    public int getPossibleMoveCount(BigInteger movesBits) {
        int count = 0;
        BigInteger movesBitsCopy = movesBits;
        while (movesBitsCopy.compareTo(BigInteger.ZERO) > 0) {
            if (movesBitsCopy.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                count++;
            }
            movesBitsCopy = movesBitsCopy.shiftRight(1);
        }
        return count;
    }

    public List<String> getPossibleMoveCountAndMoveBits(Number startPosition) {
        List<String> result = new ArrayList<>();
        BigInteger possibleMovesBits = getPossibleMovesBits(startPosition);
        int possibleMoveCount = getPossibleMoveCount(possibleMovesBits);

        result.add(String.valueOf(possibleMoveCount));
        result.add(String.valueOf(possibleMovesBits));

        return result;
    }

    @Override
    public List<String> execute(Object... object) {
        final List<Object> objects = Arrays.asList(object);
        if (objects.size() == 1) {
            final int startPosition = Integer.parseInt(objects.get(0).toString());
            return getPossibleMoveCountAndMoveBits(startPosition);
        }
        throw new UnsupportedOperationException();
    }

    protected BigInteger getBitsFigureStartPosition(Number startPosition) {
        return BigInteger.ONE.shiftLeft(startPosition.intValue());
    }

}
