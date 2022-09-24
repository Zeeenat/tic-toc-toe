package org.zee.ttt;

import org.zee.ttt.player.HumanPlayer;
import org.zee.ttt.player.Player;
import org.zee.ttt.player.VirtualPlayer;

import java.util.Scanner;

public class GameEngine {

    public void play() {
        System.out.println("Выберите ячейку, чтобы поставить туда крестик или нолик\nХод X-а");
        Value[][] grid = {
                {Value.EMPTY, Value.EMPTY, Value.EMPTY},
                {Value.EMPTY, Value.EMPTY, Value.EMPTY},
                {Value.EMPTY, Value.EMPTY, Value.EMPTY}
        };
        Scanner inputMove = new Scanner(System.in);
        Player playerX = new VirtualPlayer(Value.CROSS);
        Player playerO = new VirtualPlayer(Value.NAUGHT);
        printGrid(grid);
        boolean isPlayerX = true;
        do {
            Player p = isPlayerX ? playerX : playerO;
            Value v = isPlayerX ? Value.CROSS : Value.NAUGHT;
            Cell move = p.makeMove(grid);
            grid[move.row][move.column] = v;
            printGrid(grid);
            isPlayerX = !isPlayerX;
            GameResult gameResult = getGameResult(grid, v);
            printGameResult(gameResult, v);
            if (gameResult != GameResult.GAME_CONTINUES) {
                break;
            }
        } while (true);
    }


    public GameResult getGameResult(Value[][] grid, Value currentValue) {
        GameResult thisResult = currentValue == Value.CROSS ? GameResult.CROSSES_WON : GameResult.NAUGHTS_WON;
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
        for (Value[] row : grid) {
            for (Value cell : row) {
                if (cell.equals(Value.EMPTY)) {
                    return GameResult.GAME_CONTINUES;
                }
            }
        }
        return GameResult.DRAW;
    }

    public void printGameResult(GameResult gameResult, Value currentValue) {
        switch (gameResult) {
            case GAME_CONTINUES:
                if (currentValue == Value.CROSS) {
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
