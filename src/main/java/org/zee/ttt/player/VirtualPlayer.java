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

        return null;
    }

    public Cell makeRandomMove(Value[][] grid) {
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

    public static int winningSituation(Value[][] grid, Value value) {
        if ((grid[0][1] == grid[0][2] && grid[0][1] == value) ||
                (grid[1][0] == grid[2][0] && grid[2][0] == value) ||
                (grid[1][1] == grid[2][2] && grid[2][2] == value)) {
            return 0;
        }

        if ((grid[0][0] == grid[0][2] && grid[0][0] == value) ||
                (grid[1][1] == grid[2][1] && grid[1][1] == value)) {
            return 1;
        }


        if ((grid[0][0] == grid[0][1] && grid[0][0] == value) ||
                (grid[1][2] == grid[2][2] && grid[1][2] == value) ||
                (grid[1][1] == grid[2][0] && grid[1][1] == value)) {
            return 2;
        }


        if ((grid[0][0] == grid[2][0] && grid[0][0] == value) ||
                (grid[1][1] == grid[1][2] && grid[1][1] == value)) {
            return 10;
        }

        if ((grid[0][0] == grid[2][2] && grid[0][0] == value) ||
                (grid[0][1] == grid[2][1] && grid[0][1] == value) ||
                (grid[0][2] == grid[2][0] && grid[0][2] == value) ||
                (grid[1][0] == grid[1][2] && grid[1][0] == value)) {
            return 11;
        }


        if ((grid[0][2] == grid[2][2] && grid[0][2] == value) ||
                (grid[1][0] == grid[1][1] && grid[1][0] == value)) {
            return 12;
        }

        if ((grid[0][0] == grid[1][0] && grid[0][0] == value) ||
                (grid[2][1] == grid[2][2] && grid[2][1] == value) ||
                (grid[0][2] == grid[1][1] && grid[1][1] == value)) {
            return 20;
        }

        if ((grid[0][1] == grid[1][1] && grid[0][1] == value) ||
                (grid[2][0] == grid[2][2] && grid[2][0] == value)) {
            return 21;
        }

        if ((grid[0][0] == grid[1][1] && grid[1][1] == value) ||
                (grid[0][2] == grid[1][2] && grid[0][2] == value) ||
                (grid[2][0] == grid[2][1] && grid[2][0] == value)) {
            return 22;
        }
        return -1;
    }
}
