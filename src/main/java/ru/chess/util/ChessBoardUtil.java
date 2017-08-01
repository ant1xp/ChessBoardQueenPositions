package ru.chess.util;


import ru.chess.obj.ChessBoard;
import ru.chess.obj.Position;

import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Antix on 8/1/2017.
 */
public class ChessBoardUtil {

    /**
     * @param board шахматное поле
     * @return состояние поля с расставленными ферзями в шахматной нотациии (в виде строки)
     */
    public static String writeChessBoardStateToString(ChessBoard board) {
        if (board != null) {
            StringJoiner sj = new StringJoiner(",");
            for (int i = 0; i < board.chessBoard.length; i++) {
                sj.add(PositionUtil.convertPositionToString(new Position(i, board.chessBoard[i])));
            }
            return sj.toString();
        } else {
            return null;
        }
    }

    /**
     * выводит состояние шахматного поля в консоль
     *
     * @param board шахматное поле
     */
    public static void printChessBoard(ChessBoard board) {
        for (int i = 0; i < board.chessBoard.length; i++) {
            int position = board.chessBoard[i];
            for (int j = 0; j < board.chessBoard.length; j++) {
                System.out.print(j == position ? "X " : "0 ");
            }
            System.out.println();
        }
    }


    public static ChessBoard placeRandomQueensOnBoard(ChessBoard board) {
        board.chessBoard[0] = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        do {
            if (isValid(board)) {
                return board;
            }
        } while (next(board));
        return null;
    }

    public static boolean isValid(ChessBoard board) {
        int[] chessboard = board.chessBoard;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = i + 1; j < chessboard.length; j++) {
                // проверка по вертикали
                if (chessboard[i] == chessboard[j]) {
                    return false;
                }
                // проверка по диагонали
                if (Math.abs(i - j) == Math.abs(chessboard[i] - chessboard[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean next(ChessBoard board) {
        return move(board.chessBoard.length - 1, board);
    }

    /*
     * Двигает фигуру в указаной линии на одну клетку вправо и возвращает true.
     * Если фигура находится в крайнем положении, то фигура устанавливается в
     * первое положение и двигается фигура находящаяся на линии выше и так далее.
     * Усли линий выше не осталось возвращает false.
     */
    private static boolean move(int index, ChessBoard board) {
        if (board.chessBoard[index] < board.chessBoard.length - 1) {
            board.chessBoard[index]++;
            return true;
        }

        board.chessBoard[index] = 0;
        if (index == 0) {
            return false;
        } else {
            return move(index - 1, board);
        }
    }

}
