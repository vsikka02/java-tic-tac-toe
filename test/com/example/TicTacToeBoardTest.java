package com.example;

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  /**
   * If you want to test other sized boards simply change the constant in the TicTacToeBoard.java file and input your new
   * n x n size. For example for 3 x 3 the BOARD_SIZE would be 9 (Default).
   */
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("o...x.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }
  @Test
  public void testValidBoardUnreachableState(){
    TicTacToeBoard board = new TicTacToeBoard("XayXcdXdO");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
  @Test
  public void testValidBoardXWins() {
    TicTacToeBoard board = new TicTacToeBoard("X!!OxO.OX");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test (expected = NullPointerException.class)
  public void testNullBoard(){
    TicTacToeBoard board = null;
    board.evaluate();
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBoardLength() {
    TicTacToeBoard board = new TicTacToeBoard("X.o..!foXoX");
    board.evaluate();
  }
  @Test
  public void testValidBoardOWins() {
    TicTacToeBoard board = new TicTacToeBoard("O.Xo.wo.x");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
}
