package org.zee.ttt.player;

import org.zee.ttt.Cell;
import org.zee.ttt.Value;

import java.util.Random;

public class VirtualPlayer implements Player {
    private final Value value;


    public VirtualPlayer(Value value) {
        this.value = value;
    }

    @Override
    public Cell makeMove(Value[][] grid) {
        int emptyCells = 0;
        for (Value[] row : grid) {
            for (Value cell : row) {
                if (cell.equals(Value.EMPTY)) {
                    emptyCells++;
                }
            }
        }
        Random random = new Random();
        int i = random.nextInt(emptyCells) + 1;
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int cell = 0; cell < grid[row].length; cell++) {
                if (grid[row][cell].equals(Value.EMPTY)) {
                    count++;
                }
                if (count == i) {
                    return new Cell(row, cell);
                }

            }
        }
        return null;
    }
}
