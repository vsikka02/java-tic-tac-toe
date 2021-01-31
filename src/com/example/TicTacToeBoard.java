package com.example;

import java.util.Locale;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  private String ticTacToeBoard;
  private final int BOARD_SIZE = 9;
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    ticTacToeBoard = board;
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    if (ticTacToeBoard = null) {
      throw new NullPointerException("The board that was inputted is null!");
    }
    /**
     * Checks if the Board Size is a perfect square so that it is n*n allowing me to make sure
     * that I can do all the necessary row and column checks. 
     */
    if ((Math.sqrt(BOARD_SIZE) - Math.floor(Math.sqrt(BOARD_SIZE))) != 0) {
      throw new IllegalArgumentException("Board Size must be a perfect square i.e. 4, 9, 16,...");
    }
    /**
     * Checks to make sure the board that is passed through is the intended size in this case it is declared by the constant BOARD_SIZE and must be a perfect square.
     * For this test we are strictly using BOARD_SIZE = 9.
     */
    if (ticTacToeBoard.length() != BOARD_SIZE) {
      throw new IllegalArgumentException("Board is not the intended board size!");
    }
    /**
     * Ensures that our Tic Tac Toe String is not case-sensitive.
     */
    ticTacToeBoard = ticTacToeBoard.toUpperCase();
    int charCounter = 0;
    char[][] charTicTacToeBoard = new char[(int) Math.sqrt(BOARD_SIZE)][(int) Math.sqrt(BOARD_SIZE)];
    for (int i = 0; i < Math.sqrt(BOARD_SIZE); i++) {
      for (int j = 0; j < Math.sqrt(BOARD_SIZE); j++) {
        charTicTacToeBoard[i][j] = ticTacToeBoard.charAt(charCounter);
        charCounter++;
      }
    }
    /**
     * Simply count the number of X's and O's in the board to check whether there is a possible winner or not.
     */
    int countX = 0;
    int countO = 0;
    for (int i = 0; i < Math.sqrt(BOARD_SIZE); i++) {
      for (int j = 0; j < Math.sqrt(BOARD_SIZE); j++) {
        if (charTicTacToeBoard[i][j] == 'X') {
          countX++;
        }
        if (charTicTacToeBoard[i][j] == 'O') {
          countO++;
        }
      }
    }
    /**
     * Ensure that the number of X's and O's only differs by one to be considered a valid game.
     */
    if (Math.abs(countX - countO) > 1) {
      return Evaluation.UnreachableState;
    }
    boolean xWinner = false;
    boolean oWinner = false;
    char[][] transposedTicTacToeBoard = transposeArray(charTicTacToeBoard);
    for (int i = 0; i < Math.sqrt(BOARD_SIZE); i++) {
      if (checkRowsAndColumnHelper(charTicTacToeBoard[i], 'X')) {
        xWinner = true;
      }
      if (checkRowsAndColumnHelper(charTicTacToeBoard[i], 'O')) {
        oWinner = true;
      }
      if (checkRowsAndColumnHelper(transposedTicTacToeBoard[i], 'X')) {
        xWinner = true;
      }
      if (checkRowsAndColumnHelper(transposedTicTacToeBoard[i], 'O')) {
        oWinner = true;
      }
    }
    if (checkDiagonals(charTicTacToeBoard, 'X')) {
      xWinner = true;
    }
    if (checkDiagonals(charTicTacToeBoard, 'O')) {
      oWinner = true;
    }
    if (xWinner && oWinner) {
      return Evaluation.UnreachableState;
    } else if (xWinner) {
      return Evaluation.Xwins;
    } else if (oWinner) {
      return Evaluation.Owins;
    }

    return Evaluation.NoWinner;
  }
  public boolean checkRowsAndColumnHelper (char[] ticTacToeRow, char character) {
    for (int i = 0; i < ticTacToeRow.length; i++) {
      if (ticTacToeRow[i] != character) {
        return false;
      }
    }
    return true;
  }
  public char[][] transposeArray (char[][] ticTacToeBoard) {
    char[][] transposedTicTacToeBoard = new char[(int) Math.sqrt(BOARD_SIZE)][(int) Math.sqrt(BOARD_SIZE)];
    for (int i = 0; i < transposedTicTacToeBoard.length; i++) {
      for (int j = 0; j < transposedTicTacToeBoard.length; j++) {
        transposedTicTacToeBoard[i][j] = ticTacToeBoard[j][i];
      }
    }
    return transposedTicTacToeBoard;
  }
  public boolean checkDiagonals(char[][] ticTacToeBoard, char character) {
    boolean diagonalWin1 = true;
    boolean diagonalWin2 = true;
    for (int i = 0; i < ticTacToeBoard.length; i++) {
      if(ticTacToeBoard[i][i] != character) {
        diagonalWin1 = false;
      }
      if (ticTacToeBoard[i][ticTacToeBoard.length - i - 1] != character) {
        diagonalWin2 = false;
      }
    }
    return diagonalWin1 || diagonalWin2;
  }
}
