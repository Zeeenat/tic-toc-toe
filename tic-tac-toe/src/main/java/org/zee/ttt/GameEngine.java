package org.zee.ttt;

import java.util.Scanner;

public class GameEngine {

    public void play() {
        System.out.println("Выберите ячейку, чтобы поставить туда крестик или нолик\nХод X-а");
        Value[][] grid = {
                {Value.EMPTY, Value.EMPTY, Value.EMPTY},
                {Value.EMPTY, Value.EMPTY, Value.EMPTY},
                {Value.EMPTY, Value.EMPTY, Value.EMPTY}
        };
        printGrid(grid);
        Scanner xnos = new Scanner(System.in);
        boolean isPlayer1 = true;
        int move = 0;
        GameResult thisResult;
        do {
            Value thisValue = isPlayer1 ? Value.CROSS : Value.NAUGHT;
            int nextMove = xnos.nextInt();
            grid[nextMove / 10][nextMove % 10] = thisValue;
            thisResult = getGameResult(grid, move, isPlayer1);
            printGrid(grid);
            move++;
            printGameResult(thisResult, isPlayer1);
            isPlayer1 = !isPlayer1;
            if (thisResult != GameResult.GAME_CONTINUES) {
                break;
            }
        } while (move != 9);
    }


    public GameResult getGameResult(Value[][] grid, int move, boolean isPlayer1) {
        GameResult thisResult = isPlayer1 ? GameResult.CROSSES_WON : GameResult.NAUGHTS_WON;
        for (int i = 0; i < grid.length; i++) {
            Value cell = grid[i][0];
            if ((cell == grid[i][1] && cell == grid[i][2]) && cell != Value.EMPTY) {
                return thisResult;
            }
            cell = grid[0][i];
            if ((cell == grid[1][i] && cell == grid[2][i]) && cell != Value.EMPTY) {
                return thisResult;
            }
        }
        Value middle = grid[1][1];
        if (middle != Value.EMPTY) {
            if (middle == grid[0][0] && middle == grid[2][2] || middle == grid[2][0] && middle == grid[0][2]) {
                return thisResult;
            }
        }
        if (move == 9) {
            return GameResult.DRAW;
        }
        return GameResult.GAME_CONTINUES;
    }

    public static void printGameResult(GameResult gameResult, boolean isPlayer1) {
        switch (gameResult) {
            case GAME_CONTINUES:
                if (isPlayer1) {
                    System.out.println("Ход нолика");
                } else {
                    System.out.println("Ход крестика");
                }
                break;
            case CROSSES_WON:
                System.out.println("Крестики победили!");
                break;
            case NAUGHTS_WON:
                System.out.println("Нолики победили!");
                break;
            case DRAW:
                System.out.println("Ничья!");
                break;

        }
    }

    public void printGrid(Value[][] grid) {
        System.out.println(getGridString(grid));
    }

    public String getGridString(Value[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (Value[] row : grid) {
            for (Value cell : row) {
                sb.append(cell).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
