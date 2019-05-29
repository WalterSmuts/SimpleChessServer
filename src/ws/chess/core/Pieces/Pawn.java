package ws.chess.core.Pieces;

import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;

import static ws.chess.core.Pieces.Piece.Color.WHITE;

public class Pawn extends Piece {

    public Pawn(Color color, int x, int y) {
        super(color, x, y);
    }

    public List<Move> getMovePattern() {
        Piece destination = this.clone();
        destination.setY(this.getColor().equals(WHITE) ? destination.getY() + 1 : destination.getY() - 1);

        List<Move> moves = new ArrayList<>();
        moves.add(Move.builder()
            .original(this)
            .destination(destination)
            .build());
        return moves;
    }

    String getSymbol() {
        return "P";
    }

    public Piece clone() {
        return new Pawn(this.getColor(), this.getX(), this.getY());
    }
}
