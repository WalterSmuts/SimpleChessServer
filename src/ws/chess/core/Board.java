package ws.chess.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ws.chess.core.Piece.Color;

public class Board {
    List<Piece> pieces;
    Square[][] board;
    State state;
    Color next;

    enum State {
        PLAYING,
        CHECK,
        GAMEOVER
    }

    List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList();
        pieces.stream().filter(this::canMoveNext).forEach(piece -> moves.addAll(piece.getPossibleMoves()));
        return moves.stream().filter(this::isValidMove).collect(Collectors.toList());
    }

    boolean canMoveNext(Piece piece) {
        assert !state.equals(State.GAMEOVER);
        return piece.getColor().equals(next);
    }

    boolean isValidMove(Move move) {
        int x = move.getDestination().getX();
        int y = move.getDestination().getY();
        Square destinationSquare = board[x][y];
        if (!(destinationSquare.piece == null) &&
            destinationSquare.piece.getColor().equals(move.getOriginal().getColor())) {
            return false;
        }
        if (move.getOriginal().getType().equals(Piece.Type.KNIGHT)) return true;
        return hasCleanPath(move);
    }

    boolean hasCleanPath(Move move) {
        // TODO
        return true;
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
