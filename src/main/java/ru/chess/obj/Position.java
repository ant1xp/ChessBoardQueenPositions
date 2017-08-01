package ru.chess.obj;

/**
 * Позиция фигуры на шахматном поле
 * Created by Antix on 7/31/2017.
 */
public class Position extends Object {

    private int columpPos;
    private int rowPost;

    public Position(int columpPos, int rowPost) {
        this.columpPos = columpPos;
        this.rowPost = rowPost;
    }

    public int getColumpPos() {
        return columpPos;
    }

    public int getRowPos() {
        return rowPost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return position.getColumpPos() == getColumpPos() && position.getRowPos() == getRowPos();
        }
        return false;
    }
}
