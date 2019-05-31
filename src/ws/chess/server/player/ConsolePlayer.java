package ws.chess.server.player;

import ws.chess.core.Board;
import ws.chess.core.Move;

import java.util.List;
import java.util.Scanner;

public class ConsolePlayer implements Player {
    private Scanner in = new Scanner(System.in);

    public Move getMove(Board board) {
        List<Move> moves = board.getAvailableMoves();
        System.out.println("Choose a move to make:");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(String.format("%d) %s", i+1, moves.get(i)));
        }

        return moves.get(in.nextInt()-1);
    }
}
