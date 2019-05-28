package ws.chess.core;

import java.util.List;
import java.util.stream.Collectors;

import static ws.chess.core.Piece.Color;

public class Board {
    List<Piece> pieces;
    Piece[][] board;
    Color next;

    List<Move> getPossibleMoves() {
        return pieces.stream()
            .filter(piece -> piece.getColor().equals(next))
            .flatMap(piece -> piece.getMovePattern().stream())
            .filter(this::isValidMove)
            .collect(Collectors.toList());
    }

    boolean isValidMove(Move move) {
        int x = move.getDestination().getX();
        int y = move.getDestination().getY();
        Piece destinationSquare = board[x][y];
        if (!(destinationSquare== null) &&
            destinationSquare.getColor().equals(move.getOriginal().getColor())) {
            return false;
        }
        if (causesCheck(move)) return false;
        if (move.getOriginal().getType().equals(Piece.Type.KNIGHT)) return true;
        return hasCleanPath(move);
    }

    boolean hasCleanPath(Move move) {
        // TODO
        return true;
    }

    boolean causesCheck(Move move) {
        Board nextBoard = applyMove(move);
        if (next.equals(Color.BLACK)) {
            return nextBoard.whiteInCheck();
        } else {
            return nextBoard.blackInCheck();
        }
    }

    public Board applyMove(Move move) {
        // TODO need to deep copy state!!!
        // Will this be a problem?
        return this;
    }

    boolean whiteInCheck() {
        // TODO
        return false;
    }

    boolean blackInCheck() {
        // TODO
        return false;
    }
}
