import java.util.Arrays;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * June 9th
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0)
            return res;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        System.out.println(Arrays.toString(leftMax));
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        for (int i = 0; i < n; i++) {
            int ans = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += ans;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(inputs));
    }
}
