package org.zee.ttt;

import java.util.Scanner;

public final class CELL {
    final int ROW;
    final int COLUMN;
    Scanner nextMove;

    public CELL(int ROW, int COLUMN, Scanner nextMove) {
        this.ROW = ROW;
        this.COLUMN = COLUMN;
        this.nextMove = nextMove;
    }


    //    public static Cell intToCell(int num) {
    //        if (num == 0 || num == 1 || num == 2 || num == 10 || num == 11 || num == 12 || num == 20 || num == 21 || num == 22) {
    //            return new Cell(num / 10, num % 10);
    //        } else {
    //            return null;
    //        }
    //    }

    //    public static int cellToInt(Cell cell) {
    //        return cell.ROW * 10 + cell.COLUMN;
    //    }
}
