package ru.chess;


import ru.chess.obj.ChessBoard;
import ru.chess.util.ChessBoardUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessBoardMain {
    private static String AUTO_PLACING_PARAM = "auto";

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard(); //создание пустого шахматного поля
        if (placeQueensOnBoard(args, board)) {
            ChessBoardUtil.printChessBoard(board);
            String currentPosition = ChessBoardUtil.writeChessBoardStateToString(board); //запись состояния шахматного поля в строку
            if (currentPosition != null)
                System.out.println(currentPosition);
        } else {
            System.out.println("Failed to place queens on board");
        }
    }

    private static boolean placeQueensOnBoard(String[] args, ChessBoard board) {
        if (isRandomPlacing(args)) {               //флаг авторасстановки ферзей на произвольные позиции
            return ChessBoardUtil.placeRandomQueensOnBoard(board) != null;
        } else {
            final List<String> initialPositions = loadPositionsFromInitFile();
            for (String pos : initialPositions) { //установка ферзей на начально заданные позиции
                board.placeQueenOnBoard(pos);
            }
            return !initialPositions.isEmpty() && ChessBoardUtil.isValid(board); //проверка валидности установки ферзей на поле по заданным позициям
        }
    }

    private static boolean isRandomPlacing(String[] args) {
        if (args.length > 0) {
            final String arg = args[0];
            if (AUTO_PLACING_PARAM.equals(arg))
                return true;
        }
        return false;
    }

    private static List<String> loadPositionsFromInitFile() {
        ArrayList<String> list = new ArrayList<>();
        URL url = ChessBoardMain.class.getClassLoader().getResource("init_positions.properties");
        if (url != null) {
            try (Scanner scanner = new Scanner(new File(url.getPath())).useDelimiter(",")) {
                while (scanner.hasNext()) {
                    list.add(scanner.next());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Init position file not found");
            }
        } else {
            System.out.println("Init position file not found");
        }
        return list;
    }
}
