package ru.otus.algo.chess.figure;

import java.math.BigInteger;

public class Knight extends FigureBits {

	@Override
	public BigInteger getPossibleMovesBits(Number startPosition) {
		BigInteger knightPosition = getBitsFigureStartPosition(startPosition);

		final BigInteger knightPositionExcludeAcolumn = excludeAcolumn.and(knightPosition);
		final BigInteger knightPositionExcludeBcolumn = excludeBcolumn.and(knightPosition);
		final BigInteger knightPositionExcludeHcolumn = excludeHcolumn.and(knightPosition);
		final BigInteger knightPositionExcludeGcolumn = excludeGcolumn.and(knightPosition);

		return treatBigInteger(knightPositionExcludeAcolumn.shiftLeft(15))
				.or(treatBigInteger(knightPositionExcludeHcolumn.shiftLeft(17)))
				.or(treatBigInteger(knightPositionExcludeBcolumn.and(knightPositionExcludeAcolumn).shiftLeft(6)))
				.or(treatBigInteger(knightPositionExcludeGcolumn.and(knightPositionExcludeHcolumn).shiftLeft(10)))
				.or(treatBigInteger(knightPositionExcludeBcolumn.and(knightPositionExcludeAcolumn).shiftRight(10)))
				.or(treatBigInteger(knightPositionExcludeGcolumn.and(knightPositionExcludeHcolumn).shiftRight(6)))
				.or(treatBigInteger(knightPositionExcludeAcolumn.shiftRight(17)))
				.or(treatBigInteger(knightPositionExcludeHcolumn.shiftRight(15)));
	}

}
