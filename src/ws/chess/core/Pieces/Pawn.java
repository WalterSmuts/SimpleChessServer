package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getMovePattern() {
        return new ArrayList<>();
    }

    String getSymbol() {
        return "P";
    }

    public Piece clone() {
        return new Pawn(this.getColor(), this.getX(), this.getY());
    }
}
