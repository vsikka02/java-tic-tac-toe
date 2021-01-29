package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }
  @Test
  public void testValidBoardUnreachableState(){
    TicTacToeBoard board = new TicTacToeBoard("X..X..X.O");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }
}
