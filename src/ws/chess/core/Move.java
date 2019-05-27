package ws.chess.core;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Move {
    private Piece original;
    private Piece destination;
}
