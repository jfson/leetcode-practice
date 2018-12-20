package com.sun.leetcode.company.Microsoft;

/**
 * Author: jfson sun
 * Create on:  2018/12/21
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc794 {
    /**
     794. Valid Tic-Tac-Toe State
     A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

     The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.

     Here are the rules of Tic-Tac-Toe:

     Players take turns placing characters into empty squares (" ").
     The first player always places "X" characters, while the second player always places "O" characters.
     "X" and "O" characters are always placed into empty squares, never filled ones.
     The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
     The game also ends if all squares are non-empty.
     No more moves can be played if the game is over.
     Example 1:
     Input: board = ["O  ", "   ", "   "]
     Output: false
     Explanation: The first player always plays "X".

     Example 2:
     Input: board = ["XOX", " X ", "   "]
     Output: false
     Explanation: Players take turns making moves.

     Example 3:
     Input: board = ["XXX", "   ", "OOO"]
     Output: false

     Example 4:
     Input: board = ["XOX", "O O", "XOX"]
     Output: true
     Note:

     board is a length-3 array of strings, where each string board[i] has length 3.
     Each board[i][j] is a character in the set {" ", "X", "O"}.
     题意：先画'X'..两人轮流在九格方盘上画'X'或者'O'，直到三个相同记号排成横线、直线、斜线，
     solution: 依次校验行，列，对角，斜对角是否满足
     */

    public boolean validTicTacToe(String[] board) {
        int xCount = 0,oCount = 0;
        for (int i = 0;i<board.length;i++){
            for (char c: board[i].toCharArray()){
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }

        ////先画'X',oCount must is xCount-1
        if (oCount > xCount && oCount != xCount-1) return false;
        if (win(board,'X') && oCount != xCount-1 ) return false;
        if (win(board,'O') && oCount != xCount-1 ) return false;
        return true;
    }

    // B: board, P: player
    public boolean win(String[] board,char P){
        for (int i = 0; i < 3; i++) {
            if (P == board[0].charAt(i) && P == board[1].charAt(i) && P==board[2].charAt(i)) // col
                return true;

            if (P == board[i].charAt(0) &&P == board[i].charAt(1) &&P == board[i].charAt(2) ) //row
                return true;
        }

        //对角线
        if (P == board[0].charAt(0) && P == board[1].charAt(1) && P == board[2].charAt(2)) //对角线
            return true;

        if(P==board[0].charAt(2) && P==board[1].charAt(1) && P==board[2].charAt(0)) //逆对角线
            return true;

        return false;
    }
}
