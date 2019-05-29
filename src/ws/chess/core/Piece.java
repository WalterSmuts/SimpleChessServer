package ws.chess.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Piece {
    private Color color;
    private Type type;
    private int y;
    private int x;

    public Piece(Piece old) {
        this.color = old.getColor();
        this.type = old.getType();
        this.x = old.getX();
        this.y = old.getY();
    }

    public List<Move> getMovePattern() {
        return null;
    }


    enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    enum Color {
        WHITE,
        BLACK
    }
}
