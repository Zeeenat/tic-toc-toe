package org.zee.ttt.player;

import org.zee.ttt.Cell;
import org.zee.ttt.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VirtualPlayer implements Player {
  private final Value value;

  public VirtualPlayer(Value value) {
    this.value = value;
  }

  @Override
  public Cell makeMove(Value[][] grid) {
    // Win the game if possible
    Cell myWinningCell = getWinningCell(grid, value);
    if (myWinningCell != null) {
      return myWinningCell;
    }

    // Make a move to not lose the game if necessary
    Cell opponentWinningCell = getWinningCell(grid, getOtherValue(value));
    if (opponentWinningCell != null) {
      return opponentWinningCell;
    }

    // Try to take center
    if (grid[1][1] == Value.EMPTY) {
      return new Cell(1, 1);
    }

    // Try to build a 2-out-of-3 triplet
    List<Triplet> triplets = getTriplets();
    for (Triplet triplet : triplets) {
      Cell c = getTripletMoveCell(grid, triplet, value);
      if (c != null) {
        return c;
      }
    }

    // Try to take corner
    for (Cell c : Arrays.asList(new Cell(0, 0), new Cell(2, 2), new Cell(0, 2), new Cell(2, 0))) {
      if (grid[c.row][c.column] == Value.EMPTY) {
        return c;
      }
    }

    // Take first empty cell we see
    for (int i = 0; i < 2; ++i) {
      for (int j = 0; j < 2; ++j) {
        if (grid[i][j] == Value.EMPTY) {
          return new Cell(i, j);
        }
      }
    }

    throw new IllegalStateException("No empty cells!");
  }

  private Value getOtherValue(Value value) {
    return value == Value.CROSS ? Value.NAUGHT : Value.CROSS;
  }

  private Cell getWinningCell(Value[][] grid, Value value) {
    List<Triplet> triplets = getTriplets();
    for (Triplet triplet : triplets) {
      Cell wc = getTripletWinningCell(grid, triplet, value);
      if (wc != null) {
        return wc;
      }
    }
    return null;
  }

  /** Get all possible triplets. */
  private List<Triplet> getTriplets() {
    List<Triplet> result = new ArrayList<>();

    for (int i = 0; i < 3; ++i) {
      List<Cell> hor = new ArrayList<>();
      List<Cell> ver = new ArrayList<>();
      for (int j = 0; j < 3; ++j) {
        hor.add(new Cell(i, j));
        ver.add(new Cell(j, i));
      }
      result.add(new Triplet(hor));
      result.add(new Triplet(ver));
    }

    List<Cell> d1 = new ArrayList<>();
    List<Cell> d2 = new ArrayList<>();
    for (int i = 0; i < 3; ++i) {
      d1.add(new Cell(i, i));
      d2.add(new Cell(2 - i, i));
    }
    result.add(new Triplet(d1));
    result.add(new Triplet(d2));

    return result;
  }

  /** If a triplet has the cell that wins the game, return it. */
  private Cell getTripletWinningCell(Value[][] grid, Triplet triplet, Value value) {
    // Has opponent field, no way to win
    if (triplet.hasValue(grid, getOtherValue(value))) {
      return null;
    }

    List<Cell> emptyCells = triplet.getEmptyCells(grid);
    if (emptyCells.size() > 1) {
      return null;
    }
    return emptyCells.get(0);
  }

  /** If a triplet has the cell that advances the game, return it. */
  private Cell getTripletMoveCell(Value[][] grid, Triplet triplet, Value value) {
    // Has opponent field, no way to win
    if (triplet.hasValue(grid, getOtherValue(value))) {
      return null;
    }

    List<Cell> emptyCells = triplet.getEmptyCells(grid);
    Cell center = new Cell(1, 1);
    if (emptyCells.contains(center)) {
      return center;
    }
    return emptyCells.get(0);
  }

  /** Helper class to manage cell triplets. */
  private class Triplet {
    List<Cell> cells;

    public Triplet(List<Cell> cells) {
      if (cells.size() != 3) {
        throw new IllegalArgumentException("Malformed triplet!");
      }
      this.cells = cells;
    }

    public boolean hasValue(Value[][] grid, Value value) {
      for (Cell cell : cells) {
        Value v = grid[cell.row][cell.column];
        if (v == value) {
          return true;
        }
      }
      return false;
    }

    public List<Cell> getEmptyCells(Value[][] grid) {
      List<Cell> result = new ArrayList<>();
      for (Cell cell : cells) {
        Value v = grid[cell.row][cell.column];
        if (v == Value.EMPTY) {
          result.add(cell);
        }
      }
      return result;
    }
  }

}
