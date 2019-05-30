package ws.chess.core.Pieces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ws.chess.core.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ws.chess.core.Pieces.Piece.Color.WHITE;

@Data
@AllArgsConstructor
public abstract class Piece {
    private Color color;
    private int x;
    private int y;

    abstract List<Move> getUniqueMovePattern();
    abstract String getSymbol();

    public List<Move> getMovePattern() {
        return getUniqueMovePattern().stream()
            .filter(this::onBoard)
            .collect(Collectors.toList());
    }

    List<Move> getLinearPattern() {
        List<Move> moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Piece piece1 = this.clone();
            Piece piece2 = this.clone();
            Piece piece3 = this.clone();
            Piece piece4 = this.clone();

            piece1.setX(this.getX() + i);
            piece2.setX(this.getX() - i);
            piece3.setY(this.getY() + i);
            piece4.setY(this.getY() - i);

            moves.add(Move.builder()
                .original(this)
                .destination(piece1)
                .build()
            );
            moves.add(Move.builder()
                .original(this)
                .destination(piece2)
                .build()
            );
            moves.add(Move.builder()
                .original(this)
                .destination(piece3)
                .build()
            );
            moves.add(Move.builder()
                .original(this)
                .destination(piece4)
                .build()
            );
        }
        return moves;
    }

    List<Move> getDiagonalPattern() {
        List<Move> moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Piece piece1 = this.clone();
            Piece piece2 = this.clone();
            Piece piece3 = this.clone();
            Piece piece4 = this.clone();

            piece1.setX(this.getX() + i);
            piece2.setX(this.getX() - i);
            piece3.setX(this.getX() + i);
            piece4.setX(this.getX() - i);

            piece1.setY(this.getY() + i);
            piece2.setY(this.getY() + i);
            piece3.setY(this.getY() - i);
            piece4.setY(this.getY() - i);

            moves.add(Move.builder()
                .original(this)
                .destination(piece1)
                .build()
            );
            moves.add(Move.builder()
                .original(this)
                .destination(piece2)
                .build()
            );
            moves.add(Move.builder()
                .original(this)
                .destination(piece3)
                .build()
            );
            moves.add(Move.builder()
                .original(this)
                .destination(piece4)
                .build()
            );
        }
        return moves;
    }

    private boolean onBoard(Move move) {
        return (move.getDestination().getY() < 8) && (move.getDestination().getY() >= 0)
            && (move.getDestination().getX() < 8) && (move.getDestination().getX() >= 0);
    }

    public abstract Piece clone();

    public String toString() {
        return color.equals(WHITE) ? getSymbol().toUpperCase() : getSymbol().toLowerCase();
    }

    public enum Color {
        WHITE,
        BLACK
    }

}
