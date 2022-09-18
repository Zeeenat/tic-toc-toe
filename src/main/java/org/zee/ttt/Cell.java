package org.zee.ttt;

public class Cell {
    int row;
    int column;

    Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Cell intToCell(int num) {
        if (num == 0 || num == 1 || num == 2 || num == 10 || num == 11 || num == 12 || num == 20 || num == 21 || num == 22) {
            return new Cell(num / 10, num % 10);
        } else {
            return null;
        }
    }

    public static int cellToInt(Cell cell) {
        return cell.row * 10 + cell.column;
    }
}
