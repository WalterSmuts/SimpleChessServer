package ws.chess.server;

import lombok.AllArgsConstructor;
import ws.chess.core.Board;
import ws.chess.server.player.Player;

import static ws.chess.core.Pieces.Piece.Color.BLACK;
import static ws.chess.core.Pieces.Piece.Color.WHITE;

@AllArgsConstructor
public class SimpleChessServer {
    private Board board;
    private Player white;
    private Player black;

    public void run() {
        while (board.getAvailableMoves().size() != 0) {
            System.out.println(board.toString());
            System.out.println();
            board = board.applyMove(board.getNext().equals(WHITE) ?
                white.getMove(board) : black.getMove(board));
        }
        System.out.println(board.toString());
        System.out.println(String.format("%s wins!!!", board.getNext().equals(WHITE) ? BLACK : WHITE));
    }

}
