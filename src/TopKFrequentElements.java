import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * May 30th
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        int[] top_k = new int[k];
        int i = k - 1;
        while (!heap.isEmpty()) {
            top_k[i--] = heap.poll();
        }
        return top_k;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequentElements.topKFrequent(nums, k);
        System.out.println(res.length);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
