import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 * June 11th
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int R = grid.length;
        int C = grid[0].length;

        int fresh = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    int code = r*C + c;
                    queue.offer(code);
                    map.put(code, 0);
                }

                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int res = 0;
        while(!queue.isEmpty()) {
            int code = queue.remove();
            int r = code/C, c = code % C;
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (newR < R && newR >= 0 && newC < C && newC >= 0 && grid[newR][newC] == 1) {
                    int newCode = newR * C + newC;
                    grid[newR][newC] = 2;
                    fresh--;
                    queue.offer(newCode);
                    map.put(newCode, map.get(code) + 1);
                    res = map.get(newCode);
                }
            }
        }

        if (fresh != 0) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] oranges = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(oranges));
    }
}
