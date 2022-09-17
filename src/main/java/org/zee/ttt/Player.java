package org.zee.ttt;

public class Player implements Players {
    Value value;

    Player(Value value) {
        this.value = value;

    }

    public int makeMove(Value[][] grid) {
        return 0;
    }

    //    public static int makeMove(Value[][] grid, Value value, int moves) {
    //        if (value.equals(Value.CROSS)) {
    //            if (moves == 0) {
    //                double random = Math.random();
    //                if (random < 0.25) {
    //                    return 0;
    //                } else if (random < 0.5) {
    //                    return 2;
    //                } else if (random < 0.75) {
    //                    return 20;
    //                } else {
    //                    return 22;
    //                }
    //            }
    //            if (moves >= 4) {
    //                if (winningSituation(grid, value) != -1) {
    //                    return winningSituation(grid, value);
    //                }
    //            }
    //        }
    //
    //
    //
    //
    //        else if (value.equals(Value.NAUGHT)) {
    //            if (moves >= 5) {
    //                if (winningSituation(grid, value) != -1) {
    //                    return winningSituation(grid, value);
    //                }
    //            }
    //        }
    //        for (int row = 0; row < grid.length; row++) {
    //            for (int cell = 0; cell < grid[row].length; cell++) {
    //                if (grid[row][cell].equals(Value.EMPTY)) {
    //                    grid[row][cell] = value;
    //                    return row * 10 + cell;
    //                }
    //            }
    //        }
    //        return 0;
    //    }

    //    public static int winningSituation(Value[][] grid, Value value) {
    //
    //        {
    //            if ((grid[0][1] == grid[0][2] && grid[0][1] == value) ||
    //                    (grid[1][0] == grid[2][0] && grid[2][0] == value) ||
    //                    (grid[1][1] == grid[2][2] && grid[2][2] == value)) {
    //                return 0;
    //            }
    //            {
    //                if ((grid[0][0] == grid[0][2] && grid[0][0] == value) ||
    //                        (grid[1][1] == grid[2][1] && grid[1][1] == value)) {
    //                    return 1;
    //                }
    //            }
    //            {
    //                if ((grid[0][0] == grid[0][1] && grid[0][0] == value) ||
    //                        (grid[1][2] == grid[2][2] && grid[1][2] == value) ||
    //                        (grid[1][1] == grid[2][0] && grid[1][1] == value)) {
    //                    return 2;
    //                }
    //            }
    //            {
    //                if ((grid[0][0] == grid[2][0] && grid[0][0] == value) ||
    //                        (grid[1][1] == grid[1][2] && grid[1][1] == value)) {
    //                    return 10;
    //                }
    //            }
    //            {
    //                if ((grid[0][0] == grid[2][2] && grid[0][0] == value) ||
    //                        (grid[0][1] == grid[2][1] && grid[0][1] == value) ||
    //                        (grid[0][2] == grid[2][0] && grid[0][2] == value) ||
    //                        (grid[1][0] == grid[1][2] && grid[1][0] == value)) {
    //                    return 11;
    //                }
    //
    //            }
    //            {
    //                if ((grid[0][2] == grid[2][2] && grid[0][2] == value) ||
    //                        (grid[1][0] == grid[1][1] && grid[1][0] == value)) {
    //                    return 12;
    //                }
    //            }
    //            {
    //                if ((grid[0][0] == grid[1][0] && grid[0][0] == value) ||
    //                        (grid[2][1] == grid[2][2] && grid[2][1] == value) ||
    //                        (grid[0][2] == grid[1][1] && grid[1][1] == value)) {
    //                    return 20;
    //                }
    //            }
    //            {
    //                if ((grid[0][1] == grid[1][1] && grid[0][1] == value) ||
    //                        (grid[2][0] == grid[2][2] && grid[2][0] == value)) {
    //                    return 21;
    //                }
    //            }
    //            {
    //                if ((grid[0][0] == grid[1][1] && grid[1][1] == value) ||
    //                        (grid[0][2] == grid[1][2] && grid[0][2] == value) ||
    //                        (grid[2][0] == grid[2][1] && grid[2][0] == value)) {
    //                    return 22;
    //                }
    //            }
    //        }
    //        return -1;
    //    }
}
