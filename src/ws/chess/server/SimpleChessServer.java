package ws.chess.server;

import ws.chess.core.Board;
import ws.chess.core.Move;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SimpleChessServer {
    @Inject
    private Board board;

    public void run() {
        Random random = new Random();
        while (true) {
            System.out.println(board.toString());
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            List<Move> moves = board.getAvailableMoves();
            board = board.applyMove(moves.get(random.nextInt(moves.size())));
        }
    }

}
