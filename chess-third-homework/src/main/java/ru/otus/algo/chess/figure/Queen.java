package ru.otus.algo.chess.figure;

import java.math.BigInteger;

public class Queen extends FigureBits {

    private final Rook rook = new Rook();
    private final Bishop bishop = new Bishop();

    @Override
    public BigInteger getPossibleMovesBits(Number startPosition) {
        final BigInteger possibleRookMove = rook.getPossibleMovesBits(startPosition);
        final BigInteger possibleBishopMoves = bishop.getPossibleMovesBits(startPosition);
        return possibleRookMove.or(possibleBishopMoves);
    }
}
