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
        // There has to be a simpler way to check this!!!
        int ax = move.getOriginal().getX();
        int ay = move.getOriginal().getY();
        int bx = move.getDestination().getX();
        int by = move.getDestination().getY();

        ax = stepTowards(ax, bx);
        ay = stepTowards(ay, by);
        bx = stepTowards(bx, ax);
        by = stepTowards(by, ay);

        while (ax != bx && ay != by) {
            if (!(board[ax][ay] == null)) return false;
            ax = stepTowards(ax, bx);
            ay = stepTowards(ay, by);
        }
        return true;
    }

    static int stepTowards(int a, int b) {
        a += (a > b) ? -1 : 1;
        if (a == b) a--;
        return a;
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
