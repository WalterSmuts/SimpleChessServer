package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getMovePattern() {
        return new ArrayList<>();
    }

    String getSymbol() {
        return "B";
    }

    public Piece clone() {
        return new Bishop(this.getColor(), this.getX(), this.getY());
    }
}
