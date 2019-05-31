package ws.chess;

import ws.chess.core.Utils;
import ws.chess.server.SimpleChessServer;
import ws.chess.server.player.RandomPlayer;

public class RunSimpleChessServer {

    public static void main(String[] args) {
        SimpleChessServer server = new SimpleChessServer(
            Utils.getStartingBoard(),
            new RandomPlayer(),
            new RandomPlayer()
        );
        server.run();
    }
}
