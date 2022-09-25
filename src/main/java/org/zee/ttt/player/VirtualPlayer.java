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
        if (winningSituation(grid, value) != null) {
            return winningSituation(grid, value);
        } else if (winningSituation(grid, value == Value.CROSS ? Value.NAUGHT : Value.CROSS) != null) {
            return winningSituation(grid, value == Value.CROSS ? Value.NAUGHT : Value.CROSS);
        } else {
            return makeRandomMove(grid);
        }
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


    public static Cell winningSituation(Value[][] grid, Value value) {
        if (grid[0][0] == Value.EMPTY && (
                (grid[0][1] == grid[0][2] && grid[0][1] == value) ||
                        (grid[1][0] == grid[2][0] && grid[2][0] == value) ||
                        (grid[1][1] == grid[2][2] && grid[2][2] == value))) {
            return new Cell(0, 0);
        }

        if (grid[0][1] == Value.EMPTY && (
                (grid[0][0] == grid[0][2] && grid[0][0] == value) ||
                        (grid[1][1] == grid[2][1] && grid[1][1] == value))) {
            return new Cell(0, 1);
        }


        if (grid[0][2] == Value.EMPTY && (
                (grid[0][0] == grid[0][1] && grid[0][0] == value) ||
                        (grid[1][2] == grid[2][2] && grid[1][2] == value) ||
                        (grid[1][1] == grid[2][0] && grid[1][1] == value))) {
            return new Cell(0, 2);
        }


        if (grid[1][0] == Value.EMPTY && (
                (grid[0][0] == grid[2][0] && grid[0][0] == value) ||
                        (grid[1][1] == grid[1][2] && grid[1][1] == value))) {
            return new Cell(1, 0);
        }

        if (grid[1][1] == Value.EMPTY && (
                (grid[0][0] == grid[2][2] && grid[0][0] == value) ||
                        (grid[0][1] == grid[2][1] && grid[0][1] == value) ||
                        (grid[0][2] == grid[2][0] && grid[0][2] == value) ||
                        (grid[1][0] == grid[1][2] && grid[1][0] == value))) {
            return new Cell(1, 1);
        }


        if (grid[1][2] == Value.EMPTY && (
                (grid[0][2] == grid[2][2] && grid[0][2] == value) ||
                        (grid[1][0] == grid[1][1] && grid[1][0] == value))) {
            return new Cell(1, 2);
        }

        if (grid[2][0] == Value.EMPTY && (
                (grid[0][0] == grid[1][0] && grid[0][0] == value) ||
                        (grid[2][1] == grid[2][2] && grid[2][1] == value) ||
                        (grid[0][2] == grid[1][1] && grid[1][1] == value))) {
            return new Cell(2, 0);
        }

        if (grid[2][1] == Value.EMPTY && (
                (grid[0][1] == grid[1][1] && grid[0][1] == value) ||
                        (grid[2][0] == grid[2][2] && grid[2][0] == value))) {
            return new Cell(2, 1);
        }

        if (grid[2][2] == Value.EMPTY && (
                (grid[0][0] == grid[1][1] && grid[1][1] == value) ||
                        (grid[0][2] == grid[1][2] && grid[0][2] == value) ||
                        (grid[2][0] == grid[2][1] && grid[2][0] == value))) {
            return new Cell(2, 2);
        }
        return null;
    }
}
