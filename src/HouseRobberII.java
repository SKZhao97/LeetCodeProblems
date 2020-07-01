/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * July 1st
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int [] dp = new int[nums.length + 1];
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        ans1 = dp[dp.length - 1];
        dp = new int[nums.length + 2];
        for (int j = 3; j < dp.length; j++) {
            dp[j] = Math.max(dp[j - 2] + nums[j - 2], dp[j - 1]);
        }
        ans2 = dp[dp.length - 1];
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(nums));
    }
}
