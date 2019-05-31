package ws.chess.server.player;

import ws.chess.core.Board;
import ws.chess.core.Move;

public interface Player {
    Move getMove(Board board);
}
