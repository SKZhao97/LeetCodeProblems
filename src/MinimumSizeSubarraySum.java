import java.util.LinkedList;
import java.util.Queue;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * June 20th
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s && j < nums.length) {
                res = Math.min(res, i - j + 1);
                sum -= nums[j++];
            }
        }
        if (res == Integer.MAX_VALUE)
            return 0;
        else
            return res;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(s, nums));
    }
}
