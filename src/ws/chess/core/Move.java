package ws.chess.core;

import lombok.Builder;
import lombok.Data;
import ws.chess.core.Pieces.Piece;

@Builder
@Data
public class Move {
    private Piece original;
    private Piece destination;

    public String toString() {
        return String.format("%s %d,%d goes to %d,%d%n",
            original, original.getX(), original.getY(), destination.getX(), destination.getY());
    }
}
