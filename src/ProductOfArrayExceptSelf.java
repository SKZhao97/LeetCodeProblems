/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * June 9th
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null)
            return new int[0];
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        int prod = nums[0];
        for (int i = 1 ; i < n ; i++) {
            left[i] = prod;
            prod *= nums[i];
        }
        right[n - 1] = 1;
        prod = nums[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--) {
            right[i] = prod;
            prod *= nums[i];
        }

        for (int k = 0; k < n; k++) {
            nums[k] = left[k] * right[k];
        }
        return nums;
    }
}
