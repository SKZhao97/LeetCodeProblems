import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 909. Snakes and Ladders
 * https://leetcode.com/problems/snakes-and-ladders/
 * June 24th
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0)
            return -1;

        int n = board.length;

        Map<Integer, Integer> squareDistanceMap = new HashMap<>();
        squareDistanceMap.put(1, 0);

        // most accessible squares from starting square get enqueued first
        Queue<Integer> accessibilityQueue = new LinkedList<>();
        accessibilityQueue.offer(1);

        while(!accessibilityQueue.isEmpty()) {
            int polledSquareNumber = accessibilityQueue.poll();

            if (polledSquareNumber == n * n)
                return squareDistanceMap.get(polledSquareNumber);

            for (int nextSquare = polledSquareNumber + 1; nextSquare <= Math.min(polledSquareNumber + 6, n * n); nextSquare++) {
                int nextSquareBoardCoordinates = generateBoardCoordinates(nextSquare, n);
                int nextSquareRow = nextSquareBoardCoordinates / n;
                int nextSquareCol = nextSquareBoardCoordinates % n;

                int squareNumberToEnqueue = board[nextSquareRow][nextSquareCol] == -1? nextSquare : board[nextSquareRow][nextSquareCol];
                if(!squareDistanceMap.containsKey(squareNumberToEnqueue)) {
                    squareDistanceMap.put(squareNumberToEnqueue, squareDistanceMap.get(polledSquareNumber) + 1);
                    accessibilityQueue.offer(squareNumberToEnqueue);
                }
            }
        }

        return -1;
    }

    public int generateBoardCoordinates(int squareNumber, int n) {
        // subtract by 1 because square numbers start from 1 and not 0 where as board rows and columns are 0 indexed
        int quotient = (squareNumber - 1) / n;
        int remainder = (squareNumber - 1) % n;

        // the game starts from last row and moves to 0th row of board in a reverse manner as it progresses
        int rowNumber = n - 1 - quotient;

        /*
            direction of column number changes depending on 2 factors -
            a) the row number
            b) how many rows there are in total. The 0th row for n = 4 will have right to left increasing column numbers
            whereas 0th row for n = 5 will have left to right increasing column numbers
        */
        int columnNumber = rowNumber % 2 != n % 2? remainder : n - 1 - remainder;

        return rowNumber * n + columnNumber;
    }

    public static void main(String[] args) {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1}, {-1,-1,-1,-1,-1,-1}, {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1}, {-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders.snakesAndLadders(board));
    }
}
