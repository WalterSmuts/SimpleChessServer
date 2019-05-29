package ws.chess.core;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ws.chess.core.Piece.Color;

@AllArgsConstructor
public class Board {
    List<Piece> pieces;
    Piece[][] board;
    Color next;

    List<Move> getPossibleMoves(Color color) {
        return pieces.stream()
            .filter(piece -> piece.getColor().equals(color))
            .flatMap(piece -> piece.getMovePattern().stream())
            .filter(this::isValidDestination)
            .filter(this::hasCleanPath)
            .collect(Collectors.toList());
    }

    public List<Move> getAvailableMoves() {
        return getPossibleMoves(next).stream()
            .filter(move -> !applyMove(move).inCheck(next))
            .collect(Collectors.toList());
    }

    boolean isValidDestination(Move move) {
        Piece destination = board[move.getDestination().getX()][move.getDestination().getY()];
        return (destination == null) || !destination.getColor().equals(move.getOriginal().getColor());
    }

    boolean hasCleanPath(Move move) {
        // There has to be a simpler way to check this!!!
        if (move.getOriginal().getType().equals(Piece.Type.KNIGHT)) return true;
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

    public Board applyMove(Move move) {
        Color newNext = next.equals(Color.BLACK) ? Color.WHITE : Color.BLACK;
        List<Piece> newPieces = new ArrayList<>();
        Piece[][] newBoard = new Piece[8][8];
        pieces.forEach(piece -> {
            Piece newPiece = new Piece(piece);
            newPieces.add(newPiece);
            newBoard[newPiece.getX()][newPiece.getY()] = newPiece;
        });
        return new Board(newPieces, newBoard, newNext);
    }

    boolean inCheck(Color color) {
        return getPossibleMoves(color.equals(Color.BLACK) ? Color.WHITE : Color.BLACK)
            .stream()
            .anyMatch(this::consumesKing);
    }

    boolean consumesKing(Move move) {
        return board[move.getDestination().getX()][move.getDestination().getY()]
            .getType()
            .equals(Piece.Type.KING);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8 ; j++) {
                Piece piece = board[j][i];
                if (piece == null) {
                    sb.append("X");
                } else {
                    sb.append(piece.toString());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
