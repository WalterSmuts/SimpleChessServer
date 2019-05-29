package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Piece.Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getUniqueMovePattern() {
        return new ArrayList<>();
    }

    String getSymbol() {
        return "H";
    }

    public Piece clone() {
        return new Knight(this.getColor(), this.getX(), this.getY());
    }
}
