/**
 * 348. Design Tic-Tac-Toe
 * https://leetcode.com/problems/design-tic-tac-toe/
 * June 29th
 */
public class TicTacToe {
    char[][] board;
    int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
        size = n;
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
        char symbol = (player == 1) ? 'X': 'O';
        board[row][col] = symbol;
        if(hasWon(symbol, row, col))
            return player;
        return 0;
    }

    private boolean hasWon(char symbol, int row, int col) {
        boolean hasWon = true;
        for (int i = 0; i < size; i++) {
            if (board[row][i] != symbol) {
                hasWon = false;
                break;
            }
        }
        if (hasWon)
            return true;

        hasWon = true;
        for (int i = 0; i < size; i++) {
            if (board[i][col] != symbol) {
                hasWon = false;
                break;
            }
        }
        if (hasWon)
            return true;

        hasWon = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                hasWon = false;
                break;
            }
        }

        if (hasWon)
            return true;
        hasWon = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != symbol) {
                hasWon = false;
                break;
            }

        }
        if (hasWon)
            return true;

        return false;
    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }
}
