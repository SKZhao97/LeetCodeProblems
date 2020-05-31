import java.util.Arrays;
import java.util.Comparator;

public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int res = (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,5};
        MaximumProductOfTwoElementsInAnArray maximumProductOfTwoElementsInAnArray
                = new MaximumProductOfTwoElementsInAnArray();
        System.out.println(maximumProductOfTwoElementsInAnArray.maxProduct(nums));
    }
}
