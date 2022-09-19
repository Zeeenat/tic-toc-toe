package org.zee.ttt;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameEngineTest {
//    GameEngine engine = new GameEngine();
//
//    @Test
//    public void isOverShouldDetectPlayer1Victory() throws Exception {
//        assertEquals(GameResult.CROSSES_WON, engine.getGameResult(parseField(
//                "XO ",
//                "OX ",
//                "  X"),7,true));
//
//        assertEquals(GameResult.GAME_CONTINUES, engine.getGameResult(parseField(
//                "XO ",
//                "XO ",
//                "   "),4,true));
//    }
//
//    @Test
//    public void isOverShouldDetectNonFinalState() throws Exception {
//        assertEquals(GameResult.DRAW, engine.getGameResult(parseField(
//                "OXX",
//                "XXO",
//                "OOX"),9,true));
//    }
//
//
//
//
//
//    private Value[][] parseField(String... lines) throws Exception {
//        Value[][] result = new Value[3][3];
//        for (int i = 0; i < 3; ++i) {
//            for (int j = 0; j < 3; j++) {
//                switch (lines[i].charAt(j)) {
//                    case 'X':
//                        result[i][j] = Value.CROSS;
//                        break;
//                    case 'O':
//                        result[i][j] = Value.NAUGHT;
//                        break;
//                    case ' ':
//                        result[i][j] = Value.EMPTY;
//                        break;
//                    default:
//                        throw new Exception("Unexpected character! " + lines[i].charAt(j));
//                }
//            }
//        }
//        return result;
//    }
}
