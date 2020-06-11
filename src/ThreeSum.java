import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * June 11th
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            if (i == 0 || firstNum != nums[i - 1]) {
                int leftIndex = i + 1;
                int rightIndex = nums.length - 1;
                int twoSumTarget = -firstNum;
                while (leftIndex < rightIndex) {
                    int twoSum = nums[leftIndex] + nums[rightIndex];
                    if (twoSum == twoSumTarget) {
                        res.add(Arrays.asList(firstNum, nums[leftIndex], nums[rightIndex]));
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                            leftIndex++;
                        }
                        while (leftIndex < rightIndex && nums[rightIndex - 1] == nums[rightIndex]) {
                            rightIndex--;
                        }
                        leftIndex++;
                        rightIndex--;
                    } else if (twoSum < twoSumTarget) {
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}
