package ru.otus.algo.chess.figure;

import java.math.BigInteger;

public class King extends FigureBits {

	@Override
	public BigInteger getPossibleMovesBits(Number startPosition) {
		BigInteger kingPosition = getBitsFigureStartPosition(startPosition);

		BigInteger kingPositionExcludeLeftColumn = kingPosition.and(excludeAcolumn);
		BigInteger kingPositionExcludeRightColumn = kingPosition.and(excludeHcolumn);

		return (treatBigInteger(kingPositionExcludeLeftColumn.shiftLeft(7))).or(treatBigInteger(kingPosition.shiftLeft(8)))
				.or(treatBigInteger(kingPositionExcludeRightColumn.shiftLeft(9)))
				.or(treatBigInteger(kingPositionExcludeLeftColumn.shiftRight(1)))
				.or(treatBigInteger(kingPositionExcludeRightColumn.shiftLeft(1)))
				.or(treatBigInteger(kingPositionExcludeLeftColumn.shiftRight(9)))
				.or(treatBigInteger(kingPosition.shiftRight(8)))
				.or(treatBigInteger(kingPositionExcludeRightColumn.shiftRight(7)));
	}
}
