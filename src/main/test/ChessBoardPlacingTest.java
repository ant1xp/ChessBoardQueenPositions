import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.chess.obj.ChessBoard;
import ru.chess.util.ChessBoardUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Antix on 8/1/2017.
 */
public class ChessBoardPlacingTest extends Assert {
    private static List<String> initialPositions;

    @Before
    public void setUpPositions() {
        initialPositions = new ArrayList<>(Arrays.asList("a2", "b4", "c6", "d8", "e3", "f1", "g7", "h5"));
    }

    @After
    public void creatPositions() {
        initialPositions.clear();
    }

    @Test
    public void testValidatePlacing() {
        ChessBoard board = new ChessBoard();
        for (String pos : initialPositions) {
            board.placeQueenOnBoard(pos);
        }
        assertTrue(ChessBoardUtil.isValid(board));
    }
}
