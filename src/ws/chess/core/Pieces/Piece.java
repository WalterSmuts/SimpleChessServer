package ws.chess.core.Pieces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ws.chess.core.Pieces.Piece.Color.WHITE;

@Data
@AllArgsConstructor
public abstract class Piece {
    private Color color;
    private int x;
    private int y;

    abstract List<Move> getUniqueMovePattern();
    abstract String getSymbol();

    public List<Move> getMovePattern() {
        return getUniqueMovePattern().stream()
            .filter(this::onBoard)
            .collect(Collectors.toList());
    }

    List<Move> getLinearPattern() {
        List<Move> moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            moves.add(move(+i, 0));
            moves.add(move(-i, 0));
            moves.add(move(0, +i));
            moves.add(move(0, -i));
        }
        return moves;
    }

    List<Move> getDiagonalPattern() {
        List<Move> moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            moves.add(move(+i, +i));
            moves.add(move(-i, -i));
            moves.add(move(+i, -i));
            moves.add(move(-i, +i));
        }
        return moves;
    }

    private boolean onBoard(Move move) {
        return (move.getDestination().getY() < 8) && (move.getDestination().getY() >= 0)
            && (move.getDestination().getX() < 8) && (move.getDestination().getX() >= 0);
    }

    protected Move move(int x, int y) {
        Piece clone = this.clone();
        clone.setX(this.getX() + x);
        clone.setY(this.getY() + y);
        return Move.builder()
            .original(this)
            .destination(clone)
            .build();
    }

    public abstract Piece clone();

    public String toString() {
        return color.equals(WHITE) ? getSymbol().toUpperCase() : getSymbol().toLowerCase();
    }

    public enum Color {
        WHITE,
        BLACK
    }

}
