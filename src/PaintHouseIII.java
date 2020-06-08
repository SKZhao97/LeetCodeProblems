import java.util.Arrays;

/**
 * 1473. Paint House III
 * https://leetcode.com/problems/paint-house-iii/
 * June 7th
 */
public class PaintHouseIII {
    int MAX = 100000000;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                Arrays.fill(dp[i][j], -1);
        }
        int ans = paintRecursively(houses, cost, m, n, target, 0, 0, -1, dp);
        if (ans == MAX) {
            return -1;
        }
        return ans;
    }

    public int paintRecursively(int[] houses, int[][] cost, int m, int n, int target,
                                int houseToBePainted, // Dp state
                                int currentTarget, // Dp state
                                int lastNeighborhoodColor, // Dp state
                                int[][][] dp
    ) {
        if (houseToBePainted == m) {
            if (currentTarget == target) {
                return 0;
            }
            return MAX;
        }

        if (currentTarget == target + 1) {
            return MAX;
        }
        if (lastNeighborhoodColor != -1) {
            if (dp[houseToBePainted][lastNeighborhoodColor][currentTarget] != -1) {
                return dp[houseToBePainted][lastNeighborhoodColor][currentTarget];
            }
        }

        int minCost = MAX;
        //Step 1: Choose a paint color
        for (int currentColor = 0; currentColor < n; ++currentColor) {
            // Do we even need to paint? Or the house is already painted with color that we chose.
            boolean isFree = false;
            if (houses[houseToBePainted] != 0) {
                //Note: If house is already painted with a different color than the one which we are using, stop right away, since we cannot override a paint.
                if (houses[houseToBePainted] != currentColor + 1)
                    continue;
                else // No need to pay to paint this color, it's already painted!
                    isFree = true;
            }
            //Step 2: Are we using a new paint that was not same as the last one?
            //Step 2A: If yes, we will create a new neighborhood from here
            if (currentColor != lastNeighborhoodColor) {
                minCost = Math.min(minCost, paintRecursively(houses, cost, m, n, target, houseToBePainted + 1, currentTarget + 1, currentColor, dp) + ((isFree) ? 0 : cost[houseToBePainted][currentColor]));

            } else { // If no, we will continue with previous neighborhood
                minCost = Math.min(minCost, paintRecursively(houses, cost, m, n, target, houseToBePainted + 1, currentTarget, currentColor, dp) + ((isFree) ? 0 : cost[houseToBePainted][currentColor]));
            }
        }
        if (lastNeighborhoodColor != -1) {
            dp[houseToBePainted][lastNeighborhoodColor][currentTarget] = minCost;
        }
        return minCost;
    }

    public static void main(String[] args) {
        PaintHouseIII paintHouseIII = new PaintHouseIII();
        int[] houses = {0, 2, 1, 2, 0};
        int[][] cost = new int[][]{{1,10},{10,1},{10,1}, {1,10}, {5,1}};
        int m = 5;
        int n = 2;
        int target = 3;
        System.out.println(paintHouseIII.minCost(houses, cost, m, n, target));
    }
}
