import java.util.Arrays;

/**
 * 1470. Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 * June 6th
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            res[k++] = nums[i];
            res[k++] = nums[i + n];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2};
        int n = 2;
        ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        System.out.println(Arrays.toString(shuffleTheArray.shuffle(nums, n)));
    }
}
