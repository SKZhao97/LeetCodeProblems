import java.util.LinkedList;
import java.util.List;

/**
 * 130. Surrounded Regions。
 * https://leetcode.com/problems/surrounded-regions/
 * May 28th
 */
public class SurroundedRegions {
    private int ROWS = 0;
    private int COLS = 0;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.ROWS = board.length;
        this.COLS = board[0].length;
        List<int[]> borders = new LinkedList<>();
        for (int r = 0; r < this.ROWS; r++) {
            borders.add(new int[]{r, 0});
            borders.add(new int[]{r, this.COLS - 1});
        }
        for (int c = 0; c < this.COLS; c++) {
            borders.add(new int[]{0, c});
            borders.add(new int[]{this.ROWS - 1, c});
        }
        for (int[] arr : borders) {
            dfs(board, arr[0], arr[1]);
        }
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'E';
        if (col < this.COLS - 1) {
            dfs(board, row, col + 1);
        }
        if (row < this.ROWS - 1) {
            dfs(board, row + 1, col);
        }
        if (col > 0) {
            dfs(board, row, col - 1);
        }
        if (row > 0) {
            dfs(board, row - 1, col);
        }
    }


    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        surroundedRegions.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
