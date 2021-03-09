package ru.otus.algo.chess.service;

import java.math.BigInteger;

public interface ChessBigIntegerHandler {

	default BigInteger treatBigInteger(BigInteger bigInteger) {
		final long longValue = bigInteger.longValue();
		if (longValue == 0) {
			return BigInteger.ZERO;
		}
		return bigInteger;
	}
}
