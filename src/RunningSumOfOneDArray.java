import java.util.Arrays;

/**
 * 5453. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * June 13th
 */
public class RunningSumOfOneDArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        RunningSumOfOneDArray runningSumOfOneDArray = new RunningSumOfOneDArray();
        System.out.println(Arrays.toString(runningSumOfOneDArray.runningSum(nums)));
    }
}
