package ru.chess.obj;

import ru.chess.util.PositionUtil;

/**
 * Шахматное поле.
 * хранит расстановку ферзей. Каждый ферзь находится на своей линии.
 * Значение ячейки массива chessBoard[2] == 4 означает что
 * ферзь второй линии находиться на четвертой позиции.
 * Created by Antix on 7/31/2017.
 */
public class ChessBoard {

    //Состояние шахматного поля в виде массива
    public int[] chessBoard;

    public ChessBoard() {
        chessBoard = createNewBoard();
    }

    /**
     * Создание и инициализация нового поля
     */
    private int[] createNewBoard() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
        return arr;
    }

    /**
     * Установка ферзя на заданную позицию
     *
     * @param positionString позиция в виде шахматной нотации
     */
    public void placeQueenOnBoard(String positionString) {
        if (PositionUtil.isPositionStringValid(positionString)) {
            Position pos = PositionUtil.convertStringToPosition(positionString);
            chessBoard[pos.getColumpPos()] = pos.getRowPos();
        } else {
            System.out.println("Invalid target position");
        }
    }
}
