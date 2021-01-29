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
    char[] charTicTacToeBoard = ticTacToeBoard.toUpperCase().toCharArray();
    if(ticTacToeBoard.length() != BOARD_SIZE) {
      return Evaluation.UnreachableState;
    }
    int countX = 0;
    int countO = 0;
    for (char c: charTicTacToeBoard) {
      if (c == 'X') {
        countX++;
      } else if (c == 'O') {
        countO++;
      }
    }
    if (Math.abs(countX - countO) > 1) {
      return Evaluation.UnreachableState;
    } else if (countX < 3 || countO < 3) {
      return Evaluation.NoWinner;
    }
    return Evaluation.UnreachableState;
  }
}
