package ru.otus.algo.chess.figure;

import ru.otus.algo.chess.service.BitsFigureMoveToBorder;

import java.math.BigInteger;

public class Bishop extends FigureBits implements BitsFigureMoveToBorder {

	private static final int LEFT_DIAGONAL_RIGHT_SHIFT = 9;

	private static final int RIGHT_DIAGONAL_LEFT_SHIFT = 9;

	private static final int LEFT_DIAGONAL_LEFT_SHIFT = 7;

	private static final int RIGHT_DIAGONAL_RIGHT_SHIFT = 7;

	@Override
	public BigInteger getPossibleMovesBits(Number startPosition) {
		BigInteger bishopStartPosition = getBitsFigureStartPosition(startPosition);

		final BigInteger upRightDiagonal = getShiftLeftToTheBorder(
				bishopStartPosition,
				RIGHT_DIAGONAL_LEFT_SHIFT,
				excludeHcolumn
		);
		final BigInteger upLeftDiagonal = getShiftLeftToTheBorder(
				bishopStartPosition,
				LEFT_DIAGONAL_LEFT_SHIFT,
				excludeAcolumn
		);
		final BigInteger downRightDiagonal = getShiftRightToTheBorder(
				bishopStartPosition,
				RIGHT_DIAGONAL_RIGHT_SHIFT,
				excludeHcolumn
		);
		final BigInteger downLeftDiagonal = getShiftRightToTheBorder(
				bishopStartPosition,
				LEFT_DIAGONAL_RIGHT_SHIFT,
				excludeAcolumn
		);
		return upRightDiagonal
				.or(upLeftDiagonal)
				.or(downRightDiagonal)
				.or(downLeftDiagonal);

	}
}
