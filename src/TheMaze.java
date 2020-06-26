/**
 * 490. The Maze
 * https://leetcode.com/problems/the-maze/
 * June 26th
 */
public class TheMaze {
    int[] dirX = new int[]{-1, 1, 0, 0};
    int[] dirY = new int[]{0, 0, -1, 1};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int m = maze.length;
        int n = maze[0].length;

        for (int k = 0; k < 4; k++) {
            int x = start[0];
            int y = start[1];
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1) {
                x += dirX[k];
                y += dirY[k];
            }

            x -= dirX[k];
            y -= dirY[k];

            if (maze[x][y] == 2) {
                continue;
            }

            maze[x][y] = 2;

            if (hasPath(maze, new int[]{x, y}, destination)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();
//        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
//        int[] destination = new int[]{4, 4};
        int[] destination = new int[]{1, 2};

        System.out.println(theMaze.hasPath(maze, start, destination));
    }
}
