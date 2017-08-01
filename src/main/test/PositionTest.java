import org.junit.Assert;
import org.junit.Test;
import ru.chess.obj.Position;
import ru.chess.util.PositionUtil;

/**
 * Created by Antix on 8/1/2017.
 */
public class PositionTest extends Assert {

    @Test
    public void testPositionStringValidation() {
        String goodPos = "a1";
        String badPos1 = "z1";
        String badPos2 = "a11";
        assertTrue(PositionUtil.isPositionStringValid(goodPos));
        assertFalse(PositionUtil.isPositionStringValid(badPos1));
        assertFalse(PositionUtil.isPositionStringValid(badPos2));
    }

    @Test
    public void testConvertPositions(){
        String strPos = "a2";
        Position pos = new Position(0, 1);
        assertTrue(strPos.equals(PositionUtil.convertPositionToString(pos)));
        assertTrue(PositionUtil.convertStringToPosition(strPos).equals(pos));
    }
}
