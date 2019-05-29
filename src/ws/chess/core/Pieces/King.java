package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getMovePattern() {
        return new ArrayList<>();
    }

    public String getSymbol() {
        return "K";
    }

    public Piece clone() {
        return new King(this.getColor(), this.getX(), this.getY());
    }
}
