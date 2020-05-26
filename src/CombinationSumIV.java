import java.util.Arrays;

/**
 * 377. Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int target = 4;
        System.out.println(combinationSumIV.combinationSum4(nums, target));
    }
}
