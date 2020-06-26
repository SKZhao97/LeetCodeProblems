import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillDFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }

    public void dfs (int[][] image, int row, int col, int color, int newColor) {
        if (image[row][col] == color) {
            image[row][col] = newColor;
            if (row >= 1) {
                dfs(image, row - 1, col, color, newColor);
            }
            if (row < image.length - 1) {
                dfs(image, row + 1, col, color, newColor);
            }
            if (col >= 1) {
                dfs(image, row, col - 1, color, newColor);
            }

            if (col < image[0].length - 1) {
                dfs(image, row, col + 1, color, newColor);
            }
        }
    }

    public static void main(String[] args) {
        FloodFillDFS floodFillDFS = new FloodFillDFS();
        int[][] image = new int[][]{{0, 0, 0},{0, 1, 1}};
        int sr = 1, sc = 1, newColor = 1;
        for (int[] item : floodFillDFS.floodFill(image, sr, sc, newColor)) {
            System.out.println(Arrays.toString(item));
        }
    }
}
