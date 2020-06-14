import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 5454. Least Number of Unique Integers after K Removals
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * June 13th
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[][] nums = new int[map.size()][2];
        int n = 0;
        for (int key : map.keySet()) {
            nums[n][0] = key;
            nums[n][1] = map.get(key);
            pq.add(nums[n]);
            n++;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int val = item[1];
            if (k >= val) {
                k -= val;
            } else {
                res = pq.size() + 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals leastNumberOfUniqueIntegersAfterKRemovals = new LeastNumberOfUniqueIntegersAfterKRemovals();
        int[] nums = new int[]{1,1,1,1,1, 2, 4};
        int k = 1;
        System.out.println(leastNumberOfUniqueIntegersAfterKRemovals.findLeastNumOfUniqueInts(nums, k));
    }
}
