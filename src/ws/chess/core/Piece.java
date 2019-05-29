package ws.chess.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Piece {
    private Color color;
    private Type type;
    private int x;
    private int y;

    public Piece(Piece old) {
        this.color = old.getColor();
        this.type = old.getType();
        this.x = old.getX();
        this.y = old.getY();
    }

    public List<Move> getMovePattern() {
        return null;
    }


    public enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    public enum Color {
        WHITE,
        BLACK
    }

    public String toString() {
        String out = "?";
        switch (type) {
            case KING: out = "K"; break;
            case QUEEN: out = "Q"; break;
            case ROOK: out = "R"; break;
            case BISHOP: out = "B"; break;
            case KNIGHT: out = "H"; break;
            case PAWN: out = "P"; break;
        }
        return color.equals(Color.BLACK) ? out.toUpperCase() : out.toLowerCase();
    }
}
