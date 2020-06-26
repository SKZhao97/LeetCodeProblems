/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/
 * June 26th
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ;j++) {
                if (grid[i][j] == 1) {
                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    if (j + 1 > grid[0].length - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }

                    if (i - 1 <0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    if (i + 1 > grid.length - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                }
                System.out.println(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter.islandPerimeter(grid));
    }
}
