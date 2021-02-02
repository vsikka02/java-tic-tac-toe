package com.example;

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import org.junit.Test;
import sun.util.resources.cldr.vi.TimeZoneNames_vi;

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

  @Test(expected = IllegalArgumentException.class)
  public void testNullBoard() {
    TicTacToeBoard board = new TicTacToeBoard(null);
    board.evaluate();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBoardLength() {
    TicTacToeBoard board = new TicTacToeBoard("X.o@.!foXoX");
    board.evaluate();
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

  /** Test 5 By 5 Boards to prove the extensibility of my code. */
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

  @Test
  public void testValid5By5BoardORowWins() {
    TicTacToeBoard board = new TicTacToeBoard("X!X!!!X!!!12345OOOOO***XX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValid5By5BoardOColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("wwwOxyxyO!123O$x2%Ox!@#Ox");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValid5By5BoardODiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("o@@X@xo#x#&&ox*^^^o!%x%%O");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValid5By5BoardOAntiDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("1234O1x3O512O4x1O3x5O2x45");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  /** Begin Testing on 4 By 4 Boards to prove Extensibility. */
  @Test
  public void testValid4By4BoardXColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("O!XO()X(o*X&%%Xo");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid4By4BoardXRowWins() {
    TicTacToeBoard board = new TicTacToeBoard("o...*o*oxxxx///o");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid4By4BoardXDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("X;o;:XccppXooFpX");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid4By4BoardXAntiDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("OO.x::X:PXoPX*oi");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValid4By4BoardOColumnWins() {
    TicTacToeBoard board = new TicTacToeBoard("9O(x8ox)xO(){O}|");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValid4By4BoardORowWins() {
    TicTacToeBoard board = new TicTacToeBoard("#x#xOoOo0123x23x");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValid4By4ODiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("O;x;:OccppOxxFpO");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValid4By4OAntiDiagonalWins() {
    TicTacToeBoard board = new TicTacToeBoard("xx.O::O:POxPO*xi");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
}
