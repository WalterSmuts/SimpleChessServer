package ws.chess.server;

import ws.chess.core.Board;
import ws.chess.core.Move;

import javax.inject.Inject;
import java.io.IOException;

public class SimpleChessServer {
    @Inject
    private Board board;

    public void run() {
        while (true) {
            System.out.println(board.toString());
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Move move = board.getAvailableMoves().get(0);
            board = board.applyMove(move);
        }
    }

}
