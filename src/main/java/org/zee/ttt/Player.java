package org.zee.ttt;

public class Player {
    Value value;

    Player(Value value) {
        this.value = value;
    }

    public static int makeMove(Value[][] grid, Value value, int moves) {
        if (value.equals(Value.CROSS)) {
            if (moves >= 5) {

            }
        } else if (value.equals(Value.NAUGHT)) {

        }
        for (int row = 0; row < grid.length; row++) {
            for (int cell = 0; cell < grid[row].length; cell++) {
                if (grid[row][cell].equals(Value.EMPTY)) {
                    grid[row][cell] = value;
                    return row * 10 + cell;
                }
            }
        }
        return 0;
    }

    public static int winningSituation(Value[][] grid, Value value) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                Value newValue = grid[i][j];
            }
        }
        return -1;
    }
}
