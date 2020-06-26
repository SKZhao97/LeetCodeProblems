import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/
 * June 25th
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        queue.offer(new int[]{sr, sc});
        int start = image[sr][sc];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if (image[row][col] == start) {
                image[row][col] = newColor;
                visited[row][col] = true;
                if (row - 1 >= 0 && !visited[row - 1][col]) {
                    queue.offer(new int[]{row - 1, col});
                }
                if (row + 1 < image.length && !visited[row + 1][col]) {
                    queue.offer(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && !visited[row][col - 1]) {
                    queue.offer(new int[]{row, col - 1});
                }
                if (col + 1 < image[0].length && !visited[row][col + 1]) {
                    queue.offer(new int[]{row, col + 1});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = new int[][]{{0, 0, 0},{0, 1, 1}};
        int sr = 1, sc = 1, newColor = 1;
        for (int[] item : floodFill.floodFill(image, sr, sc, newColor)) {
            System.out.println(Arrays.toString(item));
        }
    }
}
