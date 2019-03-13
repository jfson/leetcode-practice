package com.sun.leetcode.company.Ms;

/**
 * Author: jfson sun
 * Create on:  2018/12/21
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc348 {
    /**
     348. Design Tic-Tac-Toe
     Medium

     279

     21

     Favorite

     Share
     Design a Tic-tac-toe game that is played between two players on a n x n grid.

     You may assume the following rules:

     A move is guaranteed to be valid and is placed on an empty block.
     Once a winning condition is reached, no more moves is allowed.
     A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
     Example:
     Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

     TicTacToe toe = new TicTacToe(3);

     toe.move(0, 0, 1); -> Returns 0 (no one wins)
     |X| | |
     | | | |    // Player 1 makes a move at (0, 0).
     | | | |

     toe.move(0, 2, 2); -> Returns 0 (no one wins)
     |X| |O|
     | | | |    // Player 2 makes a move at (0, 2).
     | | | |

     toe.move(2, 2, 1); -> Returns 0 (no one wins)
     |X| |O|
     | | | |    // Player 1 makes a move at (2, 2).
     | | |X|

     toe.move(1, 1, 2); -> Returns 0 (no one wins)
     |X| |O|
     | |O| |    // Player 2 makes a move at (1, 1).
     | | |X|

     toe.move(2, 0, 1); -> Returns 0 (no one wins)
     |X| |O|
     | |O| |    // Player 1 makes a move at (2, 0).
     |X| |X|

     toe.move(1, 0, 2); -> Returns 0 (no one wins)
     |X| |O|
     |O|O| |    // Player 2 makes a move at (1, 0).
     |X| |X|

     toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
     |X| |O|
     |O|O| |    // Player 1 makes a move at (2, 1).
     |X|X|X|

     题意： 最终胜利的情况是。连成一排，一列，或者对角线。用int[]数组（1标识player1,-1标识player2）.移动只能是空位置
     solution:用一位数组。可以标识行，列合。在计算一个对角线和逆对角线值即可
     */

    class TicTacToe{
        int[] rows,cols;
        int diagonal,antiDiagonal;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
        }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;

            rows[row] += toAdd;
            cols[col] += toAdd;
            if (row == col){ // 对角线上
                diagonal += toAdd;
            }

            if (col == (cols.length - row -1)){ // 逆对角线
                antiDiagonal+=toAdd;
            }

            int size = rows.length;
            if (Math.abs(rows[row]) == size||Math.abs(cols[col]) == size ||Math.abs(diagonal) ==size || Math.abs(antiDiagonal) ==size){
                return player;
            }

            return 0;
        }
    }
}
