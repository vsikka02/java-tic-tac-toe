package com.example;

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  /**
   * If you want to test other sized boards simply change the constant in the TicTacToeBoard.java
   * file and input your new n x n size. For example for 3 x 3 the BOARD_SIZE would be 9 (Default).
   */
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("o...x.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardUnreachableState() {
    TicTacToeBoard board = new TicTacToeBoard("XayXcdXdO");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testValidBoardXDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("X!!OxO.OX");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXRowWins() {
    TicTacToeBoard board = new TicTacToeBoard("XXX..o.oo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXAntiDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("o.X.Xox!!");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("X^ox,yXo8");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardODiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("OxxxO*0-O");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardORowWins() {
    TicTacToeBoard board = new TicTacToeBoard("yxyOoOx+x");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOAntiDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("w.OxO-Oxy");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("cOX.OwyOx");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullBoard() {
    TicTacToeBoard board = new TicTacToeBoard(null);
    board.evaluate();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBoardLength() {
    TicTacToeBoard board = new TicTacToeBoard("X.o..!foXoX");
    board.evaluate();
  }

  @Test
  public void testValid5By5BoardXColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("XO...X.O..XO...X...OX..O.");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid5By5BoardXRowWins() {
    TicTacToeBoard board = new TicTacToeBoard("----0XXXXXyyOyy--O--O--Oy");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid5By5BoardXDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("X--O-px!!!oox--rtsx5---ox");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid5by5BoardXAntiDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("1234X1O3X512X4O1X3O5X2O45");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
}
