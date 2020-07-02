/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable
 */
public class NumArray {

    int[] sums;
    int sum = 0;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i  < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        int left = 0;
        if (i != 0) {
            left = sums[i - 1];
        }
        int right = sums[j];
        return right - left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 5));
    }
}
