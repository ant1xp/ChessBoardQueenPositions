package ru.chess.util;


import ru.chess.obj.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Antix on 7/31/2017.
 */
public class PositionUtil {

    public static List<String> columnList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
    public static List<String> rowList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));


    /**
     * Проверка соответствия записи позиции правилам шахматной нотации
     */
    public static boolean isPositionStringValid(String str) {
        if (str != null) {
            Pattern p = Pattern.compile("[a-h][1-8]");
            Matcher m = p.matcher(str);
            return m.matches();
        } else {
            return false;
        }
    }

    public static Position convertStringToPosition(String str) {
        String columnChar = str.substring(0, 1);
        String rowChar = str.substring(1, 2);
        return new Position(columnList.indexOf(columnChar), rowList.indexOf(rowChar));
    }

    public static String convertPositionToString(Position pos) {
        return new String(columnList.get(pos.getColumpPos()) + rowList.get(pos.getRowPos()));
    }
}
