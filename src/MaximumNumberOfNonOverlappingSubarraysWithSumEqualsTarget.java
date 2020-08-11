import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
            System.out.println(map);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 2;
        MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget maximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget
                = new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget();
        System.out.println(maximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget.maxNonOverlapping(nums, target));
    }
}
