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

}
