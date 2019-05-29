package ws.chess.core.Pieces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ws.chess.core.Move;

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

    private boolean onBoard(Move move) {
        return (move.getDestination().getY() < 8) || (move.getDestination().getY() >= 0)
            || (move.getDestination().getX() < 8) || (move.getDestination().getX() >= 0);
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
