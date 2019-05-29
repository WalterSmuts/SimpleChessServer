package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getMovePattern() {
        return new ArrayList<>();
    }

    String getSymbol() {
        return "Q";
    }

    public Piece clone() {
        return new Queen(this.getColor(), this.getX(), this.getY());
    }
}
