package ru.otus.algo.chess.service;

import java.math.BigInteger;
import java.util.Objects;

public interface BitsFigureMoveToBorder extends ChessBigIntegerHandler {

	default BigInteger getShiftRightToTheBorder(BigInteger startPosition, int shiftRightValue, BigInteger excludeColumn) {
		BigInteger tempStartPosition = startPosition;
		BigInteger possibleMoviesBits = null;
		while (tempStartPosition.compareTo(BigInteger.ZERO) > 0) {
			tempStartPosition = excludeColumn == null ? treatBigInteger(tempStartPosition.shiftRight(shiftRightValue)) :
					treatBigInteger((excludeColumn.and(tempStartPosition).shiftRight(shiftRightValue)));
			if (tempStartPosition.compareTo(BigInteger.ZERO) > 0) {
				possibleMoviesBits = possibleMoviesBits == null ? tempStartPosition : possibleMoviesBits.or(tempStartPosition);
			}
		}
		return Objects.requireNonNullElse(possibleMoviesBits, BigInteger.ZERO);
	}

	default BigInteger getShiftLeftToTheBorder(BigInteger startPosition, int shiftLeftValue, BigInteger excludeColumn) {
		BigInteger tempStartPosition = startPosition;
		BigInteger possibleMoviesBits = null;
		while (tempStartPosition.compareTo(BigInteger.ZERO) > 0) {
			tempStartPosition = excludeColumn == null ?
					treatBigInteger((tempStartPosition).shiftLeft(shiftLeftValue)) :
					treatBigInteger((excludeColumn.and(tempStartPosition).shiftLeft(shiftLeftValue)));
			if (tempStartPosition.compareTo(BigInteger.ZERO) > 0) {
				possibleMoviesBits = possibleMoviesBits == null ? tempStartPosition : possibleMoviesBits.or(tempStartPosition);
			}
		}
		return Objects.requireNonNullElse(possibleMoviesBits, BigInteger.ZERO);
	}

}
