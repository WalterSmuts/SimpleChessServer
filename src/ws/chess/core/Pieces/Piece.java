package ws.chess.core.Pieces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ws.chess.core.Move;

import java.util.List;

import static ws.chess.core.Pieces.Piece.Color.WHITE;

@Data
@AllArgsConstructor
public abstract class Piece {
    private Color color;
    private int x;
    private int y;

    public abstract List<Move> getMovePattern();
    abstract String getSymbol();

    public abstract Piece clone();

    public String toString() {
        return color.equals(WHITE) ? getSymbol().toUpperCase() : getSymbol().toLowerCase();
    }

    public enum Color {
        WHITE,
        BLACK
    }

}
