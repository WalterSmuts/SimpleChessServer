package ws.chess;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ws.chess.core.Board;
import ws.chess.core.Piece;

import java.util.ArrayList;
import java.util.List;

import static ws.chess.core.Piece.Color;
import static ws.chess.core.Piece.Type;

public class ServerModule extends AbstractModule {
    protected void configure() {

    }

    @Provides
    Board getStartBoard() {
        List<Piece> pieces = new ArrayList<>();
        Piece[][] board = new Piece[8][8];

        pieces.add(new Piece(Color.WHITE, Type.PAWN, 0, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 1, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 2, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 3, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 4, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 5, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 6, 1));
        pieces.add(new Piece(Color.WHITE, Type.PAWN, 7, 1));

        pieces.add(new Piece(Color.BLACK, Type.PAWN, 0, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 1, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 2, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 3, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 4, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 5, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 6, 6));
        pieces.add(new Piece(Color.BLACK, Type.PAWN, 7, 6));

        pieces.add(new Piece(Color.WHITE, Type.ROOK, 0, 0));
        pieces.add(new Piece(Color.WHITE, Type.BISHOP, 1, 0));
        pieces.add(new Piece(Color.WHITE, Type.KNIGHT, 2, 0));
        pieces.add(new Piece(Color.WHITE, Type.QUEEN, 3, 0));
        pieces.add(new Piece(Color.WHITE, Type.KING, 4, 0));
        pieces.add(new Piece(Color.WHITE, Type.KNIGHT, 5, 0));
        pieces.add(new Piece(Color.WHITE, Type.BISHOP, 6, 0));
        pieces.add(new Piece(Color.WHITE, Type.ROOK, 7, 0));

        pieces.add(new Piece(Color.BLACK, Type.ROOK, 0, 7));
        pieces.add(new Piece(Color.BLACK, Type.BISHOP, 1, 7));
        pieces.add(new Piece(Color.BLACK, Type.KNIGHT, 2, 7));
        pieces.add(new Piece(Color.BLACK, Type.QUEEN, 3, 7));
        pieces.add(new Piece(Color.BLACK, Type.KING, 4, 7));
        pieces.add(new Piece(Color.BLACK, Type.KNIGHT, 5, 7));
        pieces.add(new Piece(Color.BLACK, Type.BISHOP, 6, 7));
        pieces.add(new Piece(Color.BLACK, Type.ROOK, 7, 7));

        pieces.forEach(piece -> board[piece.getX()][piece.getY()] = piece);
        return new Board(pieces, board, Color.WHITE);
    }
}