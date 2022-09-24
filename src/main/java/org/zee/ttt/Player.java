package org.zee.ttt;

import java.util.Scanner;

public class Player {
    private Value value;
    private Scanner nextMove;

    public Player(Value value, Scanner nextMove) {
        this.value = value;
        this.nextMove = nextMove;
    }

    public static Cell makeMove(Value[][] grid, Scanner nextMove) {
        int moveAsInt = nextMove.nextInt();
        return new Cell(moveAsInt / 10, moveAsInt % 10);
    }
}
