import org.junit.Assert;
import org.junit.Test;
import ru.chess.obj.ChessBoard;
import ru.chess.util.ChessBoardUtil;

/**
 * Created by Antix on 8/1/2017.
 */
public class ChessBoardToStringTest extends Assert {

    @Test
    public void testConvertChessBoardToString() {
        ChessBoard board = new ChessBoard();                        //Представление шахматного поля в виде массива
        board.chessBoard = new int[]{1, 3, 5, 7, 2, 0, 6, 4};       //установка ферзей на поле
        String str = "a2,b4,c6,d8,e3,f1,g7,h5";
        assertTrue(str.equals(ChessBoardUtil.writeChessBoardStateToString(board)));
    }
}
