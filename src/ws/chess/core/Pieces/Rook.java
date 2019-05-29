package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Piece.Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getMovePattern() {
        return new ArrayList<>();
    }

    String getSymbol() {
        return "R";
    }

    public Piece clone() {
        return new Rook(this.getColor(), this.getX(), this.getY());
    }
}
