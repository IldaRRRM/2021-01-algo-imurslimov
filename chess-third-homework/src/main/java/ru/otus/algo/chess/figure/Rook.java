package ru.otus.algo.chess.figure;

import ru.otus.algo.chess.service.BitsFigureMoveToBorder;

import java.math.BigInteger;

public class Rook extends FigureBits implements BitsFigureMoveToBorder {

    public static final int LEFT_SHIFT_TO_UP = 8;

    public static final int LEFT_SHIFT_TO_RIGHT_BORDER = 1;
    public static final int RIGHT_SHIFT_TO_LEFT_BORDER = 1;

    public static final int RIGHT_SHIFT_TO_THE_BOTTOM_PART = 8;


    @Override
    public BigInteger getPossibleMovesBits(Number startPosition) {
        final BigInteger rookStartPosition = getBitsFigureStartPosition(startPosition);

        final BigInteger movesToUpBorder = getShiftLeftToTheBorder(
                rookStartPosition,
                LEFT_SHIFT_TO_UP,
                null
        );

        final BigInteger movesToRightBorder = getShiftLeftToTheBorder(
                rookStartPosition,
                LEFT_SHIFT_TO_RIGHT_BORDER,
                excludeHcolumn
        );

        final BigInteger movesToBottomBorder = getShiftRightToTheBorder(
                rookStartPosition,
                RIGHT_SHIFT_TO_THE_BOTTOM_PART,
                null
        );

        final BigInteger movesToLeftBorder = getShiftRightToTheBorder(
                rookStartPosition,
                RIGHT_SHIFT_TO_LEFT_BORDER,
                excludeAcolumn
        );

        return movesToUpBorder
                .or(movesToBottomBorder)
                .or(movesToLeftBorder)
                .or(movesToRightBorder);
    }

}
