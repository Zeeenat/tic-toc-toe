package org.zee.ttt.player;

import org.zee.ttt.Cell;
import org.zee.ttt.Value;

public interface Player {

    public Cell makeMove(Value[][] grid);
}
