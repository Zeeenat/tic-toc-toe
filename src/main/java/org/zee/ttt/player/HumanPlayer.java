package org.zee.ttt.player;

import org.zee.ttt.Cell;
import org.zee.ttt.Value;
import org.zee.ttt.player.Player;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Value value;
    private final Scanner nextMove;

    public HumanPlayer(Value value, Scanner nextMove) {
        this.value = value;
        this.nextMove = nextMove;
    }

    @Override
    public Cell makeMove(Value[][] grid) {
        int moveAsInt = nextMove.nextInt();
        return new Cell(moveAsInt / 10, moveAsInt % 10);
    }
}
