import java.util.LinkedList;
import java.util.Queue;

/**
 * 1102. Path With Maximum Minimum Value
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 * June 25th
 */
public class PathWithMaximumMinimumValue {
    int[] dirX = new int[]{1, -1, 0, 0};
    int[] dirY = new int[]{0, 0, -1, 1};

    public int maximumMinimumPath(int[][] A) {
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                l = Math.min(l, A[i][j]);
                r = Math.max(r, A[i][j]);
            }
        }

        while (l < r - 1) {
            int mid = l + (r - l)/2;
            if (validate(A, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (validate(A, r)) {
            return r;
        }
        return l;
    }

    public boolean validate(int[][] A, int val) {
        Queue<int[]> queue = new LinkedList<>();

        if (A[0][0] < val) {
            return false;
        }
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[A.length][A[0].length];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == A.length - 1 && cur[1] == A[0].length - 1) {
                return true;
            }

            visited[cur[0]][cur[1]] = true;
            for (int k = 0; k < 4; k++) {
                int newX = cur[0] + dirX[k];
                int newY = cur[1] + dirY[k];
                if (newX >= 0 && newX < A.length && newY >= 0 && newY < A[0].length) {
                    if (!visited[newX][newY] && A[newX][newY] >= val) {
                        queue.add(new int[]{newX, newY});
                    }
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{5,4,5},{1,2,6},{7,4,6}};
        PathWithMaximumMinimumValue pathWithMaximumMinimumValue = new PathWithMaximumMinimumValue();
        System.out.println(pathWithMaximumMinimumValue.maximumMinimumPath(A));
    }
}
