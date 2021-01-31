package com.example;

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("o...x.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }
  @Test
  public void testValidBoardUnreachableState(){
    TicTacToeBoard board = new TicTacToeBoard("X..X..X.O");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
  @Test
  public void testXRowWins() {
    TicTacToeBoard board = new TicTacToeBoard("XXX..O.O.");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test
  public void testXColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("X.OX.OXO.");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test
  public void testXDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("X!!OxO.OX");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }
  @Test
  public void testODiagonalWins(){
    TicTacToeBoard board = new TicTacToeBoard("X.O.O.ox.");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
  @Test
  public void testInvalidBoardLength() {
    TicTacToeBoard board = new TicTacToeBoard("X.o..!foXoX");
    assertThrows();
  }
}
