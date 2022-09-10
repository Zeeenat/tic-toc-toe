package org.zee.ttt;

public class Player {
    Value value;

    Player(Value value) {
        this.value = value;
    }

    public static Value[][] makeMove(Value[][] grid, Value value) {
        for (int row = 0; row < grid.length; row++) {
            for (int cell = 0; cell < grid[row].length; cell++) {
                if (grid[row][cell].equals(Value.EMPTY)) {
                    grid[row][cell] = value;
                    return grid;
                }
            }
        }
        return grid;
    }
}
