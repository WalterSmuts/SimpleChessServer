package ws.chess.core;

import lombok.Builder;
import lombok.Data;
import ws.chess.core.Pieces.Piece;

@Builder
@Data
public class Move {
    private Piece original;
    private Piece destination;
}
