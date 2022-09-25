package org.zee.ttt;

import java.util.Objects;

public class Cell {
    public final int row;
    public final int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int hashCode() {
      return Objects.hash(column, row);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Cell other = (Cell) obj;
      return column == other.column && row == other.row;
    }

    @Override
    public String toString() {
      return "(" + row + "; " + column + ")";
    }
}
