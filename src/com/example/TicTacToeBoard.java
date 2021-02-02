package com.example;

import java.util.Locale;

/** Takes in and evaluates a string representing a tic tac toe board. */
public class TicTacToeBoard {
  private String ticTacToeBoard;
  /**
   * In order to test different board sizes change the constant board size to a perfect square that
   * is greater than 9. If an invalid board size is inputted then an Illegal Argument Exception will
   * be thrown.
   */
  private int boardSize;
  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param board The string representing the board
   */

  public TicTacToeBoard(String board) {
    if (board == null) {
      throw new IllegalArgumentException("The board that was inputted is null!");
    }
    ticTacToeBoard = board;
    boardSize = board.length();
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins).
   *
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {

    /*Checks if the Board Size is a perfect square so that it is n*n allowing me to make sure that
    I can do all the necessary row and column checks.*/
    if ((Math.sqrt(boardSize) - Math.floor(Math.sqrt(boardSize))) != 0
        && Math.sqrt(boardSize) > 3) {
      throw new IllegalArgumentException("Board Size must be a perfect square i.e. 4, 9, 16,...");
    }

    /* Checks to make sure the board that is passed through is the intended size in this case it is
     * declared by the length of the original String and must be a perfect square. For most tests,
     * we use boardSize = 9. */
    if (ticTacToeBoard.length() != boardSize) {
      throw new IllegalArgumentException("Board is not the intended board size!");
    }

    // Ensures that our Tic Tac Toe String is not case-sensitive.
    ticTacToeBoard = ticTacToeBoard.toUpperCase();

    //Switches String TicTacToe Board into a 2D char array that resembles a real TicTacToeBoard.
    int charCounter = 0;
    char[][] charTicTacToeBoard = new char[(int) Math.sqrt(boardSize)][(int) Math.sqrt(boardSize)];
    for (int row = 0; row < Math.sqrt(boardSize); row++) {
      for (int column = 0; column < Math.sqrt(boardSize); column++) {
        charTicTacToeBoard[row][column] = ticTacToeBoard.charAt(charCounter);
        charCounter++;
      }
    }

    /*Count the number of X's and O's in the board to check whether there is
     a possible winner or not. */
    int countX = 0;
    int countO = 0;
    for (int row = 0; row < Math.sqrt(boardSize); row++) {
      for (int column = 0; column < Math.sqrt(boardSize); column++) {
        if (charTicTacToeBoard[row][column] == 'X') {
          countX++;
        }
        if (charTicTacToeBoard[row][column] == 'O') {
          countO++;
        }
      }
    }

    // Ensure that the number of X's and O's only differs by one to be considered a valid game.
    if (Math.abs(countX - countO) > 1) {
      return Evaluation.UnreachableState;
    }
    boolean xwinner = false;
    boolean owinner = false;
    char[][] transposedTicTacToeBoard = transposeArray(charTicTacToeBoard);

    // Split up the TicTacToe board by row and pass it into the checkRows helper function in order
    for (int row = 0; row < Math.sqrt(boardSize); row++) {
      if (checkRows(charTicTacToeBoard[row], 'X')) {
        xwinner = true;
      }
      if (checkRows(charTicTacToeBoard[row], 'O')) {
        owinner = true;
      }
      /*Transpose the TicTacToeBoard and check the rows for winners which will act as the columns
       * in the original TicTacToe Board. */
      if (checkRows(transposedTicTacToeBoard[row], 'X')) {
        xwinner = true;
      }
      if (checkRows(transposedTicTacToeBoard[row], 'O')) {
        owinner = true;
      }
    }
    if (checkDiagonals(charTicTacToeBoard, 'X')) {
      xwinner = true;
    }
    if (checkDiagonals(charTicTacToeBoard, 'O')) {
      owinner = true;
    }

    /*Ensures that there is no double winner for TicTacToe making it an Unreachable State.
     * Otherwise if there is one winner it will return the Evaluation. */
    if (xwinner && owinner) {
      return Evaluation.UnreachableState;
    } else if (xwinner) {
      return Evaluation.Xwins;
    } else if (owinner) {
      return Evaluation.Owins;
    }

    return Evaluation.NoWinner;
  }

  /**
   * Analyze each individual row of a TicTacToeBoard to check whether the row contains
   * a winner or not.
   *
   * @param ticTacToeRow Takes in individual rows of a TicTacToe board
   * @param character this is the character that is aiming to be matched in each row.
   * @return a boolean of whether there is a winner in the row or not.
   */
  private boolean checkRows(char[] ticTacToeRow, char character) {
    for (int rowIndex = 0; rowIndex < ticTacToeRow.length; rowIndex++) {
      if (ticTacToeRow[rowIndex] != character) {
        return false;
      }
    }
    return true;
  }

  /**
   * Transpose the array in order to check the columns by using the checkRows helper function above.
   *
   * @param ticTacToeBoard a 2D char array that represents the original TicTacToe board.
   * @return a transposed 2D char array that is the transposed TicTacToe board.
   */
  private char[][] transposeArray(char[][] ticTacToeBoard) {
    char[][] transposedTicTacToeBoard =
        new char[(int) Math.sqrt(boardSize)][(int) Math.sqrt(boardSize)];
    for (int row = 0; row < transposedTicTacToeBoard.length; row++) {
      for (int column = 0; column < transposedTicTacToeBoard.length; column++) {
        transposedTicTacToeBoard[row][column] = ticTacToeBoard[column][row];
      }
    }
    return transposedTicTacToeBoard;
  }

  /**
   * This is a helper function that is utilized to check the diagonal and anti-diagonal of the
   * TicTacToe board.
   *
   * @param ticTacToeBoard the 2D char array that represents a TicTacToe board.
   * @param character the character that is being searched for on the diagonals.
   * @return boolean of whether there is a winner present.
   */
  private boolean checkDiagonals(char[][] ticTacToeBoard, char character) {
    boolean diagonalWin1 = true;
    boolean diagonalWin2 = true;
    for (int i = 0; i < ticTacToeBoard.length; i++) {
      if (ticTacToeBoard[i][i] != character) {
        diagonalWin1 = false;
      }
      if (ticTacToeBoard[i][ticTacToeBoard.length - i - 1] != character) {
        diagonalWin2 = false;
      }
    }
    return diagonalWin1 || diagonalWin2;
  }
}
