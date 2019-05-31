package ws.chess.server.player;

import ws.chess.core.Board;
import ws.chess.core.Move;

import java.util.List;
import java.util.Random;

public class RandomPlayer implements Player {
    Random random = new Random();

    public Move getMove(Board board) {
        List<Move> moves = board.getAvailableMoves();
        return moves.get(random.nextInt(moves.size()));
    }
}
